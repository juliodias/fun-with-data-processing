package com.juliodias.producer.service;

import com.juliodias.producer.model.City;
import com.juliodias.producer.repository.CityRepository;
import com.juliodias.producer.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.stream.Stream;

@Service
public class CityService {

    private static final Logger LOG = LoggerFactory.getLogger(CityService.class);

    private final CityRepository cityRepository;
    private final FileUtils fileUtils;

    public CityService(CityRepository cityRepository, FileUtils fileUtils) {
        this.cityRepository = cityRepository;
        this.fileUtils = fileUtils;
    }

    @PostConstruct
    public void populateCities() {
        LOG.info("Starting process of populate cities...");
        try {
            Stream<City> cities = fileUtils.getCities();
            cities.forEach(city -> cityRepository.save(city));
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        LOG.info("Finalizing process of populate cities...");
    }
}
