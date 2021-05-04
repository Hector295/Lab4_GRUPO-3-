package com.example.laboratorio4.entity;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Countries {

    @Id
    @Column(name = "country_id")
    private String id;
    @Column(name = "country_name")
    private String countryname;
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Regions regions;

    public Regions getRegions() {
        return regions;
    }

    public void setRegions(Regions regions) {
        this.regions = regions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

}
