package com.statnett.weatherservice.responseentity;

import java.util.ArrayList;

public class EarthQuakeClientResponse {
    private String type;
    private Metadata metadata;
    private ArrayList< Feature > features = new ArrayList < Feature>() ;

    private ArrayList < Object > bbox = new ArrayList < Object> ();


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

    public ArrayList<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(ArrayList<Feature> features) {
        this.features = features;
    }

    public ArrayList<Object> getBbox() {
        return bbox;
    }

    public void setBbox(ArrayList<Object> bbox) {
        this.bbox = bbox;
    }


}
