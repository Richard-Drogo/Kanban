package com.telecom.richard.drogo.kanban.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.telecom.richard.drogo.kanban.DatabaseInitializer;
import com.telecom.richard.drogo.kanban.dao.ChangeLogRepository;
import com.telecom.richard.drogo.kanban.dao.TaskRepository;
import com.telecom.richard.drogo.kanban.dao.TaskStatusRepository;
import com.telecom.richard.drogo.kanban.dao.TaskTypeRepository;
import com.telecom.richard.drogo.kanban.domain.ChangeLog;
import com.telecom.richard.drogo.kanban.domain.Task;
import com.telecom.richard.drogo.kanban.domain.TaskStatus;
import com.telecom.richard.drogo.kanban.service.TaskService;
import com.telecom.richard.drogo.tables.constants.ServicesConstants;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private TaskStatusRepository taskStatusRepository;
	
	@Autowired
	private TaskTypeRepository taskTypeRepository;
	
	@Autowired
	private ChangeLogRepository changeLogRepository;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Task> findAllTasks() {
		return this.taskRepository.findAll();
	}


	@Override
	@Transactional(readOnly = true)
	public Task findTaskById(Long id) {
		return this.taskRepository.findById(id).get();
	}

	/*
	 * MOVE TO RIGHT ACCORDINGLY TO THIS ORDER OF STATUSES: TODO -> DOING -> TEST -> DONE
	 */
	@Override
	@Transactional
	public Task moveRightTask(Task task) {
		Long currentId = task.getStatus().getId();
		TaskStatus newStatus = taskStatusRepository.findById(currentId + 1).get();
		if(newStatus != null) { // We can manage condition like that because we set the statuses with an ascending order.
			// We can change the Status and create a ChangeLog.
			changeLogRepository.save(new ChangeLog(LocalDate.now(), task, task.getStatus(), newStatus));
			task.changeStatus(newStatus);
		} else {
			System.out.println(ServicesConstants.MOVING_TASK_IMPOSSIBLE_FR);
		}
		return null;
	}

	/*
	 * MOVE TO LEFT ACCORDINGLY TO THIS ORDER OF STATUSES: TODO <- DOING <- TEST <- DONE
	 */
	@Override
	@Transactional
	public Task moveLeftTask(Task task) {
		Long currentId = task.getStatus().getId();
		TaskStatus newStatus = taskStatusRepository.findById(currentId - 1).get();
		if(newStatus != null) {
			// We can change the Status and create a ChangeLog.
			changeLogRepository.save(new ChangeLog(LocalDate.now(), task, task.getStatus(), newStatus));
			task.changeStatus(newStatus);
		} else {
			System.out.println(ServicesConstants.MOVING_TASK_IMPOSSIBLE_FR);
		}
		return null;
	}


	@Override
	@Transactional
	public Task createTask(Task task) {
		TaskStatus todo = taskStatusRepository.getOne((DatabaseInitializer.getTaskStatuses()[0].getId()));
		task.setStatus(todo);
		task.setCreated(LocalDate.now());
		return this.taskRepository.save(task);
	}

}
