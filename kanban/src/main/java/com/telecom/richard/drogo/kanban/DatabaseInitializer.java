package com.telecom.richard.drogo.kanban;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;

import com.telecom.richard.drogo.kanban.domain.Developer;
import com.telecom.richard.drogo.kanban.domain.Task;
import com.telecom.richard.drogo.kanban.domain.TaskStatus;
import com.telecom.richard.drogo.kanban.domain.TaskType;

/* DatabaseInitializer
 * This class has been made to insert Data in the Database with the
 * CommandLineRunner and to test the insertion during Junit Tests.
 */
public class DatabaseInitializer {
	
	// BEGIN: ATTRIBUTES	
	private final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(new Locale("yyyy-MM-dd"));
	
	private final static Developer[] initialDevelopers = new Developer[] {new Developer("Richard", "DROGO", "RDpassword?", "richard.drogo@domain.com", LocalDate.parse("2020-12-07", dtf)),
			new Developer("Adrien", "MIDOL-MONNET", "AM-Mpassword?", "adrien.midol-monnet@domain.com", LocalDate.parse("2020-12-07", dtf)),
			new Developer("Cédric", "GORMOND", "CGpassword?", "cedric.gormond@domain.com", LocalDate.parse("2020-12-07", dtf)),
			new Developer("Arnaud", "TAVERNIER", "ATpassword?", "arnaud.tavernier@domain.com", LocalDate.parse("2020-12-07", dtf)),
			new Developer("Audric", "MERLEY", "AMpassword?", "audric.merley@domain.com", LocalDate.parse("2020-12-07", dtf))};	
	
	// BEGIN: TO BE MODIFIED TOGETHER
	private final static Map<Long, String> TASK_TYPES = new HashMap<Long, String>() {{ put((long) 1, "Feature"); put((long) 2, "Bug"); put((long) 3, "Spike"); put((long) 4, "Upgrade"); }};
	private final static Map<Long, String> TASK_STATUSES = new HashMap<Long, String>() {{ put((long) 1, "TODO"); put((long) 2, "DOING"); put((long) 3, "TEST"); put((long) 4, "DONE"); }};

	private final static TaskType[] taskTypes = new TaskType[] {new TaskType((Long) TASK_TYPES.keySet().toArray()[0],(String) TASK_TYPES.values().toArray()[0]), new TaskType((Long) TASK_TYPES.keySet().toArray()[1],(String) TASK_TYPES.values().toArray()[1]), new TaskType((Long) TASK_TYPES.keySet().toArray()[2],(String) TASK_TYPES.values().toArray()[2]), new TaskType((Long) TASK_TYPES.keySet().toArray()[3],(String) TASK_TYPES.values().toArray()[3])};
	private final static TaskStatus[] taskStatuses = new TaskStatus[] {new TaskStatus((Long) TASK_STATUSES.keySet().toArray()[0],(String) TASK_STATUSES.values().toArray()[0]), new TaskStatus((Long) TASK_STATUSES.keySet().toArray()[1],(String) TASK_STATUSES.values().toArray()[1]), new TaskStatus((Long) TASK_STATUSES.keySet().toArray()[2],(String) TASK_STATUSES.values().toArray()[2]), new TaskStatus((Long) TASK_STATUSES.keySet().toArray()[3],(String) TASK_STATUSES.values().toArray()[3])};
	// END: TO BE MODIFIED TOGETHER
	
	private final static Task[] initialTasks = new Task[] {new Task("Définir le périmètre du projet", 8, 0, LocalDate.parse("2020-12-07", dtf), taskTypes[0], taskStatuses[0], new HashSet<Developer>() {}),
			new Task("Initialiser le Backlog avec le client", 6, 0, LocalDate.parse("2020-12-07", dtf), taskTypes[0], taskStatuses[0], new HashSet<Developer>() {}),
			new Task("Éstimer le temps des différentes taches et les créer", 12, 0, LocalDate.parse("2020-12-07", dtf), taskTypes[0], taskStatuses[0], new HashSet<Developer>() {})};
	// END: ATTRIBUTES
	
	
	// BEGIN: GETTERS
	public static Developer[] getInitialDevelopers() { return initialDevelopers;}
	public static Task[] getInitialTasks() { return initialTasks;};
	public static TaskStatus[] getTaskStatuses() { return taskStatuses;};
	public static TaskType[] getTaskTypes() { return taskTypes;};
	// END: GETTERS
}
