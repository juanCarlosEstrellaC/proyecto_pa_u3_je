package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Hotel;

public interface IHabitacionService {

	public List<Habitacion> buscarHotelOuterLeftJoin();
	public List<Habitacion> buscarHotelOuterRightJoin();
	public List<Habitacion> buscarHotelOuterFullJoin();
}
