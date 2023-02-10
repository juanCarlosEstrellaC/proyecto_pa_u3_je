package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Automovil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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

	
	
}
