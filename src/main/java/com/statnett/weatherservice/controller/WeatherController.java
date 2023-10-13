package com.statnett.weatherservice.controller;

import com.statnett.weatherservice.earthquakesentity.EarthQuakeClientResponse;
import com.statnett.weatherservice.entity.Channel;
import com.statnett.weatherservice.entity.WeatherClientResponse;
import com.statnett.weatherservice.service.WeatherClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    @Autowired
    WeatherClientService weatherClientService;

    @GetMapping("/weatherData")
    public WeatherClientResponse getAllWeatherData(){
        return weatherClientService.getWeatherInfo();
    }

    @GetMapping("/earthquake")
    public EarthQuakeClientResponse getEarthquakeData(){
        return weatherClientService.getEarthquakeData();
    }

}
