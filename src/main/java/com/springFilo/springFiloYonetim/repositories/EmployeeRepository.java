package com.springFilo.springFiloYonetim.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springFilo.springFiloYonetim.models.*;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public Employee findByUsername(String un);
}
