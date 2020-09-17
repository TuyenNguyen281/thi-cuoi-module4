package com.codegym.controller;


import com.codegym.model.City;
import com.codegym.model.Country;
import com.codegym.service.CityService;
import com.codegym.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @ModelAttribute("countries")
    public Iterable<Country> countries() {
        return countryService.findAll();
    }

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public String listCity(Model model, @RequestParam("page") Optional<String> page, Pageable pageable) {

        Page<City> listCity;
        int t = 0;
        if (page.isPresent()) {
            t = Integer.parseInt( page.get() );
        }
        pageable = new PageRequest( t, 5 );
        listCity = cityService.findAll( pageable );
        model.addAttribute( "listCity", listCity );
        return "/listCity";
    }

    @RequestMapping(value = "/detailCity/{id}", method = RequestMethod.GET)
    public String detailCity(Model model, @PathVariable("id") Long id) {
        City city = cityService.findById( id );
        model.addAttribute( "city", city );
        return "/detail";
    }

    @RequestMapping(value = "/createCity", method = RequestMethod.GET)
    public String formCreateCity(Model model) {
        model.addAttribute( "city", new City() );
        return "/create";
    }

    @RequestMapping(value = "/createCity", method = RequestMethod.POST)
    public String createCity(@ModelAttribute("city") City city, Model model) {
        cityService.saveCity( city );
        model.addAttribute( "city", new City() );
        model.addAttribute( "message", "New city created successfully" );
        return "/create";
    }

    @RequestMapping(value = "/deleteCity/{id}", method = RequestMethod.GET)
    public String formDeleteCity(@PathVariable("id") Long id, Model model) {
        City city = cityService.findById( id );
        model.addAttribute( "city", city );

        return "/delete";
    }

    @PostMapping("/delete-city")
    public String deleteCity(@ModelAttribute("customer") City city) {
        cityService.removeCity( city.getId() );
        return "redirect:city";
    }

    @RequestMapping(value = "/editCity/{id}", method = RequestMethod.GET)
    public String formEditCity(@PathVariable("id") Long id, Model model) {
        City city = cityService.findById( id );
        model.addAttribute( "city", city );
        return "/edit";
    }

    @RequestMapping(value = "/editCity", method = RequestMethod.POST)
    public String EditCity(@ModelAttribute("city") City city, Model model) {
        cityService.saveCity( city );
        model.addAttribute( "city", city );
        model.addAttribute( "message", "City updated successfully" );
        return "/edit";
    }

}
