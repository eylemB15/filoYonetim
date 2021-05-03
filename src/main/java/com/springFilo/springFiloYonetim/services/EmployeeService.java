package com.springFilo.springFiloYonetim.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springFilo.springFiloYonetim.models.Employee;
import com.springFilo.springFiloYonetim.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	//get all employee
	public List<Employee> getEmployees(){
		return employeeRepository.findAll();
	
	}
	
	
	//add new employee
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}
	
	
	//get by id
	public Optional<Employee> findById(int id){
		return employeeRepository.findById(id);
	}
	
	
	//delete employee
	public void delete(int id) {
		employeeRepository.deleteById(id);
	}
}
