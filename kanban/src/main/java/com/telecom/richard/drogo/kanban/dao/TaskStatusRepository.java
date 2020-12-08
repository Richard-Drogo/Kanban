package com.telecom.richard.drogo.kanban.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.richard.drogo.kanban.domain.TaskStatus;

@Repository
public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long> {

}
