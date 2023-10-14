package com.statnett.weatherservice.responseentity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class Properties {
    private Double mag;
    private String place;
    private Long time;
    private Long updated;
    private String url;
    private String detail;
    private String tz;
    private String felt;
    private String cdi;
    private String mmi;
    private String alert;
    private String status;
    private String tsunami;
    private String sig;
    private String net;
    private String code;
    private String ids;
    private String sources;
    private String types;
    private String nst;
    private String dmin;
    private String rms;
    private String gap;
    private String magType;
    private String type;
    private String title;
}
