package com.dev.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.library.models.UF;

@Repository
public interface UFRepository extends JpaRepository<UF, Integer>{

}
