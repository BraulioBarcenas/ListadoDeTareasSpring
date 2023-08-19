package com.example.ListadoDeTareas.dao;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.ListadoDeTareas.models.Task;
import com.example.ListadoDeTareas.models.TaskResponse;



public interface taskDao {
    List<Task> getTaskList();

    ResponseEntity<TaskResponse> deleteTask(long id, HttpStatus httpStatus);

    ResponseEntity<TaskResponse> newTask(Task task, HttpStatus httpStatus, String tokenHeader);

    ResponseEntity<TaskResponse> updateTask(Task task, HttpStatus httpStatus);
}
