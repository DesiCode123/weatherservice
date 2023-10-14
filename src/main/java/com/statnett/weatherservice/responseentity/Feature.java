package com.statnett.weatherservice.responseentity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Feature {
    private String type;
    private Properties properties;
    private Geometry geometry;
    private String id;
}
