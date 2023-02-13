package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.Hotel;
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
		
		
//		int estuNum2 = this.iEstudianteService.actualizarPorPais("Colombia", "F");
//		System.out.println(estuNum2);
		
		int estuNum = this.iEstudianteService.eliminarPorPais("Argentina");
		System.out.println(estuNum);
	}

}
