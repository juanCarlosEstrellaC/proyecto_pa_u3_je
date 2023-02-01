package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.ClienteRent;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ClienteRentRepositoryImpl implements IClienteRentRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(ClienteRent clienteRent) {
		this.entityManager.persist(clienteRent);
	}

	@Override
	public void actualizar(ClienteRent clienteRent) {
		this.entityManager.merge(clienteRent);
	}

	@Override
	public ClienteRent buscar(Integer id) {
		return this.entityManager.find(ClienteRent.class, id);
	}

	@Override
	public void borrar(Integer id) {
		ClienteRent c = this.buscar(id);
		this.entityManager.remove(c);
	}

}
