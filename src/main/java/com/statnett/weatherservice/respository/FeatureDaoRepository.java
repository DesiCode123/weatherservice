package com.statnett.weatherservice.respository;

import com.statnett.weatherservice.dao.FeatureDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureDaoRepository extends JpaRepository <FeatureDao,String> {
}
