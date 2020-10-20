package com.telecom.richard.drogo.kanban.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.telecom.richard.drogo.tables.constants.DeveloperConstants;

import lombok.Data; // Generate getters and setters during the compilation.
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
public class Developer {
	// BEGIN: ATTRIBUTES
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, length=DeveloperConstants.FIRSTNAME_LENGTH)
	private String firstname;
	@Column(nullable=false, length=DeveloperConstants.LASTNAME_LENGTH)
	private String lastname;
	private String password;
	private String email;
	private LocalDate startContract;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToMany(mappedBy="developers", fetch=FetchType.EAGER)
	@JsonIgnoreProperties("developers")
	private Set<Task> tasks;
	// END: ATTRIBUTES
	
	public Developer() {
		this.tasks = new HashSet<>();
	}
}
