package com.telecom.richard.drogo.tables.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.richard.drogo.kanban.dao.ChangeLogRepository;
import com.telecom.richard.drogo.kanban.dao.TaskRepository;
import com.telecom.richard.drogo.kanban.dao.TaskStatusRepository;
import com.telecom.richard.drogo.kanban.domain.ChangeLog;
import com.telecom.richard.drogo.kanban.domain.Task;
import com.telecom.richard.drogo.kanban.domain.TaskStatus;
import com.telecom.richard.drogo.tables.constants.ServicesConstants;
import com.telecom.richard.drogo.tables.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private TaskStatusRepository taskStatusRepository;
	
	@Autowired
	private ChangeLogRepository changeLogRepository;
	
	
	@Override
	public List<Task> findAllTasks() {
		return this.taskRepository.findAll();
	}


	@Override
	public Task findTask(Long id) {
		return this.taskRepository.getOne(id);
	}

	/*
	 * MOVE TO RIGHT ACCORDINGLY TO THIS ORDER OF STATUSES: TODO -> DOING -> TEST -> DONE
	 */
	@Override
	public Task moveRightTask(Task task) {
		Long currentId = task.getStatus().getId();
		TaskStatus newStatus = taskStatusRepository.getOne(currentId + 1);
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
	public Task moveLeftTask(Task task) {
		Long currentId = task.getStatus().getId();
		TaskStatus newStatus = taskStatusRepository.getOne(currentId - 1);
		if(newStatus != null) {
			// We can change the Status and create a ChangeLog.
			changeLogRepository.save(new ChangeLog(LocalDate.now(), task, task.getStatus(), newStatus));
			task.changeStatus(newStatus);
		} else {
			System.out.println(ServicesConstants.MOVING_TASK_IMPOSSIBLE_FR);
		}
		return null;
	}

}
