package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.ClienteRent;
import com.example.demo.repository.IClienteRentRepository;

@Service
public class ClienteRentServiceImpl implements IClienteRentService {

	@Autowired
	private IClienteRentRepository iClienteRentRepository;

	@Override
	public void guardar(ClienteRent clienteRent) {
		this.iClienteRentRepository.insertar(clienteRent);
	}

	@Override
	public void actualizar(ClienteRent clienteRent) {
		this.iClienteRentRepository.actualizar(clienteRent);
	}

	@Override
	public ClienteRent encontrar(Integer id) {
		return this.iClienteRentRepository.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		this.iClienteRentRepository.borrar(id);
	}

	@Override
	public ClienteRent buscarCedulaQuery(String cedula) {
		return this.iClienteRentRepository.buscarCedulaQuery(cedula);
	}

}
