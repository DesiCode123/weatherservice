package com.statnett.weatherservice.responseentity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Bbox {
    private List<Double> bbox;
}
