package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Hotel;
import com.example.demo.service.IHotelService;

import jakarta.persistence.FetchType;

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
//		List<Hotel> listaHotel2 = this.iHotelService.buscarHotelOuterLeftJoin("VIP");
//		List<Hotel> listaHotel3 = this.iHotelService.buscarHotelOuterRightJoin("VIP");
//		List<Hotel> listaHotel4 = this.iHotelService.buscarHotelOuterFullJoin("VIP");
//		List<Hotel> listaHotel5 = this.iHotelService.buscarHotelJoinFetch("VIP");

		// Para traer BAJO DEMANDA:
		// 1. Clase padre = Hotel: fetch = FetchType.LAZY
		// 2. En el la clase Repositorio para el padre, se implementa manualmente el método.
		// 3. Para imprimir sin causar un bucle, en Clase hija = Habitación: toString sin el objeto de la relación de la clase padre.

		
		//INNER:
		for (Hotel hotel : listaHotel1) {
			for (Habitacion habitacion : hotel.getHabitaciones()) {
				System.out.println("La habitación de "+ hotel.getNombre()+ " es "+ habitacion.getNumero());
			}
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
