package com.example.ListadoDeTareas.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id") 
    private Long id;
    @Getter @Setter @Column(name = "descripcion")
    private String descripcion;
    @Getter @Setter @Column(name = "estado")
    private String estado;

}
