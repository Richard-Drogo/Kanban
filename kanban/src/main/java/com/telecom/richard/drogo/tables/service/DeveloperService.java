package com.telecom.richard.drogo.tables.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.telecom.richard.drogo.kanban.domain.Developer;

@Service
public interface DeveloperService {
	public List<Developer> findAllDevelopers();
}
