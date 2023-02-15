package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Habitacion;
import com.example.demo.repository.IHabitacionRepository;

@Service
public class HabitacionServiceImpl implements IHabitacionService{

	@Autowired
	private IHabitacionRepository iHabitacionRepository;
	
	@Override
	public List<Habitacion> buscarHotelOuterLeftJoin() {
		return this.iHabitacionRepository.buscarHotelOuterLeftJoin();
	}

	@Override
	public List<Habitacion> buscarHotelOuterRightJoin() {
		return this.iHabitacionRepository.buscarHotelOuterRightJoin();
	}

	@Override
	public List<Habitacion> buscarHotelOuterFullJoin() {
		return this.iHabitacionRepository.buscarHotelOuterFullJoin();
	}

}
