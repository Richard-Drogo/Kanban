package com.telecom.richard.drogo.kanban.domain;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
public class Task {
	// BEGIN: ATTRIBUTES
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Title cannot be null")
	@NotEmpty(message = "Title cannote be empty")
	private String title;
	
	private Integer nbHoursForecast;
	private Integer nbHoursReal;
	private LocalDate created;
	
	@ManyToOne
	@Valid
	private TaskType type;
	
	@ManyToOne
	private TaskStatus status;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JsonIgnoreProperties({"password", "startContract", "tasks")
	@EqualsAndHashCode.Exclude
	@NotEmpty(message ="Developers canot be empty")
	}
	private Set<Developer> developers;
	
	// BEGIN: ATTRIBUTES
}
