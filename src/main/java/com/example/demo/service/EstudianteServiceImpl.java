package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Estudiante;
import com.example.demo.repository.IEstudianteRepository;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

	@Autowired
	private IEstudianteRepository iEstudianteRepository;
	
	@Override
	public void ingresar(Estudiante estudiante) {
		this.iEstudianteRepository.ingresar(estudiante);
	}


	
	@Override
	public Estudiante buscarPorNombreQuery(String nombre) {
		return this.iEstudianteRepository.buscarPorNombreQuery(nombre);
	}

	@Override
	public Estudiante buscarPorApellidoQuery(String apellido) {
		return this.iEstudianteRepository.buscarPorApellidoQuery(apellido);
	}

	@Override
	public Estudiante buscarPorGeneroQuery(String genero) {
		return this.iEstudianteRepository.buscarPorGeneroQuery(genero);
	}

	@Override
	public Estudiante buscarPorCedulaQuery(String cedula) {
		return this.iEstudianteRepository.buscarPorCedulaQuery(cedula);
	}

	@Override
	public Estudiante buscarPorCiudadQuery(String ciudad) {
		return this.iEstudianteRepository.buscarPorCiudadQuery(ciudad);
	}

	//TYPED:
	@Override
	public Estudiante buscarPorNombreTypedQuery(String nombre) {
		return this.iEstudianteRepository.buscarPorNombreTypedQuery(nombre);
	}

	@Override
	public Estudiante buscarPorNombreNamedQuery(String nombre) {
		return this.iEstudianteRepository.buscarPorNombreNamedQuery(nombre);
	}

	//NAMED Y TYPED
	@Override
	public Estudiante buscarPorNombreNamedQueryTyped(String nombre) {
		return this.iEstudianteRepository.buscarPorNombreNamedQueryTyped(nombre);
	}

	@Override
	public Estudiante buscarPorNombreNativeQuery(String nombre) {
		return this.iEstudianteRepository.buscarPorNombreNativeQuery(nombre);
	}

	@Override
	public Estudiante buscarPorNombreNamedNativeQueryTyped(String nombre) {
		return this.iEstudianteRepository.buscarPorNombreNamedNativeQueryTyped(nombre);
	}

	@Override
	public List<Estudiante> buscarPorNombreQueryList(String nombre) {
		return this.iEstudianteRepository.buscarPorNombreQueryList(nombre);
	}



	@Override
	public Estudiante buscarPorNombreQueryListFirst(String nombre) {
		return this.iEstudianteRepository.buscarPorNombreQueryListFirst(nombre);
	}

	

	
	

}
