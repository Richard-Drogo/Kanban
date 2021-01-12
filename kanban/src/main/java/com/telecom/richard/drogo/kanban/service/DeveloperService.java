package com.telecom.richard.drogo.kanban.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.telecom.richard.drogo.kanban.domain.Developer;

public interface DeveloperService {
	public List<Developer> findAllDevelopers();
}
