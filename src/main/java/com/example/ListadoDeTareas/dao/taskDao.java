package com.example.ListadoDeTareas.dao;

import java.util.List;

import com.example.ListadoDeTareas.models.Task;
import com.example.ListadoDeTareas.models.TaskResponse;



public interface taskDao {
    List<Task> getTaskList();

    TaskResponse deleteTask(long id);

    void newTask(Task task);

    TaskResponse updateTask(Task task);
}
