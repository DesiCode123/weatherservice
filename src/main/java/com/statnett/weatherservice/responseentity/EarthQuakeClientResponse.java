package com.statnett.weatherservice.responseentity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Getter
@Setter
public class EarthQuakeClientResponse {
    private String type;
    private Metadata metadata;
    private ArrayList< Feature > features = new ArrayList < Feature>() ;
    private ArrayList < Object > bbox = new ArrayList < Object> ();
}
