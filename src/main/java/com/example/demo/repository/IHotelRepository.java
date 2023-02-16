package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Hotel;

public interface IHotelRepository {

	// INNER, LEFT, RIGHT, FULL Y JOIN FETCH 
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion);
		// Métodos de prueba y ensayo:
		public Hotel metodoDePrueba();
		public String metodoRetornaNombreYNoUnObjeto();
		
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion);

	public List<Hotel> buscarHotelOuterLeftJoin(String tipoHabitacion);
	public List<Hotel> buscarHotelOuterRightJoin(String tipoHabitacion);
	public List<Hotel> buscarHotelOuterFullJoin(String tipoHabitacion);
	
	
	// JOINS SIN PARAMETROS
	public List<Hotel> buscarHotelOuterLeftJoin();
	public List<Hotel> buscarHotelOuterRightJoin();
	public List<Hotel> buscarHotelOuterFullJoin();
	


	


}
