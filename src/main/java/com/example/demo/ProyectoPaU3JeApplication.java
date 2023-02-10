package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Automovil;
import com.example.demo.service.IAutomovilService;

@SpringBootApplication
public class ProyectoPaU3JeApplication implements CommandLineRunner {

	@Autowired
	private IAutomovilService iAutomovilService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU3JeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Automovil miAutomovil = new Automovil();
		miAutomovil.setMarca("Root");
		miAutomovil.setPlaca("SMT555");
		miAutomovil.setColor("marron");
		miAutomovil.setPrecio(new BigDecimal(88));
		miAutomovil.setDescuento(new BigDecimal(1500));
		miAutomovil.setFechaFabricacion(LocalDateTime.of(2000, 02, 02, 0, 0));

//		this.iAutomovilService.ingresar(miAutomovil);

		//Typed:
		System.out.println("TYPED");
		Automovil autoBuscado1 = this.iAutomovilService.buscarPorPlacaTyped(miAutomovil.getPlaca());
		System.out.println(autoBuscado1);
		
		Automovil autoBuscado2 = this.iAutomovilService.buscarPorColorTyped(miAutomovil.getColor());
		System.out.println(autoBuscado2);
		
		Automovil autoBuscado3 = this.iAutomovilService.buscarPorMarcaTyped(miAutomovil.getMarca());
		System.out.println(autoBuscado3);
		
		
		//Named:
		System.out.println("NAMED");
		Automovil autoBuscado4 = this.iAutomovilService.buscarPorPlacaNamed(miAutomovil.getPlaca());
		System.out.println(autoBuscado4);
		
		Automovil autoBuscado5 = this.iAutomovilService.buscarPorColorNamed(miAutomovil.getColor());
		System.out.println(autoBuscado5);
		
		Automovil autoBuscado6 = this.iAutomovilService.buscarPorMarcaNamed(miAutomovil.getMarca());
		System.out.println(autoBuscado6);
		
		
		// Native:
		System.out.println("NATIVE");
		Automovil autoBuscado7 = this.iAutomovilService.buscarPorMarcaNative(miAutomovil.getMarca());
		System.out.println(autoBuscado7);
		
		Automovil autoBuscado8 = this.iAutomovilService.buscarPorPrecioNative(miAutomovil.getPrecio());
		System.out.println(autoBuscado8);
		
		List<Automovil> autoBuscado9 = this.iAutomovilService.buscarPorDescuentoNative(miAutomovil.getDescuento());
		System.out.println(autoBuscado9);
		
		
		// Named Native
		System.out.println("NAMED NATIVE");
		Automovil autoBuscado10 = this.iAutomovilService.buscarPorPlacaNamedNative(miAutomovil.getPlaca());
		System.out.println(autoBuscado10);
		
		Automovil autoBuscado11 = this.iAutomovilService.buscarPorColorNamedNative(miAutomovil.getColor());
		System.out.println(autoBuscado11);
		
		Automovil autoBuscado12 = this.iAutomovilService.buscarPorPrecioNamedNative(miAutomovil.getPrecio());
		System.out.println(autoBuscado12);
		
		
		
		
		
		
	
	}

}
