package com.telecom.richard.drogo.kanban.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import com.telecom.richard.drogo.kanban.domain.Developer;
import com.telecom.richard.drogo.kanban.service.DeveloperService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.PATCH})
public class DeveloperController {
	
	@Autowired
	private DeveloperService developerService;
	
	@GetMapping("/developers")
	public List<Developer> getDevelopers() {
		return developerService.findAllDevelopers();
	}
}
