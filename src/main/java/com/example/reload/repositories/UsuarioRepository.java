package com.example.reload.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.reload.models.Usuario;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByUsername(String username);

    long countByRol(String rol); // 👈 NUEVO
}