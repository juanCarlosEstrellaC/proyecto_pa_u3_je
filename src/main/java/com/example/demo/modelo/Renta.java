package com.example.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "rentaRent")
public class Renta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rentaRent_seq")
	@SequenceGenerator(name = "rentaRent_seq", sequenceName = "rentaRent_seq", allocationSize = 1)
	@Column(name = "renta_id")
	private Integer id;
	
	@Column(name = "renta_fecha")
	private LocalDateTime fecha;
	
	@Column(name = "renta_numeroDias")
	private BigDecimal numeroDias;
	
	@Column(name = "renta_valorPago")
	private BigDecimal valorPago;
	
	
	@ManyToOne
	@JoinColumn(name = "renta_id_vehiculo")
	private VehiculoRent miVehiculoRent;
	
	@ManyToOne
	@JoinColumn(name = "renta_id_cliente")
	private ClienteRent miclienteRent;

	//toString:
	@Override
	public String toString() {
		return "RentaRent [id=" + id + ", fecha=" + fecha + ", numeroDias=" + numeroDias + ", valorPago=" + valorPago
				+ ", miVehiculoRent=" + miVehiculoRent + ", miclienteRent=" + miclienteRent + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	//Get y Set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getNumeroDias() {
		return numeroDias;
	}

	public void setNumeroDias(BigDecimal numeroDias) {
		this.numeroDias = numeroDias;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public VehiculoRent getMiVehiculoRent() {
		return miVehiculoRent;
	}

	public void setMiVehiculoRent(VehiculoRent miVehiculoRent) {
		this.miVehiculoRent = miVehiculoRent;
	}

	public ClienteRent getMiclienteRent() {
		return miclienteRent;
	}

	public void setMiclienteRent(ClienteRent miclienteRent) {
		this.miclienteRent = miclienteRent;
	}

	
	
}
