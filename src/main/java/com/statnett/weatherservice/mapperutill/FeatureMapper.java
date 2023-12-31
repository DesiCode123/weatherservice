package com.statnett.weatherservice.mapperutill;

import com.statnett.weatherservice.dao.FeatureDao;
import com.statnett.weatherservice.dao.GeometryDao;
import com.statnett.weatherservice.dao.PropertiesDao;
import com.statnett.weatherservice.responseentity.Feature;
import org.springframework.stereotype.Component;
import com.statnett.weatherservice.exception.FeatureMappingException;

@Component
public class FeatureMapper {

    public FeatureDao mapFeatureObject(Feature feature) {
        if (feature == null) {
            throw new FeatureMappingException("Provided feature object is null.");
        }

        FeatureDao featureDao = new FeatureDao();
        GeometryDao geometryDao = new GeometryDao();
        PropertiesDao propertiesDao = new PropertiesDao();

        propertiesDao.setAlert(feature.getProperties().getAlert());
        propertiesDao.setId(feature.getId());
        propertiesDao.setMag(feature.getProperties().getMag());
        propertiesDao.setPlace(feature.getProperties().getPlace());
        propertiesDao.setDetail(feature.getProperties().getDetail());
        propertiesDao.setStatus(feature.getProperties().getStatus());

        geometryDao.setId(feature.getId());
        geometryDao.setType(feature.getGeometry().getType());
        geometryDao.setCoordinates(feature.getGeometry().getCoordinates());

        featureDao.setId(feature.getId());
        featureDao.setType(feature.getType());

        featureDao.setGeometry(geometryDao);
        featureDao.setProperties(propertiesDao);

        return featureDao;
    }
}
