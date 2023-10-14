package com.statnett.weatherservice.service;

import com.statnett.weatherservice.dao.FeatureDao;
import com.statnett.weatherservice.responseentity.EarthQuakeClientResponse;
import com.statnett.weatherservice.responseentity.Feature;
import com.statnett.weatherservice.responseentity.Metadata;
import com.statnett.weatherservice.entity.Channel;
import com.statnett.weatherservice.entity.WeatherClientResponse;
import com.statnett.weatherservice.mapperutill.FeatureMapper;
import com.statnett.weatherservice.respository.FeatureDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WeatherClientService {
    @Autowired
    private FeatureDaoRepository featureDaoRepository;
    RestTemplate restTemplate = new RestTemplate();
    FeatureMapper featureMapper = new FeatureMapper();

    public WeatherClientResponse getWeatherInfo(){
        String url = "https://api.met.no/weatherapi/metalerts/1.1?show=all";
       // String weatherInfo = restTemplate.getForObject(url,String.class);
        WeatherClientResponse weatherInfo =restTemplate.getForObject(url, WeatherClientResponse.class);

        return weatherInfo;

    }

    public EarthQuakeClientResponse getEarthquakeData(){
        String url = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/1.0_hour.geojson";
        EarthQuakeClientResponse earthQuakeClientResponse = restTemplate.getForObject(url,EarthQuakeClientResponse.class);
        EarthQuakeClientResponse earthQuakeClientResponse1 = restTemplate.getForEntity(url,EarthQuakeClientResponse.class).getBody();
        String url1 ="https://earthquake.usgs.gov/earthquakes/eventpage/mb90030048";
        HttpHeaders earthQuakeClientResponse3 = restTemplate.headForHeaders(url1,EarthQuakeClientResponse.class);
        System.out.println(earthQuakeClientResponse3 + "tester");

        System.out.println(earthQuakeClientResponse1);
        return earthQuakeClientResponse;
    }

    public Metadata getMetaDataInfo(){
       return getEarthquakeData().getMetadata();
    }
    public List<Feature> getListOfFeatures(){
      return getEarthquakeData().getFeatures();
    }

    public Feature getFeatureByID(String id){
        return getEarthquakeData().getFeatures()
                .stream()
                .filter(feature -> feature.getId().equals(id))
                .findFirst().get();
    }

    public void saveData(){
        List<Feature> features = getListOfFeatures();
        for(int i = 0; i < features.size(); i ++){
         FeatureDao featureDao = featureMapper.mapFeatureObject(features.get(i));
            featureDaoRepository.save(featureDao);


        }
    }

}
