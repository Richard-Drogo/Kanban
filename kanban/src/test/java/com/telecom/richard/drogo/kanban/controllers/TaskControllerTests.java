package com.telecom.richard.drogo.kanban.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.telecom.richard.drogo.kanban.DatabaseInitializer;
import com.telecom.richard.drogo.kanban.service.TaskService;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
class TaskControllerTests {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private TaskService taskService;
	

}
