package com.telecom.richard.drogo.kanban.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.xml.bind.v2.schemagen.xmlschema.Occurs;
import com.telecom.richard.drogo.tables.constants.ChangeLogConstants;

import lombok.Data;

@Data
@Entity
public class ChangeLog {
	// BEGIN: ATTRIBUTES
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(nullable=false, length=ChangeLogConstants.COLUMN_LENGTH_OCCURED)	
	private LocalDate occured;
	
	
	@ManyToOne
	private Task task;
	
	@ManyToOne
	private TaskStatus sourceStatus;
	
	@ManyToOne
	private TaskStatus targetStatus;
	// END: ATTRIBUTES
	
	
	public ChangeLog(LocalDate occured_, Task task_, TaskStatus sourceStatus_, TaskStatus targetStatus_) {
		occured = occured_;
		task = task_;
		sourceStatus = sourceStatus_;
		targetStatus = targetStatus_;
	}
}
