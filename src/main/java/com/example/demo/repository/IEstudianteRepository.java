package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.dto.EstudianteDTO;

public interface IEstudianteRepository {
	
	public void ingresar(Estudiante estudiante);
	
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
	
	// 
	public List<Estudiante> buscarPorNombreQueryList(String nombre);
	public Estudiante buscarPorNombreQueryListFirst(String nombre);

	public List<Estudiante> buscarPorNombreNamedQueryList(String nombre);
	public List<Estudiante> buscarPorNombreNamedNativeQueryTypedList(String nombre);

	public EstudianteDTO buscarPorNombreTypedQueryDTO(String nombre);


}
