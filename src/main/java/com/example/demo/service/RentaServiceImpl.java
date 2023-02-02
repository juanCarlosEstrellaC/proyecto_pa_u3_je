package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.ClienteRent;
import com.example.demo.modelo.Renta;
import com.example.demo.modelo.VehiculoRent;
import com.example.demo.repository.IClienteRentRepository;
import com.example.demo.repository.IRentaRepository;
import com.example.demo.repository.IVehiculoRentRepository;

@Service
public class RentaServiceImpl implements IRentaService {

	@Autowired
	private IRentaRepository iRentaRepository;
	
	@Autowired
	private IVehiculoRentRepository iVehiculoRentRepository;
	
	@Autowired
	private IClienteRentRepository iClienteRentRepository;
	
	@Override
	public void ingresarRenta(String placa, String cedula) {
		
		VehiculoRent vehi = this.iVehiculoRentRepository.buscarPlacaQuery(placa);
		ClienteRent client = this.iClienteRentRepository.buscarCedulaQuery(cedula);
		System.out.println(vehi.getColor());
		System.out.println(client.getApellido());
		
		Renta miRenta = new Renta();
		miRenta.setFecha(LocalDateTime.now());
		miRenta.setNumeroDias(new BigDecimal(7));
		miRenta.setValorPago(new BigDecimal(2.5));
		miRenta.setMiclienteRent(client);
		miRenta.setMiVehiculoRent(vehi);
		
		this.iRentaRepository.insertar(miRenta);
		
		
		
		
	}


	@Override
	public void guardar(Renta renta) {
		this.iRentaRepository.insertar(renta);
	}

	@Override
	public void actualizar(Renta renta) {
		this.iRentaRepository.actualizar(renta);
	}

	@Override
	public Renta encontrar(Integer id) {
		return this.iRentaRepository.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		this.iRentaRepository.borrar(id);
	}




}
