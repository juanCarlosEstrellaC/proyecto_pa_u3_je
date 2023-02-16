package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Hotel;

public interface IHotelService {

	// INNER, LEFT, RIGHT, FULL Y JOIN FETCH 
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion);
		// Métodos de prueba y ensayo:
		public Hotel metodoDePrueba();
		public String metodoRetornaNombreYNoUnObjeto();
	
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion);
	
	public List<Hotel> buscarHotelOuterLeftJoin(String tipoHabitacion);
	public List<Hotel> buscarHotelOuterRightJoin(String tipoHabitacion);
	public List<Hotel> buscarHotelOuterFullJoin(String tipoHabitacion);
	
	
	// LEFT, RIGHT Y FULL SIN PARAMETROS:
	public List<Hotel> buscarHotelOuterLeftJoin();
	public List<Hotel> buscarHotelOuterRightJoin();
	public List<Hotel> buscarHotelOuterFullJoin();
	
	

}
