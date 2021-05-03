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

import com.springFilo.springFiloYonetim.models.Client;
import com.springFilo.springFiloYonetim.models.Country;
import com.springFilo.springFiloYonetim.models.State;
import com.springFilo.springFiloYonetim.services.ClientService;
import com.springFilo.springFiloYonetim.services.CountryService;
import com.springFilo.springFiloYonetim.services.StateService;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;

	@GetMapping("/client")
	public String getClients(Model model) {
		List<Client> clientList=clientService.getClients();
		model.addAttribute("client",clientList);
		
		model.addAttribute("country",countryService.getCountries());
		
		model.addAttribute("state",stateService.getStates());
		
		return "client";
	}
	
	
	
	//add new
	@PostMapping("client/addNew")
	public String addNew(Client client) {
		clientService.save(client);
		return "redirect:/client";
	}
	
	
	
	//find by id
	@RequestMapping("/client/findById")
	@ResponseBody
	public Optional<Client> findById(int id) {
		return clientService.findById(id);
		
	}
	
	
	//update
	@RequestMapping(value="/client/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(Client client) {
		clientService.save(client);
		return "redirect:/client";
	}
	
	
	//delete
	@RequestMapping(value="/client/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id) {
		clientService.delete(id);
		return "redirect:/client";
	}
	
	
}
