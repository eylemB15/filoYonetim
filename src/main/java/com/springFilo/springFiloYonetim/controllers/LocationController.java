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
import com.springFilo.springFiloYonetim.models.Location;
import com.springFilo.springFiloYonetim.models.State;
import com.springFilo.springFiloYonetim.services.CountryService;
import com.springFilo.springFiloYonetim.services.LocationService;
import com.springFilo.springFiloYonetim.services.StateService;


@Controller
public class LocationController {
	
	@Autowired
	private LocationService locationService; 
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private CountryService countryService;
	

	@GetMapping("/location")
	public String getLocations(Model model) {
		List<Location> locationList=locationService.getLocations();
		model.addAttribute("location",locationList);
		
		List<Country> countryList=countryService.getCountries();
		model.addAttribute("country" ,countryList);
		
		List<State> stateList= stateService.getStates();
		model.addAttribute("state" , stateList );
		
		return "location";
		
	}
	
	
	
	//add new
	@PostMapping("/location/addNew")
	public String addNew(Location location) {
		locationService.save(location);
		return "redirect:/location";
	}
	
	
	//getById
	@RequestMapping("/location/findById")
	@ResponseBody
	public Optional<Location> findById(int id){
		return locationService.findById(id);
		
	}
	
	
	//update
	@RequestMapping(value="/location/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(Location location) {
		locationService.save(location);
		return "redirect:/location";
	}
	
	
	//delete
	@RequestMapping(value="/location/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id) {
		locationService.delete(id);
		return "redirect:/location";

	}

	

}
