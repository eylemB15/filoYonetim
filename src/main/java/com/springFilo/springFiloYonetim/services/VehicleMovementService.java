package com.springFilo.springFiloYonetim.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springFilo.springFiloYonetim.models.VehicleMovement;
import com.springFilo.springFiloYonetim.repositories.VehicleMovementRepository;

@Service
public class VehicleMovementService {

	@Autowired
	private VehicleMovementRepository vehicleMovementRepository;
	
	
	//get all vehicleMovementMaintenance
	public List<VehicleMovement> getVehicleMovements() {
		return vehicleMovementRepository.findAll();
		
	}
	
	//add vehicleMovementMaintenance
	public void save(VehicleMovement vehicleMovement) {
		vehicleMovementRepository.save(vehicleMovement);
	}
	
	//get by id
	public Optional<VehicleMovement> findById(int id) {
		return vehicleMovementRepository.findById(id);
	}
	
	
	//delete vehicleMovementMaintenance
	public void delete(int id) {
		vehicleMovementRepository.deleteById(id);
	}
}
