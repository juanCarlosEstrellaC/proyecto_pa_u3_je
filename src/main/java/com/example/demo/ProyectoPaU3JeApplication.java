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
		
//		Estudiante e1 = new Estudiante();
//		e1.setNombre("Juan");
//		e1.setApellido("Estrella");
//		e1.setCedula("123456789");
//		e1.setCiudad("Quito");
		
		// ingresar estudiante:
		
		// consultar por nombre:
		Estudiante e = this.iEstudianteService.buscarPorNombre("Alberto");
		System.out.println(e);
		
	}

}
