package com.telecom.richard.drogo.kanban.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class TaskStatus {
	// BEGIN: ATTRIBUTES
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String label;
	// END: ATTRIBUTES
}
