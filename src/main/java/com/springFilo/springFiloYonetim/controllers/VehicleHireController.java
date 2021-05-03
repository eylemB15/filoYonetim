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

import com.springFilo.springFiloYonetim.models.VehicleHire;
import com.springFilo.springFiloYonetim.services.ClientService;
import com.springFilo.springFiloYonetim.services.LocationService;
import com.springFilo.springFiloYonetim.services.VehicleHireService;
import com.springFilo.springFiloYonetim.services.VehicleService;

@Controller
public class VehicleHireController {

	@Autowired
	private VehicleHireService vehicleHireService;
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private ClientService clientService;
	
	
	@GetMapping("/vehicleHire")
	public String getVehicleHires(Model model) {
		List<VehicleHire> vehicleHireList= vehicleHireService.getVehicleHires();
		model.addAttribute("vehicleHire" , vehicleHireList );
		
		model.addAttribute("vehicle" , vehicleService.getVehicles());
		model.addAttribute("location" ,locationService.getLocations());
		model.addAttribute("client" ,clientService.getClients());
		return "vehicleHire";
	}
	
	
	//add vehicleHire
	@PostMapping("/vehicleHire/addNew")
	public String addNew(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehicleHire";
	}
	
	
	//get by id
	@RequestMapping("/vehicleHire/findById")
	@ResponseBody
	public Optional<VehicleHire> findById(int id) {
		return vehicleHireService.findById(id);
		
	}
	
	
	//update country
	@RequestMapping(value = "/vehicleHire/update" ,method = {RequestMethod.PUT , RequestMethod.GET})
	public String update(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehicleHire";
		
	}
		
		
	// delete country
	@RequestMapping(value="/vehicleHire/delete", method= {RequestMethod.DELETE ,RequestMethod.GET})
	public String delete(int id) {
		vehicleHireService.delete(id);
		return "redirect:/vehicleHire";
	}



}
