
import java.util.List;

public class MetodosGames {

	/**
	 * Abre una instancia a hace una llamda retornando la persona si la encuetra si
	 * no lanza una excepcion
	 * 
	 * @param class1
	 * @param id
	 * @return
	 * @throws Exception
	 */
	static public EntidadGames obtenerPorId(Class<EntidadGames> class1, int id) throws Exception {
		try {
			ServiceDB.abrir();
			return ServiceDB.sesion.get(class1, id);
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			ServiceDB.cerrar();
		}
	}

	/**
	 * Elimina una persona por id primero hace el GET por id y uktimamente la
	 * elimina si hay un error lanza una excepsion
	 * 
	 * @param class1
	 * @param id
	 * @throws Exception
	 */
	public static void EliminarPorId(Class<EntidadGames> class1, int id) throws Exception {
		try {
			ServiceDB.abrir();
			EntidadGames entidad = ServiceDB.sesion.get(class1, id);
			if (entidad != null) {
				ServiceDB.sesion.delete(entidad);
			}
		} catch (Exception e) {
			throw new Exception(e);

		} finally {
			ServiceDB.cerrar();
		}
	}

	/**
	 * Elimina personas con el nombre dado nombre Nombre de las personas a eliminar.
	 * 
	 * @param
	 * @throws
	 */
	public static void eliminarPorNombre(String nombre) throws Exception {
		try {
			ServiceDB.abrir();
			String hql = "DELETE FROM EntidadGames WHERE nombre = :nombre";
			int eliminados = ServiceDB.sesion.createQuery(hql).setParameter("nombre", nombre).executeUpdate();
			System.out.println(eliminados + " Games eliminadas con el nombre: " + nombre);
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			ServiceDB.cerrar();
		}
	}

	/**
	 * Elimina personas con un saldo menor al valor dado saldo Valor de tiempoJugado
	 * como límite inferior.
	 * 
	 * @param tiempoJugadoLimite
	 * 
	 * @param
	 * @throws
	 */
	public static void eliminarPorTiempoJugador(int tiempoJugado, int tiempoJugadoLimite) throws Exception {
		try {
			ServiceDB.abrir();
			String hql = "DELETE FROM EntidadGames WHERE tiempoJugado > :tiempoJugado AND tiempoJugado < :tiempoJugadoLimite";
			int eliminados = ServiceDB.sesion.createQuery(hql).setParameter("tiempoJugado", tiempoJugado)
					.setParameter("tiempoJugadoLimite", tiempoJugadoLimite).executeUpdate();
			System.out.println(eliminados + " Games eliminadas con tiempo Jugado menor a: " + tiempoJugado);
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			ServiceDB.cerrar();
		}
	}

	/**
	 * Acuializa una persona por id primero hace el get de la entidad y por ultimo
	 * setea las pupiedades devuelve una exapxion en caso de que algo falle
	 * 
	 * @param class1
	 * @param id
	 * @param nuevaPersona
	 * @return
	 * @throws Exception
	 */
	public static EntidadGames ActulizarPorId(Class<EntidadGames> class1, int id, EntidadGames nuevaPersona)
			throws Exception {
		try {
			ServiceDB.abrir();
			EntidadGames entidad = ServiceDB.sesion.get(class1, id);
			if (entidad != null) {
				entidad.setNombre(nuevaPersona.getNombre());
				entidad.setTiempoJugado(nuevaPersona.getTiempoJugado());
				ServiceDB.sesion.update(entidad);
			}
			return entidad;
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			ServiceDB.cerrar();
		}
	}

