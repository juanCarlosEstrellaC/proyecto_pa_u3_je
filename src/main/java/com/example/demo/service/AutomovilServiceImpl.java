package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Automovil;
import com.example.demo.repository.IAutomovilRepository;

@Service
public class AutomovilServiceImpl implements IAutomovilService {

	@Autowired
	private IAutomovilRepository iAutomovilRepository;
	
	@Override
	public void ingresar(Automovil automovil) {
		this.iAutomovilRepository.ingresar(automovil);
	}

	//Typed
	@Override
	public Automovil buscarPorPlacaTyped(String placa) {
		return this.iAutomovilRepository.buscarPorPlacaTyped(placa);
	}

	@Override
	public Automovil buscarPorColorTyped(String color) {
		return this.iAutomovilRepository.buscarPorColorTyped(color);
	}

	@Override
	public Automovil buscarPorMarcaTyped(String marca) {
		return this.iAutomovilRepository.buscarPorMarcaTyped(marca);
	}


	//Named
	@Override
	public Automovil buscarPorPlacaNamed(String placa) {
		return this.iAutomovilRepository.buscarPorPlacaNamed(placa);
	}

	@Override
	public Automovil buscarPorColorNamed(String color) {
	return this.iAutomovilRepository.buscarPorColorNamed(color);
	}

	@Override
	public Automovil buscarPorMarcaNamed(String marca) {
		return this.iAutomovilRepository.buscarPorMarcaNamed(marca);
	}

	//Native:
	@Override
	public Automovil buscarPorMarcaNative(String marca) {
		return this.iAutomovilRepository.buscarPorMarcaNative(marca);
	}

	@Override
	public Automovil buscarPorPrecioNative(BigDecimal precio) {
		return this.iAutomovilRepository.buscarPorPrecioNative(precio);
	}

	@Override
	public List<Automovil> buscarPorDescuentoNative(BigDecimal precio) {
		return this.iAutomovilRepository.buscarPorDescuentoNative(precio);
	}

	@Override
	public Automovil buscarPorPlacaNamedNative(String placa) {
		return this.iAutomovilRepository.buscarPorPlacaNamedNative(placa);
	}

	@Override
	public Automovil buscarPorColorNamedNative(String color) {
		return this.iAutomovilRepository.buscarPorColorNamedNative(color);
	}

	@Override
	public Automovil buscarPorPrecioNamedNative(BigDecimal precio) {
		return this.iAutomovilRepository.buscarPorPrecioNamedNative(precio);
	}



	
	



}
