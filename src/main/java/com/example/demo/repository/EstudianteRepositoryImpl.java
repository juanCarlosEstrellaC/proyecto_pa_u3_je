	package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.dto.EstudianteDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void ingresar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
	}
	
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
	
	
	//----------------------------------------------------------------------------------------------------
	// Retornos con más de un elemento:
	// Obtener todos los estudiantes con el mismo nombre.
	// A diferencia del método "buscarPorNombreQuery", que devolvía un único elemento (usaba .getSingleResult()), este ejemplo utiliza el .getResultList() para obtener más de un solo elemento.
	// En este caso devolverá una Lista de elementos.
	@Override
	public List<Estudiante> buscarPorNombreQueryList(String nombre) {
		Query jpqlQuery = this.entityManager.createQuery("select e  from Estudiante e where e.nombre = :datoNombre");
		jpqlQuery.setParameter("datoNombre", nombre);
		return jpqlQuery.getResultList();
	}
	
	// Obtener el primer registro de todos los estudiantes con un mismo nombre.
	// A diferencia del método "buscarPorNombreQuery", que devolvía un único elemento (usaba .getSingleResult()), este ejemplo utiliza el .getResultList() para obtener más de un solo elemento.
	// En este caso devolverá una Lista de elementos, pero yo solo obtendré el primero de dicha lista para tener el primer registro.
	@Override
	public Estudiante buscarPorNombreQueryListFirst(String nombre) {
		Query jpqlQuery = this.entityManager.createQuery("select e  from Estudiante e where e.nombre = :datoNombre");
		jpqlQuery.setParameter("datoNombre", nombre);
		return (Estudiante) jpqlQuery.getResultList().get(0);  // getResultList() devuelve una lista de Estudiantes, con .get(0) obtengo el primer elemento de la lista, y eso devuelvo.
	}														   // Casteo porque sigo usando un Query que es genérico, y necesito especificarlo ahora.
	
	//----------------------------------------------------------------------------------------------------
	// DTO:
	@Override
	public EstudianteDTO buscarPorNombreTypedQueryDTO(String nombre) {
		TypedQuery<EstudianteDTO> myTypedQuery = this.entityManager.createQuery("select NEW com.example.demo.modelo.dto.EstudianteDTO(e.nombre, e.apellido, e.cedula)  from Estudiante e where e.nombre = :datoNombre", EstudianteDTO.class);
		myTypedQuery.setParameter("datoNombre", nombre);
		return myTypedQuery.getSingleResult();
	}
	
	//----------------------------------------------------------------------------------------------------
	// CRITERIA:
	@Override
	public Estudiante buscarPorNombreCriteria(String nombre) {
		// creamos la fabrica:
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		
		// declaro el tipo de retorno del SQL:
		CriteriaQuery<Estudiante> myQuery = myBuilder.createQuery(Estudiante.class);
		
		// comenzamos a crear el "SQL"
		// defino la tabla destino, ie, el FROM-Root:
		Root<Estudiante> miTablaFrom = myQuery.from(Estudiante.class); // La tabla será de tipo Estudiante. (FROM estudinte)
		
		// Las condiciones WHERE se conocen en Criteria API Query como predicados.
		// el segundo argumento es con el que tengo que comparar.
		Predicate condicion1 = myBuilder.equal(miTablaFrom.get("nombre"), nombre); // e.nombre = :datoNombre
		
		// Declaro mi Query
		myQuery.select(miTablaFrom).where(condicion1);
		// Declarado/Armado mi Query
		
		// La ejecución del query lo realizamos con cualquier tipo conocido. Recomendado TypedQuery
		TypedQuery<Estudiante> mySQL = this.entityManager.createQuery(myQuery);
		
		
		return mySQL.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorNombreCriteriaAndOr(String nombre, String apellido, String genero) {
		// creamos la fabrica:
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		
		// declaro el tipo de retorno del SQL:
		CriteriaQuery<Estudiante> myQuery = myBuilder.createQuery(Estudiante.class);
		
		// comenzamos a crear el "SQL"
		// defino la tabla destino, ie, el FROM-Root:
		Root<Estudiante> miTablaFrom = myQuery.from(Estudiante.class); // La tabla será de tipo Estudiante. (FROM estudinte)
		
		// Es dinámico xq el query cambiará dependiendo del parámetro que ingrese.
		// Masculino (M) : query es e.nombre = AND e.apellido =
		// Masculino (F) : query es e.nombre = OR e.apellido =
		
		// Predicado del nombre:
		Predicate p1 = myBuilder.equal(miTablaFrom.get("nombre"), nombre);
		// Predicado del apellido:
		Predicate p2 = myBuilder.equal(miTablaFrom.get("apellido"), apellido);
		
		Predicate predicadoFinal = null;
		if (genero.equals("M")) {
			// Predicado del AND:
			predicadoFinal = myBuilder.and(p1, p2);
		} else {
			// Predicado del OR:
			predicadoFinal = myBuilder.or(p1, p2);
		}

		// Declaro mi Query
		myQuery.select(miTablaFrom).where(predicadoFinal);
		
		// La ejecución del query lo realizamos con cualquier tipo conocido. Recomendado TypedQuery
		TypedQuery<Estudiante> mySQL = this.entityManager.createQuery(myQuery);
		
		return mySQL.getResultList();
	}

	//------------------------------------------------------------------------------------------
	// QUERYS de ELIMINAR Y ACTUALIZAR 
	// El entero que retorna es el número de elementos que se elimina o se actualiza.
	@Override
	public int eliminarPorApellido(String apellido) {
		//DELETE FROM estudiante WHERE estu_apellido = 'Teran'
		Query query = this.entityManager.createQuery("DELETE FROM Estudiante e WHERE e.apellido = :datoEntrada"); //Elimina a todos los estudiantes con apellido X
		query.setParameter("datoEntrada", apellido);
		return query.executeUpdate(); //es executeUpdate() así sea eliminar. Y me retorna un entero.
	}

	@Override
	public int actualizarPorApellido(String apellido, String nombre) {
		// UPDATE estudiante set estu_nombre = "Edison" WHERE estu_apellido = "Cayambe"
		Query query = this.entityManager.createQuery("UPDATE Estudiante e SET e.nombre =:datoNombre WHERE e.apellido = :datoApellido");
		query.setParameter("datoNombre", nombre);
		query.setParameter("datoApellido", apellido);
		return query.executeUpdate(); 
	}

	
	
	

}
	