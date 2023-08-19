package com.example.ListadoDeTareas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.example.ListadoDeTareas.dao.taskDao;
import com.example.ListadoDeTareas.models.Task;

@SpringBootTest
class ListadoDeTareasApplicationTests {

	@Autowired
	taskDao taskDao;


	@Test
	public void crearTask() {
		Task task = new Task();
		task.setDescripcion("Testeando creacion");
		task.setEstado("en progreso");
		taskDao.newTask(task, HttpStatus.OK);
	}

	@Test
	public void eliminarTask() {

		taskDao.deleteTask(1,HttpStatus.OK);
	}
	
	@Test
	public void getTask() {
		taskDao.getTaskList();
	}
	
	@Test
	public void editTask() {
		Task task = new Task();
		task.setDescripcion("Testeando creacion");
		task.setEstado("en progreso");
		taskDao.updateTask(task,HttpStatus.OK);
	}

}
