package com.example.demo.service;

import com.example.demo.modelo.ClienteRent;

public interface IClienteRentService {

	public void guardar(ClienteRent clienteRent);
	public void actualizar(ClienteRent clienteRent);
	public ClienteRent encontrar(Integer id);
	public void eliminar(Integer id);
}
