package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Hotel;
import com.example.demo.service.IHabitacionService;
import com.example.demo.service.IHotelService;

import jakarta.persistence.FetchType;

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

		List<Hotel> listaHotel1 = this.iHotelService.buscarHotelInnerJoin("VIP");
		List<Hotel> listaHotel2 = this.iHotelService.buscarHotelOuterLeftJoin();
//		List<Hotel> listaHotel4 = this.iHotelService.buscarHotelOuterFullJoin("VIP");
		List<Hotel> listaHotel5 = this.iHotelService.buscarHotelJoinFetch("VIP");

		// Para traer BAJO DEMANDA:
		// 1. Clase padre = Hotel: fetch = FetchType.LAZY
		// 2. En el la clase Repositorio para el padre, se implementa manualmente el método, con el artificio del .size()
		// 3. Para imprimir sin causar un bucle, en Clase hija = Habitación: toString sin el objeto de la relación de la clase padre.

		
		//INNER:
//		for (Hotel hotel : listaHotel1) {
//			for (Habitacion habitacion : hotel.getHabitaciones()) {
//				System.out.println("La habitación de "+ hotel.getNombre()+ " es "+ habitacion.getNumero());
//			}
//		}
		
		
//		//fetch:
//		for (Hotel hotel : listaHotel5) {
//			for (Habitacion habitacion : hotel.getHabitaciones()) {
//				System.out.println("La habitación de "+ hotel.getNombre()+ " es "+ habitacion.getNumero()+ " TIPO "+ habitacion.getTipo());
//			}
//		}
		
		//LEFT JOIN SIN PARAMETROS:
//		for (Hotel hotel : listaHotel2) {
//			System.out.println(hotel.getNombre());
//			for (Habitacion habi : hotel.getHabitaciones()) {
//				System.out.println(habi.getNumero());
//			}
//		}
		
		//LEFT JOIN SIN PARAMETROS:
//		List<Habitacion> listaHabi = this.iHabitacionService.buscarHotelOuterLeftJoin();
//
//		for (Habitacion ha : listaHabi) {
//			System.out.println( ha!= null ? ha.getNumero(): null);
////			for (Habitacion habi : hotel.getHabitaciones()) {
////				System.out.println(habi.getNumero());
////			}
//		}
		
		
//		//RIGHT JOIN SIN PARAMETROS:
//		List<Habitacion> listaHabiRight = this.iHabitacionService.buscarHotelOuterRightJoin();
//
//		for (Habitacion ha : listaHabiRight) {
//			System.out.println( ha != null ? ha.getNumero(): null);
////			for (Habitacion habi : hotel.getHabitaciones()) {
////				System.out.println(habi.getNumero());
////			}
//		}
		
//		//LEFT JOIN SIN PARAMETROS:
//		List<Hotel> listaHotel3 = this.iHotelService.buscarHotelOuterRightJoin();
//
//		for (Hotel hotel : listaHotel3) {
//			System.out.println(hotel!= null ? hotel.getNombre(): null);
////			for (Habitacion habi : hotel.getHabitaciones()) {
////				System.out.println(habi.getNumero());
////			}
//		}
		
		//RIGHT JOIN SIN PARAMETROS:
		List<Habitacion> listaHabiRight = this.iHabitacionService.buscarHotelOuterRightJoin();

		for (Habitacion ha : listaHabiRight) {
			System.out.println( ha != null ? ha.getNumero(): null);
//			for (Habitacion habi : hotel.getHabitaciones()) {
//				System.out.println(habi.getNumero());
//			}
		}
		
	}

}
