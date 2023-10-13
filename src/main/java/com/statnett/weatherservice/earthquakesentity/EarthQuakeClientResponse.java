package com.statnett.weatherservice.earthquakesentity;

import java.util.ArrayList;

public class EarthQuakeClientResponse {
    private String type;
    private Metadata metadata;
    private ArrayList< Object > features = new ArrayList < Object > ();


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public ArrayList<Object> getFeatures() {
        return features;
    }

    public void setFeatures(ArrayList<Object> features) {
        this.features = features;
    }

    public ArrayList<Object> getBbox() {
        return bbox;
    }

    public void setBbox(ArrayList<Object> bbox) {
        this.bbox = bbox;
    }

    private ArrayList < Object > bbox = new ArrayList < Object > ();
}
