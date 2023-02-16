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
	
		//---------------------------------------------INNER--------------------------------------------------------------------------
		System.out.println("INNER");
		List<Hotel> listaHotelInner = this.iHotelService.buscarHotelInnerJoin("VIP");
		for (Hotel hotel : listaHotelInner) {			
			for (Habitacion habitacion : hotel.getHabitaciones()) {
				System.out.println("La habitación de "+ hotel.getNombre()+ " es "+ habitacion.getNumero());
			}
		}
		System.out.println("");
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
//
//			
//		// Soluciono con un Join Fetch la inicialización perezosa del Inner Join.
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
//
//	//--------------------------------------------------------------------------------------------------------------------------------------
//		// Más ejercicios usando los mismos métodos que buscaban por tipo de habitación, ahora sin esa condición(mismos métodos que antes, pero en el JPQL sin el WHERE)
//		// Además, se implementó un repo y service de habitación, y se usa también esos métodos.
//		
//		System.out.println("Left Join Hotel");
//		List<Hotel> listaHotel2 = this.iHotelService.buscarHotelOuterLeftJoin();
//		for (Hotel hotel : listaHotel2) {
//			System.out.println(hotel.getNombre());
//			for (Habitacion habi : hotel.getHabitaciones()) {
//				System.out.println(habi.getNumero());
//			}
//		}
//		System.out.println("");
//		
//		// Obtengo los nombres de las habitaciones del left join entre hotel y habitacion. La que sea null, me retorna null.
//		System.out.println("Left Join Habitaciones");
//		List<Habitacion> listaHabitaciones1 = this.iHabitacionService.buscarHabitacionOuterLeftJoin();
//		for (Habitacion habitacion : listaHabitaciones1) {
//			System.out.println( habitacion != null ? habitacion.getNumero(): null);
//		}
//		System.out.println("");
//
//		
//		// Obtengo los nombres de las habitaciones del left join entre hotel y habitacion. La que sea null, me retorna null.
//		System.out.println("Right Join");
//		List<Habitacion> listaHabitaciones2 = this.iHabitacionService.buscarHabitacionOuterRightJoin();
//		for (Habitacion ha : listaHabitaciones2) {
//			System.out.println( ha != null ? ha.getNumero(): null);
//		}
//		System.out.println("");
		
		
//**************************************************************************DA ERROR DE NULO.************************************
//		System.out.println("Right Join");
//		List<Hotel> listaHotel3 = this.iHotelService.buscarHotelOuterRightJoin();
//		for (Hotel hotel : listaHotel3) {
//			System.out.println(hotel != null ? hotel.getNombre(): null);
//		}
//		System.out.println("");

		
//		List<Habitacion> listaHabitaciones3 = this.iHabitacionService.buscarHabitacionOuterRightJoin();
//		for (Habitacion ha : listaHabitaciones3) {
//			//System.out.println( ha != null ? ha.getNumero(): null);
//			
//			// aqui toca desactivarle del toString de Hotel las habitaciones:
//			System.out.println( ha != null ? ha.getHotel(): null);
//		}
		
	}

}
