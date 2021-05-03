package com.springFilo.springFiloYonetim.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springFilo.springFiloYonetim.models.Client;
import com.springFilo.springFiloYonetim.models.Invoice;
import com.springFilo.springFiloYonetim.models.InvoiceStatus;
import com.springFilo.springFiloYonetim.services.ClientService;
import com.springFilo.springFiloYonetim.services.InvoiceService;
import com.springFilo.springFiloYonetim.services.InvoiceStatusService;

@Controller
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private InvoiceStatusService invoiceStatusService;
	
	
	
	
	@GetMapping("/invoice")
	public String getInvoices(Model model) {
		List<Invoice> invoiceList= invoiceService.getInvoices();
		model.addAttribute("invoice" , invoiceList );
		
		List<Client> clientList=clientService.getClients();
		model.addAttribute("client" ,clientList);
		
		List<InvoiceStatus> invoiceStatusList=invoiceStatusService.getInvoiceStatus();
		model.addAttribute("invoiceStatus" ,invoiceStatusList);
		
		return "invoice";
	}
	
	
	//add invoice
	@PostMapping("/invoice/addNew")
	public String addNew(Invoice invoice) {
		invoiceService.save(invoice);
		return "redirect:/invoice";
	}
	
	
	//get by id
	@RequestMapping("/invoice/findById")
	@ResponseBody
	public Optional<Invoice> findById(int id) {
		return invoiceService.findById(id);
		
	}
	
	
	//update country
	@RequestMapping(value = "/invoice/update" ,method = {RequestMethod.PUT , RequestMethod.GET})
	public String updateCountry(Invoice invoice) {
		invoiceService.save(invoice);
		return "redirect:/invoice";
		
	}
		
		
	// delete country
	@RequestMapping(value="/invoice/delete", method= {RequestMethod.DELETE ,RequestMethod.GET})
	public String delete(int id) {
		invoiceService.delete(id);
		return "redirect:/invoice";
	}
}
