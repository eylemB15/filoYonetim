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

import com.springFilo.springFiloYonetim.models.InvoiceStatus;
import com.springFilo.springFiloYonetim.services.InvoiceStatusService;

@Controller
public class InvoiceStatusController {

	@Autowired
	private InvoiceStatusService invoiceStatusService; 
	

	@GetMapping("/invoiceStatus")
	public String getInvoiceStatuss(Model model) {
		List<InvoiceStatus> invoiceStatusList=invoiceStatusService.getInvoiceStatus();
		model.addAttribute("invoiceStatus",invoiceStatusList);
		
				
		return "invoiceStatus";
		
	}
	
	
	//add new
	@PostMapping("/invoiceStatus/addNew")
	public String addNew(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoiceStatus";
	}
	
	
	//getById
	@RequestMapping("/invoiceStatus/findById")
	@ResponseBody
	public Optional<InvoiceStatus> findById(int id){
		return invoiceStatusService.findById(id);
		
	}
	
	
	//update
	@RequestMapping(value="/invoiceStatus/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoiceStatus";
	}
	
	
	//delete
	@RequestMapping(value="/invoiceStatus/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id) {
		invoiceStatusService.delete(id);
		return "redirect:/invoiceStatus";

	}

}
