package com.framgia.soundclound.data.source.remote;

import android.os.AsyncTask;


import com.framgia.soundclound.data.source.TrackDataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class LoadAsync extends AsyncTask<String, String, String>{
    private TrackDataSource.Callback<String> mCallback;

    public LoadAsync(TrackDataSource.Callback<String> callback) {
        mCallback = callback;
    }

    @Override
    protected void onPreExecute() {
        mCallback.onStartLoading();
    }

    @Override
    protected String doInBackground(String... strings) {
        String urlStr = strings[0];
        String result = null;
        try {
            URL url = new URL(urlStr);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new IOException("HTTP Code" + responseCode);
            }
            InputStream inputStream = connection.getInputStream();
            result = readStream(inputStream);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private String readStream(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder = new StringBuilder();
        String line ;
        try {
            while ((line=reader.readLine())!=null){
                builder.append(line).append("\n");
            }
        } finally {
            inputStream.close();
        }
        return builder.toString();
    }

    @Override
    protected void onPostExecute(String result) {
        mCallback.onGetSuccess(result);
        mCallback.onComplete();
    }
}
