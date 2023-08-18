package com.example.ListadoDeTareas.dao;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.ListadoDeTareas.controllers.request.CreateUserDTO;
import com.example.ListadoDeTareas.models.ERole;
import com.example.ListadoDeTareas.models.RoleEntity;
import com.example.ListadoDeTareas.models.UserEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
// @SuppressWarnings("unchecked")
public class userDaoImp implements userDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public ResponseEntity<?> createUser(CreateUserDTO createUserDTO) {

        Set<RoleEntity> roles = createUserDTO.getRoles().stream()
                .map(role ->
                    RoleEntity.builder()
                        .name(ERole.valueOf(role))
                        .build())
                .collect(Collectors.toSet());



       UserEntity userEntity = UserEntity.builder()
                .username(createUserDTO.getUsername())
                .password(createUserDTO.getPassword())
                .email(createUserDTO.getEmail())
                .roles(roles)
                .tareas(null)
                .build();

        entityManager.persist(userEntity);

        return ResponseEntity.ok(userEntity);
    }

    @Override
    public String deleteUser(Long id) {
        UserEntity user =entityManager.find(UserEntity.class,id);
          if (user != null) {
            entityManager.remove(user);
            return "The user with id: "+id+" has been deleted";
        }

        return "User not found";
        // return new ResponseEntity<TaskResponse>(new TaskResponse(id, "ERROR", "Task not found")
        // ,HttpStatus.BAD_REQUEST);
    }


}
