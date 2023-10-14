package com.statnett.weatherservice.controller;

import com.statnett.weatherservice.responseentity.EarthQuakeClientResponse;
import com.statnett.weatherservice.responseentity.Feature;
import com.statnett.weatherservice.responseentity.Metadata;
import com.statnett.weatherservice.service.WeatherClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/earthquake")
public class WeatherController {
    @Autowired
    WeatherClientService weatherClientService;

    @GetMapping("/getAll")
    public EarthQuakeClientResponse getEarthquakeData() {
        return weatherClientService.getEarthquakeData();
    }

    @GetMapping("/metadataInfo")
    public Metadata getMetaDataInfo() {
        return weatherClientService.getMetaDataInfo();

    }

    @GetMapping("/listOfFeatures")
    public List<Feature> getListOfFeatures() {
        return weatherClientService.getListOfFeatures();
    }

    @GetMapping("/findById/{featureId}")
    public Feature getFeatureByID(@PathVariable String featureId) {
        return weatherClientService.getFeatureByID(featureId);
    }

    //post get,satus code-controller
    @GetMapping("/save")
    public void saveData() {
        weatherClientService.saveData();

    }
}