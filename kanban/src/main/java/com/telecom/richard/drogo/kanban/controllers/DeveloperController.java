package com.telecom.richard.drogo.kanban.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.richard.drogo.kanban.domain.Developer;
import com.telecom.richard.drogo.kanban.service.DeveloperService;

@RestController
public class DeveloperController {
	
	@Autowired
	private DeveloperService developerService;
	
	@GetMapping("/developers")
	public List<Developer> getDevelopers() {
		return developerService.findAllDevelopers();
	}
}
