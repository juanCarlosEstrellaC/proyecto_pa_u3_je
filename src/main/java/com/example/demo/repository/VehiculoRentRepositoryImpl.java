package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.VehiculoRent;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VehiculoRentRepositoryImpl implements IVehiculoRentRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(VehiculoRent vehiculoRent) {
		this.entityManager.persist(vehiculoRent);
	}

	@Override
	public void actualizar(VehiculoRent vehiculoRent) {
		this.entityManager.merge(vehiculoRent);
	}

	@Override
	public VehiculoRent buscar(Integer id) {
		return this.entityManager.find(VehiculoRent.class, id);
	}

	@Override
	public void borrar(Integer id) {
		VehiculoRent v = this.buscar(id);
		this.entityManager.remove(v);
	}

}
