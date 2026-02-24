package com.example.reload.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(unique = true, nullable = false)
    private String username; // será el CI

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String rol; // ROLE_ADMIN o ROLE_BOMBERO

    @Column
    private String nombreCompleto;

    // 🔥 RELACIÓN CORRECTA 1 A 1
    @OneToOne
    @JoinColumn(name = "bombero_id", unique = true)
    private Bombero bombero;

    // ================= GETTERS & SETTERS =================

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Bombero getBombero() {
        return bombero;
    }

    public void setBombero(Bombero bombero) {
        this.bombero = bombero;
    }
}