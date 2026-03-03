package com.example.reload.controllers;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.reload.models.Usuario;
import com.example.reload.repositories.UsuarioRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario request) {

        String username = request.getUsername() != null ? request.getUsername().trim() : "";
        String password = request.getPassword() != null ? request.getPassword().trim() : "";

        if (username.isEmpty() || password.isEmpty()) {
            return ResponseEntity.badRequest().body("Faltan datos (username/password)");
        }

        Optional<Usuario> usuarioOptional = usuarioRepository.findByUsername(username);

        if (usuarioOptional.isEmpty()) {
            return ResponseEntity.status(401).body("Usuario o contraseña incorrectos");
        }

        Usuario usuario = usuarioOptional.get();

        if (!usuario.getPassword().equals(password)) {
            return ResponseEntity.status(401).body("Usuario o contraseña incorrectos");
        }

        String nombreCompleto = "";
        if (usuario.getBombero() != null && usuario.getBombero().getNombre_apellido() != null) {
            nombreCompleto = usuario.getBombero().getNombre_apellido();
        }

        return ResponseEntity.ok(
                Map.of(
                        "idUsuario", usuario.getIdUsuario(),
                        "username", usuario.getUsername(),
                        "rol", usuario.getRol(),
                        "nombreCompleto", nombreCompleto
                )
        );
    }
}