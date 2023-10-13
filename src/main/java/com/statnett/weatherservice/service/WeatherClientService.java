package com.statnett.weatherservice.service;

import com.statnett.weatherservice.earthquakesentity.EarthQuakeClientResponse;
import com.statnett.weatherservice.entity.Channel;
import com.statnett.weatherservice.entity.WeatherClientResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class WeatherClientService {
    RestTemplate restTemplate = new RestTemplate();

    public WeatherClientResponse getWeatherInfo(){
        String url = "https://api.met.no/weatherapi/metalerts/1.1?show=all";
       // String weatherInfo = restTemplate.getForObject(url,String.class);
        WeatherClientResponse weatherInfo =restTemplate.getForObject(url, WeatherClientResponse.class);

        return weatherInfo;

    }

    public EarthQuakeClientResponse getEarthquakeData(){
        String url = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/1.0_hour.geojson";
        EarthQuakeClientResponse earthQuakeClientResponse = restTemplate.getForObject(url,EarthQuakeClientResponse.class);
        return earthQuakeClientResponse;
    }


}
