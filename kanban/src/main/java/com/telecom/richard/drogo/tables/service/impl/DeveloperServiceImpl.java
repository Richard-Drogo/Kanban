package com.telecom.richard.drogo.tables.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.richard.drogo.kanban.dao.DeveloperRepository;
import com.telecom.richard.drogo.kanban.domain.Developer;
import com.telecom.richard.drogo.tables.service.DeveloperService;

@Service
public class DeveloperServiceImpl implements DeveloperService {

	@Autowired
	private DeveloperRepository developerRepository;
	
	@Override
	public List<Developer> findAllDevelopers() {
		return this.developerRepository.findAll();
	}

}
