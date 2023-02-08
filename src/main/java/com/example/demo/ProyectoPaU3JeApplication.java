package com.example.demo;

import java.util.List;

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
		
//		Estudiante estudianteBuscadoTQ = this.iEstudianteService.buscarPorNombreTypedQuery("Alberto");
//		System.out.println(estudianteBuscadoTQ);
//		
//		Estudiante estudianteBuscadoNQ = this.iEstudianteService.buscarPorNombreNamedQuery("Alberto");
//		System.out.println(estudianteBuscadoNQ);
//		
//		Estudiante estudianteBuscadoNAQ = this.iEstudianteService.buscarPorNombreNativeQuery("Alberto");
//		System.out.println(estudianteBuscadoNAQ);
//		
//		Estudiante estudianteBuscadoNQT = this.iEstudianteService.buscarPorNombreNamedQueryTyped("Alberto");
//		System.out.println(estudianteBuscadoNQT);
		
		Estudiante estudiateBuscadoNaQT = this.iEstudianteService.buscarPorNombreNamedNativeQueryTyped("Alberto");
//		System.out.println(estudiateBuscadoNaQT);
	
		
		Estudiante e1 = new Estudiante();
		e1.setNombre("Juani");
		
		//this.iEstudianteService.ingresar(e1);
		
//		List<Estudiante> listaEstu = this.iEstudianteService.buscarPorNombreQueryList("Juani");
//		for (Estudiante estudiante : listaEstu) {
//			System.out.println(estudiante);
//		}
		
		Estudiante Estu2 = this.iEstudianteService.buscarPorNombreQueryListFirst("Juani");
		System.out.println(Estu2);

	}

}