package com.example.ListadoDeTareas.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Entity
@Data
@Table(name ="tasks")
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") 
    private Long id;

    @NotBlank
    @Column(name = "descripcion")
    private String descripcion;

    @NotBlank
    @Column(name = "estado")
    private String estado;

}
