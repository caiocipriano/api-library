package com.dev.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.library.models.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer>{

}
