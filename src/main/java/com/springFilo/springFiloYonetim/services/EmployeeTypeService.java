package com.springFilo.springFiloYonetim.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springFilo.springFiloYonetim.models.EmployeeType;
import com.springFilo.springFiloYonetim.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {

	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;
	
	
	public List<EmployeeType> getEmployeeTypes(){
		return employeeTypeRepository.findAll();
	}
	
	
	//add new
	public void save(EmployeeType employeeType) {
		employeeTypeRepository.save(employeeType);
	}
	
	
	//get by id
	public Optional<EmployeeType> findById(int id){
		return employeeTypeRepository.findById(id);
	}
	
	
	//delete
	public void delete(int id) {
		employeeTypeRepository.deleteById(id);
	}
}
