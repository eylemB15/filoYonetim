package com.springFilo.springFiloYonetim.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springFilo.springFiloYonetim.models.JobTitle;
import com.springFilo.springFiloYonetim.repositories.JobTitleRepository;

@Service
public class JobTitleService {

	@Autowired
	private JobTitleRepository jobTitleRepository;
	
	
	public List<JobTitle> getJobTitles(){
		return jobTitleRepository.findAll();
	}
	
	
	//add new
	public void save(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
	}
	
	
	//get by id
	public Optional<JobTitle> findById(int id){
		return jobTitleRepository.findById(id);
	}
	
	
	//delete
	public void delete(int id) {
		jobTitleRepository.deleteById(id);
	}
}
