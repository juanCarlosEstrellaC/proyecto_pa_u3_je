package com.example.demo.repository;

import com.example.demo.modelo.VehiculoRent;

public interface IVehiculoRentRepository {

	public void insertar(VehiculoRent vehiculoRent);
	public void actualizar(VehiculoRent vehiculoRent);
	public VehiculoRent buscar(Integer id);
	public void borrar(Integer id);
}
