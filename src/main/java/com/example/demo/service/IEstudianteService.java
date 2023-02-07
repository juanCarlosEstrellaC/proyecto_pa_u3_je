package com.example.demo.service;

import com.example.demo.modelo.Estudiante;

public interface IEstudianteService {

	public Estudiante buscarPorNombreQuery(String nombre);
	public Estudiante buscarPorApellidoQuery(String apellido);
	public Estudiante buscarPorGeneroQuery(String genero);
	public Estudiante buscarPorCedulaQuery(String cedula);
	public Estudiante buscarPorCiudadQuery(String ciudad);
	
	public Estudiante buscarPorNombreTypedQuery(String nombre);
	public Estudiante buscarPorNombreNamedQuery(String nombre);
	public Estudiante buscarPorNombreNativeQuery(String nombre);
	public Estudiante buscarPorNombreNamedQueryTyped(String nombre);
	public Estudiante buscarPorNombreNamedNativeQueryTyped(String nombre);


}
