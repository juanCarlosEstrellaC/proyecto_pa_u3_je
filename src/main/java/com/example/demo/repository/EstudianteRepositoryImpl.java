package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Estudiante buscarPorNombreQuery(String nombre) {
		// select * from estudiante where estu_nombre = 'Juan'
		// select e  from Estudiante e where e.nombre = :datoNombre  // con e, e es el Estudiante, se trae todo el objeto
																	 // :datoNombre es un dato que me van a pasar, con las ":"
		Query jpqlQuery = this.entityManager.createQuery("select e  from Estudiante e where e.nombre = :datoNombre");
		jpqlQuery.setParameter("datoNombre", nombre);
		return (Estudiante)jpqlQuery.getSingleResult();  // jpqlQuery.getSingleResult(); devuelve objetos genéricos, por eso uso el cast.
	}

	@Override
	public Estudiante buscarPorApellidoQuery(String apellido) {
		return null;
	}

}
