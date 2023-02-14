package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Hotel;
import com.example.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoPaU3JeApplication implements CommandLineRunner {

	@Autowired
	private IHotelService iHotelService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU3JeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Hotel> listaHotel1 = this.iHotelService.buscarHotelInnerJoin("VIP");
		List<Hotel> listaHotel2 = this.iHotelService.buscarHotelOuterLeftJoin("VIP");
		List<Hotel> listaHotel3 = this.iHotelService.buscarHotelOuterRightJoin("VIP");
		List<Hotel> listaHotel4 = this.iHotelService.buscarHotelOuterFullJoin("VIP");
		List<Hotel> listaHotel5 = this.iHotelService.buscarHotelJoinFetch("VIP");

		//INNER:
		for (Hotel hotel : listaHotel1) {
			//System.out.println(hotel.getNombre());
			for (Habitacion ha  : hotel.getHabitaciones()) {
				System.out.println("Las habitacio de "+ hotel.getNombre()+ " es "+ ha.getNumero());
			}
			//System.out.println(hotel.getHabitaciones());
		}
		
//		// LEFT:
//		System.out.println("");
//		for (Hotel hotel : listaHotel2) {
//			for (Habitacion ha  : hotel.getHabitaciones()) {
//				System.out.println("Las habitacio de "+ hotel.getNombre()+ " es "+ ha.getNumero());
//			}
//		}
//		
//		// RIGHT
//		System.out.println("");
//		for (Hotel hotel : listaHotel3) {
//			for (Habitacion ha  : hotel.getHabitaciones()) {
//				System.out.println("Las habitacio de "+ hotel.getNombre()+ " es "+ ha.getNumero());
//			}
//		}
	}

}

//EstudianteDTO estudianteBuscadoDTO = this.iEstudianteService.buscarPorNombreTypedQueryDTO("Martha");
//System.out.println(estudianteBuscadoDTO);

//Estudiante estudianteBuscadoCriteria = this.iEstudianteService.buscarPorNombreCriteria("Martha");
//System.out.println(estudianteBuscadoCriteria);

//List<Estudiante> estudianteBuscadoCriteriaAndOr = this.iEstudianteService.buscarPorNombreCriteriaAndOr("", "", "F");
//System.out.println(estudianteBuscadoCriteriaAndOr);

//int estuNum = this.iEstudianteService.eliminarPorApellido("Portovelo");
//System.out.println(estuNum);
//
//int estuNum2 = this.iEstudianteService.actualizarPorApellido("Mideros", "Roberto");
//System.out.println(estuNum2);