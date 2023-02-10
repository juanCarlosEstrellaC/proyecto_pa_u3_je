package com.example.demo.service;

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

	@Override
	public Automovil buscarPorPlacaTyped(String placa) {
		return this.iAutomovilRepository.buscarPorPlacaTyped(placa);
	}

}
