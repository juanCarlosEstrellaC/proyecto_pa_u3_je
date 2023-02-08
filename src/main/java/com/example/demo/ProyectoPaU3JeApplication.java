package com.example.demo;

import java.time.LocalDateTime;
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
		
//		Estudiante miEstudiante = new Estudiante();
//		miEstudiante.setNombre("Roberta");
//		miEstudiante.setApellido("Matarero");
//		miEstudiante.setCedula("12345678");
//		miEstudiante.setGenero("F");
//		miEstudiante.setPais("Ecuador");
//		miEstudiante.setFechaNacimiento(LocalDateTime.of(1996, 01, 29, 0, 0));
//		
//		// Ingreso el estudiante:
//		this.iEstudianteService.ingresar(miEstudiante);
		
		// Obtener todos los estudiantes con nombre "Juan".
		List<Estudiante> listaEstudiantesNombreJuan = this.iEstudianteService.buscarPorNombreQueryList("Juan");
		for (Estudiante estudiante : listaEstudiantesNombreJuan) {
			System.out.println(estudiante);
		}
		
		// Obtener el primer registro de estudiante con nombre "Juan"
		Estudiante busquedaPrimerRegistroEstudiate = this.iEstudianteService.buscarPorNombreQueryListFirst("Juan");
		System.out.println(busquedaPrimerRegistroEstudiate);

	}

}


//Estudiante estudianteBuscadoTQ = this.iEstudianteService.buscarPorNombreTypedQuery("Alberto");
//System.out.println(estudianteBuscadoTQ);
//
//Estudiante estudianteBuscadoNQ = this.iEstudianteService.buscarPorNombreNamedQuery("Alberto");
//System.out.println(estudianteBuscadoNQ);
//
//Estudiante estudianteBuscadoNAQ = this.iEstudianteService.buscarPorNombreNativeQuery("Alberto");
//System.out.println(estudianteBuscadoNAQ);
//
//Estudiante estudianteBuscadoNQT = this.iEstudianteService.buscarPorNombreNamedQueryTyped("Alberto");
//System.out.println(estudianteBuscadoNQT);
//
//Estudiante estudiateBuscadoNaQT = this.iEstudianteService.buscarPorNombreNamedNativeQueryTyped("Alberto");
//System.out.println(estudiateBuscadoNaQT);