package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.dto.EstudianteDTO;
import com.example.demo.repository.IEstudianteRepository;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

	@Autowired
	private IEstudianteRepository iEstudianteRepository;


	@Override
	public void ingresar(Estudiante estudiante) {
		this.iEstudianteRepository.ingresar(estudiante);
	}
	
	//Query:
	@Override
	public Estudiante buscarPorNombreQuery(String nombre) {
		return this.iEstudianteRepository.buscarPorNombreQuery(nombre);
	}

	// Typed:
	@Override
	public Estudiante buscarPorNombreTypedQuery(String nombre) {
		return this.iEstudianteRepository.buscarPorNombreTypedQuery(nombre);
	}

	// Named:
	@Override
	public Estudiante buscarPorNombreNamedQuery(String nombre) {
		return this.iEstudianteRepository.buscarPorNombreNamedQuery(nombre);
	}

	// Native:
	@Override
	public Estudiante buscarPorNombreNativeQuery(String nombre) {
		return this.iEstudianteRepository.buscarPorNombreNativeQuery(nombre);
	}

	// Mix:
	@Override
	public Estudiante buscarPorNombreNamedQueryTyped(String nombre) {
		return this.iEstudianteRepository.buscarPorNombreNamedQueryTyped(nombre);
	}
	@Override
	public Estudiante buscarPorNombreNamedNativeQueryTyped(String nombre) {
		return this.iEstudianteRepository.buscarPorNombreNamedNativeQueryTyped(nombre);
	}

	//------------------------------------------------------------------------------------------
	// Retornos con más de un elemento:
	// Para obtener más de un resultado, por ejemplo, todos los estudiantes que se llamen "Juan"
	@Override
	public List<Estudiante> buscarPorNombreQueryList(String nombre) {
		return this.iEstudianteRepository.buscarPorNombreQueryList(nombre);
	}

	// Obtener de todos los estudiantes con un mismo nombre, el primer registro
	@Override
	public Estudiante buscarPorNombreQueryListFirst(String nombre) {
		return this.iEstudianteRepository.buscarPorNombreQueryListFirst(nombre);
	}

	//------------------------------------------------------------------------------------------
	// DTO:
	@Override
	public EstudianteDTO buscarPorNombreTypedQueryDTO(String nombre) {
		return this.iEstudianteRepository.buscarPorNombreTypedQueryDTO(nombre);
	}

	//------------------------------------------------------------------------------------------
	// CRITERIA:
	@Override
	public Estudiante buscarPorNombreCriteria(String nombre) {
		return this.iEstudianteRepository.buscarPorNombreCriteria(nombre);
	}
	@Override
	public List<Estudiante> buscarPorNombreCriteriaAndOr(String nombre, String apellido, String genero) {
		return this.iEstudianteRepository.buscarPorNombreCriteriaAndOr(nombre, apellido, genero);
	}

	
	//------------------------------------------------------------------------------------------
	// QUERYS de ELIMINAR Y ACTUALIZAR 
	@Override
	public int eliminarPorApellido(String apellido) {
		return this.iEstudianteRepository.eliminarPorApellido(apellido);
	}

	@Override
	public int actualizarPorApellido(String apellido, String nombre) {
		return this.iEstudianteRepository.actualizarPorApellido(apellido, nombre);
	}

	

}
