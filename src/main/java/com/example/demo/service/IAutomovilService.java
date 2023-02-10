package com.example.demo.service;

import com.example.demo.modelo.Automovil;

public interface IAutomovilService {
	
	public void ingresar(Automovil automovil);
	
	public Automovil buscarPorPlacaTyped(String placa);

}
