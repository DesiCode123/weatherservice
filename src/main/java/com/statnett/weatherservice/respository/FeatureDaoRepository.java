package com.statnett.weatherservice.respository;

import com.statnett.weatherservice.dao.FeatureDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureDaoRepository extends JpaRepository <FeatureDao,String> {
}
