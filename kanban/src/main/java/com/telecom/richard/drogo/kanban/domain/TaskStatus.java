package com.telecom.richard.drogo.kanban.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.telecom.richard.drogo.tables.constants.TaskConstants;
import com.telecom.richard.drogo.tables.constants.TaskStatusConstants;

import lombok.Data;

@Data
@Entity
public class TaskStatus {
	// BEGIN: ATTRIBUTES
	@Id
	private Long id;
	
	@Column(nullable=false, length=TaskStatusConstants.COLUMN_LENGTH_LABEL)
	private String label;
	// END: ATTRIBUTES
	
	public TaskStatus(Long id_, String label_) {
		id = id_;
		label = label_;
	}
	
	public TaskStatus() {}
}
