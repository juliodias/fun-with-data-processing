package com.juliodias.producer.repository;

import com.juliodias.producer.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
