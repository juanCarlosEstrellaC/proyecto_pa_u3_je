package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HabitacionRepositoryImpl implements IHabitacionRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Habitacion> buscarHotelOuterLeftJoin() {
		TypedQuery<Habitacion> query = this.entityManager.createQuery("SELECT ha FROM Hotel h LEFT JOIN  h.habitaciones ha", Habitacion.class);
		List<Habitacion> listaHoteles = query.getResultList();
//		for (Hotel hotel : listaHoteles) {
//			hotel.getHabitaciones().size();
//		}

		return listaHoteles;
	}

	@Override
	public List<Habitacion> buscarHotelOuterRightJoin() {
		TypedQuery<Habitacion> query = this.entityManager.createQuery("SELECT ha FROM Hotel h RIGHT JOIN  h.habitaciones ha", Habitacion.class);
		return query.getResultList();	
	}

	@Override
	public List<Habitacion> buscarHotelOuterFullJoin() {
		return null;
	}

}
