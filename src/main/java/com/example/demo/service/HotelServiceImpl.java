package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Hotel;
import com.example.demo.repository.IHotelRepository;

@Service
public class HotelServiceImpl implements IHotelService{

	@Autowired 
	private IHotelRepository iHotelRepository;
	
	// INNER, LEFT, RIGHT, FULL Y JOIN FETCH 
	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		return this.iHotelRepository.buscarHotelInnerJoin(tipoHabitacion);
	}

		
		
	@Override
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		return this.iHotelRepository.buscarHotelJoinFetch(tipoHabitacion);
	}	
		
	@Override
	public List<Hotel> buscarHotelLeftJoin(String tipoHabitacion) {
		return this.iHotelRepository.buscarHotelLeftJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelRightJoin(String tipoHabitacion) {
		return this.iHotelRepository.buscarHotelRightJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelFullJoin(String tipoHabitacion) {
		return this.iHotelRepository.buscarHotelFullJoin(tipoHabitacion);
	}


	
	// JOINS SIN PARAMETROS
	@Override
	public List<Hotel> buscarHotelLeftJoin() {
		return this.iHotelRepository.buscarHotelLeftJoin();
	}

	@Override
	public List<Hotel> buscarHotelRightJoin() {
		return this.iHotelRepository.buscarHotelRightJoin();
	}

	@Override
	public List<Hotel> buscarHotelFullJoin() {
		return this.iHotelRepository.buscarHotelFullJoin();
	}

	
	
	

}
