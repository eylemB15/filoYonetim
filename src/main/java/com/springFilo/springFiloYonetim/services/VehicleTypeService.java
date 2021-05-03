package com.springFilo.springFiloYonetim.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springFilo.springFiloYonetim.models.VehicleType;
import com.springFilo.springFiloYonetim.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {

	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;
	
	
	public List<VehicleType> getVehicleTypes(){
		return vehicleTypeRepository.findAll();
	}
	
	
	//add new
	public void save(VehicleType vehicleType) {
		vehicleTypeRepository.save(vehicleType);
	}
	
	
	//get by id
	public Optional<VehicleType> findById(int id){
		return vehicleTypeRepository.findById(id);
	}
	
	
	//delete
	public void delete(int id) {
		vehicleTypeRepository.deleteById(id);
	}
}
