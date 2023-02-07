package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	//QUERY
	@Override
	public Estudiante buscarPorNombreQuery(String nombre) {
		// select * from estudiante where estu_nombre = 'Juan'
		// select e  from Estudiante e where e.nombre = :datoNombre  // con e, e es el Estudiante, se trae todo el objeto
																	 // :datoNombre es un dato que me van a pasar, con las ":"
		Query jpqlQuery = this.entityManager.createQuery("select e  from Estudiante e where e.nombre = :datoNombre");
		jpqlQuery.setParameter("datoNombre", nombre);
		return (Estudiante)jpqlQuery.getSingleResult();  // jpqlQuery.getSingleResult(); devuelve objetos genéricos, por eso uso el cast.
	}													 // además devuelve solo un resultado.
	@Override
	public Estudiante buscarPorApellidoQuery(String apellido) {
		Query jpqlQuery = this.entityManager.createQuery("select e from Estudiante e where e.apellido = :datoApellido");
		jpqlQuery.setParameter("datoApellido", apellido);
		
		return (Estudiante)jpqlQuery.getSingleResult();
	}
	@Override
	public Estudiante buscarPorGeneroQuery(String genero) {
		Query jpqlQuery = this.entityManager.createQuery("select e from Estudiante e where e.genero = :datoGenero");
		jpqlQuery.setParameter("datoGenero", genero);
		return (Estudiante) jpqlQuery.getSingleResult();
	}
	@Override
	public Estudiante buscarPorCedulaQuery(String cedula) {
		Query jpqlQuery = this.entityManager.createQuery("select e from Estudiante e where e.cedula = :datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);
		return (Estudiante) jpqlQuery.getSingleResult();
	}
	@Override
	public Estudiante buscarPorCiudadQuery(String ciudad) {
		Query jpqlQuery = this.entityManager.createQuery("select e from Estudiante e where e.ciudad = :datoCiudad");
		jpqlQuery.setParameter("datoCiudad", ciudad);
		return (Estudiante) jpqlQuery.getSingleResult();
	}
		
	// TYPED: Es un Query, pero usando la interface TypedQuery<nombre del tipo de clase específico>. Como devuelve un tipo de dato específico, al final no hace falta el cast.
	@Override
	public Estudiante buscarPorNombreTypedQuery(String nombre) {
		TypedQuery<Estudiante> myTypedQuery = this.entityManager.createQuery("select e  from Estudiante e where e.nombre = :datoNombre", Estudiante.class);
		myTypedQuery.setParameter("datoNombre", nombre);
		return myTypedQuery.getSingleResult();
	}

	// NAMED: le doy un alias al query e implemento la anotación @NamedQuery(name = "alias", query = "select...") en la clase de la que se hace la consulta.
	@Override
	public Estudiante buscarPorNombreNamedQuery(String nombre) {
		Query miQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombre");
		miQuery.setParameter("datoNombre", nombre);
		return (Estudiante)miQuery.getSingleResult();
	}

	// NATIVE: Consulta que usa SQL y no JPQL.
	@Override
	public Estudiante buscarPorNombreNativeQuery(String nombre) {
		Query miQuery = this.entityManager.createNativeQuery("select * from estudiante where estu_nombre = :datoNombre", Estudiante.class);
		miQuery.setParameter("datoNombre", nombre); 
		return (Estudiante) miQuery.getSingleResult();
	}
	
	// MIXES:
	// Consulta con alias (named), que devuelve un tipo de dato específico (typed).
	@Override
	public Estudiante buscarPorNombreNamedQueryTyped(String nombre) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombre", Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getSingleResult();
	}

	// Consulta que usa un alias (named), devuelve un tipo específico de dato (typed), y usa SQL en vez de JPQL (native).
	@Override
	public Estudiante buscarPorNombreNamedNativeQueryTyped(String nombre) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombreNative", Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		return (Estudiante) myQuery.getSingleResult();
	}


}
	