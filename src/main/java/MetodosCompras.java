
import java.util.List;

public class MetodosCompras {

	/**
	 * Abre una instancia a hace una llamda retornando la persona si la encuetra si
	 * no lanza una excepcion
	 * 
	 * @param class1
	 * @param id
	 * @return
	 * @throws Exception
	 */
	static public EntidadCompras obtenerPorId(Class<EntidadCompras> class1, int id) throws Exception {
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
	public static void EliminarPorId(Class<EntidadCompras> class1, int id) throws Exception {
		try {
			ServiceDB.abrir();
			EntidadCompras entidad = ServiceDB.sesion.get(class1, id);
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
	public static void eliminarPorCosa(String cosa) throws Exception {
		try {
			ServiceDB.abrir();
			String hql = "DELETE FROM EntidadCompras WHERE cosa = :cosa";
			int eliminados = ServiceDB.sesion.createQuery(hql).setParameter("cosa", cosa).executeUpdate();
			System.out.println(eliminados + " Games eliminadas con el cosa: " + cosa);
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
	public static void eliminarPorTiempoPrecio(int precio, int precioLimite) throws Exception {
		try {
			ServiceDB.abrir();
			String hql = "DELETE FROM EntidadCompras WHERE precio > :precio AND precio < :precioLimite";
			int eliminados = ServiceDB.sesion.createQuery(hql).setParameter("precio", precio)
					.setParameter("precioLimite", precioLimite).executeUpdate();
			System.out.println(eliminados + " EnddiadCompras eliminadas con tiempo Jugado menor a: " + precio);
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
	public static EntidadCompras ActulizarPorId(Class<EntidadCompras> class1, int id, EntidadCompras x)
			throws Exception {
		try {
			ServiceDB.abrir();
			EntidadCompras entidad = ServiceDB.sesion.get(class1, id);
			if (entidad != null) {
				entidad.setCosa(x.getCosa());
				entidad.setPrecio(x.getPrecio());
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
	public static EntidadCompras ActualizarPorIdPropiedadPrecio(Class<EntidadCompras> class1, int id, EntidadCompras x)
			throws Exception {
		try {
			ServiceDB.abrir();
			EntidadCompras entidad = ServiceDB.sesion.get(class1, id);
			if (entidad != null) {
				entidad.setPrecio(x.getPrecio());
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
	public static EntidadCompras ActualizarPorIdPropiedadCosa(Class<EntidadCompras> class1, int id, EntidadCompras x)
			throws Exception {
		try {
			ServiceDB.abrir();
			EntidadCompras entidad = ServiceDB.sesion.get(class1, id);
			if (entidad != null) {
				entidad.setCosa(x.getCosa());
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
	public static List<EntidadCompras> obtenerPorCosa(String cosa) throws Exception {
		List<EntidadCompras> personas;
		try {
			ServiceDB.abrir();
			String hql = "FROM EntidadCompras WHERE cosa LIKE :cosa";
			personas = ServiceDB.sesion.createQuery(hql, EntidadCompras.class).setParameter("cosa", "%" + cosa + "%")
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
	public static List<EntidadCompras> obtenerPorPrecio(int precio, int precioLimite) throws Exception {
		List<EntidadCompras> obj;
		try {
			ServiceDB.abrir();
			String hql = "FROM EntidadCompras WHERE  precio > :precio AND precio < :precioLimite";

			obj = ServiceDB.sesion.createQuery(hql, EntidadCompras.class).setParameter("precio", precio)
					.setParameter("precioLimite", precioLimite).getResultList();
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
	public static List<EntidadCompras> mostrarTodosLasCompras() throws Exception {
		List<EntidadCompras> obj;
		try {
			ServiceDB.abrir();
			String hql = "FROM EntidadCompras";
			obj = ServiceDB.sesion.createQuery(hql, EntidadCompras.class).getResultList();
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
	public static void eliminarTablaCompras() throws Exception {
		try {
			ServiceDB.abrir();
			String hql = "DROP TABLE EntidadGames";
			ServiceDB.sesion.createQuery(hql, EntidadGames.class);
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			ServiceDB.cerrar();
		}
	}

}
