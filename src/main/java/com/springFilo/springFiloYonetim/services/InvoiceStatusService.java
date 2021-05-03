package com.springFilo.springFiloYonetim.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springFilo.springFiloYonetim.models.InvoiceStatus;
import com.springFilo.springFiloYonetim.repositories.InvoiceStatusRepository;

@Service
public class InvoiceStatusService {

	@Autowired
	private InvoiceStatusRepository invoiceStatusRepository;
	
	
	public List<InvoiceStatus> getInvoiceStatus(){
		return invoiceStatusRepository.findAll();
	}
	
	
	//add new
	public void save(InvoiceStatus invoiceStatus) {
		invoiceStatusRepository.save(invoiceStatus);
	}
	
	
	//get by id
	public Optional<InvoiceStatus> findById(int id){
		return invoiceStatusRepository.findById(id);
	}
	
	
	//delete
	public void delete(int id) {
		invoiceStatusRepository.deleteById(id);
	}
}
