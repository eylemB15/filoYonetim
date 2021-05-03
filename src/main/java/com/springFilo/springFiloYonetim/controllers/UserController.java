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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.springFilo.springFiloYonetim.models.User;
import com.springFilo.springFiloYonetim.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public String getUsers(Model model) {
		List<User> userList= userService.getUsers();
		model.addAttribute("user" , userList );
		
	
		return "user";
	}
	
	
	//add user
	//Modified method to Add a new user User
	@PostMapping(value="/user/addNew")
	public RedirectView addNew(User user, RedirectAttributes redir) {
		userService.save(user);	
		RedirectView  redirectView= new RedirectView("/login",true);
	        redir.addFlashAttribute("message",
	    		"You successfully registered! You can now login");
	    return redirectView;				
	}	
	
	
	//get by id
	@RequestMapping("/user/findById")
	@ResponseBody
	public Optional<User> findById(int id) {
		return userService.findById(id);
		
	}
	
	
	//update country
	@RequestMapping(value = "/user/update" ,method = {RequestMethod.PUT , RequestMethod.GET})
	public String update(User user) {
		userService.save(user);
		return "redirect:/user";
		
	}
		
		
	// delete country
	@RequestMapping(value="/user/delete", method= {RequestMethod.DELETE ,RequestMethod.GET})
	public String delete(int id) {
		userService.delete(id);
		return "redirect:/user";
	}

}
