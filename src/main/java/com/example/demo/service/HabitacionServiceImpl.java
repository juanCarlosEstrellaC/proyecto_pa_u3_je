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
	public List<Habitacion> buscarHabitacionOuterLeftJoin() {
		return this.iHabitacionRepository.buscarHabitacionOuterLeftJoin();
	}

	@Override
	public List<Habitacion> buscarHabitacionOuterRightJoin() {
		return this.iHabitacionRepository.buscarHabitacionOuterRightJoin();
	}

	@Override
	public List<Habitacion> buscarHabitacionOuterFullJoin() {
		return this.iHabitacionRepository.buscarHabitacionOuterFullJoin();
	}

}
