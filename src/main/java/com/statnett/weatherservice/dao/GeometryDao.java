package com.statnett.weatherservice.dao;

import jakarta.persistence.*;
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

    @OneToOne(mappedBy = "geometry",cascade = CascadeType.PERSIST)
    private FeatureDao featureDao;

}
