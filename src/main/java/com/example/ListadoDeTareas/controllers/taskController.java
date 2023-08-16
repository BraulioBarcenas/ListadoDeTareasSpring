package com.example.ListadoDeTareas.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ListadoDeTareas.dao.taskDao;
import com.example.ListadoDeTareas.models.Task;
import com.example.ListadoDeTareas.models.TaskResponse;

@RestController
public class taskController {
    
    @Autowired
    private taskDao taskDao;
    @RequestMapping(value = "/getTasks", method = RequestMethod.GET)
    public List<Task> getTareas(){

        return taskDao.getTaskList();
    }

    @RequestMapping(value = "/deleteTask", method = RequestMethod.DELETE)
    public TaskResponse eliminarTarea(Task task){
        return taskDao.deleteTask(task.getId());
    }
    
    @RequestMapping(value = "/newTask", method = RequestMethod.POST)
    public void nuevaTarea(Task task){
        taskDao.newTask(task);
    }

    @RequestMapping(value = "/updateTask", method = RequestMethod.POST)
    public TaskResponse actualizarTarea(Task task){
        return taskDao.updateTask(task);
    }
    
}
