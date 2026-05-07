package com.hoteltransilvania.usuarios.controller;


import com.hoteltransilvania.usuarios.models.Usuario;
import com.hoteltransilvania.usuarios.service.UsuarioService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hoteltransilvania.usuarios.DTO.LoginRequest;
import com.hoteltransilvania.usuarios.DTO.LoginResponse;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;
    // creo una variable llamada service
    //la variable NO puede cambiar después.

    // Constructor
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }
    // Constructor del Controller
    //Spring hace esto automáticamente:
    //Oye Spring, necesito un UsuarioService para usarlo aquí”,crea el service,lo inyecta,y lo guarda en: this.service


    @GetMapping
    public ResponseEntity<?> listar(){

        try {
            return new ResponseEntity<>(service.listar(), HttpStatus.OK);
        } catch(Exception e) {
            return new  ResponseEntity<>("Error al listar usuarios: "+ e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        try{
            return new ResponseEntity<>(service.obtenerPorId(id),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Error al listar usuarios: "+ e.getMessage(), HttpStatus.BAD_REQUEST );}
    }

// GUARDAR USUARIO
    @PostMapping
public ResponseEntity<?> guardar(@RequestBody Usuario usuario) {
    return new ResponseEntity<>(service.guardar(usuario), HttpStatus.CREATED);
}
// LOGIN USUARIO
@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody LoginRequest request) {

    try {
        Usuario usuario = service.login(
                request.getUsername(),
                request.getPassword()
        );
        LoginResponse response = new LoginResponse(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getRolId(),"Login exitoso");
        return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(
                e.getMessage(),
                HttpStatus.BAD_REQUEST
        );
    }
}

        // ACTUALIZAR USUARIO
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable Long id,
            @RequestBody Usuario usuario) {

        try {

            return new ResponseEntity<>(
                    service.actualizar(id, usuario),
                    HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(
                    "Error al actualizar usuario: " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }
    

    // ELIMINAR USUARIO
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {

            service.eliminar(id);

            return new ResponseEntity<>(
                    "Usuario eliminado correctamente",
                    HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(
                    "Error al eliminar usuario: " + e.getMessage(),
                    HttpStatus.NOT_FOUND);
        }
    }
}
