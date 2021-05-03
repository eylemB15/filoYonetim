package com.springFilo.springFiloYonetim.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.springFilo.springFiloYonetim.models.Country;
import com.springFilo.springFiloYonetim.models.State;
import com.springFilo.springFiloYonetim.repositories.StateRepository;

@Service
public class StateService {
	
	@Autowired
	private StateRepository stateRepository;
	
	
	//get all state
	public List<State> getStates() {
		return stateRepository.findAll();
		
	}
	
	//add state
	public void save(State state) {
		stateRepository.save(state);
	}
	
	//get by id
	public Optional<State> findById(int id) {
		return stateRepository.findById(id);
	}
	
	
	//delete state
	public void delete(int id) {
		stateRepository.deleteById(id);
	}

}
