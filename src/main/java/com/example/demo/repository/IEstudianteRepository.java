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
	
	//------------------------------------------------------------------------------------------
	// Retornos con más de un elemento:
	// Para obtener más de un resultado, por ejemplo, todos los estudiantes que se llamen "Juan"
	public List<Estudiante> buscarPorNombreQueryList(String nombre);
	
	// Obtener de todos los estudiantes con un mismo nombre, el primer registro
	public Estudiante buscarPorNombreQueryListFirst(String nombre);
	
	//----------------------------------------------------------------------------------------------------
	// DTO:
	public EstudianteDTO buscarPorNombreTypedQueryDTO(String nombre);

	
	//------------------------------------------------------------------------------------------
	// CRITERIA:
	public Estudiante buscarPorNombreCriteria(String nombre);
	public List<Estudiante> buscarPorNombreCriteriaAndOr(String nombre, String apellido, String genero);
	
	
	//------------------------------------------------------------------------------------------
	// QUERYS de ELIMINAR Y ACTUALIZAR 
	public int eliminarPorApellido(String apellido);
	public int actualizarPorApellido(String apellido, String nombre);
	
	
	//------------------------------------------------------------------------------------------
	// Deber: 2 QUERYS de ELIMINAR Y ACTUALIZAR c/u
	public int actualizarPorNombre(String nombre, String genero);
	public int actualizarPorPais(String pais, String genero);

	public int eliminarPorNombre(String nombre);
	public int eliminarPorPais(String pais);



	
	
	
	
	


}
