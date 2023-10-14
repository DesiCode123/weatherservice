package com.statnett.weatherservice.mapperutill;

import com.statnett.weatherservice.dao.FeatureDao;
import com.statnett.weatherservice.dao.GeometryDao;
import com.statnett.weatherservice.dao.PropertiesDao;
import com.statnett.weatherservice.responseentity.Feature;

public class FeatureMapper {
    public FeatureDao mapFeatureObject(Feature feature){
        FeatureDao featureDao = new FeatureDao();
        GeometryDao geometryDao = new GeometryDao();
        PropertiesDao propertiesDao = new PropertiesDao();
        mapFeatureCommonProperties(featureDao,feature);
        mapPropertiesObject(propertiesDao,feature);
        mapGeometryObject(geometryDao,feature);
        featureDao.setGeometry(geometryDao);
        featureDao.setProperties(propertiesDao);

        return featureDao;

    }
    private void mapFeatureCommonProperties(FeatureDao featureDao,Feature feature){
        featureDao.setId(feature.getId());
        featureDao.setType(feature.getType());
    }
    private void mapPropertiesObject(PropertiesDao properties,Feature feature){
        properties.setAlert(feature.getProperties().getAlert());
        properties.setId(feature.getId());
        properties.setMag(feature.getProperties().getMag());
        properties.setPlace(feature.getProperties().getPlace());

    }
    private void mapGeometryObject(GeometryDao geometryDao,Feature feature){
        geometryDao.setId(feature.getId());
        geometryDao.setType(feature.getGeometry().getType());
        geometryDao.setCoordinates(feature.getGeometry().getCoordinates());
    }
}
