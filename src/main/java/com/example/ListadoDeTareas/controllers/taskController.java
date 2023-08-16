package com.example.ListadoDeTareas.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ListadoDeTareas.dao.taskDao;
import com.example.ListadoDeTareas.models.Task;

@RestController
public class taskController {
    
    @Autowired
    private taskDao taskDao;
    @RequestMapping(value = "/getTasks", method = RequestMethod.GET)
    public List<Task> getTareas(){

        return taskDao.getTaskList();
    }
}
