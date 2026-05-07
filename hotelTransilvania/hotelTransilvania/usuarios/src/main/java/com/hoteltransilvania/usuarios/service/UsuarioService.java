package com.hoteltransilvania.usuarios.service;

import com.hoteltransilvania.usuarios.models.Usuario;
import com.hoteltransilvania.usuarios.repository.UsuarioRepository;

import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
        // spring puede acceder a este contructor
        // trae al repositorio y lo guarda dentro del service para usarlo aca
        // y para usarlo en la base de datos
    }
    // listar usuarios
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }
    
    // guardar usuario
    public Usuario guardar(Usuario usuario){

        if (usuarioRepository.existsById(usuario.getRolId())){
            throw new RuntimeException("existe un usuario con ese username");
        }
        return usuarioRepository.save(usuario);}

    // para login usuarios
    public Usuario login(String username, String password) {

    Usuario usuario = usuarioRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    if (!usuario.getPassword().equals(password)) {
        throw new RuntimeException("Contraseña incorrecta");
    }

    return usuario;
}
    
    
    // obterner por id
    public Usuario obtenerPorId(Long id){
        return usuarioRepository.findById(id).orElseThrow(() ->
        new RuntimeException("Usuario no encontrado con ID: "+ id));}
    





    
    // eliminar usuario

    public void eliminar(Long id){
        Usuario existente = obtenerPorId(id);
        usuarioRepository.delete(existente);}
    
    // actualizar usuario
    

    public Usuario actualizar(Long id, Usuario usuario){

        Usuario existente = obtenerPorId(id);

        existente.setUsername(usuario.getUsername());
        existente.setPassword(usuario.getPassword());
        existente.setRolId(usuario.getRolId());
        
        return usuarioRepository.save(existente);}
    
}




















