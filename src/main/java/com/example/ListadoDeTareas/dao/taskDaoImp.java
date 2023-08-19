package com.example.ListadoDeTareas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.ListadoDeTareas.models.Task;
import com.example.ListadoDeTareas.models.TaskResponse;
import com.example.ListadoDeTareas.repositories.UserRepository;
import com.example.ListadoDeTareas.security.jwt.JwtUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
@Transactional
@SuppressWarnings("unchecked")
public class taskDaoImp implements taskDao{

    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    UserRepository userRepository;

    @PersistenceContext
    EntityManager entityManager;

    // Obtener tareas
    @Override
    public List<Task> getTaskList() {
        String query = "FROM Task";
        List<Task> resultado = entityManager.createQuery(query).getResultList();
        return resultado;
    }

    // Eliminar tarea por id
    @Override
    public ResponseEntity<TaskResponse> deleteTask(long id, HttpStatus httpStatus) {
        Task task = entityManager.find(Task.class, id);
        if (task != null) {
            entityManager.remove(task);
            return new ResponseEntity<TaskResponse>(new TaskResponse(id, "OK", "Task has been deleted")
            ,HttpStatus.OK);
        }
        return new ResponseEntity<TaskResponse>(new TaskResponse(id, "ERROR", "Task not found")
        ,HttpStatus.BAD_REQUEST);
    }

    // Crear nueva tarea dada una descripcion sin id
    @Override
    public ResponseEntity<TaskResponse> newTask(Task task, HttpStatus httpStatus, String tokenHeader) {
            
        if (task.getId() == null) {
            entityManager.persist(task);
            return new ResponseEntity<TaskResponse>(new TaskResponse(task.getId(),"OK","Task Successfully created")
            ,HttpStatus.OK);
        }
        return new ResponseEntity<TaskResponse>(new TaskResponse(task.getId(),"ERROR","Id must be null to create a new task")
        ,HttpStatus.BAD_REQUEST);
        
        
    }

    // Modificar una tarea por id
    @Override
    public ResponseEntity<TaskResponse> updateTask(Task task, HttpStatus httpStatus) {
    

        if (task.getId() != null) {
            Task alreadyCreatedTask = entityManager.find(Task.class, task.getId());

            if (alreadyCreatedTask == null) {
                TaskResponse taskResponse = new TaskResponse(task.getId(), "ERROR", "There is no task assigned to given ID");
                return new ResponseEntity<TaskResponse>(taskResponse,HttpStatus.BAD_REQUEST);
            }

            entityManager.merge(task);
            TaskResponse taskResponse = new TaskResponse(task.getId(), "OK", "Task modified successfully");
            return new ResponseEntity<TaskResponse>(taskResponse,HttpStatus.OK);
        }
        
        TaskResponse taskResponse = new TaskResponse(-1, "ERROR", "ID not given");

        return new ResponseEntity<TaskResponse>(taskResponse,HttpStatus.BAD_REQUEST);

    }

    // @PersistenceContext
    // EntityManager entityManager;

    // @Override
    // @SuppressWarnings("unchecked")
    // public List<Usuario> getUsuarios() {
    //     String query = "FROM Usuario";
    //     List<Usuario> resultado = entityManager.createQuery(query).getResultList();
    //     return resultado;
    // }

    // @Override
    // public void eliminar(long id) {
    //     Usuario usuario = entityManager.find(Usuario.class, id);
    //     entityManager.remove(usuario);
    // }

    // @Override
    // public void registrar(Usuario usuario) {
    //     entityManager.merge(usuario); 
    // }

    // @Override
    // @SuppressWarnings("unchecked")
    // public boolean verificarEmailPassword(Usuario usuario) {
    //     String query = "FROM Usuario WHERE email = :email AND password = :password";
    //     List<Usuario> lista = entityManager.createQuery(query)
    //         .setParameter("email",usuario.getEmail())
    //         .setParameter("password",usuario.getPassword())
    //         .getResultList();

    //     System.out.println(lista);
    //     return !lista.isEmpty();
    // }
}
