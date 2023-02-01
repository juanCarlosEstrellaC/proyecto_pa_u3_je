package com.example.demo.service;

import com.example.demo.modelo.VehiculoRent;

public interface IVehiculoRentService {

	public void guardar(VehiculoRent vehiculoRent);
	public void actualizar(VehiculoRent vehiculoRent);
	public VehiculoRent encontrar(Integer id);
	public void eliminar(Integer id);
}
