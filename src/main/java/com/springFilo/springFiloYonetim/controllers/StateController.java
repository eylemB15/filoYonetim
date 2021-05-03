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
import com.springFilo.springFiloYonetim.models.State;
import com.springFilo.springFiloYonetim.services.CountryService;
import com.springFilo.springFiloYonetim.services.StateService;

@Controller
public class StateController {
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private CountryService countryService;
	
	
	@GetMapping("/state")
	public String getStates(Model model) {
		List<State> stateList= stateService.getStates();
		model.addAttribute("state" , stateList );
		
		List<Country> countryList=countryService.getCountries();
		model.addAttribute("country" ,countryList);
		return "state";
	}
	
	
	//add state
	@PostMapping("/state/addNew")
	public String addNew(State state) {
		stateService.save(state);
		return "redirect:/state";
	}
	
	
	//get by id
	@RequestMapping("/state/findById")
	@ResponseBody
	public Optional<State> findById(int id) {
		return stateService.findById(id);
		
	}
	
	
	//update country
	@RequestMapping(value = "/state/update" ,method = {RequestMethod.PUT , RequestMethod.GET})
	public String updateCountry(State state) {
		stateService.save(state);
		return "redirect:/state";
		
	}
		
		
	// delete country
	@RequestMapping(value="/state/delete", method= {RequestMethod.DELETE ,RequestMethod.GET})
	public String delete(int id) {
		stateService.delete(id);
		return "redirect:/state";
	}

}
