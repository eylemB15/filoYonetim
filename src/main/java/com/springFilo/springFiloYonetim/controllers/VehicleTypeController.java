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

import com.springFilo.springFiloYonetim.models.VehicleType;
import com.springFilo.springFiloYonetim.services.VehicleTypeService;

@Controller
public class VehicleTypeController {

	@Autowired
	private VehicleTypeService vehicleTypeService; 
	

	@GetMapping("/vehicleType")
	public String getVehicleTypes(Model model) {
		List<VehicleType> vehicleTypeList=vehicleTypeService.getVehicleTypes();
		model.addAttribute("vehicleType",vehicleTypeList);
		
				
		return "vehicleType";
		
	}
	
	
	//add new
	@PostMapping("/vehicleType/addNew")
	public String addNew(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicleType";
	}
	
	
	//getById
	@RequestMapping("/vehicleType/findById")
	@ResponseBody
	public Optional<VehicleType> findById(int id){
		return vehicleTypeService.findById(id);
		
	}
	
	
	//update
	@RequestMapping(value="/vehicleType/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicleType";
	}
	
	
	//delete
	@RequestMapping(value="/vehicleType/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id) {
		vehicleTypeService.delete(id);
		return "redirect:/vehicleType";

	}


}
