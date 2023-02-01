package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@SpringBootApplication
public class ProyectoPaU3JeApplication implements CommandLineRunner {

	@Autowired
	private IEstudianteService iEstudianteService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU3JeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Consultas
		// consultar por nombre:
		Estudiante e = this.iEstudianteService.buscarPorNombreQuery("Alberto");
		System.out.println(e);
		
		// consultar por apellido:
		e = this.iEstudianteService.buscarPorApellidoQuery("Estrella");
		System.out.println(e);		
		
		// consultar por genero:
		e = this.iEstudianteService.buscarPorGeneroQuery("M");
		System.out.println(e);	
		
		// consultar por cedula:
		e = this.iEstudianteService.buscarPorCedulaQuery("1723522403");
		System.out.println(e);	
		
		// consultar por apellido:
		e = this.iEstudianteService.buscarPorCiudadQuery("Quito");
		System.out.println(e);	
		
	}

}
