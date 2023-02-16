package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

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

	
	/** INNER JOIN:
		 SQL:
		 
			 SELECT *
			 FROM  Hotel h  INNER JOIN  Habitacion habi
			 ON  h.hote_id = habi.habi_id_hotel

		 JPQL:
		 
			 **OJO**, en comparación con el SQL, para el JPQL en el INNER JOIN, no se pone la Clase Habitación, después del "INNER JOIN", 
			 ie, N O se pone:	
			 					SELECT h FROM Hotel h INNER JOIN Habitacion habi
			 					
			 Ya que se pone el nombre de la variable que representa la relación @OneToMany de la Clase Hotel, que sería la lista de habitaciones.
			 que es parte de el mismo hotel, por eso se lo llama con el "h.". Ie, Se pone:
			 					
			 					SELECT h FROM Hotel h INNER JOIN h.habitaciones
			 
			 Además, en la sentencia JPQL a diferencia del SQL, ya no se pone la parte del "ON", porque ya está implícita dicha relación en variable
			 que representa la relación @OneToMany de la Clase Hotel, o sea, la lista llamada "habitaciones".
	 */
	/** TRAER BAJO DEMANDA:
	 
	 	Pasos Resumen:
		 1. Clase padre = Hotel: fetch = FetchType.LAZY
		 2. En el la clase Repositorio para el padre, se implementa manualmente el método, con el artificio del .size() o .toString()
		 3. Para imprimir sin causar un bucle, en Clase hija = Habitación: debe tener su .toString() sin el objeto de la relación de la clase padre, ie, sin hotel.

		
	 	En este ejemplo, se vuelve a ver la problemática de usar el "FetchType.LAZY" en los parámetros de la anotación de la relación de las 
	 	entidades de la DB, en este caso, en la clase "padre" Hotel:
	 	
	 		@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
			private List<Habitacion> habitaciones;
			
		Al usar este método "buscarHotelInnerJoin", yo puedo obtener todos los hoteles que tengan un tipo de habitación determinado pasado como parámetro.
		La problemática surge cuando tengo que acceder a todo el objeto hotel que tiene la lista de hoteles que me retorna el método. Ojo, si puedo acceder
		a un atributo en particular, como el nombre o tipo, usando el método get.
		Por lo general este problema se presenta cuando quiero IMPRIMIR el objeto.
		Si en el main llamo a este método, atrapo la lista de hoteles y recorro esa lista queriendo imprimir todo el objeto hotel o, peor, la
		lista de habitaciones que está dentro de cada hotel, me dará error de inicialización peresoza "failed to lazily initialize".
		
			List<Hotel> listaHotel1 = this.iHotelService.buscarHotelInnerJoin("VIP");
			for (Hotel hotel : listaHotel1) {
				System.out.println(hotel);
			}
			
		Para resolver este problema, puedo optar por 2 métodos(que no son parte de las consultas con JPQL), y uno que es propio para corregir este 
		error usando un tipo de consulta JPQL:
		1. Usando  "FetchType.EAGER" en los parámetros de la anotación de la relación de las entidades de la DB, en este caso:
	 	
	 		@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.EAGER) 
			private List<Habitacion> habitaciones;
			
		   Se soluciona rápidamente, pero se trae todo el objeto. Se supone que no es lo mejor.
		   
		2. Traer el objeto bajo demanda. 
		   En los casos que necesite traer el objeto que me devuelva un método, y este me de el mismo error, debo variar la implementación del método
		   en el Repository(siempre ahi).
		   
		   Para ello, si el método me devuelve:
		   - 1 objeto, por ejemplo un solo Hotel: 
		     atrapo al objeto que retorna en una variable, y uso esa variable con el método .toString() {esto lo probé yo, y sí funcionó. No se había hecho antes en clase}. 
		   	 Se puede observar en el ejemplo del método "metodoDePrueba".
		   	 
		   - Una lista de Objetos, por ejemplo, una lista de Hoteles: atrapo esa lista en una variable, y en un for each, uso el método .size()
		     Se puede observar en el ejemplo del método "buscarHotelInnerJoin".

		   Propiamente no se ejecutará el método toString() o el size(), devolviendo una impresión y un tamaño de lista, solo servirá para decirle a Jakarta
		   que se usará el objeto o los elementos de la lista de objetos; es un artificio para evitar el error.
		   
		   Para ambos casos, el toString o el size funcionan como artificio porque dichos métodos interactúan con los objetos como tal.
		   Además, en el caso del objeto Hotel, si quiero acceder a la lista de habitaciones, debo usar un método que interactúe con los elementos de esa lista (.size(), o si 
		   Hotel tiene un toString donde imprima también a dicha lista, también valdría).
		   
		   En resumidas cuentas:
		   Si quiero imprimir un objeto de la clase A, implemento el toString() a la clase A, y en el método del Repository que quiera ocupar lo uso.
		   Se puede observar en el ejemplo del método "metodoDePrueba".

		   Si dicho objeto tiene una lista como atributo, tengo 2 opciones:
		   	 a. Que el toString() ya implementado imprima los elementos de dicha lista (ie, interactue con los elementos de la lista), o
		   	 b. Uso el método .size() en un for each al mencionar a dicha lista.
		   Se puede observar en el ejemplo del método "buscarHotelInnerJoin".

		  
		3. Usando el JPQL JoinFetch.
		   Ver ejemplo buscarHotelJoinFetch.
		   
	 */
	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		TypedQuery<Hotel> query = this.entityManager.createQuery("SELECT h FROM Hotel h INNER JOIN h.habitaciones ha WHERE ha.tipo =: datoTipo", Hotel.class);
		query.setParameter("datoTipo", tipoHabitacion);
		
		// Traer bajo demanda la lista de Hoteles:
		List<Hotel> listaHoteles = query.getResultList();
		for (Hotel hotel : listaHoteles) {
			// a. Puedo usar el toString();
			hotel.toString();
			
			// b. Puedo usar el size():
			hotel.getHabitaciones().size();   
		}
		return listaHoteles;
	}
	
		// Metodo de Prueba para ejemplificar el Traer bajo demanda:
		@Override
		public Hotel metodoDePrueba() {
			String a = "Marriot";
			TypedQuery<Hotel> query = this.entityManager.createQuery("SELECT h  FROM Hotel h WHERE h.nombre = :datoQuemado", Hotel.class);
			query.setParameter("datoQuemado", a);
			
			// Traer bajo demanda al Objeto Hotel:
			Hotel myHotel = query.getSingleResult();
			myHotel.toString();
			return myHotel;
		}
		
		// Metodo de Prueba para ejemplificar que el método me devuelva un String y no solo un Hotel, cambiando el JPQL y el método.
		@Override
		public String metodoRetornaNombreYNoUnObjeto() {
		String a = "Marriot";
		TypedQuery<String> query = this.entityManager.createQuery("SELECT h.nombre  FROM Hotel h WHERE h.nombre = :datote", String.class); // Importante decir de qué tipo será el retorno.
		query.setParameter("datote", a);
		return query.getSingleResult();
	}
	
		
	// Soluciono con un Join Fetch la inicialización perezosa
	@Override
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		TypedQuery<Hotel> query = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha WHERE ha.tipo =: datoTipo", Hotel.class);
		query.setParameter("datoTipo", tipoHabitacion);
		return query.getResultList();	
	}
	
	
	/** Para left, right y full, es lo mismo, solo cambia el left, right y full xD 
	 SQL:
		 SELECT *
		 FROM Hotel h LEFT JOIN Habitacion ha
		 ON h.hote_id = ha.habi_id_hotel
	 

	 */
	@Override
	public List<Hotel> buscarHotelOuterLeftJoin(String tipoHabitacion) {
		TypedQuery<Hotel> query = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN  h.habitaciones ha WHERE ha.tipo =: datoTipo", Hotel.class);
		query.setParameter("datoTipo", tipoHabitacion);
		return query.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterRightJoin(String tipoHabitacion) {
		TypedQuery<Hotel> query = this.entityManager.createQuery("SELECT h FROM Hotel h RIGHT JOIN FETCH h.habitaciones ha WHERE ha.tipo =: datoTipo", Hotel.class);
		query.setParameter("datoTipo", tipoHabitacion);
		return query.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterFullJoin(String tipoHabitacion) {
		return null;
	}


	//------------------------------------------------------------------------------------------------------------
	// JOINS SIN PARÁMETROS
	@Override
	public List<Hotel> buscarHotelOuterLeftJoin() {
		TypedQuery<Hotel> query = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN  h.habitaciones ha", Hotel.class);
		List<Hotel> listaHoteles = query.getResultList();
		// Para traerlo bajo demanda
		for (Hotel hotel : listaHoteles) {
			hotel.getHabitaciones().size();
		}

		return listaHoteles;
	}

	@Override
	public List<Hotel> buscarHotelOuterRightJoin() {
		TypedQuery<Hotel> query = this.entityManager.createQuery("SELECT h FROM  Hotel h  RIGHT JOIN  h.habitaciones ha", Hotel.class);
		List<Hotel> listaHoteles = query.getResultList();
		// Para traerlo bajo demanda
		for (Hotel hotel : listaHoteles) {
			hotel.getHabitaciones().size();
		}
		return listaHoteles;
	}

	@Override
	public List<Hotel> buscarHotelOuterFullJoin() {
		return null;
	}

	



	
	
}

























