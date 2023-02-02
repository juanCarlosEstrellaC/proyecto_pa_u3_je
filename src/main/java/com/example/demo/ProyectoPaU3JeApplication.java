package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.ClienteRent;
import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.Renta;
import com.example.demo.modelo.VehiculoRent;
import com.example.demo.repository.IClienteRentRepository;
import com.example.demo.service.IClienteRentService;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IRentaService;
import com.example.demo.service.IVehiculoRentService;

@SpringBootApplication
public class ProyectoPaU3JeApplication implements CommandLineRunner {
	
	@Autowired
	private IClienteRentService iClienteRentService;
	
	@Autowired
	private IRentaService iRentaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU3JeApplication.class, args);
	}

	
	/** NOTA:
	 1. Creo, para cada inserción, un objeto de vehículo y cliente nuevo, no reciclo el objeto 
        cambiando los valores e ingresando de nuevo.
        Aunque, cabe recalcar que, si seteo al mismo objeto, cuando lo mande a guardar será uno nuevo, por 
	    lo que se pordría reciclar el objeto anterior. En este caso, puede tener los mismos datos, excepto la 
	    cédula, y la placa, respectivamente, puesto que ese parámetro se usa en la búsqueda por cédula y placa, 
	 	  y el query retorna solo un elemento, por lo que no puede estar duplicado.
     2. Cada vehículo y cada cliente tiene su propia lista de Rentas, la creo y la seteo para c/u aquí.
     3. Una vez insertados los vehículos y clientes, realizo las rentas. Claro, que podría crear un nuevo 
        vehículo o cliente e insertarlo, pero así es más ordenado.
	 4. No usé cascada en los padres.
	 */
	@Override
	public void run(String... args) throws Exception {

	// Vehiculos:
		
		VehiculoRent miVehiculo1 = new VehiculoRent();
		miVehiculo1.setPlaca("AAA");
		miVehiculo1.setColor("Rojo");
		miVehiculo1.setMarca("Mazda");
		miVehiculo1.setPrecio(new BigDecimal(20255));
		List<Renta> listaRentasVehiculo1= new ArrayList<Renta>();
		miVehiculo1.setMisRentas(listaRentasVehiculo1);

//		this.iVehiculoRentService.guardar(miVehiculo1);
		
		VehiculoRent miVehiculo2 = new VehiculoRent();
		miVehiculo2.setPlaca("BBB");
		miVehiculo2.setColor("Morado");
		miVehiculo2.setMarca("Toyota");
		miVehiculo2.setPrecio(new BigDecimal(5525));
		List<Renta> listaRentasVehiculo2= new ArrayList<Renta>();
		miVehiculo2.setMisRentas(listaRentasVehiculo2);

//		this.iVehiculoRentService.guardar(miVehiculo2);
	
		
	// Clientes:
		
		ClienteRent miCliente1 = new ClienteRent();
		miCliente1.setNombre("Roberto");
		miCliente1.setApellido("Cedeño");
		miCliente1.setCedula("555");
		miCliente1.setFechaNacimiento(LocalDateTime.of(1990, 10, 6, 0, 0));
		List<Renta> listaRentasCliente1= new ArrayList<Renta>();
		miCliente1.setMiListaRentas(listaRentasCliente1);
		
//		this.iClienteRentService.guardar(miCliente1);
		
		ClienteRent miCliente2 = new ClienteRent();
		miCliente2.setNombre("Josseline");
		miCliente2.setApellido("Ponce");
		miCliente2.setCedula("95123654");
		miCliente2.setFechaNacimiento(LocalDateTime.of(2000, 10, 6, 0, 0));
		List<Renta> listaRentasCliente2= new ArrayList<Renta>();
		miCliente2.setMiListaRentas(listaRentasCliente2);
		
//		this.iClienteRentService.guardar(miCliente2);
	
	//Realizar Renta: 
		
		this.iRentaService.ingresarRenta(miVehiculo2.getPlaca(), miCliente1.getCedula());
		
		// Imprimo algunos datos de la renta de un cliente:
		ClienteRent clientebuscado = this.iClienteRentService.buscarCedulaQuery(miCliente1.getCedula());
		System.out.println("-------------------------------------------------------");
		for (Renta renta  : clientebuscado.getMiListaRentas()) {
			System.out.println(renta.getFecha());
			System.out.println(renta.getValorPago());
		}
		System.out.println("-------------------------------------------------------");

		
	}

}
