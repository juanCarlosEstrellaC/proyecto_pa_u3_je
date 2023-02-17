package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Hotel;

public interface IHotelService {

	// INNER, LEFT, RIGHT, FULL Y JOIN FETCH 
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion);
		
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion);
	
	public List<Hotel> buscarHotelLeftJoin(String tipoHabitacion);
	public List<Hotel> buscarHotelRightJoin(String tipoHabitacion);
	public List<Hotel> buscarHotelFullJoin(String tipoHabitacion);
	
	
	// LEFT, RIGHT Y FULL SIN PARAMETROS:
	public List<Hotel> buscarHotelLeftJoin();
	public List<Hotel> buscarHotelRightJoin();
	public List<Hotel> buscarHotelFullJoin();
	
	

}
