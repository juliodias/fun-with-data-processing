package com.juliodias.producer.model;

import javax.persistence.*;
import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String country;

    @Column
    private String subcountry;

    @Column
    private Long geonameid;

    public City() {
    }

    public City(String name, String country, String subcountry, Long geonameid) {
        this.name = name;
        this.country = country;
        this.geonameid = geonameid;
        this.subcountry = subcountry;
    }

    public String getName() {
        return name;
    }

    public Long getGeonameid() {
        return geonameid;
    }

    public String getCountry() {
        return country;
    }

    public String getSubcountry() {
        return subcountry;
    }

}
