package com.statnett.weatherservice.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "geometry")
public class GeometryDao {
    @Id
    private String id;
    private String type;
    private List<String> coordinates;

    @OneToOne(mappedBy = "geometry")
    private FeatureDao featureDao;

}
