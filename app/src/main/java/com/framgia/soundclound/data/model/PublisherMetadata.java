package com.framgia.soundclound.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PublisherMetadata {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("urn")
    @Expose
    private String urn;
    @SerializedName("artist")
    @Expose
    private String artist;
    @SerializedName("album_title")
    @Expose
    private String albumTitle;
    @SerializedName("contains_music")
    @Expose
    private Boolean containsMusic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrn() {
        return urn;
    }

    public void setUrn(String urn) {
        this.urn = urn;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public Boolean getContainsMusic() {
        return containsMusic;
    }

    public void setContainsMusic(Boolean containsMusic) {
        this.containsMusic = containsMusic;
    }
}
