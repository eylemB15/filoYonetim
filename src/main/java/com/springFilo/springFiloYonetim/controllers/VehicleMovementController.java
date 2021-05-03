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

import com.springFilo.springFiloYonetim.models.VehicleMovement;
import com.springFilo.springFiloYonetim.services.LocationService;
import com.springFilo.springFiloYonetim.services.SupplierService;
import com.springFilo.springFiloYonetim.services.VehicleMovementService;
import com.springFilo.springFiloYonetim.services.VehicleService;

@Controller
public class VehicleMovementController {


	@Autowired
	private VehicleMovementService vehicleMovementService;
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private VehicleService vehicleService;
	
	
	@GetMapping("/vehicleMovement")
	public String getVehicleMovements(Model model) {
		List<VehicleMovement> vehicleMovementList= vehicleMovementService.getVehicleMovements();
		model.addAttribute("vehicleMovement" , vehicleMovementList );
		
		model.addAttribute("vehicle" , vehicleService.getVehicles());
		model.addAttribute("location" ,locationService.getLocations());
		return "vehicleMovement";
	}
	
	
	//add vehicleMovement
	@PostMapping("/vehicleMovement/addNew")
	public String addNew(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehicleMovement";
	}
	
	
	//get by id
	@RequestMapping("/vehicleMovement/findById")
	@ResponseBody
	public Optional<VehicleMovement> findById(int id) {
		return vehicleMovementService.findById(id);
		
	}
	
	
	//update country
	@RequestMapping(value = "/vehicleMovement/update" ,method = {RequestMethod.PUT , RequestMethod.GET})
	public String update(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehicleMovement";
		
	}
		
		
	// delete country
	@RequestMapping(value="/vehicleMovement/delete", method= {RequestMethod.DELETE ,RequestMethod.GET})
	public String delete(int id) {
		vehicleMovementService.delete(id);
		return "redirect:/vehicleMovement";
	}


}
