package com.example.demo.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculoRent")
public class VehiculoRent{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehiRent_seq")
	@SequenceGenerator(name = "vehiRent_seq", sequenceName = "vehiRent_seq", allocationSize = 1) 
	@Column(name = "vehi_id")
	private Integer id;
	
	@Column(name = "vehi_placa")
	private String placa;

	@Column(name = "vehi_marca")
	private String marca;
	
	@Column(name = "vehi_color")
	private String color;
	
	@Column(name = "vehi_precio")
	private BigDecimal precio;
	
	
	@OneToMany(mappedBy = "miVehiculoRent")
	private List<Renta> misRentas;
	
	
	//toString:
	@Override
	public String toString() {
		return "VehiculoRent [id=" + id + ", placa=" + placa + ", marca=" + marca + ", color=" + color + ", precio="
				+ precio + ", misRentas=" + misRentas + "]";
	}

	//Get y Set
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

	public List<Renta> getMisRentas() {
		return misRentas;
	}

	public void setMisRentas(List<Renta> misRentas) {
		this.misRentas = misRentas;
	}

	



	
	
}
