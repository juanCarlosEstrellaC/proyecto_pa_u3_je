package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Hotel;

public interface IHotelRepository {

	// INNER, LEFT, RIGHT, FULL Y JOIN FETCH 
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion);

	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion);

	public List<Hotel> buscarHotelLeftJoin(String tipoHabitacion);
	public List<Hotel> buscarHotelRightJoin(String tipoHabitacion);
	public List<Hotel> buscarHotelFullJoin(String tipoHabitacion);
	
	
	// JOINS SIN PARAMETROS
	public List<Hotel> buscarHotelLeftJoin();
	public List<Hotel> buscarHotelRightJoin();
	public List<Hotel> buscarHotelFullJoin();
	


	


}
