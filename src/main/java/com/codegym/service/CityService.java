package com.codegym.service;

import com.codegym.model.City;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService {
    Page<City> findAll(Pageable pageable);
    City findById(Long id);
    void saveCity(City city);
    void removeCity(Long id);


}
