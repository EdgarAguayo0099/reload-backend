package com.example.reload.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_REGISTRO_MOVILES")
public class RegistroMoviles implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_registro_moviles;

    @Column
    private String descripcion;

    @Column
    private Double capacidad_tanque;

    @Column(columnDefinition = "TEXT")
    private String foto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Bombero bombero;

	public Integer getId_registro_moviles() {
		return id_registro_moviles;
	}

	public void setId_registro_moviles(Integer id_registro_moviles) {
		this.id_registro_moviles = id_registro_moviles;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getCapacidad_tanque() {
		return capacidad_tanque;
	}

	public void setCapacidad_tanque(Double capacidad_tanque) {
		this.capacidad_tanque = capacidad_tanque;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Bombero getBombero() {
		return bombero;
	}

	public void setBombero(Bombero bombero) {
		this.bombero = bombero;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public RegistroMoviles(Integer id_registro_moviles, String descripcion, Double capacidad_tanque, String foto,
			Bombero bombero) {
		super();
		this.id_registro_moviles = id_registro_moviles;
		this.descripcion = descripcion;
		this.capacidad_tanque = capacidad_tanque;
		this.foto = foto;
		this.bombero = bombero;
	}

	public RegistroMoviles() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
	

}
