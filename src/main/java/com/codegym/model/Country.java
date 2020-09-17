package com.codegym.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "countrys")
public class Country {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String nameCountry;

    public Country() {
    }

    public Country(Long id, String nameCountry) {
        this.id = id;
        this.nameCountry = nameCountry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }
}
