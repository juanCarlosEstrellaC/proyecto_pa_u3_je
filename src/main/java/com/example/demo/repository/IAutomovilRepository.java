package com.example.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.modelo.Automovil;

public interface IAutomovilRepository {
	
	public void ingresar(Automovil automovil);
	
	//Typed
	public Automovil buscarPorPlacaTyped(String placa);
	public Automovil buscarPorColorTyped(String color);
	public Automovil buscarPorMarcaTyped(String marca);
	
	//Named
	public Automovil buscarPorPlacaNamed(String placa);
	public Automovil buscarPorColorNamed(String color);
	public Automovil buscarPorMarcaNamed(String marca);
	
	//Native
	public Automovil buscarPorMarcaNative(String marca);
	public Automovil buscarPorPrecioNative(BigDecimal precio);
	public List<Automovil> buscarPorDescuentoNative(BigDecimal precio);
	
	//Named Native:
	public Automovil buscarPorPlacaNamedNative(String placa);
	public Automovil buscarPorColorNamedNative(String color);
	public Automovil buscarPorPrecioNamedNative(BigDecimal precio);
}
