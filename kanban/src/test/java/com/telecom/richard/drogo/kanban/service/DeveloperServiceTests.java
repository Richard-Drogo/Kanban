package com.telecom.richard.drogo.kanban.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.telecom.richard.drogo.kanban.DatabaseInitializer;
import com.telecom.richard.drogo.kanban.domain.Developer;
import com.telecom.richard.drogo.kanban.service.DeveloperService;

@SpringBootTest
@RunWith(SpringRunner.class)
class DeveloperServiceTests {

	@Autowired
	private DeveloperService developerService;
	
	@Test
	void findAllDevelopersTest() {
		Developer[] actual = new Developer[developerService.findAllDevelopers().size()];
		assertArrayEquals(DatabaseInitializer.getInitialDevelopers(), developerService.findAllDevelopers().toArray(actual));
	}

}
