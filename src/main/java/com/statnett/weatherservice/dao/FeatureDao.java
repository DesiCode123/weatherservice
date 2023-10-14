package com.statnett.weatherservice.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeatureDao {
    @Id
    @Column(name="id")
    private String id;
    private String type;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="properies_id",referencedColumnName = "id")
    private PropertiesDao properties;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="geometry_id",referencedColumnName = "id")//adding id for mapping
    private GeometryDao geometry;

}
