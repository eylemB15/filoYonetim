package com.springFilo.springFiloYonetim.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springFilo.springFiloYonetim.models.Invoice;
import com.springFilo.springFiloYonetim.repositories.InvoiceRepository;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	
	//get all invoice
	public List<Invoice> getInvoices() {
		return invoiceRepository.findAll();
		
	}
	
	//add invoice
	public void save(Invoice invoice) {
		invoiceRepository.save(invoice);
	}
	
	//get by id
	public Optional<Invoice> findById(int id) {
		return invoiceRepository.findById(id);
	}
	
	
	//delete invoice
	public void delete(int id) {
		invoiceRepository.deleteById(id);
	}
}
