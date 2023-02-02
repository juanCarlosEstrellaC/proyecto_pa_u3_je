package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.ClienteRent;
import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.VehiculoRent;
import com.example.demo.repository.IClienteRentRepository;
import com.example.demo.service.IClienteRentService;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IRentaService;
import com.example.demo.service.IVehiculoRentService;

@SpringBootApplication
public class ProyectoPaU3JeApplication implements CommandLineRunner {

	@Autowired
	private IVehiculoRentService iVehiculoRentService;
	
	@Autowired
	private IClienteRentService iClienteRentService;
	
	@Autowired
	private IRentaService iRentaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU3JeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		VehiculoRent miVehiculo = new VehiculoRent();
		miVehiculo.setPlaca("AAA");
		miVehiculo.setColor("Rojo");
		miVehiculo.setMarca("Mazda");
		miVehiculo.setPrecio(new BigDecimal(20255));
//		this.iVehiculoRentService.guardar(miVehiculo);
		
		VehiculoRent miVehiculo2 = new VehiculoRent();
		miVehiculo2.setPlaca("BBB");
		miVehiculo2.setColor("Morado");
		miVehiculo2.setMarca("Toyota");
		miVehiculo2.setPrecio(new BigDecimal(5525));
//		this.iVehiculoRentService.guardar(miVehiculo2);
		
		ClienteRent miCliente = new ClienteRent();
		miCliente.setNombre("Manolo");
		miCliente.setApellido("Manrique");
		miCliente.setCedula("12345678");
		miCliente.setFechaNacimiento(LocalDateTime.of(1990, 10, 6, 0, 0));
//		this.iClienteRentService.guardar(miCliente);
		
		this.iRentaService.ingresarRenta(miVehiculo2.getPlaca(), miCliente.getCedula());
		
		
	}

}
