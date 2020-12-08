package com.telecom.richard.drogo.kanban;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.telecom.richard.drogo.kanban.dao.DeveloperRepository;
import com.telecom.richard.drogo.kanban.dao.TaskRepository;
import com.telecom.richard.drogo.kanban.dao.TaskStatusRepository;
import com.telecom.richard.drogo.kanban.domain.Developer;
import com.telecom.richard.drogo.kanban.domain.Task;
import com.telecom.richard.drogo.kanban.domain.TaskStatus;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskTests {

    @Autowired
    private DeveloperRepository developerRepository;
    
    @Autowired
    private TaskRepository taskRepository;
    
    @Autowired
    private TaskStatusRepository taskStatusRepository;
    
    
	@Test
	public void addDeveloperTest() {
		if(KanbanApplicationTests.COMMENTS) {
			System.out.println("Testing \"Task.addDeveloper(Developer)\"");
		}
		
		if((developerRepository.findAll().size() != DatabaseInitializer.getInitialDevelopers().length) || (taskRepository.findAll().size() != DatabaseInitializer.getInitialTasks().length)) {
			System.out.println(KanbanApplicationTests.ERROR_LINE_TEMPLATE);
			fail("No developers or tasks could be found in DB! Check the CommandLineRunner!\nDevelopers: " + developerRepository.findAll().size() + "\nTasks: " + taskRepository.findAll().size());
		}
		
		Developer developerToBeAddedToTask = developerRepository.findAll().get(0);
		Task taskToBeChanged = taskRepository.findAll().get(0);
		Task taskToTestFalse = taskRepository.findAll().get(1);
		
		taskToBeChanged.addDeveloper(developerToBeAddedToTask); // TESTED METHOD HERE!
		
		// Now, we need to see if "developerToBeAddedToTask" is in the developers in "taskToBeChanged" and if "taskToBeChanged" is in "developerToBeAddedToTask".
		boolean state = false;
		if(taskToBeChanged.getDevelopers().contains(developerToBeAddedToTask) && developerToBeAddedToTask.getTasks().contains(taskToBeChanged) && (!developerToBeAddedToTask.getTasks().contains(taskToTestFalse))) {
			state = true;			
		}
		
		if(state) {
			if(KanbanApplicationTests.COMMENTS) {
				System.out.println("Testing \"Task.addDeveloper(Developer)\": SUCCESS!");
			}
		} else {
			if(KanbanApplicationTests.COMMENTS) {
				System.out.println("Testing \"Task.addDeveloper(Developer)\": FAILED!");
			}
		}
		
		assertTrue(state);
	}
	
	
	@Test
	public void changeStatusTest() {
		if(KanbanApplicationTests.COMMENTS) {
			System.out.println("Testing \"Task.changeStatus(TaskStatus)\"");
		}
		
		if((taskRepository.findAll().size() != DatabaseInitializer.getInitialTasks().length) || (taskStatusRepository.findAll().size() != DatabaseInitializer.getTaskStatuses().length)) {
			System.out.println(KanbanApplicationTests.ERROR_LINE_TEMPLATE);
			fail("No tasks or tasks statuses could be found in DB! Check the CommandLineRunner!\nTasks: " + taskRepository.findAll().size() + "\nTasksStatuses: " + taskStatusRepository.findAll().size());
		}
		
		Task taskToBeChanged = taskRepository.findAll().get(0);
		TaskStatus nextTaskStatus = taskStatusRepository.findById(taskToBeChanged.getStatus().getId() + 1).get(); // We know that the starting ID is 1. So we know that 1 + 1 will be 2 and within the allowed Id ranges.
		
		if(taskToBeChanged.getStatus() == nextTaskStatus) {
			fail("Previous and next Statuses are the same!\nTaskStatus: " + nextTaskStatus.toString());
		}
		
		taskToBeChanged.changeStatus(nextTaskStatus);
		
		boolean state = false;
		if(taskToBeChanged.getStatus() == nextTaskStatus) {
			state = true;			
		}
		
		if(state) {
			if(KanbanApplicationTests.COMMENTS) {
				System.out.println("Testing \"Task.changeStatus(TaskStatus)\": SUCCESS!");
			}
		} else {
			if(KanbanApplicationTests.COMMENTS) {
				System.out.println("Testing \"Task.changeStatus(TaskStatus)\": FAILED!");
			}
		}
		
		assertTrue(state);
	}
}
