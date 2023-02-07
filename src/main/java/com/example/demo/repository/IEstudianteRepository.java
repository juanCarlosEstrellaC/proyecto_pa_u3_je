package com.example.demo.repository;

import com.example.demo.modelo.Estudiante;

public interface IEstudianteRepository {
	
	//Query:
	public Estudiante buscarPorNombreQuery(String nombre);
	public Estudiante buscarPorApellidoQuery(String apellido);
	public Estudiante buscarPorGeneroQuery(String genero);
	public Estudiante buscarPorCedulaQuery(String cedula);
	public Estudiante buscarPorCiudadQuery(String ciudad);
	
	// Typed:
	public Estudiante buscarPorNombreTypedQuery(String nombre);
	
	// Named:
	public Estudiante buscarPorNombreNamedQuery(String nombre);
	
	// Native (usa SQL):
	public Estudiante buscarPorNombreNativeQuery(String nombre);

	// Mix:
	public Estudiante buscarPorNombreNamedQueryTyped(String nombre);
	public Estudiante buscarPorNombreNamedNativeQueryTyped(String nombre);

}
