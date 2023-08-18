package com.example.ListadoDeTareas.dao;

import org.springframework.http.ResponseEntity;

import com.example.ListadoDeTareas.controllers.request.CreateUserDTO;


public interface userDao {
    ResponseEntity<?> createUser(CreateUserDTO createUserDTO);

    String deleteUser(Long id);
}
