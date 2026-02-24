package com.example.reload.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_SERVICIO_ABASTECIMIENTO")
public class ServicioAbastecimiento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_servicio_abastecimiento;

    @Column
    private LocalDateTime fecha_inicio;

    @Column
    private LocalDateTime fecha_fin;

    @Column
    private String descripcion;

	public Integer getId_servicio_abastecimiento() {
		return id_servicio_abastecimiento;
	}

	public void setId_servicio_abastecimiento(Integer id_servicio_abastecimiento) {
		this.id_servicio_abastecimiento = id_servicio_abastecimiento;
	}

	public LocalDateTime getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(LocalDateTime fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public LocalDateTime getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(LocalDateTime fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ServicioAbastecimiento(Integer id_servicio_abastecimiento, LocalDateTime fecha_inicio,
			LocalDateTime fecha_fin, String descripcion) {
		super();
		this.id_servicio_abastecimiento = id_servicio_abastecimiento;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.descripcion = descripcion;
	}

	public ServicioAbastecimiento() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    
	
	
	

}
