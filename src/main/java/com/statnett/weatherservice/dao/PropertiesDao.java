package com.statnett.weatherservice.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "properties")
public class PropertiesDao {
    @Id
    private String id;
    private Double mag;
    private String place;
    private Long time;
    private Long updated;
    private String url;
    private String detail;
    private String tz;
    private String felt;
    private String cdi;
    private String mmi;
    private String alert;
    private String status;
    private String tsunami;
    private String sig;
    private String net;
    private String code;


    @OneToOne(mappedBy = "properties")
    private FeatureDao featureDao;

}
