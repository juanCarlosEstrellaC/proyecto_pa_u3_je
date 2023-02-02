package com.example.demo.service;

import com.example.demo.modelo.Renta;

public interface IRentaService {

	public void ingresarRenta(String placa, String cedula);
	
	public void guardar(Renta renta);
	public void actualizar(Renta renta);
	public Renta encontrar(Integer id);
	public void eliminar(Integer id);
}
