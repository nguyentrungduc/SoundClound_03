package com.framgia.soundclound.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Collection {
    @SerializedName("track")
    @Expose
    private Track track;
    @SerializedName("score")
    @Expose
    private Integer score;

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public static List<Track> toListTrack(List<Collection> collectionList){
        List<Track> trackList = new ArrayList<>();
        for(Collection collection : collectionList){
            trackList.add(collection.getTrack());
        }
        return trackList;
    }
}
