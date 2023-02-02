package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.VehiculoRent;
import com.example.demo.repository.IVehiculoRentRepository;

@Service
public class VehiculoRentServiceImpl implements IVehiculoRentService {

	@Autowired
	private IVehiculoRentRepository iVehiculoRentRepository;
	
	@Override
	public void guardar(VehiculoRent vehiculoRent) {
		this.iVehiculoRentRepository.insertar(vehiculoRent);
	}

	@Override
	public void actualizar(VehiculoRent vehiculoRent) {
		this.iVehiculoRentRepository.actualizar(vehiculoRent);
	}

	@Override
	public VehiculoRent encontrar(Integer id) {
		return this.iVehiculoRentRepository.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		this.iVehiculoRentRepository.borrar(id);
	}

	@Override
	public VehiculoRent buscarPlaca(String placa) {
		return this.iVehiculoRentRepository.buscarPlacaQuery(placa);
	}

}
