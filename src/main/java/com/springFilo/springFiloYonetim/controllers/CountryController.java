package com.springFilo.springFiloYonetim.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springFilo.springFiloYonetim.models.Country;
import com.springFilo.springFiloYonetim.services.CountryService;

@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	
	//List all country
	@GetMapping("/country")
	public String getCountry(Model model) {
		
		List<Country> countryList=countryService.getCountries();
		model.addAttribute("country" , countryList ); //html olarak görüntülenmesi için modele eklenmesi gerekir
		return "country";
	}
	
	
	//add new country
	@PostMapping("/country/addNew")
	public String addNew(Country country) {
		countryService.save(country);
		return "redirect:/country";
	}
	
	
	//find by id
	@RequestMapping("/country/findById")
	@ResponseBody
	public Optional<Country> findById(int id){
		return countryService.findById(id);
	}
	
	
	//update country
	@RequestMapping(value = "/country/update" ,method = {RequestMethod.PUT , RequestMethod.GET})
	public String updateCountry(Country country) {
		countryService.save(country);
		return "redirect:/country";
	
	}
	
	
	// delete country
	@RequestMapping(value="/country/delete", method= {RequestMethod.DELETE ,RequestMethod.GET})
	public String delete(int id) {
		countryService.delete(id);
		return "redirect:/country";
	}
}
