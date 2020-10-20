package com.telecom.richard.drogo.kanban.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telecom.richard.drogo.kanban.domain.Developer;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {

}
