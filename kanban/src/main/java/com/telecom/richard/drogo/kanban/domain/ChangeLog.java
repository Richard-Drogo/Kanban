package com.telecom.richard.drogo.kanban.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ChangeLog {
	// BEGIN: ATTRIBUTES
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate occured;
	
	private Task task;
	private TaskStatus sourceStatus;
	private TaskStatus targetStatus;
	// END: ATTRIBUTES
}
