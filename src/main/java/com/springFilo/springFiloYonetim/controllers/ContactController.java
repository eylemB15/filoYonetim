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

import com.springFilo.springFiloYonetim.models.Contact;
import com.springFilo.springFiloYonetim.services.ContactService;
import com.springFilo.springFiloYonetim.services.CountryService;
import com.springFilo.springFiloYonetim.services.StateService;

@Controller
public class ContactController {@Autowired
	private ContactService contactService;
	
	
	@GetMapping("/contact")
	public String getContacts(Model model) {
		List<Contact> contactList=contactService.getContacts();
		model.addAttribute("contact",contactList);
				
		return "contact";
	}
	
	
	
	//add new
	@PostMapping("contact/addNew")
	public String addNew(Contact contact) {
		contactService.save(contact);
		return "redirect:/contact";
	}
	
	
	
	//find by id
	@RequestMapping("/contact/findById")
	@ResponseBody
	public Optional<Contact> findById(int id) {
		return contactService.findById(id);
		
	}
	
	
	//update
	@RequestMapping(value="/contact/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(Contact contact) {
		contactService.save(contact);
		return "redirect:/contact";
	}
	
	
	//delete
	@RequestMapping(value="/contact/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id) {
		contactService.delete(id);
		return "redirect:/contact";
	}}
