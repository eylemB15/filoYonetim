package com.springFilo.springFiloYonetim.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springFilo.springFiloYonetim.models.VehicleModel;
import com.springFilo.springFiloYonetim.repositories.VehicleModelRepository;

@Service
public class VehicleModelService {

	@Autowired
	private VehicleModelRepository vehicleModelRepository;
	
	
	public List<VehicleModel> getVehicleModels(){
		return vehicleModelRepository.findAll();
	}
	
	
	//add new
	public void save(VehicleModel vehicleModel) {
		vehicleModelRepository.save(vehicleModel);
	}
	
	
	//get by id
	public Optional<VehicleModel> findById(int id){
		return vehicleModelRepository.findById(id);
	}
	
	
	//delete
	public void delete(int id) {
		vehicleModelRepository.deleteById(id);
	}
}
