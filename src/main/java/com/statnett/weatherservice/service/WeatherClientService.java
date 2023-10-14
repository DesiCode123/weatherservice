package com.statnett.weatherservice.service;

import com.statnett.weatherservice.dao.FeatureDao;
import com.statnett.weatherservice.exception.FeatureMappingException;
import com.statnett.weatherservice.responseentity.EarthQuakeClientResponse;
import com.statnett.weatherservice.responseentity.Feature;
import com.statnett.weatherservice.responseentity.Geometry;
import com.statnett.weatherservice.responseentity.Metadata;
import com.statnett.weatherservice.mapperutill.FeatureMapper;
import com.statnett.weatherservice.respository.FeatureDaoRepository;
import com.statnett.weatherservice.respository.GeometryDaoRepository;
import com.statnett.weatherservice.respository.PropertiesDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

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

    public void saveData() throws FeatureMappingException {
        List<Feature> features = getListOfFeatures();
        if (features == null || features.isEmpty()) {
            throw new FeatureMappingException("List of features is either null or empty.");
        }
        for (int i = 0; i < features.size(); i++) {
            FeatureDao featureDao = featureMapper.mapFeatureObject(features.get(i));
        try {
            propertiesDaoRepository.save(featureDao.getProperties());
            geometryDaoRepository.save(featureDao.getGeometry());
            featureDaoRepository.save(featureDao);
        } catch (Exception e){
            throw new FeatureMappingException("Error occurred while mapping the feature object.");
        }

        }
    }

}
