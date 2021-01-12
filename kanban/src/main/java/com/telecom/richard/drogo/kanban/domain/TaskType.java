package com.telecom.richard.drogo.kanban.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.telecom.richard.drogo.tables.constants.TaskStatusConstants;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@JsonIgnoreProperties({"tasks"})
@Entity
public class TaskType {
	// BEGIN: ATTRIBUTES
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, length=TaskStatusConstants.COLUMN_LENGTH_LABEL)
	private String label;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="type", fetch=FetchType.EAGER)
	private List<Task> tasks;
	// END: ATTRIBUTES

	
	public TaskType(Long id_, String label_) {
		id = id_;
		label = label_;
	}
	
	public TaskType() {}
}
