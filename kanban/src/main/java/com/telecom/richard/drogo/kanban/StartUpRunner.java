package com.telecom.richard.drogo.kanban;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import com.telecom.richard.drogo.kanban.dao.ChangeLogRepository;
import com.telecom.richard.drogo.kanban.dao.DeveloperRepository;
import com.telecom.richard.drogo.kanban.dao.TaskRepository;
import com.telecom.richard.drogo.kanban.dao.TaskStatusRepository;
import com.telecom.richard.drogo.kanban.dao.TaskTypeRepository;
import com.telecom.richard.drogo.kanban.domain.Developer;
import com.telecom.richard.drogo.kanban.domain.Task;
import com.telecom.richard.drogo.kanban.domain.TaskStatus;
import com.telecom.richard.drogo.kanban.domain.TaskType;
import com.telecom.richard.drogo.tables.service.DeveloperService;

@Component
public class StartUpRunner implements CommandLineRunner {

	// BEGIN : ATTRIBUTES
	@Autowired
	private ChangeLogRepository changeLogRepository;
	
	@Autowired
	private DeveloperRepository developerRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private TaskStatusRepository taskStatusRepository;
	
	@Autowired
	private TaskTypeRepository taskTypeRepository;
	// END : ATTRBIUTES
	
	
	// BEGIN : METHODS
	@Override
	public void run(String... args) throws Exception {
		populateTaskStatusTable();
		populateTaskTypeTable();
		populateTaskTable();
		populateDeveloperTable();
	}
	
	private void populateDeveloperTable() {
		Developer[] initialDevelopers = DatabaseInitializer.getInitialDevelopers();
		
		for(int i = 0; i < initialDevelopers.length; i++) {
			developerRepository.save(initialDevelopers[i]);
		}
		
		System.out.println(initialDevelopers.length + " " + Developer.class.toString() + " theoretically inserted in DB.");
	}
	
	private void populateTaskTable() {
		Task[] initialTasks = DatabaseInitializer.getInitialTasks();
		
		for(int i = 0; i < initialTasks.length; i++) {
			taskRepository.save(initialTasks[i]);
		}
		
		System.out.println(initialTasks.length + " " + Task.class.toString() + " theoretically inserted in DB.");
	}
	
	private void populateTaskStatusTable() {
		TaskStatus[] taskStatuses = DatabaseInitializer.getTaskStatuses();
		
		for(int i = 0; i < taskStatuses.length; i++) {
			taskStatusRepository.save(taskStatuses[i]);
		}
		
		System.out.println(taskStatuses.length + " " + TaskStatus.class.toString() + " theoretically inserted in DB.");
	}
	
	private void populateTaskTypeTable() {
		TaskType[] taskTypes = DatabaseInitializer.getTaskTypes();
		
		for(int i = 0; i < taskTypes.length; i++) {
			taskTypeRepository.save(taskTypes[i]);
		}
		
		System.out.println(taskTypes.length + " " + TaskType.class.toString() + " theoretically inserted in DB.");
	}
	
	// END : METHODS
}
