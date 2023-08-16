package com.example.ListadoDeTareas.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.ListadoDeTareas.models.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
@Transactional
@SuppressWarnings("unchecked")
public class taskDaoImp implements taskDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Task> getTaskList() {
        String query = "FROM Task";
        List<Task> resultado = entityManager.createQuery(query).getResultList();
        return resultado;
    }

    @Override
    public void deleteTask(long id) {

    }

    @Override
    public void newTask(Task task) {

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
