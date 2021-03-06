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

import com.springFilo.springFiloYonetim.models.EmployeeType;
import com.springFilo.springFiloYonetim.services.EmployeeTypeService;

@Controller
public class EmployeeTypeController {

	@Autowired
	private EmployeeTypeService employeeTypeService; 
	

	@GetMapping("/employeeType")
	public String getEmployeeTypes(Model model) {
		List<EmployeeType> employeeTypeList=employeeTypeService.getEmployeeTypes();
		model.addAttribute("employeeType",employeeTypeList);
		
				
		return "employeeType";
		
	}
	
	
	//add new
	@PostMapping("/employeeType/addNew")
	public String addNew(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return "redirect:/employeeType";
	}
	
	
	//getById
	@RequestMapping("/employeeType/findById")
	@ResponseBody
	public Optional<EmployeeType> findById(int id){
		return employeeTypeService.findById(id);
		
	}
	
	
	//update
	@RequestMapping(value="/employeeType/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return "redirect:/employeeType";
	}
	
	
	//delete
	@RequestMapping(value="/employeeType/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id) {
		employeeTypeService.delete(id);
		return "redirect:/employeeType";

	}


}
