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
		
		Estudiante estudianteBuscado4 = this.iEstudianteService.buscarPorNombreQueryTyped("Alberto");
		System.out.println(estudianteBuscado4);
		
		Estudiante estudianteBuscado = this.iEstudianteService.buscarPorNombreQueryNamed("Alberto");
		System.out.println(estudianteBuscado);
		
		Estudiante estudianteBuscado2 = this.iEstudianteService.buscarPorNombreNamedQueryTyped("Alberto");
		System.out.println(estudianteBuscado2);
		
		Estudiante estudianteBuscado3 = this.iEstudianteService.buscarPorNombreNativeQuery("Alberto");
		System.out.println(estudianteBuscado3);
		
	
	}

}
