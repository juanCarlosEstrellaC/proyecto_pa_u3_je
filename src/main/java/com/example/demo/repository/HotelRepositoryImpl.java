package com.example.demo.repository;

import java.util.ArrayList;
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
public class HotelRepositoryImpl implements IHotelRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// SQL:
		// SELECT *
		// FROM  Hotel h  INNER JOIN  Habitacion habi
		// ON  h.hote_id = habi.habi_id_hotel

		// **OJO**, en comparación con el SQL, para el JPQL en el INNER JOIN, no se pone la Clase Habitación, después del "INNER JOIN", 
		// ie, NO se pone:	
		// 					SELECT h FROM Hotel h INNER JOIN Habitacion habi
		// ya que se pone el nombre de la variable que representa la relación @OneToMany de la Clase Hotel, que sería la lista de habitaciones.
		// que es parte de el mismo hotel, por eso se lo llama con el "h.". Ie, Se pone:
		// 					SELECT h FROM Hotel h INNER JOIN h.habitaciones
		// 
		// Además, en la sentencia JPQL a diferencia del SQL, ya no se pone la parte del "ON", porque ya está implícita dicha relación en variable
		// que representa la relación @OneToMany de la Clase Hotel
		
		TypedQuery<Hotel> query = this.entityManager.createQuery("SELECT h FROM Hotel h INNER JOIN h.habitaciones ha WHERE ha.tipo =: datoTipo", Hotel.class);
		query.setParameter("datoTipo", tipoHabitacion);
		
		// para traerlo bajo demanda:
		List<Hotel> listaHoteles = query.getResultList();
		
		// ************************* CÓMO FUNCIONA EL SIZE PARA QUE NO ME DE ERROR LAZY????????????????????***************************
		for (Hotel hotel : listaHoteles) {
			// .size() es un artificio para decirle a Jakarta que voy a usar la lista. No propiamente me devuelve el número de elementos.
			// cualquier método que interaccione con todos los elementos de la lista, me funcionará.
			hotel.getHabitaciones().size();   // jakarta interpreta q se van a usar los elementos de la lista, no solo con el .size
		}
		
		return listaHoteles;
	}

	@Override
	public List<Hotel> buscarHotelOuterLeftJoin(String tipoHabitacion) {
		// SQL:
		// SELECT *
		// FROM Hotel h LEFT JOIN Habitacion ha
		// ON h.hote_id = ha.habi_id_hotel

		TypedQuery<Hotel> query = this.entityManager.createQuery(
				"SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha WHERE ha.tipo =: datoTipo", Hotel.class);
		query.setParameter("datoTipo", tipoHabitacion);
		

		
		return query.getResultList();
		
	}

	@Override
	public List<Hotel> buscarHotelOuterRightJoin(String tipoHabitacion) {
		// SQL:
		// SELECT *
		// FROM Hotel h LEFT JOIN Habitacion ha
		// ON h.hote_id = ha.habi_id_hotel

		TypedQuery<Hotel> query = this.entityManager.createQuery(
				"SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha WHERE ha.tipo =: datoTipo", Hotel.class);
		query.setParameter("datoTipo", tipoHabitacion);
		
		// para traerlo bajo demanda:
		List<Hotel> listaHoteles = query.getResultList();
		
//		for (Hotel hotel : listaHoteles) {
//			hotel.getHabitaciones().size();   // XQ EL SIZe??????????????????????????
//		}
		
//		return listaHoteles;
		return query.getResultList();
		}

	@Override
	public List<Hotel> buscarHotelOuterFullJoin(String tipoHabitacion) {
		return null;
	}

	@Override
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		TypedQuery<Hotel> query = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha WHERE ha.tipo =: datoTipo", Hotel.class);
		query.setParameter("datoTipo", tipoHabitacion);
		
		// para traerlo bajo demanda:
		return query.getResultList();	
		}

	
	// JOINS SIN PARÁMETROS
	@Override
	public List<Hotel> buscarHotelOuterLeftJoin() {
		TypedQuery<Hotel> query = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN  h.habitaciones ha", Hotel.class);
		List<Hotel> listaHoteles = query.getResultList();
//		for (Hotel hotel : listaHoteles) {
//			hotel.getHabitaciones().size();
//		}

		return listaHoteles;
	}

	@Override
	public List<Hotel> buscarHotelOuterRightJoin() {
		TypedQuery<Hotel> query = this.entityManager.createQuery("SELECT h FROM Hotel h RIGHT JOIN  h.habitaciones ha", Hotel.class);
		List<Hotel> listaHoteles = query.getResultList();
//		for (Hotel hotel : listaHoteles) {
//			hotel.getHabitaciones().size();
//		}

		return listaHoteles;
	}

	@Override
	public List<Hotel> buscarHotelOuterFullJoin() {
		return null;
	}

	
	
}

























