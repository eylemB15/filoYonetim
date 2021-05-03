package com.springFilo.springFiloYonetim.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springFilo.springFiloYonetim.models.VehicleMake;
import com.springFilo.springFiloYonetim.repositories.VehicleMakeRepository;

@Service
public class VehicleMakeService {

	@Autowired
	private VehicleMakeRepository vehicleMakeRepository;
	
	
	public List<VehicleMake> getVehicleMakes(){
		return vehicleMakeRepository.findAll();
	}
	
	
	//add new
	public void save(VehicleMake vehicleMake) {
		vehicleMakeRepository.save(vehicleMake);
	}
	
	
	//get by id
	public Optional<VehicleMake> findById(int id){
		return vehicleMakeRepository.findById(id);
	}
	
	
	//delete
	public void delete(int id) {
		vehicleMakeRepository.deleteById(id);
	}
}
