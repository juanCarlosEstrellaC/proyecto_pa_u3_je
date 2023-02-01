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
	public Estudiante buscarPorNombre(String nombre) {
		return this.iEstudianteRepository.buscarPorNombreQuery(nombre);
	}

	@Override
	public Estudiante buscarPorApellido(String apellido) {
		return this.iEstudianteRepository.buscarPorApellidoQuery(apellido);
	}

}
