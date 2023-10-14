package com.statnett.weatherservice.service;

import com.statnett.weatherservice.dao.FeatureDao;
import com.statnett.weatherservice.dao.GeometryDao;
import com.statnett.weatherservice.dao.PropertiesDao;
import com.statnett.weatherservice.responseentity.EarthQuakeClientResponse;
import com.statnett.weatherservice.responseentity.Feature;
import com.statnett.weatherservice.responseentity.Metadata;
import com.statnett.weatherservice.mapperutill.FeatureMapper;
import com.statnett.weatherservice.respository.FeatureDaoRepository;
import com.statnett.weatherservice.respository.GeometryDaoRepository;
import com.statnett.weatherservice.respository.PropertiesDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WeatherClientService {
    @Autowired
    private FeatureDaoRepository featureDaoRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private FeatureMapper featureMapper;


    @Autowired
    private PropertiesDaoRepository propertiesDaoRepository;

    @Autowired
    private GeometryDaoRepository geometryDaoRepository;


    public EarthQuakeClientResponse getEarthquakeData() {
        String url = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/1.0_hour.geojson";
        EarthQuakeClientResponse earthQuakeClientResponse = restTemplate.getForObject(url, EarthQuakeClientResponse.class);

        return earthQuakeClientResponse;
    }

    public Metadata getMetaDataInfo() {
        return getEarthquakeData().getMetadata();
    }

    public List<Feature> getListOfFeatures() {
        return getEarthquakeData().getFeatures();
    }

    public Feature getFeatureByID(String id) {
        return getEarthquakeData().getFeatures()
                .stream()
                .filter(feature -> feature.getId().equals(id))
                .findFirst().get();
    }

    public void saveData() {
        List<Feature> features = getListOfFeatures();
        for (int i = 0; i < features.size(); i++) {
            FeatureDao featureDao = featureMapper.mapFeatureObject(features.get(i));

            propertiesDaoRepository.save(featureDao.getProperties());
            geometryDaoRepository.save(featureDao.getGeometry());
            featureDaoRepository.save(featureDao);

        }
    }

    public String getPlaceInfo(){
        String url1 = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/1.0_hour.geojson";
        String earthQuakeClientResponse3 = restTemplate.getForObject(url1, String.class);
        String[] array = earthQuakeClientResponse3.split("\\{");
        String[] array2 = array[4].split(":");
        String[] array3 = array2[2].split(",");
        System.out.println(array3[0].concat(array3[1]));

        System.out.println(array[4]);
        System.out.println(array2[2]);
        return array3[0].concat(array3[1]);
    }

    public String getId(){
        String url1 = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/1.0_hour.geojson";
        String earthQuakeClientResponse5 = restTemplate.getForObject(url1, String.class);
        String[] array4 = earthQuakeClientResponse5.split("},");
        String[] array5 = array4[3].split(":");
        String[] array6 = array4[3].split(":");
        System.out.println(array6[1]);
        return array6[1];
    }

}
