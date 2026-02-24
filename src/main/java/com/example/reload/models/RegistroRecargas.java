package com.example.reload.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_REGISTRO_RECARGAS")
public class RegistroRecargas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idRegistroRecargas;

	@Column
	private String tipo;          // 👈 NUEVO

	@Column
	private String descripcion;

	@Column
	private String celular;       // 👈 NUEVO

	@Column(columnDefinition = "TEXT")
	private String foto;

	@Column
	private String latitud;

	@Column
	private String longitud;

	// ================= GETTERS & SETTERS =================

	public Integer getIdRegistroRecargas() {
		return idRegistroRecargas;
	}

	public void setIdRegistroRecargas(Integer idRegistroRecargas) {
		this.idRegistroRecargas = idRegistroRecargas;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// ================= CONSTRUCTOR COMPLETO =================

	public RegistroRecargas(
			Integer idRegistroRecargas,
			String tipo,
			String descripcion,
			String celular,
			String foto,
			String latitud,
			String longitud) {

		this.idRegistroRecargas = idRegistroRecargas;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.celular = celular;
		this.foto = foto;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public RegistroRecargas() {
	}
}
