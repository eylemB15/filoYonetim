package com.springFilo.springFiloYonetim.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springFilo.springFiloYonetim.models.VehicleStatus;
import com.springFilo.springFiloYonetim.repositories.VehicleStatusRepository;

@Service
public class VehicleStatusService {
	@Autowired
	private VehicleStatusRepository vehicleStatusRepository;
	
	
	public List<VehicleStatus> getVehicleStatus(){
		return vehicleStatusRepository.findAll();
	}
	
	
	//add new
	public void save(VehicleStatus vehicleStatus) {
		vehicleStatusRepository.save(vehicleStatus);
	}
	
	
	//get by id
	public Optional<VehicleStatus> findById(int id){
		return vehicleStatusRepository.findById(id);
	}
	
	
	//delete
	public void delete(int id) {
		vehicleStatusRepository.deleteById(id);
	}
}
