package com.statnett.weatherservice.respository;

import com.statnett.weatherservice.dao.FeatureDao;
import com.statnett.weatherservice.dao.GeometryDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeometryDaoRepository extends JpaRepository<GeometryDao,String> {
}
