package com.telecom.richard.drogo.tables.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.telecom.richard.drogo.kanban.domain.Task;

@Service
public interface TaskService {
	public List<Task> findAllTasks();
	public Task findTask(Long id);
	public Task moveRightTask(Task task);
	public Task moveLeftTask(Task task);
	
}
