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

import com.springFilo.springFiloYonetim.models.Country;
import com.springFilo.springFiloYonetim.models.Supplier;
import com.springFilo.springFiloYonetim.models.State;
import com.springFilo.springFiloYonetim.services.CountryService;
import com.springFilo.springFiloYonetim.services.SupplierService;
import com.springFilo.springFiloYonetim.services.StateService;

@Controller
public class SupplierController {

	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;
	
	
	
	
	@GetMapping("/supplier")
	public String getSuppliers(Model model) {
		List<Supplier> supplierList= supplierService.getSuppliers();
		model.addAttribute("supplier" , supplierList );
		
		List<Country> countryList=countryService.getCountries();
		model.addAttribute("country" ,countryList);
		
		List<State> stateList=stateService.getStates();
		model.addAttribute("state" ,stateList);
		
		return "supplier";
	}
	
	
	//add supplier
	@PostMapping("/supplier/addNew")
	public String addNew(Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/supplier";
	}
	
	
	//get by id
	@RequestMapping("/supplier/findById")
	@ResponseBody
	public Optional<Supplier> findById(int id) {
		return supplierService.findById(id);
		
	}
	
	
	//update country
	@RequestMapping(value = "/supplier/update" ,method = {RequestMethod.PUT , RequestMethod.GET})
	public String updateCountry(Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/supplier";
		
	}
		
		
	// delete country
	@RequestMapping(value="/supplier/delete", method= {RequestMethod.DELETE ,RequestMethod.GET})
	public String delete(int id) {
		supplierService.delete(id);
		return "redirect:/supplier";
	}

}
