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

}
