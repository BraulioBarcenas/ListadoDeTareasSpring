package com.example.ListadoDeTareas.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.ListadoDeTareas.controllers.request.CreateUserDTO;
import com.example.ListadoDeTareas.dao.userDao;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class userController {

    @Autowired
    private userDao userDao;

    @PostMapping(value="/createUser")
    public ResponseEntity<?> nuevoUsuario(@Valid @RequestBody CreateUserDTO createUserDTO){
        return userDao.createUser(createUserDTO);
    }

    @DeleteMapping(value="/deleteUser")
    public String eliminarUsuario(@RequestParam Long id){
        return userDao.deleteUser(id);
    }
    
}
