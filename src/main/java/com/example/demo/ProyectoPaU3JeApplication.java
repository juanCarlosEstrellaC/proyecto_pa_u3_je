package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
		miAutomovil.setMarca("Mercedez Benz");
		miAutomovil.setPlaca("BBB585");
		miAutomovil.setColor("rojo");
		miAutomovil.setPrecio(new BigDecimal(25000));
		miAutomovil.setDescuento(new BigDecimal(1500));
		miAutomovil.setFechaFabricacion(LocalDateTime.of(2000, 01, 02, 0, 0));

		this.iAutomovilService.ingresar(miAutomovil);

		Automovil autoBuscado = this.iAutomovilService.buscarPorPlacaTyped(miAutomovil.getPlaca());
		System.out.println(autoBuscado);

	}

}
