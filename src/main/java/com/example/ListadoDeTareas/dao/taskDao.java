package com.example.ListadoDeTareas.dao;

import java.util.List;

import com.example.ListadoDeTareas.models.Task;



public interface taskDao {
    List<Task> getTaskList();

    void deleteTask(long id);

    void newTask(Task task);

}
