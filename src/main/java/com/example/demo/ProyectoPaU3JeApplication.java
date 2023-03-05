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

//		 EstudianteDTO estudianteBuscadoDTO = this.iEstudianteService.buscarPorNombreTypedQueryDTO("Martha");
//		 System.out.println(estudianteBuscadoDTO);
		 
//		 Estudiante estudianteBuscadoCriteria = this.iEstudianteService.buscarPorNombreCriteria("Martha");
//		 System.out.println(estudianteBuscadoCriteria);
		
//		List<Estudiante> estudianteBuscadoCriteriaAndOr = this.iEstudianteService.buscarPorNombreCriteriaAndOr("", "", "F");
//		 System.out.println(estudianteBuscadoCriteriaAndOr);
		 
//		int estuNum = this.iEstudianteService.eliminarPorApellido("Portovelo");
//		System.out.println(estuNum);
//		
//		int estuNum2 = this.iEstudianteService.actualizarPorApellido("Mideros", "Roberto");
//		System.out.println(estuNum2);
		
		
		
	}

}
