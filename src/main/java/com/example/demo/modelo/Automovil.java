package com.example.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "automovil")
@NamedQuery(name = "Automovil.buscarPorPlacaNamed", query = "select a from Automovil a where a.placa = :datoPlaca")
@NamedQuery(name = "Automovil.buscarPorColorNamed", query = "select a from Automovil a where a.color = :datoColor")
@NamedQuery(name = "Automovil.buscarPorMarcaNamed", query = "select a from Automovil a where a.marca = :datoMarca")

@NamedNativeQuery(name = "Automovil.buscarPorPlacaNamedNative", query = "select * from automovil where auto_placa = :datoPlaca", resultClass = Automovil.class)
@NamedNativeQuery(name = "Automovil.buscarPorColorNamedNative", query = "select * from automovil where auto_color = :datoColor", resultClass = Automovil.class)
@NamedNativeQuery(name = "Automovil.buscarPorPrecioNamedNative", query = "select * from automovil where auto_precio = :datoPrecio", resultClass = Automovil.class)


public class Automovil{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "automov_seq")
	@SequenceGenerator(name = "automov_seq", sequenceName = "automov_seq", allocationSize = 1) 
	@Column(name = "autoId")
	private Integer id;
	
	@Column(name = "autoPlaca")
	private String placa;

	@Column(name = "autoMarca")
	private String marca;
	
	@Column(name = "autoColor")
	private String color;
	
	@Column(name = "autoPrecio")
	private BigDecimal precio;
	
	@Column(name = "autoDescuento")
	private BigDecimal descuento;
	
	@Column(name = "autoFechaFabricacion")
	private LocalDateTime fechaFabricacion;

	//toString:
	@Override
	public String toString() {
		return "Automovil [id=" + id + ", placa=" + placa + ", marca=" + marca + ", color=" + color + ", precio="
				+ precio + ", descuento=" + descuento + ", fechaFabricacion=" + fechaFabricacion + "]";
	}

	//Get y Set:
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public LocalDateTime getFechaFabricacion() {
		return fechaFabricacion;
	}

	public void setFechaFabricacion(LocalDateTime fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}
	
	
	
	
}
