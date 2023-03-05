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
	
	//CRUD simple:
	@Override
	public void ingresar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
	}
	
	@Override
	public void actualizar(Estudiante estudiante) {
		this.entityManager.merge(estudiante);
	}

	@Override
	public Estudiante buscar(Integer id) {
		return this.entityManager.find(Estudiante.class, id);
	}
	
	@Override
	public void borrar(Integer id) { 	// Borrar Simple: 2 pasos
		Estudiante e = buscar(id);
		this.entityManager.remove(e);
	}
	
	
	/** RESUMEN:
	 
	 	- BUSCAR:
	 	          fila/Atributos   tabla/Clase			condiciones
	 	           
		  SQL =  SELECT  *  FROM  estudiante    WHERE  estu_nombre = 'Juan' 
		  JPQL = SELECT  e  FROM  Estudiante e  WHERE  e.nombre = :datoNombre
	  
	  	- ACTUALIZAR:
	  					tabla/Clase          valorASetear                      condiciones
	  		
	  	  SQL =  UPDATE  estudiante    SET  estu_nombre = "Edison"  WHERE estu_apellido = "Cayambe"
	  	  JPQL = UPDATE  Estudiante e  SET  e.nombre =:datoNombre   WHERE e.apellido = :datoApellido
	  	   
	  	- BORRAR:
	  						 tabla/Clase              condiciones
	  	
	  	  SQL =  DELETE FROM  estudiante    WHERE  estu_nombre = "Edison"
 		  JPQL = DELETE FROM  Estudiante e  WHERE  e.apellido = :datoEntrada



	  1. Query: Mantenimiento
	  			Query query = this.entityManager.createQuery("JPQL");
	  			return (cast);
	  
	  2. Typed:
		  		TypedQuery<E> typedQuery = this.entityManager.createQuery("JPQL", E.class);
				return (sin cast);
				
	  3. Named: [Reutilización][c]  -> es un Query con alias[c]
	  			Query namedQuery = this.entityManager.createNamedQuery("ALIAS");
				
				En la clase:
  				@NamedQuery(name = "ALIAS", query = "JPQL")

				return (cast)
				
	  4. Native: Rendimiento
	  			Query nativeQuery = this.entityManager.createNativeQuery("SQL", E.class);
				return (cast)

	  5. DTO:
				public E_DTO nombreMetodo(Parametros) 
				TypedQuery<E_DTO> queryDto = this.entityManager.createQuery("JPQL + NEW", E_DTO.class);
				return (sin cast, xq uso typed);
				
	  6. CRITERIA F en el chat
	  
	  7. Actualizar y Borrar complejos:
	  	 Son métodos de retorno int, usan Querys con JPQL con un return query.executeUpdate().
	  
	 */
	
	// ********************************  Querys complejos, la mayoría de Buscar  ****************************************
	// 1. QUERY = mantenimiento; JPQL
	@Override
	public Estudiante buscarPorNombreQuery(String nombre) {
		Query query = this.entityManager.createQuery("SELECT e  FROM Estudiante e WHERE e.nombre = :datoNombre");
		query.setParameter("datoNombre", nombre);
		return (Estudiante)query.getSingleResult();  
	}													 

		
	// 2. TYPED: Es un Query, que devuelve un tipo de dato específico. No tiene beneficio; JPQL
	@Override
	public Estudiante buscarPorNombreTypedQuery(String nombre) {
		TypedQuery<Estudiante> typedQuery = this.entityManager.createQuery("SELECT e  FROM Estudiante e WHERE e.nombre = :datoNombre", Estudiante.class);
		typedQuery.setParameter("datoNombre", nombre);
		return typedQuery.getSingleResult();
	}

	// 3. NAMED: le doy un alias al query e implemento la anotación @NamedQuery(name = "alias", query = "select...") en la clase de la que se hace la consulta. Beneficio de nombre; JPQL.
	@Override
	public Estudiante buscarPorNombreNamedQuery(String nombre) {
		Query namedQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombre");
		namedQuery.setParameter("datoNombre", nombre);
		return (Estudiante)namedQuery.getSingleResult();
	}

	// 4. NATIVE: Consulta que usa SQL y no JPQL. Beneficio de Rendimiento y pierde Mantenimiento
	@Override
	public Estudiante buscarPorNombreNativeQuery(String nombre) {
		Query nativeQuery = this.entityManager.createNativeQuery("SELECT * FROM estudiante WHERE estu_nombre = :datoNombre", Estudiante.class);
		nativeQuery.setParameter("datoNombre", nombre); 
		return (Estudiante) nativeQuery.getSingleResult();
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
	
	
	// ************************************* Retornos con más de un elemento ************************************************

	/* 1.1 QUERY RETORNA LISTA:
	  Obtener todos los estudiantes con el mismo nombre.
	  A diferencia del método "buscarPorNombreQuery", que devolvía un único elemento (usaba .getSingleResult()), este ejemplo utiliza el .getResultList() para obtener más de un solo elemento.
	  En este caso devolverá una Lista de elementos.
	 */
	@Override
	public List<Estudiante> buscarPorNombreQueryList(String nombre) {
		Query query = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.nombre = :datoNombre");
		query.setParameter("datoNombre", nombre);
		return query.getResultList();
	}
	

	/* 1.1.1 QUERY RETORNA EL PRIMER ELEMENTO DE LA LISTA
	  Obtener el primer registro de todos los estudiantes con un mismo nombre.
	  A diferencia del método "buscarPorNombreQuery", que devolvía un único elemento (usaba .getSingleResult()), este ejemplo utiliza el .getResultList() para obtener más de un solo elemento.
	  En este caso devolverá una Lista de elementos, pero yo solo obtendré el primero de dicha lista para tener el primer registro.
	 */
	@Override
	public Estudiante buscarPorNombreQueryListFirst(String nombre) {
		Query jpqlQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.nombre = :datoNombre");
		jpqlQuery.setParameter("datoNombre", nombre);
		return (Estudiante) jpqlQuery.getResultList().get(0);  // getResultList() devuelve una lista de Estudiantes, con .get(0) obtengo el primer elemento de la lista, y eso devuelvo.
	}														   // Casteo porque sigo usando un Query que es genérico, y necesito especificarlo ahora.
	
	// ***********************************************************************************************************************

	/* 5. DTO: 
	 	  Voy a trabajarlo con Typed para aprenderme así.
	 	  Entonces, DTO es un Typed, ie, TypedQuery<EstudianteDTO>, createQuery, ("JPQL + NEW", E_DTO.class)
	 */
	@Override
	public EstudianteDTO buscarPorNombreTypedQueryDTO(String nombre) {
		TypedQuery<EstudianteDTO> queryDto = this.entityManager.createQuery("SELECT NEW com.example.demo.modelo.dto.EstudianteDTO(e.nombre, e.apellido, e.cedula) FROM Estudiante e WHERE e.nombre = :datoNombre", EstudianteDTO.class);
		queryDto.setParameter("datoNombre", nombre);
		return queryDto.getSingleResult();
	}
	
	// ***********************************************************************************************************************
	// 6. CRITERIA:
	@Override
	public Estudiante buscarPorNombreCriteria(String nombre) {
		// 1. creamos la fabrica:
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		
		// 2. declaro el tipo de retorno del SQL:
		CriteriaQuery<Estudiante> myQuery = myBuilder.createQuery(Estudiante.class);
		
		// comenzamos a crear el "SQL"
		// 3. defino la tabla destino, ie, el FROM-Root:
		Root<Estudiante> miTablaFrom = myQuery.from(Estudiante.class); // La tabla será de tipo Estudiante. (FROM estudinte)
		
		// 4. Las condiciones WHERE se conocen en Criteria API Query como predicados.
		// el segundo argumento es con el que tengo que comparar.
		Predicate condicion1 = myBuilder.equal(miTablaFrom.get("nombre"), nombre); // e.nombre = :datoNombre
																				   // El primer "nombre" viene del nombre del atributo de la Clase
		// 5. Declaro mi Query
		myQuery.select(miTablaFrom).where(condicion1);
		// Declarado/Armado mi Query
		
		// 6. La ejecución del query lo realizamos con cualquier tipo conocido. Recomendado TypedQuery
		TypedQuery<Estudiante> mySQL = this.entityManager.createQuery(myQuery);  //sin el parámetro de Estudiante.class. porque en el paso 2 especifico el tipo de dato de retorno
												
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

	// ************************************ QUERYS Complejos de ELIMINAR Y ACTUALIZAR ***************************************** 
	// El entero que retorna es el número de elementos que se elimina o se actualiza.
	
	@Override
	public int actualizarPorApellido(String apellido, String nombre) {
		// UPDATE estudiante set estu_nombre = "Edison" WHERE estu_apellido = "Cayambe"
		Query query = this.entityManager.createQuery("UPDATE Estudiante e SET e.nombre =:datoNombre WHERE e.apellido = :datoApellido");
		query.setParameter("datoNombre", nombre);
		query.setParameter("datoApellido", apellido);
		return query.executeUpdate(); 
	}




	@Override
	public int eliminarPorApellido(String apellido) {
		//DELETE FROM estudiante WHERE estu_apellido = 'Teran'
		Query query = this.entityManager.createQuery("DELETE FROM Estudiante e WHERE e.apellido = :datoEntrada"); //Elimina a todos los estudiantes con apellido X
		query.setParameter("datoEntrada", apellido);
		return query.executeUpdate(); //es executeUpdate() así sea eliminar. Y me retorna un entero.
	}
	
	
	

}
	