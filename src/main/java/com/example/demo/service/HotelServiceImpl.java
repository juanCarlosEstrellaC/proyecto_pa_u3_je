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

		// Métodos de prueba y ensayo:
		@Override
		public Hotel metodoDePrueba() {
			return this.iHotelRepository.metodoDePrueba();
		}

		@Override
		public String metodoRetornaNombreYNoUnObjeto() {
			return this.iHotelRepository.metodoRetornaNombreYNoUnObjeto();
		}
		
	@Override
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		return this.iHotelRepository.buscarHotelJoinFetch(tipoHabitacion);
	}	
		
	@Override
	public List<Hotel> buscarHotelOuterLeftJoin(String tipoHabitacion) {
		return this.iHotelRepository.buscarHotelOuterLeftJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelOuterRightJoin(String tipoHabitacion) {
		return this.iHotelRepository.buscarHotelOuterRightJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelOuterFullJoin(String tipoHabitacion) {
		return this.iHotelRepository.buscarHotelOuterFullJoin(tipoHabitacion);
	}


	
	// JOINS SIN PARAMETROS
	@Override
	public List<Hotel> buscarHotelOuterLeftJoin() {
		return this.iHotelRepository.buscarHotelOuterLeftJoin();
	}

	@Override
	public List<Hotel> buscarHotelOuterRightJoin() {
		return this.iHotelRepository.buscarHotelOuterRightJoin();
	}

	@Override
	public List<Hotel> buscarHotelOuterFullJoin() {
		return this.iHotelRepository.buscarHotelOuterFullJoin();
	}

	
	
	

}
