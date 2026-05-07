package com.hoteltransilvania.usuarios.repository;

import com.hoteltransilvania.usuarios.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;




public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
// crea una conexion automatica con la tabla usuarios y dame todas las
// operaciones CRUD sin escribir en sql
    boolean existsByUsername(String username);
// valida username repetido


Optional<Usuario> findByUsername(String username);
// busca usuario por username
}


