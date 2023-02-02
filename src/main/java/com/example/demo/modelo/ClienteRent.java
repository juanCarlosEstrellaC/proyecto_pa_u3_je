package com.example.demo.modelo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "clienteRent")
public class ClienteRent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clieRent_seq")
	@SequenceGenerator(name = "clieRent_seq", sequenceName = "clieRent_seq", allocationSize = 1) 
	@Column(name = "clie_id")
	private Integer id;
	
	@Column(name = "clie_cedula")
	private String cedula;
	
	@Column(name = "clie_nombre")
	private String nombre;
	
	@Column(name = "clie_apellido")
	private String apellido;
	
	@Column(name = "clie_fechaNacimiento")
	private LocalDateTime fechaNacimiento;
	
	@OneToMany(mappedBy = "miclienteRent", fetch = FetchType.EAGER)
	private List<Renta> miListaRentas;


	
	@Override
	public String toString() {
		return "ClienteRent [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fechaNacimiento=" + fechaNacimiento+"]";
	}

	//Get y Set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<Renta> getMiListaRentas() {
		return miListaRentas;
	}

	public void setMiListaRentas(List<Renta> miListaRentas) {
		this.miListaRentas = miListaRentas;
	}


	

}