	/**
	 * Acuializa una persona por id primero hace el get de la entidad y por ultimo
	 * setea la pupiedad tiempoJugado devuelve una exapxion en caso de que algo
	 * falle
	 * 
	 * @param class1
	 * @param id
	 * @param nuevaPersona
	 * @return
	 * @throws Exception
	 */
	public static EntidadGames ActualizarPorIdPropiedad1(Class<EntidadGames> class1, int id, EntidadGames nuevaPersona)
			throws Exception {
		try {
			ServiceDB.abrir();
			EntidadGames entidad = ServiceDB.sesion.get(class1, id);
			if (entidad != null) {
				entidad.setTiempoJugado(nuevaPersona.getTiempoJugado());
				ServiceDB.sesion.update(entidad);
			}
			return entidad;
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			ServiceDB.cerrar();
		}
	}

	/***
	 * Acuializa una persona por id primero hace el get de la entidad y por ultimo
	 * setea la pupiedad Nombre devuelve una exapxion en caso de que algo falle
	 * 
	 * @param class1
	 * @param id
	 * @param nuevaPersona
	 * @return
	 * @throws Exception
	 */
	public static EntidadGames ActualizarPorIdPropiedad2(Class<EntidadGames> class1, int id, EntidadGames nuevaPersona)
			throws Exception {
		try {
			ServiceDB.abrir();
			EntidadGames entidad = ServiceDB.sesion.get(class1, id);
			if (entidad != null) {
				entidad.setNombre(nuevaPersona.getNombre());
				ServiceDB.sesion.update(entidad);
			}
			return entidad;
		} catch (Exception e) {
			throw new Exception(e);

		} finally {
			ServiceDB.cerrar();
		}
	}

	/**
	 * Select por nombre recibe el nombre como parametro para la consulta SQL y
	 * devuelve un listado si hay un error lanza una excepcion
	 * 
	 * @param nombre
	 * @return
	 * @throws Exception
	 */
	public static List<EntidadGames> obtenerPorNombre(String nombre) throws Exception {
		List<EntidadGames> personas;
		try {
			ServiceDB.abrir();
			String hql = "FROM EntidadGames WHERE nombre LIKE :nombre";
			personas = ServiceDB.sesion.createQuery(hql, EntidadGames.class).setParameter("nombre", "%" + nombre + "%")
					.getResultList();
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			ServiceDB.cerrar();
		}
		return personas;
	}

	/**
	 * Optiene las personas con un saldo mayor al saldo dado usa por consulta SQL si
	 * hay un error se lanza una excepcion
	 * 
	 * @param tiempoJugado
	 * @return
	 * @throws Exception
	 */
	public static List<EntidadGames> obtenerPorTiempoJugado(int tiempoJugado, int tiempoJugadoLimite) throws Exception {
		List<EntidadGames> obj;
		try {
			ServiceDB.abrir();
			String hql = "FROM EntidadGames WHERE  tiempoJugado > :tiempoJugado AND tiempoJugado < :tiempoJugadoLimite";

			obj = ServiceDB.sesion.createQuery(hql, EntidadGames.class).setParameter("tiempoJugado", tiempoJugado)
					.setParameter("tiempoJugadoLimite", tiempoJugadoLimite).getResultList();
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			ServiceDB.cerrar();
		}
		return obj;
	}

	/**
	 * Obtiene un listadio de personas completa si ahy un error lanza un escepcion
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<EntidadGames> mostrarTodosLosJuegos() throws Exception {
		List<EntidadGames> obj;
		try {
			ServiceDB.abrir();
			String hql = "FROM EntidadGames";
			obj = ServiceDB.sesion.createQuery(hql, EntidadGames.class).getResultList();
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			ServiceDB.cerrar();
		}
		return obj;
	}

	/**
	 * Obtiene un listadio de personas completa si ahy un error lanza un escepcion
	 * 
	 * @return
	 * @throws Exception
	 */
	public static void eliminarTabla() throws Exception {
		try {
			ServiceDB.abrir();
			String hql = "DELETE FROM EntidadGames";
			int eliminados = ServiceDB.sesion.createQuery(hql).executeUpdate();
			System.out.println(eliminados + " registros eliminados de la tabla EntidadGames");

		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			ServiceDB.cerrar();
		}
	}

}
