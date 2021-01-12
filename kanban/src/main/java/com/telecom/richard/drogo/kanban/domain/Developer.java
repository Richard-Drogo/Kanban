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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.telecom.richard.drogo.tables.constants.DeveloperConstants;

import lombok.Data; // Generate getters and setters during the compilation.
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@JsonIgnoreProperties({"tasks", "password"})
@Entity
public class Developer {
	// BEGIN: ATTRIBUTES
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message=DeveloperConstants.MESSAGE_FIRSTNAME_FR)
	@Column(nullable=false, length=DeveloperConstants.COLUMN_LENGTH_FIRSTNAME)
	private String firstname;
	
	@NotBlank(message=DeveloperConstants.MESSAGE_LASTNAME_FR)
	@Column(nullable=false, length=DeveloperConstants.COLUMN_LENGTH_LASTNAME)
	private String lastname;
	
	@Size(min=DeveloperConstants.SIZE_MIN_PASSWORD, max=DeveloperConstants.SIZE_MAX_PASSWORD, message=DeveloperConstants.MESSAGE_PASSWORD_FR)
	@Column(nullable=false, length=DeveloperConstants.COLUMN_LENGTH_LASTNAME)
	private String password;
	
	@Email(message=DeveloperConstants.MESSAGE_EMAIL_FR)
	@Size(max=DeveloperConstants.SIZE_MAX_EMAIL, message=DeveloperConstants.MESSAGE_EMAIL_FR)
	@Column(nullable=false, length=DeveloperConstants.COLUMN_LENGTH_EMAIL)
	private String email;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(nullable=false, length=DeveloperConstants.COLUMN_LENGTH_STARTCONTRACT)	
	private LocalDate startContract;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToMany(mappedBy="developers", fetch=FetchType.EAGER)
	private Set<Task> tasks;
	// END: ATTRIBUTES
	
	public Developer(String firstname_, String lastname_, String password_, String email_, LocalDate startContract_) {
		this.setFirstname(firstname_);
		this.setLastname(lastname_);
		this.setPassword(password_);
		this.setEmail(email_);
		this.setStartContract(startContract_);
		this.tasks = new HashSet<>();
	}
	
	public Developer() {} // Needed for tests.
}
