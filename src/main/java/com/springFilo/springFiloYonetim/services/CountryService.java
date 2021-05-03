package com.springFilo.springFiloYonetim.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springFilo.springFiloYonetim.models.Country;
import com.springFilo.springFiloYonetim.repositories.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	//get all country
	public List<Country> getCountries(){
		return countryRepository.findAll();
	
	}
	
	
	//add new country
	public void save(Country country) {
		countryRepository.save(country);
	}
	
	
	//get by id
	public Optional<Country> findById(int id){
		return countryRepository.findById(id);
	}
	
	
	//delete country
	public void delete(int id) {
		countryRepository.deleteById(id);
	}
}
