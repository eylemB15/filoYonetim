package com.springFilo.springFiloYonetim.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springFilo.springFiloYonetim.models.VehicleHire;
import com.springFilo.springFiloYonetim.repositories.VehicleHireRepository;

@Service
public class VehicleHireService {

	@Autowired
	private VehicleHireRepository vehicleHireRepository;
	
	
	//get all vehicleHire
	public List<VehicleHire> getVehicleHires() {
		return vehicleHireRepository.findAll();
		
	}
	
	//add vehicleHire
	public void save(VehicleHire vehicleHire) {
		vehicleHireRepository.save(vehicleHire);
	}
	
	//get by id
	public Optional<VehicleHire> findById(int id) {
		return vehicleHireRepository.findById(id);
	}
	
	
	//delete vehicleHire
	public void delete(int id) {
		vehicleHireRepository.deleteById(id);
	}

}
