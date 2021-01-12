package com.telecom.richard.drogo.kanban.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.richard.drogo.kanban.domain.Task;
import com.telecom.richard.drogo.kanban.domain.TaskStatus;
import com.telecom.richard.drogo.kanban.service.TaskService;

@RestController
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@GetMapping("/tasks")
	public List<Task> getTasks() {
		return taskService.findAllTasks();
	}
	
	@PostMapping("/tasks")
	public Task addTask(@RequestBody Task task) {
		return taskService.createTask(task);
	}
	
	@PatchMapping("/tasks")
	public Task moveTask(@RequestParam(name="id") long id, @RequestBody TaskStatus taskStatus) {
		Task taskToBeMoved = taskService.findTaskById(id);
		TaskStatus actualStatus = taskToBeMoved.getStatus();
		
		if(taskStatus.getId() == actualStatus.getId() + 1) {
			return taskService.moveRightTask(taskToBeMoved);
		} else {
			if(taskStatus.getId() == actualStatus.getId() - 1) {
				return taskService.moveLeftTask(taskToBeMoved);
			} else {
				// Nothing because the TaskStatus is not correct
				return null;
			}
		}
	}
}
