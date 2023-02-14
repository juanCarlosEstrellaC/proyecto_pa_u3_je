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
		// FROM Hotel h INNER JOIN Habitacion ha
		// ON h.hote_id = ha.habi_id_hotel

		// se pone la relación q representa la relación (el nombre de la lista q esta en hotel, o sea habitaciones)
		// el inner join de JPQL ya no se pone lo del ON del SQL, porque ya está implícito en el @OneToMany de Hotel
		TypedQuery<Hotel> query = this.entityManager.createQuery(
				"SELECT h FROM Hotel h INNER JOIN h.habitaciones ha WHERE ha.tipo =: datoTipo", Hotel.class);
		query.setParameter("datoTipo", tipoHabitacion);
		
		// para traerlo bajo demanda:
		List<Hotel> listaHoteles = query.getResultList();
		
		for (Hotel hotel : listaHoteles) {
			hotel.getHabitaciones().size();   // XQ EL SIZe??????????????????????????
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
		
		// para traerlo bajo demanda:
		List<Hotel> listaHoteles = query.getResultList();
		
		for (Hotel hotel : listaHoteles) {
			List<Habitacion> listaTmp = new ArrayList<> ();
			for (Habitacion ha : hotel.getHabitaciones()) {
				if (ha.getTipo().equals(tipoHabitacion)) {
					listaTmp.add(ha);
				}
				hotel.setHabitaciones(listaTmp);
			}
			
//			if (condition) {
//				hotel.getHabitaciones().size();   // XQ EL SIZe??????????????????????????
//
//			} else {
//
//			}
		}
		
		return listaHoteles;
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
		return null;
	}

}
