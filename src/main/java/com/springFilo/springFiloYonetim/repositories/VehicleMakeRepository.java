package com.springFilo.springFiloYonetim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springFilo.springFiloYonetim.models.*;

@Repository
public interface VehicleMakeRepository extends JpaRepository<VehicleMake, Integer> {

}
