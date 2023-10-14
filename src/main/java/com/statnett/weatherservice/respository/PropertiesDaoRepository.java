package com.statnett.weatherservice.respository;

import com.statnett.weatherservice.dao.PropertiesDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertiesDaoRepository extends JpaRepository<PropertiesDao,String> {
}
