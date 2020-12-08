package com.telecom.richard.drogo.kanban;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.telecom.richard.drogo.kanban.dao.TaskRepository;
import com.telecom.richard.drogo.kanban.domain.Task;

@SpringBootTest
@RunWith(SpringRunner.class)
class TaskRepositoryTests {

	@Autowired
	private TaskRepository taskRepository;
	
	// With this test, we compare the actual inserted Tasks with the ones who where planned to be inserted by the CommandLineRunner.
	@Test
	void findAllTest() {
		Task[] actual = new Task[taskRepository.findAll().size()];
		taskRepository.findAll().toArray(actual);
		
		//System.out.println("ICI----------");
		//System.out.println(actual[0].toString());
		//System.out.println(DatabaseInitializer.getInitialTasks()[0].toString()); // TODO ASK PROF FOR IMPROOVEMENT
		assertArrayEquals(DatabaseInitializer.getInitialTasks(), actual);
	}

}
