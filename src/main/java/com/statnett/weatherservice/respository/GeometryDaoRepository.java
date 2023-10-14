package com.statnett.weatherservice.respository;

import com.statnett.weatherservice.dao.FeatureDao;
import com.statnett.weatherservice.dao.GeometryDao;
import com.statnett.weatherservice.responseentity.Geometry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GeometryDaoRepository extends JpaRepository<GeometryDao,String> {
}
