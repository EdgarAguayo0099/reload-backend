package com.example.reload.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore; // ✅ NUEVO

import jakarta.persistence.*;

@Entity
@Table(name = "TB_BOMBERO")
public class Bombero implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idbombero;

    @Column
    private String nombre_apellido;

    @Column
    private String ci_identidad;

    @Column
    private String contrasenha;

    @Column(columnDefinition = "TEXT")
    private String foto;

    @Column
    private Boolean is_admin;

    // ✅ Evita bucle JSON al listar bomberos
    @JsonIgnore
    @OneToOne(mappedBy = "bombero", cascade = CascadeType.ALL, orphanRemoval = true)
    private Usuario usuario;

    // ================= GETTERS & SETTERS =================

    public Integer getIdbombero() {
        return idbombero;
    }

    public void setIdbombero(Integer idbombero) {
        this.idbombero = idbombero;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public String getCi_identidad() {
        return ci_identidad;
    }

    public void setCi_identidad(String ci_identidad) {
        this.ci_identidad = ci_identidad;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Boolean getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(Boolean is_admin) {
        this.is_admin = is_admin;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Bombero() {}

    public Bombero(Integer idbombero, String nombre_apellido, String ci_identidad,
                   String contrasenha, String foto, Boolean is_admin) {
        this.idbombero = idbombero;
        this.nombre_apellido = nombre_apellido;
        this.ci_identidad = ci_identidad;
        this.contrasenha = contrasenha;
        this.foto = foto;
        this.is_admin = is_admin;
    }
}