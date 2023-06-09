package com.dev.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.library.models.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{

}
