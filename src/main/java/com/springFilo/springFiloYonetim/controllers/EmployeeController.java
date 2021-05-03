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

import com.springFilo.springFiloYonetim.models.Employee;
import com.springFilo.springFiloYonetim.services.CountryService;
import com.springFilo.springFiloYonetim.services.EmployeeService;
import com.springFilo.springFiloYonetim.services.EmployeeTypeService;
import com.springFilo.springFiloYonetim.services.JobTitleService;
import com.springFilo.springFiloYonetim.services.StateService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeTypeService employeeTypeService;
	
	@Autowired
	private JobTitleService jobTitleService;
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private CountryService countryService;
	
	
	//List all employee
	@GetMapping("/employee")
	public String getEmployee(Model model) {
		
		List<Employee> employeeList=employeeService.getEmployees();
		model.addAttribute("employee" , employeeList ); //html olarak görüntülenmesi için modele eklenmesi gerekir
		
		model.addAttribute("employeeType" ,employeeTypeService.getEmployeeTypes());
		model.addAttribute("jobTitle" ,jobTitleService.getJobTitles());
		model.addAttribute("state" ,stateService.getStates());
		model.addAttribute("country" ,countryService.getCountries());
		
		return "employee";
	}
	
	
	//add new employee
	@PostMapping("/employee/addNew")
	public String addNew(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employee";
	}
	
	
	//find by id
	@RequestMapping("/employee/findById")
	@ResponseBody
	public Optional<Employee> findById(int id){
		return employeeService.findById(id);
	}
	
	
	//update employee
	@RequestMapping(value = "/employee/update" ,method = {RequestMethod.PUT , RequestMethod.GET})
	public String updateEmployee(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employee";
	
	}
	
	
	// delete employee
	@RequestMapping(value="/employee/delete", method= {RequestMethod.DELETE ,RequestMethod.GET})
	public String delete(int id) {
		employeeService.delete(id);
		return "redirect:/employee";
	}

}
