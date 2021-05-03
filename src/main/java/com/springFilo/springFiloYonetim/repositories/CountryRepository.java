package com.springFilo.springFiloYonetim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springFilo.springFiloYonetim.*;
import com.springFilo.springFiloYonetim.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
