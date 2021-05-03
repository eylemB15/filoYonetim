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

import com.springFilo.springFiloYonetim.models.VehicleModel;
import com.springFilo.springFiloYonetim.services.VehicleModelService;

@Controller
public class VehicleModelController {
	
	@Autowired
	private VehicleModelService vehicleModelService; 
	

	@GetMapping("/vehicleModel")
	public String getVehicleModels(Model model) {
		List<VehicleModel> vehicleModelList=vehicleModelService.getVehicleModels();
		model.addAttribute("vehicleModel",vehicleModelList);
		
				
		return "vehicleModel";
		
	}
	
	
	//add new
	@PostMapping("/vehicleModel/addNew")
	public String addNew(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);
		return "redirect:/vehicleModel";
	}
	
	
	//getById
	@RequestMapping("/vehicleModel/findById")
	@ResponseBody
	public Optional<VehicleModel> findById(int id){
		return vehicleModelService.findById(id);
		
	}
	
	
	//update
	@RequestMapping(value="/vehicleModel/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);
		return "redirect:/vehicleModel";
	}
	
	
	//delete
	@RequestMapping(value="/vehicleModel/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id) {
		vehicleModelService.delete(id);
		return "redirect:/vehicleModel";

	}


}
