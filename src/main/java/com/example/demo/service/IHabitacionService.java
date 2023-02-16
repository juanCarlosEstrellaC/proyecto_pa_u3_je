package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Hotel;

public interface IHabitacionService {

	public List<Habitacion> buscarHabitacionOuterLeftJoin();
	public List<Habitacion> buscarHabitacionOuterRightJoin();
	public List<Habitacion> buscarHabitacionOuterFullJoin();
}
