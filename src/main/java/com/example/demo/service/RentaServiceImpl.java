package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Renta;
import com.example.demo.repository.IRentaRepository;

@Service
public class RentaServiceImpl implements IRentaService {

	@Autowired
	private IRentaRepository iRentaRepository;

	@Override
	public void guardar(Renta renta) {
		this.iRentaRepository.insertar(renta);
	}

	@Override
	public void actualizar(Renta renta) {
		this.iRentaRepository.actualizar(renta);
	}

	@Override
	public Renta encontrar(Integer id) {
		return this.iRentaRepository.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		this.iRentaRepository.borrar(id);
	}

}
