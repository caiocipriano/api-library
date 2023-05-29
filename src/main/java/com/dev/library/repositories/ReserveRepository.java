package com.dev.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.library.models.Reserve;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Integer>{

}
