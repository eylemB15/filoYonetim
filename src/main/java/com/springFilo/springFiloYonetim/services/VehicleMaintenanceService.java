package com.springFilo.springFiloYonetim.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springFilo.springFiloYonetim.models.VehicleMaintenance;
import com.springFilo.springFiloYonetim.repositories.VehicleMaintenanceRepository;

@Service
public class VehicleMaintenanceService {

	@Autowired
	private VehicleMaintenanceRepository vehicleMaintenanceRepository;
	
	
	//get all vehicleMaintenance
	public List<VehicleMaintenance> getVehicleMaintenances() {
		return vehicleMaintenanceRepository.findAll();
		
	}
	
	//add vehicleMaintenance
	public void save(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceRepository.save(vehicleMaintenance);
	}
	
	//get by id
	public Optional<VehicleMaintenance> findById(int id) {
		return vehicleMaintenanceRepository.findById(id);
	}
	
	
	//delete vehicleMaintenance
	public void delete(int id) {
		vehicleMaintenanceRepository.deleteById(id);
	}
}
