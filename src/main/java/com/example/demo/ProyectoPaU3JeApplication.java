package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Hotel;
import com.example.demo.repository.IHotelRepository;
import com.example.demo.service.IHabitacionService;
import com.example.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoPaU3JeApplication implements CommandLineRunner {

	@Autowired
	private IHotelService iHotelService;
	
	@Autowired
	private IHabitacionService iHabitacionService;
	
		
	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU3JeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
//		//---------------------------------------------INNER--------------------------------------------------------------------------
//		System.out.println("INNER");
//		List<Hotel> listaHotelInner = this.iHotelService.buscarHotelInnerJoin("VIP");
//		for (Hotel hotel : listaHotelInner) {			
//			for (Habitacion habitacion : hotel.getHabitaciones()) {
//				System.out.println("La habitación de "+ hotel.getNombre()+ " es "+ habitacion.getNumero());
//			}
//		}
//		System.out.println("");
//
//			// Metodo de Prueba para ejemplificar el Traer bajo demanda:
//			System.out.println("Ejemplo 1: traer bajo demanda");
//			Hotel hotelPrueba = this.iHotelService.metodoDePrueba();
//			System.out.println(hotelPrueba);
//			System.out.println("");
//
//			
//			// Metodo de Prueba para ejemplificar que el método me devuelva un String y no solo un Hotel, cambiando el JPQL y el método.
//			System.out.println("Metodo que devuelve String");
//			String nombreHotelPrueba = this.iHotelService.metodoRetornaNombreYNoUnObjeto();
//			System.out.println(nombreHotelPrueba);
//			System.out.println("");

			
//		// Soluciono con un Join Fetch la inicialización perezosa
//		// ------------------------------------------  JOIN FETCH --------------------------------------------------------
//		// **********************ME PARECE QUE HAY LEFT, RIGHT, FULL JOIN FETCH ***********************************
//		System.out.println("JOIN FETCH");
//		List<Hotel> listaJoinFetch = this.iHotelService.buscarHotelJoinFetch("VIP");
//		for (Hotel hotel : listaJoinFetch) {
//			for (Habitacion habitacion : hotel.getHabitaciones()) {
//				System.out.println("La habitación de "+ hotel.getNombre()+ " es "+ habitacion.getNumero()+ " TIPO "+ habitacion.getTipo());
//			}
//		}
//		System.out.println("");

		
//		//LEFT JOIN SIN PARAMETROS:
//		System.out.println("Left Join");
//		List<Hotel> listaHotel2 = this.iHotelService.buscarHotelOuterLeftJoin();
//		for (Hotel hotel : listaHotel2) {
//			System.out.println(hotel.getNombre());
//			for (Habitacion habi : hotel.getHabitaciones()) {
//				System.out.println(habi.getNumero());
//			}
//		}
//		System.out.println("");
		
//		//LEFT JOIN SIN PARAMETROS:
//		List<Habitacion> listaHabitaciones = this.iHabitacionService.buscarHabitacionOuterLeftJoin();
//
//		for (Habitacion habitacion : listaHabitaciones) {
//			System.out.println( habitacion != null ? habitacion.getNumero(): null);
//		}
		
		
//		//RIGHT JOIN SIN PARAMETROS:
//		List<Habitacion> listaHabiRight = this.iHabitacionService.buscarHabitacionOuterRightJoin();
//
//		for (Habitacion ha : listaHabiRight) {
//			System.out.println( ha != null ? ha.getNumero(): null);
//		}
		
////		//LEFT JOIN SIN PARAMETROS:
//		List<Hotel> listaHotel3 = this.iHotelService.buscarHotelOuterRightJoin();
//		for (Hotel hotel : listaHotel3) {
//			System.out.println(hotel != null ? hotel.getNombre(): null);
//		}
		
		//RIGHT JOIN SIN PARAMETROS:
//		List<Habitacion> listaHabiRight = this.iHabitacionService.buscarHotelOuterRightJoin();
//
//		for (Habitacion ha : listaHabiRight) {
//			System.out.println( ha != null ? ha.getNumero(): null);
////			for (Habitacion habi : hotel.getHabitaciones()) {
////				System.out.println(habi.getNumero());
////			}
//		}
		
	}

}
