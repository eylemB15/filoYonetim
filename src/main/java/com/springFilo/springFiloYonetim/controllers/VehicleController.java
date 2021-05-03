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

import com.springFilo.springFiloYonetim.models.Vehicle;
import com.springFilo.springFiloYonetim.services.EmployeeService;
import com.springFilo.springFiloYonetim.services.LocationService;
import com.springFilo.springFiloYonetim.services.VehicleMakeService;
import com.springFilo.springFiloYonetim.services.VehicleModelService;
import com.springFilo.springFiloYonetim.services.VehicleService;
import com.springFilo.springFiloYonetim.services.VehicleStatusService;
import com.springFilo.springFiloYonetim.services.VehicleTypeService;

@Controller
public class VehicleController {


	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private VehicleTypeService vehicleTypeService;
	
	@Autowired
	private VehicleMakeService vehicleMakeService;
	
	@Autowired
	private VehicleModelService vehicleModelService;
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private VehicleStatusService vehicleStatusService;
	

	
	@GetMapping("/vehicle")
	public String getVehicles(Model model) {
		List<Vehicle> vehicleList= vehicleService.getVehicles();
		model.addAttribute("vehicle" , vehicleList );
		
		model.addAttribute("vehicleType" , vehicleTypeService.getVehicleTypes() );
		model.addAttribute("vehicleMake" , vehicleMakeService.getVehicleMakes() );
		model.addAttribute("vehicleModel" , vehicleModelService.getVehicleModels() );
		model.addAttribute("location" , locationService.getLocations() );
		model.addAttribute("employee" , employeeService.getEmployees() );
		model.addAttribute("vehicleStatus" , vehicleStatusService.getVehicleStatus() );
		
	
		return "vehicle";
	}
	
	
	//add vehicle
	@PostMapping("/vehicle/addNew")
	public String addNew(Vehicle vehicle) {
		vehicleService.save(vehicle);
		return "redirect:/vehicle";
	}
	
	
	//get by id
	@RequestMapping("/vehicle/findById")
	@ResponseBody
	public Optional<Vehicle> findById(int id) {
		return vehicleService.findById(id);
		
	}
	
	
	//update country
	@RequestMapping(value = "/vehicle/update" ,method = {RequestMethod.PUT , RequestMethod.GET})
	public String update(Vehicle vehicle) {
		vehicleService.save(vehicle);
		return "redirect:/vehicle";
		
	}
		
		
	// delete country
	@RequestMapping(value="/vehicle/delete", method= {RequestMethod.DELETE ,RequestMethod.GET})
	public String delete(int id) {
		vehicleService.delete(id);
		return "redirect:/vehicle";
	}

}
