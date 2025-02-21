
import java.util.List;

public class MetodosPlayer {

	/**
	 * Obtiene un listadio de personas completa si ahy un error lanza un escepcion
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<EntidadPlayer> mostrarTodosLosJuegadores() throws Exception {
		List<EntidadPlayer> obj;
		try {
			ServiceDB.abrir();
			String hql = "FROM EntidadPlayer";
			obj = ServiceDB.sesion.createQuery(hql, EntidadPlayer.class).getResultList();
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			ServiceDB.cerrar();
		}
		return obj;
	}

	/**
	 * Abre una instancia a hace una llamda retornando la persona si la encuetra si
	 * no lanza una excepcion
	 * 
	 * @param class1
	 * @param id
	 * @return
	 * @throws Exception
	 */
	static public EntidadPlayer obtenerPorId(Class<EntidadPlayer> class1, int id) throws Exception {
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
	public static void EliminarPorId(Class<EntidadPlayer> class1, int id) throws Exception {
		try {
			ServiceDB.abrir();
			EntidadPlayer entidad = ServiceDB.sesion.get(class1, id);
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
	 * Acuializa una persona por id primero hace el get de la entidad y por ultimo
	 * setea las pupiedades devuelve una exapxion en caso de que algo falle
	 * 
	 * @param class1
	 * @param id
	 * @param nuevaPersona
	 * @return
	 * @throws Exception
	 */
	public static EntidadPlayer ActulizarPorId(Class<EntidadPlayer> class1, int id, EntidadPlayer x) throws Exception {
		try {
			ServiceDB.abrir();
			EntidadPlayer entidad = ServiceDB.sesion.get(class1, id);
			if (entidad != null) {
				entidad.setNick(x.getNick());
				entidad.setEmail(x.getEmail());
				entidad.setPassword(x.getPassword());
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
	public static EntidadPlayer ActulizarPorIdPropiedadPassword(Class<EntidadPlayer> class1, int id, EntidadPlayer x)
			throws Exception {
		try {
			ServiceDB.abrir();
			EntidadPlayer entidad = ServiceDB.sesion.get(class1, id);
			if (entidad != null) {
				entidad.setPassword(x.getPassword());
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
	 * Elimina personas con el nombre dado nombre Nombre de las personas a eliminar.
	 * 
	 * @param
	 * @throws
	 */
	public static void eliminarPorPassword(String password) throws Exception {
		try {
			ServiceDB.abrir();
			String hql = "DELETE FROM EntidadPlayer WHERE password = :password";
			int eliminados = ServiceDB.sesion.createQuery(hql).setParameter("password", password).executeUpdate();
			System.out.println(eliminados + " EntidadPlayer eliminadas con el password: " + password);
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
	public static List<EntidadPlayer> obtenerPorPassword(String password) throws Exception {
		List<EntidadPlayer> personas;
		try {
			ServiceDB.abrir();
			String hql = "FROM EntidadPlayer WHERE password LIKE :password";
			personas = ServiceDB.sesion.createQuery(hql, EntidadPlayer.class)
					.setParameter("password", "%" + password + "%").getResultList();
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			ServiceDB.cerrar();
		}
		return personas;
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
	public static EntidadPlayer ActulizarPorIdPropiedadEmail(Class<EntidadPlayer> class1, int id, EntidadPlayer x)
			throws Exception {
		try {
			ServiceDB.abrir();
			EntidadPlayer entidad = ServiceDB.sesion.get(class1, id);
			if (entidad != null) {
				entidad.setEmail(x.getEmail());
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
	 * Elimina personas con el nombre dado nombre Nombre de las personas a eliminar.
	 * 
	 * @param
	 * @throws
	 */
	public static void eliminarPorEmail(String email) throws Exception {
		try {
			ServiceDB.abrir();
			String hql = "DELETE FROM EntidadPlayer WHERE email = :email";
			int eliminados = ServiceDB.sesion.createQuery(hql).setParameter("email", email).executeUpdate();
			System.out.println(eliminados + " EntidadPlayer eliminadas con el email: " + email);
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
	public static List<EntidadPlayer> obtenerPorEmail(String email) throws Exception {
		List<EntidadPlayer> personas;
		try {
			ServiceDB.abrir();
			String hql = "FROM EntidadPlayer WHERE email LIKE :email";
			personas = ServiceDB.sesion.createQuery(hql, EntidadPlayer.class).setParameter("email", "%" + email + "%")
					.getResultList();
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			ServiceDB.cerrar();
		}
		return personas;
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
	public static EntidadPlayer ActulizarPorIdPropiedadNick(Class<EntidadPlayer> class1, int id, EntidadPlayer x)
			throws Exception {
		try {
			ServiceDB.abrir();
			EntidadPlayer entidad = ServiceDB.sesion.get(class1, id);
			if (entidad != null) {
				entidad.setNick(x.getNick());
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
	 * Elimina personas con el nombre dado nombre Nombre de las personas a eliminar.
	 * 
	 * @param
	 * @throws
	 */
	public static void eliminarPorNick(String nick) throws Exception {
		try {
			ServiceDB.abrir();
			String hql = "DELETE FROM EntidadPlayer WHERE nick = :nick";
			int eliminados = ServiceDB.sesion.createQuery(hql).setParameter("nick", nick).executeUpdate();
			System.out.println(eliminados + " EntidadPlayer eliminadas con el nick: " + nick);
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
	public static List<EntidadPlayer> obtenerPorNick(String nick) throws Exception {
		List<EntidadPlayer> personas;
		try {
			ServiceDB.abrir();
			String hql = "FROM EntidadPlayer WHERE nick LIKE :nick";
			personas = ServiceDB.sesion.createQuery(hql, EntidadPlayer.class).setParameter("nick", "%" + nick + "%")
					.getResultList();
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			ServiceDB.cerrar();
		}
		return personas;
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
			String hql = "DELETE FROM EntidadPlayer";
			int eliminados = ServiceDB.sesion.createQuery(hql).executeUpdate();
			System.out.println(eliminados + " registros eliminados de la tabla EntidadPlayer");

		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			ServiceDB.cerrar();
		}
	}

}
