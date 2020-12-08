package com.telecom.richard.drogo.kanban;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.telecom.richard.drogo.kanban.dao.TaskStatusRepository;
import com.telecom.richard.drogo.kanban.domain.Task;
import com.telecom.richard.drogo.kanban.domain.TaskStatus;
import com.telecom.richard.drogo.tables.service.TaskService;

@SpringBootTest
@RunWith(SpringRunner.class)
class TaskServiceTests {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private TaskStatusRepository taskStatusRepository;
	
	@Test
	void findAllTasksTest() {
		Task[] actual = new Task[taskService.findAllTasks().size()];
		assertArrayEquals(DatabaseInitializer.getInitialTasks(), taskService.findAllTasks().toArray(actual));
	}

	@Test
	void findTaskTest() {
		Task asked_task = DatabaseInitializer.getInitialTasks()[0];
		assertEquals(asked_task, taskService.findTask(asked_task.getId()));
	}
	
	@Test
	void moveRightTaskTest() {
		Task taskToBeMovedToRight = DatabaseInitializer.getInitialTasks()[0];
		TaskStatus nextTaskStatus = taskStatusRepository.findById(taskToBeMovedToRight.getStatus().getId() + 1).get(); // We know that the starting ID is 1. So we know that 1 + 1 will be 2 and within the allowed Id ranges.
		
		taskService.moveRightTask(taskToBeMovedToRight);
		
		boolean state = false;
		if(taskToBeMovedToRight.getStatus() == nextTaskStatus) {
			state = true;			
		}
		
		assertTrue(state);
	}
	
	@Test
	void moveLeftTaskTest() {
		Task taskToBeMovedToLeft = DatabaseInitializer.getInitialTasks()[0];
		taskService.moveRightTask(taskToBeMovedToLeft); // IMPORTANT! WE ASSUME THAT THE METHOD moveRightTask works! We do this because none of our initial Task are in the second status. So we simulate it.
		TaskStatus previousTaskStatus = taskStatusRepository.findById(taskToBeMovedToLeft.getStatus().getId() - 1).get(); // We know that the starting ID is 1. So we know that 1 + 1 will be 2 and within the allowed Id ranges.
		
		taskService.moveLeftTask(taskToBeMovedToLeft);
		
		boolean state = false;
		if(taskToBeMovedToLeft.getStatus() == previousTaskStatus) {
			state = true;			
		}
		
		assertTrue(state);
	}
}
