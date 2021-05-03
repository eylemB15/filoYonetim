package com.springFilo.springFiloYonetim.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.springFilo.springFiloYonetim.models.Location;
import com.springFilo.springFiloYonetim.repositories.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	
	public List<Location> getLocations(){
		return locationRepository.findAll();
	}
	
	
	//add new
	public void save(Location location) {
		locationRepository.save(location);
	}
	
	
	//get by id
	public Optional<Location> findById(int id){
		return locationRepository.findById(id);
	}
	
	
	//delete
	public void delete(int id) {
		locationRepository.deleteById(id);
	}
}
