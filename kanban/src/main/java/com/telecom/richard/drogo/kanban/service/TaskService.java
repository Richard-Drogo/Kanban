package com.telecom.richard.drogo.kanban.service;

import java.util.List;

import com.telecom.richard.drogo.kanban.domain.Task;

public interface TaskService {
	public List<Task> findAllTasks();
	public Task findTaskById(Long id);
	public Task moveRightTask(Task task);
	public Task moveLeftTask(Task task);
	public Task createTask(Task task);
}
