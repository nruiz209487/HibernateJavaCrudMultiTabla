
import java.util.List;
import java.util.Scanner;

public class MainPlayer {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		int opcion;
		do {
			menuPlayer();
			opcion = sc.nextInt();
			sc.nextLine();
			switch (opcion) {
			case 0:
				System.err.println("Ha salido del programa.");
				break;
			case 1:
				nuevoJugador();
				break;
			case 2:
				sleccionarJugador();
				break;
			case 3:
				mostrarTodosLosJugadores();
				break;
			case 4:
				seleccionarJuegadoresPorNick();
				break;
			case 5:
				seleccionarJugadoresPorContasenya();
				break;
			case 6:
				seleccionarJuegadoresPorEmail();
				break;
			case 7:
				actualizarJugador();
				break;
			case 8:
				actualizarPorNickJugador();
				break;
			case 9:
				actualizarPorContasenyaJugador();
				break;
			case 10:
				actualizarPorEmailJugador();
				break;
			case 11:
				eliminarJugador();
				break;
			case 13:
				eliminarJugadorPorNick();
				break;
			case 14:
				eliminarJugadorPorContrasenya();
				break;
			case 15:
				eliminarJugadorPorEmail();
				break;
			case 16:
				MetodosGames.eliminarTabla();
				break;
			default:
				System.err.println("Opción no válida.");
				break;
			}
		} while (opcion != 0);
		sc.close();
	}

	private static void menuPlayer() {
		System.out.println("Elija una opción:");
		System.out.println("1. Nuevo Jugador");
		System.out.println("2. Seleccionar Jugador");
		System.out.println("3. Mostrar Todos los Jugadores");
		System.out.println("4. Buscar Jugadores por Nick");
		System.out.println("5. Buscar Jugadores por Contraseña");
		System.out.println("6. Buscar Jugadores por Email");
		System.out.println("7. Actualizar Jugador");
		System.out.println("8. Actualizar Nick");
		System.out.println("9. Actualizar Contraseña");
		System.out.println("10. Actualizar Email");
		System.out.println("11. Eliminar Jugador");
		System.out.println("13. Eliminar Por Nick");
		System.out.println("14. Eliminar Por Contraseña");
		System.out.println("15. Eliminar Por Email");
		System.out.println("16. Eliminar Tabla");
		System.out.println("0. Salir");
	}

	private static void actualizarJugador() {
		EntidadPlayer obj;
		EntidadPlayer objActualizada;
		String nick;
		String email;
		String contrasenya;
		int id;
		System.out.println("Introduce el ID del Player a actualizar:");
		id = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese el nuevo nombre del Player:");
		nick = sc.nextLine();
		System.out.println("Ingrese el nuevo email del Player:");
		email = sc.nextLine();
		System.out.println("Ingrese el nuevo contrasenya del Player:");
		contrasenya = sc.nextLine();
		obj = new EntidadPlayer(nick, contrasenya, email);
		try {
			objActualizada = MetodosPlayer.ActulizarPorId(EntidadPlayer.class, id, obj);
			if (objActualizada != null) {
				System.out.println("Player actualizado con éxito:");
				System.out.println(objActualizada);
			} else {
				System.err.println("No se encontró ningún Player con el ID proporcionado.");
			}
		} catch (Exception e) {
			System.err.println("Error al actualizar el Player.");
		}
	}

	private static void actualizarPorNickJugador() {
		EntidadPlayer obj;
		EntidadPlayer objActualizada;
		String nombre;
		int id;
		System.out.println("Introduce el ID del Player a actualizar:");
		id = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese el nuevo nick del Player:");
		nombre = sc.nextLine();
		obj = new EntidadPlayer(nombre, "", "");
		try {
			objActualizada = MetodosPlayer.ActulizarPorIdPropiedadNick(EntidadPlayer.class, id, obj);
			if (objActualizada != null) {
				System.out.println("Player actualizado con éxito:");
				System.out.println(objActualizada);
			} else {
				System.err.println("No se encontró ningún Player con el ID proporcionado.");
			}
		} catch (Exception e) {
			System.err.println("Error al actualizar el Player.");
		}
	}

	private static void actualizarPorContasenyaJugador() {
		EntidadPlayer obj;
		EntidadPlayer objActualizada;
		String contasenaya;
		int id;
		System.out.println("Introduce el ID del Player a actualizar:");
		id = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese el nuevo contrasenya del Player:");
		contasenaya = sc.nextLine();
		obj = new EntidadPlayer("", contasenaya, "");
		try {
			objActualizada = MetodosPlayer.ActulizarPorIdPropiedadPassword(EntidadPlayer.class, id, obj);
			if (objActualizada != null) {
				System.out.println("Player actualizado con éxito:");
				System.out.println(objActualizada);
			} else {
				System.err.println("No se encontró ningún Player con el ID proporcionado.");
			}
		} catch (Exception e) {
			System.err.println("Error al actualizar el Player.");
		}
	}

	private static void actualizarPorEmailJugador() {
		EntidadPlayer obj;
		EntidadPlayer objActualizada;
		String email;
		int id;
		System.out.println("Introduce el ID del Player a actualizar:");
		id = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese el nuevo email del Player:");
		email = sc.nextLine();
		obj = new EntidadPlayer("", "", email);
		try {
			objActualizada = MetodosPlayer.ActulizarPorIdPropiedadEmail(EntidadPlayer.class, id, obj);
			if (objActualizada != null) {
				System.out.println("Player actualizado con éxito:");
				System.out.println(objActualizada);
			} else {
				System.err.println("No se encontró ningún Player con el ID proporcionado.");
			}
		} catch (Exception e) {
			System.err.println("Error al actualizar el Player.");
		}
	}

	private static void eliminarJugador() {
		int id;
		System.out.println("Introduce el ID del Player a eliminar:");
		id = sc.nextInt();
		sc.nextLine();
		try {
			MetodosPlayer.EliminarPorId(EntidadPlayer.class, id);
			System.out.println("Player eliminado con éxito.");
		} catch (Exception e) {
			System.err.println("Error al eliminar el Player.");
		}
	}

	private static void eliminarJugadorPorNick() {
		String nick;
		System.out.println("Introduce el nombre del Player a eliminar:");
		nick = sc.nextLine();
		try {
			MetodosPlayer.eliminarPorNick(nick);
			System.out.println("Player eliminado con éxito.");
		} catch (Exception e) {
			System.err.println("Error al eliminar el Player.");
		}
	}

	private static void eliminarJugadorPorContrasenya() {
		String contrasenya;
		System.out.println("Introduce la contrasenya del juego a eliminar:");
		contrasenya = sc.nextLine();
		try {
			MetodosPlayer.eliminarPorPassword(contrasenya);
			System.out.println("Player eliminado con éxito.");
		} catch (Exception e) {
			System.err.println("Error al eliminar el Player.");
		}
	}

	private static void eliminarJugadorPorEmail() {
		String email;
		System.out.println("Introduce el email del Player a eliminar:");
		email = sc.nextLine();
		try {
			MetodosPlayer.eliminarPorEmail(email);
			System.out.println("Player eliminado con éxito.");
		} catch (Exception e) {
			System.err.println("Error al eliminar el juego.");
		}
	}

	private static void sleccionarJugador() {
		EntidadPlayer obj;
		int id;
		System.out.println("Introduce el ID del Player a buscar:");
		id = sc.nextInt();
		sc.nextLine();
		try {
			obj = MetodosPlayer.obtenerPorId(EntidadPlayer.class, id);
			if (obj != null) {
				System.out.println("Player encontrado:");
				System.out.println(obj);
			} else {
				System.out.println("No se encontró ningún Player con el ID proporcionado.");
			}
		} catch (Exception e) {
			System.err.println("Error al buscar el Player.");
		}
	}

	private static void mostrarTodosLosJugadores() {
		try {
			List<EntidadPlayer> obj = MetodosPlayer.mostrarTodosLosJuegadores();
			if (obj.isEmpty()) {
				System.out.println("No hay Player registrados.");
			} else {
				System.out.println("Listado de Player:");
				for (EntidadPlayer c : obj) {
					System.out.println(c);
				}
			}
		} catch (Exception e) {
			System.err.println("Error al mostrar los Player.");
		}
	}

	private static void seleccionarJuegadoresPorNick() {
		String nick;
		List<EntidadPlayer> obj;
		System.out.println("Introduce el nombre del Player a buscar:");
		nick = sc.nextLine();
		try {
			obj = MetodosPlayer.obtenerPorNick(nick);
			if (obj.isEmpty()) {
				System.out.println("No se encontraron Player con el nombre proporcionado.");
			} else {
				System.out.println("Player encontrados:");
				for (EntidadPlayer c : obj) {
					System.out.println(c);
				}
			}
		} catch (Exception e) {
			System.err.println("Error al buscar juegos por nombre.");
		}
	}

	private static void seleccionarJugadoresPorContasenya() {
		String contasenya;
		List<EntidadPlayer> obj;
		System.out.println("Introduce la contasenya del Player a buscar:");
		contasenya = sc.nextLine();
		try {
			obj = MetodosPlayer.obtenerPorPassword(contasenya);
			if (obj.isEmpty()) {
				System.out.println("No se encontraron Player con el contasenya proporcionado.");
			} else {
				System.out.println("Player encontrados:");
				for (EntidadPlayer c : obj) {
					System.out.println(c);
				}
			}
		} catch (Exception e) {
			System.err.println("Error al buscar juegos por nombre.");
		}
	}

	private static void seleccionarJuegadoresPorEmail() {
		String email;
		List<EntidadPlayer> obj;
		System.out.println("Introduce el nombre del Player a buscar:");
		email = sc.nextLine();
		try {
			obj = MetodosPlayer.obtenerPorEmail(email);
			if (obj.isEmpty()) {
				System.out.println("No se encontraron Player con el nombre proporcionado.");
			} else {
				System.out.println("Player encontrados:");
				for (EntidadPlayer c : obj) {
					System.out.println(c);
				}
			}
		} catch (Exception e) {
			System.err.println("Error al buscar Player por email.");
		}
	}

	private static void nuevoJugador() {
		String nick;
		String email;
		String contrasenya;
		EntidadPlayer nuevoJugador;
		System.out.println("Ingrese el nombre del nuevo Player:");
		nick = sc.nextLine();
		System.out.println("Ingrese el email del nuevo Player:");
		email = sc.nextLine();
		System.out.println("Ingrese el contrasenya del nuevo Player:");
		contrasenya = sc.nextLine();

		nuevoJugador = new EntidadPlayer(nick, contrasenya, email);
		try {
			guardar(nuevoJugador);
		} catch (Exception e) {
			System.err.println("Error al guardar el Player.");
		}
	}

	private static void guardar(Object cosa) {
		try {
			ServiceDB.abrir();
			int id = (int) ServiceDB.guardar(cosa);
			System.out.println("Player guardado con ID: " + id);
		} catch (Exception e) {
			System.err.println("Error al guardar el Player: " + e.getMessage());
		} finally {
			ServiceDB.cerrar();
		}
	}
}