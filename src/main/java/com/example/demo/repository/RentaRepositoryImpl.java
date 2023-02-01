package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Renta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RentaRepositoryImpl implements IRentaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Renta renta) {
		this.entityManager.persist(renta);
	}

	@Override
	public void actualizar(Renta renta) {
		this.entityManager.merge(renta);
	}

	@Override
	public Renta buscar(Integer id) {
		return this.entityManager.find(Renta.class, id);
	}

	@Override
	public void borrar(Integer id) {
		Renta r = this.buscar(id);
		this.entityManager.remove(r);
	}

}
