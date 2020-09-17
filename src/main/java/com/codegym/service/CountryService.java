package com.codegym.service;

import com.codegym.model.City;
import com.codegym.model.Country;

public interface CountryService {
    Iterable<Country> findAll();
    Country findById(Long id);
}
