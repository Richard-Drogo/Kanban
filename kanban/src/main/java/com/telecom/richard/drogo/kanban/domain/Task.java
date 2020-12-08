package com.telecom.richard.drogo.kanban.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.telecom.richard.drogo.tables.constants.DeveloperConstants;
import com.telecom.richard.drogo.tables.constants.TaskConstants;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
public class Task {
	// BEGIN: ATTRIBUTES
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message=TaskConstants.MESSAGE_TITLE_FR)
	@Column(nullable=false, length=TaskConstants.COLUMN_LENGTH_TITLE)
	private String title;
	
	@Min(value=TaskConstants.MIN_NBHOURSFORECAST)
	@Column(length=TaskConstants.COLUMN_LENGTH_NBHOURSFORECAST)
	private Integer nbHoursForecast;
	
	@Min(value=TaskConstants.MIN_NBHOURSREAL)
	@Column(length=TaskConstants.COLUMN_LENGTH_NBHOURSREAL)
	private Integer nbHoursReal;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(nullable=false, length=TaskConstants.COLUMN_LENGTH_CREATED)	
	private LocalDate created;
	
	
	@ManyToOne
	private TaskType type;
	
	@ManyToOne
	private TaskStatus status;
	
	//@OneToMany(mappedBy="task", fetch=FetchType.EAGER) // FETCHTYPE EAGER NEEDED TO ERASE ERROR LAZINESS
	//private List<ChangeLog> changeLogs; // TODO ASK PROF FOR IMPROOVEMENT.
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToMany(fetch=FetchType.EAGER)
	@JsonIgnoreProperties("tasks")
	private Set<Developer> developers;
	// END: ATTRIBUTES
	
	public Task(String title_, int nbHoursForecast_, int nbHoursReal_, LocalDate created_, TaskType type_, TaskStatus status_, Set<Developer> developers_) {
		this.setTitle(title_);
		this.setNbHoursForecast(nbHoursForecast_);
		this.setNbHoursReal(nbHoursReal_);
		this.setCreated(created_);
		this.type = type_;
		this.status = status_;
		if(developers_ == null) {
			this.developers = new HashSet<>();
		} else {
			this.developers = developers_;
		}
	}
	
	public Task() {} // Needed for Tests.
	
	public void addDeveloper(Developer developer) {
		developer.getTasks().add(this);
		developers.add(developer);
	}
	
	public void changeStatus(TaskStatus newStatus) {
		this.status = newStatus;
	}
}
