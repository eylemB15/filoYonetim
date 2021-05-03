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
import com.springFilo.springFiloYonetim.models.JobTitle;
import com.springFilo.springFiloYonetim.models.State;
import com.springFilo.springFiloYonetim.services.CountryService;
import com.springFilo.springFiloYonetim.services.JobTitleService;
import com.springFilo.springFiloYonetim.services.StateService;

@Controller
public class JobTitleController {

	@Autowired
	private JobTitleService jobTitleService; 
	

	@GetMapping("/jobTitle")
	public String getJobTitles(Model model) {
		List<JobTitle> jobTitleList=jobTitleService.getJobTitles();
		model.addAttribute("jobTitle",jobTitleList);
		
				
		return "jobTitle";
		
	}
	
	
	//add new
	@PostMapping("/jobTitle/addNew")
	public String addNew(JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return "redirect:/jobTitle";
	}
	
	
	//getById
	@RequestMapping("/jobTitle/findById")
	@ResponseBody
	public Optional<JobTitle> findById(int id){
		return jobTitleService.findById(id);
		
	}
	
	
	//update
	@RequestMapping(value="/jobTitle/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return "redirect:/jobTitle";
	}
	
	
	//delete
	@RequestMapping(value="/jobTitle/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id) {
		jobTitleService.delete(id);
		return "redirect:/jobTitle";

	}

}
