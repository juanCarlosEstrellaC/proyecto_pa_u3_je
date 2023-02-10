package com.example.demo.repository;

import com.example.demo.modelo.Automovil;

public interface IAutomovilRepository {
	
	public void ingresar(Automovil automovil);
	
	public Automovil buscarPorPlacaTyped(String placa);

}
