package com.juliodias.producer.controller;

import com.juliodias.producer.model.City;
import com.juliodias.producer.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    private CityRepository cityRepository;

    @Autowired
    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping("cities")
    public List<City> cities() {
        return cityRepository.findAll();
    }
}
