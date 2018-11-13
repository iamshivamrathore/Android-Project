package com.ucdandroidproject.shivamvarunanas.project;

import java.io.Serializable;

class Track implements Serializable {
    String trackName;
    String latitude;
    String longitude;

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Track(String trackName, String latitude, String longitude) {

        this.trackName = trackName;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
