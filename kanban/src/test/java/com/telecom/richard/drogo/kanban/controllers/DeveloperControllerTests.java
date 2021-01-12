package com.telecom.richard.drogo.kanban.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telecom.richard.drogo.kanban.DatabaseInitializer;
import com.telecom.richard.drogo.kanban.domain.Developer;
import com.telecom.richard.drogo.kanban.service.DeveloperService;

@RunWith(SpringRunner.class)
@WebMvcTest(DeveloperController.class)
class DeveloperControllerTests {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private DeveloperService developerService;
	
	// Ne passe pas car les réponses sont stockées en UTF-8 et pas ce que je sérialise avant...
	@Test
	void getDevelopersTest() throws Exception {
	    List<Developer> allDevelopers = Arrays.asList(DatabaseInitializer.getInitialDevelopers());	    
	    Mockito.when(developerService.findAllDevelopers()).thenReturn(allDevelopers);

	    ObjectMapper mapper = new ObjectMapper();
	    String jsonString = mapper.writeValueAsString(allDevelopers);

	    mvc.perform(MockMvcRequestBuilders.get("/developers")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string(jsonString));
	}

}
