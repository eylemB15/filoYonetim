package com.springFilo.springFiloYonetim.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springFilo.springFiloYonetim.models.Vehicle;
import com.springFilo.springFiloYonetim.repositories.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	
	//get all vehicleMaintenance
	public List<Vehicle> getVehicles() {
		return vehicleRepository.findAll();
		
	}
	
	//add vehicleMaintenance
	public void save(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}
	
	//get by id
	public Optional<Vehicle> findById(int id) {
		return vehicleRepository.findById(id);
	}
	
	
	//delete vehicleMaintenance
	public void delete(int id) {
		vehicleRepository.deleteById(id);
	}
}
