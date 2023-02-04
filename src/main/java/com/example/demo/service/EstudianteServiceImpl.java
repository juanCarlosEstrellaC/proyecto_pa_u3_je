package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Estudiante;
import com.example.demo.repository.IEstudianteRepository;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

	@Autowired
	private IEstudianteRepository iEstudianteRepository;
	
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
	public Estudiante buscarPorNombreQueryTyped(String nombre) {
		return this.iEstudianteRepository.buscarPorNombreQueryTyped(nombre);
	}

	@Override
	public Estudiante buscarPorNombreQueryNamed(String nombre) {
		return this.iEstudianteRepository.buscarPorNombreQueryNamed(nombre);
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
	public Estudiante buscarPorNombreNativeQueryTypedNamed(String nombre) {
		return this.iEstudianteRepository.buscarPorNombreNativeQueryTypedNamed(nombre);
	}

}
