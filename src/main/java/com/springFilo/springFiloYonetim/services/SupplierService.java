package com.springFilo.springFiloYonetim.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springFilo.springFiloYonetim.models.Supplier;
import com.springFilo.springFiloYonetim.repositories.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;
	
	
	//get all supplier
	public List<Supplier> getSuppliers() {
		return supplierRepository.findAll();
		
	}
	
	//add supplier
	public void save(Supplier supplier) {
		supplierRepository.save(supplier);
	}
	
	//get by id
	public Optional<Supplier> findById(int id) {
		return supplierRepository.findById(id);
	}
	
	
	//delete supplier
	public void delete(int id) {
		supplierRepository.deleteById(id);
	}

}
