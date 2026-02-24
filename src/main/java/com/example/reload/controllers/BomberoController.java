package com.example.reload.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import com.example.reload.models.Bombero;
import com.example.reload.models.Usuario;
import com.example.reload.repositories.BomberoRepository;
import com.example.reload.repositories.UsuarioRepository;

@RestController
@RequestMapping("/bomberos") // opcional pero recomendado
public class BomberoController {

    private final BomberoRepository bomberoRepository;
    private final UsuarioRepository usuarioRepository;

    public BomberoController(
            BomberoRepository bomberoRepository,
            UsuarioRepository usuarioRepository) {
        this.bomberoRepository = bomberoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    // ==========================
    // SAVE (CREATE + UPDATE)
    // ==========================
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Bombero b) {

        if (b.getCi_identidad() == null || b.getCi_identidad().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("CI requerido");
        }

        if (b.getContrasenha() == null || b.getContrasenha().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Contraseña requerida");
        }

        String usernameNuevo = b.getCi_identidad().trim();
        boolean esEdicion = (b.getIdbombero() != null);

        // ================= UPDATE =================
        if (esEdicion) {

            Optional<Bombero> actualOpt = bomberoRepository.findById(b.getIdbombero());

            if (actualOpt.isEmpty()) {
                return ResponseEntity.badRequest().body("Bombero no encontrado");
            }

            Bombero actual = actualOpt.get();
            String usernameViejo = actual.getCi_identidad();

            // Si cambió el CI validar duplicado
            if (!usernameNuevo.equals(usernameViejo)) {
                if (usuarioRepository.findByUsername(usernameNuevo).isPresent()) {
                    return ResponseEntity.badRequest()
                            .body("Ya existe un usuario con ese CI");
                }
            }

            Bombero actualizado = bomberoRepository.save(b);

            Usuario usuario = usuarioRepository
                    .findByUsername(usernameViejo)
                    .orElse(new Usuario());

            usuario.setUsername(usernameNuevo);
            usuario.setPassword(b.getContrasenha());
            usuario.setRol(Boolean.TRUE.equals(b.getIs_admin())
                    ? "ROLE_ADMIN"
                    : "ROLE_BOMBERO");
            usuario.setNombreCompleto(b.getNombre_apellido());
            usuario.setBombero(actualizado);

            actualizado.setUsuario(usuario);

            usuarioRepository.save(usuario);

            return ResponseEntity.ok(actualizado);
        }

        // ================= INSERT =================
        if (usuarioRepository.findByUsername(usernameNuevo).isPresent()) {
            return ResponseEntity.badRequest()
                    .body("Ya existe un usuario con ese CI");
        }

        Usuario usuario = new Usuario();
        usuario.setUsername(usernameNuevo);
        usuario.setPassword(b.getContrasenha());
        usuario.setRol(Boolean.TRUE.equals(b.getIs_admin())
                ? "ROLE_ADMIN"
                : "ROLE_BOMBERO");
        usuario.setNombreCompleto(b.getNombre_apellido());

        usuario.setBombero(b);
        b.setUsuario(usuario);

        Bombero guardado = bomberoRepository.save(b);

        return ResponseEntity.ok(guardado);
    }

    // ==========================
    // FIND ALL
    // ==========================
    @GetMapping("/findAll")
    public Iterable<Bombero> findAllBomberos() {
        return bomberoRepository.findAll();
    }

    // ==========================
    // DELETE SEGURO
    // ==========================
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Integer id) {

        Optional<Bombero> bomberoOpt = bomberoRepository.findById(id);

        if (bomberoOpt.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body("Bombero no encontrado");
        }

        Bombero bombero = bomberoOpt.get();

        // 🔥 PROTECCIÓN: no borrar último admin
        if (Boolean.TRUE.equals(bombero.getIs_admin())) {

            long admins = usuarioRepository.countByRol("ROLE_ADMIN");

            if (admins <= 1) {
                return ResponseEntity.badRequest()
                        .body("No se puede eliminar el último administrador");
            }
        }

        bomberoRepository.deleteById(id);

        return ResponseEntity.ok("Eliminado correctamente");
    }
}