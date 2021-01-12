package com.telecom.richard.drogo.kanban.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.telecom.richard.drogo.kanban.DatabaseInitializer;
import com.telecom.richard.drogo.kanban.dao.DeveloperRepository;
import com.telecom.richard.drogo.kanban.domain.Developer;

@SpringBootTest
@RunWith(SpringRunner.class)
class DeveloperRepositoryTests {

	@Autowired
	private DeveloperRepository developerRepository;
	
	// With this test, we compare the actual inserted Developers with the ones who where planned to be inserted by the CommandLineRunner.
	@Test
	void findAllTest() {
		Developer[] actual = new Developer[developerRepository.findAll().size()];
		developerRepository.findAll().toArray(actual);
		assertArrayEquals(DatabaseInitializer.getInitialDevelopers(), actual);
	}

}
