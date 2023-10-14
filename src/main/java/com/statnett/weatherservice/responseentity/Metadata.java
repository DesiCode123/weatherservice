package com.statnett.weatherservice.responseentity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Metadata {
    private String generated;
    private String url;
    private String title;
    private String status;
    private String api;
    private String count;
}
