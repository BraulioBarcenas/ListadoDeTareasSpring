package com.example.ListadoDeTareas.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<TaskResponse> eliminarTarea(Task task, HttpStatus httpStatus){
        return taskDao.deleteTask(task.getId(), httpStatus);
    }
    
    @RequestMapping(value = "/newTask", method = RequestMethod.POST)
    public ResponseEntity<TaskResponse> nuevaTarea(Task task, HttpStatus httpStatus){
        return taskDao.newTask(task, httpStatus);
    }

    @RequestMapping(value = "/updateTask", method = RequestMethod.POST)
    public ResponseEntity<TaskResponse> actualizarTarea(Task task, HttpStatus httpStatus){
        return taskDao.updateTask(task, httpStatus);
    }
    
}
