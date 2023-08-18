package com.example.ListadoDeTareas.models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="users")
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank 
    @Size(max=80)
    private String email;
    
    @NotBlank
    @Size(max=30)
    private String username;

    @NotBlank
    private String password;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Task.class, cascade = CascadeType.REMOVE)
    private Set<Task> tareas; 
    
    // CONFIGURACION DE RELACIONES
    //  manera de traerse los datos     a que entidad se hace referencia        accion al eliminar un usuario
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = RoleEntity.class, cascade = CascadeType.PERSIST)
    // Creacion de tabla intermedia
    //          NOMBRE DE TABLA                     FK referente a esta entidad                     FK referente a entidad a referenciar
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles; 


}
