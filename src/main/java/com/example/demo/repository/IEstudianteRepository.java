package com.example.demo.repository;

import com.example.demo.modelo.Estudiante;

public interface IEstudianteRepository {
	
	public Estudiante buscarPorNombreQuery(String nombre);
	public Estudiante buscarPorApellidoQuery(String apellido);
	

}
