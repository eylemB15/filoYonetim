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
import com.springFilo.springFiloYonetim.models.VehicleMaintenance;
import com.springFilo.springFiloYonetim.services.CountryService;
import com.springFilo.springFiloYonetim.services.SupplierService;
import com.springFilo.springFiloYonetim.services.VehicleMaintenanceService;
import com.springFilo.springFiloYonetim.services.VehicleService;

@Controller
public class VehicleMaintenanceController {


	@Autowired
	private VehicleMaintenanceService vehicleMaintenanceService;
	
	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private VehicleService vehicleService;
	
	
	@GetMapping("/vehicleMaintenance")
	public String getVehicleMaintenances(Model model) {
		List<VehicleMaintenance> vehicleMaintenanceList= vehicleMaintenanceService.getVehicleMaintenances();
		model.addAttribute("vehicleMaintenance" , vehicleMaintenanceList );
		
		model.addAttribute("vehicle" , vehicleService.getVehicles());
		model.addAttribute("supplier" ,supplierService.getSuppliers());
		return "vehicleMaintenance";
	}
	
	
	//add vehicleMaintenance
	@PostMapping("/vehicleMaintenance/addNew")
	public String addNew(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehicleMaintenance";
	}
	
	
	//get by id
	@RequestMapping("/vehicleMaintenance/findById")
	@ResponseBody
	public Optional<VehicleMaintenance> findById(int id) {
		return vehicleMaintenanceService.findById(id);
		
	}
	
	
	//update country
	@RequestMapping(value = "/vehicleMaintenance/update" ,method = {RequestMethod.PUT , RequestMethod.GET})
	public String update(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehicleMaintenance";
		
	}
		
		
	// delete country
	@RequestMapping(value="/vehicleMaintenance/delete", method= {RequestMethod.DELETE ,RequestMethod.GET})
	public String delete(int id) {
		vehicleMaintenanceService.delete(id);
		return "redirect:/vehicleMaintenance";
	}

}
