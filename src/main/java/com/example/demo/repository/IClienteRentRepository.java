package com.example.demo.repository;

import com.example.demo.modelo.ClienteRent;

public interface IClienteRentRepository {

	public void insertar(ClienteRent clienteRent);
	public void actualizar(ClienteRent clienteRent);
	public ClienteRent buscar(Integer id);
	public void borrar(Integer id);
}
