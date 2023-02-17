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
	// Dado los elementos de mi DB, por el JPQL, de cajón en la lista de Habitaciones tendré una habitación null.
	public List<Habitacion> buscarHabitacionOuterLeftJoin() {
		TypedQuery<Habitacion> query = this.entityManager.createQuery("SELECT ha FROM Hotel h LEFT JOIN   h.habitaciones ha", Habitacion.class);
//		return query.getResultList();
		List<Habitacion> listaHoteles = query.getResultList(); 
		for (Habitacion hotel : listaHoteles) {
			
			hotel.getHotel();
			
		}
		return listaHoteles;
	}

	@Override
	public List<Habitacion> buscarHabitacionOuterRightJoin() {
		// El JPQL es un HOtel RIGHT JOIN Habitaciones, ie, que me devuelve TODAS las habitaciones (en este caso xq no hay un WHERE que le de una
		// condición) con columnas de hotel null, cuando no empareje.
		TypedQuery<Habitacion> query = this.entityManager.createQuery("SELECT ha FROM Hotel h RIGHT JOIN  h.habitaciones ha", Habitacion.class);
		return query.getResultList();	
	}

	@Override
	public List<Habitacion> buscarHabitacionOuterFullJoin() {
		return null;
	}

}
