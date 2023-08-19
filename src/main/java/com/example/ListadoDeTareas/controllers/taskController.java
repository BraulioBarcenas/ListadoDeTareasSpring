package com.example.ListadoDeTareas.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestHeader;
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
    @Autowired
    private SessionRegistry sessionRegistry;

    @RequestMapping(value = "/getTasks", method = RequestMethod.GET)
    public List<Task> getTareas(){

        return taskDao.getTaskList();
    }

    @RequestMapping(value = "/deleteTask", method = RequestMethod.DELETE)
    public ResponseEntity<TaskResponse> eliminarTarea(Task task, HttpStatus httpStatus){
        return taskDao.deleteTask(task.getId(), httpStatus);
    }
    
    @RequestMapping(value = "/newTask", method = RequestMethod.POST)
    public ResponseEntity<TaskResponse> nuevaTarea(Task task, HttpStatus httpStatus, @RequestHeader("Authorization") String tokenHeader){
        return taskDao.newTask(task, httpStatus, tokenHeader);
    }

    @RequestMapping(value = "/updateTask", method = RequestMethod.POST)
    public ResponseEntity<TaskResponse> actualizarTarea(Task task, HttpStatus httpStatus){
        return taskDao.updateTask(task, httpStatus);
    }

    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public ResponseEntity<?> getSessionDetails(Task task, HttpStatus httpStatus){
        
            String sessionId = "";
            User userObject = null;

            List<Object> sessions = sessionRegistry.getAllPrincipals();

            for (Object session : sessions) {
                userObject = (User)session;
                if (session instanceof User) {
                }

                List<SessionInformation> sessionInformations = sessionRegistry.getAllSessions(session, false);

                for (SessionInformation sessionInformation : sessionInformations) {
                    sessionId = sessionInformation.getSessionId();
                }
            }

        Map<String, Object> response = new HashMap<>();
        response.put("response","Hello World");
        response.put("sessionId",sessionId);
        response.put("sessionUser",userObject);
        return ResponseEntity.ok(response);
    }
    
}
