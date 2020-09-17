package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.Min;


@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameCity;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @Min(value = 1, message = "Khong duoc so am")
    private Double acreage;
    @Min(value = 1, message = "Khong duoc so am")
    private Double population;
    @Min(value = 1, message = "Khong duoc so am")
    private Double gdp;

    private String description;

    public City() {
    }

    public City(Long id, String nameCity, Country country, Double acreage, Double population, Double gdp, String description) {
        this.id = id;
        this.nameCity = nameCity;
        this.country = country;
        this.acreage = acreage;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Double getAcreage() {
        return acreage;
    }

    public void setAcreage(Double acreage) {
        this.acreage = acreage;
    }

    public Double getPopulation() {
        return population;
    }

    public void setPopulation(Double population) {
        this.population = population;
    }

    public Double getGdp() {
        return gdp;
    }

    public void setGdp(Double gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
