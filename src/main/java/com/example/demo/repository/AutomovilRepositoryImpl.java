package com.example.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Automovil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AutomovilRepositoryImpl implements IAutomovilRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void ingresar(Automovil automovil) {
		this.entityManager.persist(automovil);
	}

	@Override
	public Automovil buscarPorPlacaTyped(String placa) {
		TypedQuery<Automovil> jpqlQuery = this.entityManager.createQuery("select a from Automovil a where a.placa = :datoPlaca", Automovil.class);
		jpqlQuery.setParameter("datoPlaca", placa);
		return jpqlQuery.getSingleResult();
	}

	@Override
	public Automovil buscarPorColorTyped(String color) {
		TypedQuery<Automovil> jpqlQuery = this.entityManager.createQuery("SELECT a FROM Automovil a WHERE a.color = :datoColor", Automovil.class);
		jpqlQuery.setParameter("datoColor", color);
		return jpqlQuery.getSingleResult();
	}

	@Override
	public Automovil buscarPorMarcaTyped(String marca) {
		TypedQuery<Automovil> jpqlQuery = this.entityManager.createQuery("SELECT a FROM Automovil a WHERE a.marca = :datoMarca", Automovil.class);
		jpqlQuery.setParameter("datoMarca", marca);
		return jpqlQuery.getSingleResult();
	}



	@Override
	public Automovil buscarPorPlacaNamed(String placa) {
		Query jpqlQuery = this.entityManager.createNamedQuery("Automovil.buscarPorPlacaNamed");
		jpqlQuery.setParameter("datoPlaca", placa);
		return (Automovil) jpqlQuery.getSingleResult();
	}

	@Override
	public Automovil buscarPorColorNamed(String color) {
		Query jpqlQuery = this.entityManager.createNamedQuery("Automovil.buscarPorColorNamed");
		jpqlQuery.setParameter("datoColor", color);
		return (Automovil) jpqlQuery.getSingleResult();
	}

	@Override
	public Automovil buscarPorMarcaNamed(String marca) {
		Query jpqlQuery = this.entityManager.createNamedQuery("Automovil.buscarPorMarcaNamed");
		jpqlQuery.setParameter("datoMarca", marca);
		return (Automovil) jpqlQuery.getSingleResult();
	}

	
	
	
	@Override
	public Automovil buscarPorMarcaNative(String marca) {
		Query jpqlQuery = this.entityManager.createNativeQuery("select * from automovil where auto_marca = :datoMarca", Automovil.class);
		jpqlQuery.setParameter("datoMarca", marca);
		return (Automovil) jpqlQuery.getSingleResult();
	}

	@Override
	public Automovil buscarPorPrecioNative(BigDecimal precio) {
		Query jpqlQuery = this.entityManager.createNativeQuery("select * from automovil where auto_precio = :datoPrecio", Automovil.class);
		jpqlQuery.setParameter("datoPrecio", precio);
		return (Automovil) jpqlQuery.getSingleResult();
	}

	@Override
	public List<Automovil> buscarPorDescuentoNative(BigDecimal descuento) {
		Query jpqlQuery = this.entityManager.createNativeQuery("select * from automovil where auto_descuento = :datoDescuento", Automovil.class);
		jpqlQuery.setParameter("datoDescuento", descuento);
		return jpqlQuery.getResultList();
	}

	
	
	
	@Override
	public Automovil buscarPorPlacaNamedNative(String placa) {
		Query jpqlQuery = this.entityManager.createNamedQuery("Automovil.buscarPorPlacaNamedNative");
		jpqlQuery.setParameter("datoPlaca", placa);
		return (Automovil) jpqlQuery.getSingleResult();
	}




	@Override
	public Automovil buscarPorColorNamedNative(String color) {
		Query jpqlQuery = this.entityManager.createNamedQuery("Automovil.buscarPorColorNamedNative");
		jpqlQuery.setParameter("datoColor", color);
		return (Automovil) jpqlQuery.getSingleResult();
	}
	

	@Override
	public Automovil buscarPorPrecioNamedNative(BigDecimal precio) {
		Query jpqlQuery = this.entityManager.createNamedQuery("Automovil.buscarPorPrecioNamedNative");
		jpqlQuery.setParameter("datoPrecio", precio);
		return (Automovil) jpqlQuery.getSingleResult();
	}

	
	






	
	
}
