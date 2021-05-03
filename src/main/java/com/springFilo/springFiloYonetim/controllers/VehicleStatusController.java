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

import com.springFilo.springFiloYonetim.models.VehicleStatus;
import com.springFilo.springFiloYonetim.services.VehicleStatusService;

@Controller
public class VehicleStatusController {

	@Autowired
	private VehicleStatusService vehicleStatusService; 
	

	@GetMapping("/vehicleStatus")
	public String getVehicleStatuss(Model model) {
		List<VehicleStatus> vehicleStatusList=vehicleStatusService.getVehicleStatus();
		model.addAttribute("vehicleStatus",vehicleStatusList);
		
				
		return "vehicleStatus";
		
	}
	
	
	//add new
	@PostMapping("/vehicleStatus/addNew")
	public String addNew(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehicleStatus";
	}
	
	
	//getById
	@RequestMapping("/vehicleStatus/findById")
	@ResponseBody
	public Optional<VehicleStatus> findById(int id){
		return vehicleStatusService.findById(id);
		
	}
	
	
	//update
	@RequestMapping(value="/vehicleStatus/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehicleStatus";
	}
	
	
	//delete
	@RequestMapping(value="/vehicleStatus/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id) {
		vehicleStatusService.delete(id);
		return "redirect:/vehicleStatus";

	}


}
