package com.hoteltransilvania.usuarios.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {


@Id
// identificador unico clave primaria
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
//el id se genera automaticamente
//le dice tambien usa AUTO_INCREMENT

@NotBlank(message = "el username no puede estar vacio")
@Pattern(
        regexp = "^[a-zA-Z0-9]+$",
        message = "el username solo puede tener letras y números"
)
@Column(nullable = false, unique = true)
private String username;




@NotBlank(message = "el username no puede estar vacio")
    @Pattern(
            regexp = "^[a-zA-Z0-9]+$",
            message = "el username solo puede tener letras y números"
    )
@Column(nullable = false, unique = true)
// AL ACEPTA NUMEROS Y LETRAS
private String password;



@Column(nullable = false)
private Long rolId;}



