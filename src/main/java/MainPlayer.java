
import java.util.List;
import java.util.Scanner;

public class MainPlayer {

	private static Scanner sc = Main.sc;

	public static void main(String[] args) {
		int opcion;
		do {
			mostrarMenu();
			opcion = Main.pedirInt();
			switch (opcion) {
			case 0:
				System.err.println("Ha salido del programa.");
				break;
			case 1:
				nuevoJugador();
				break;
			case 2:
				seleccionarJugador();
				break;
			case 3:
				mostrarTodosLosJugadores();
				break;
			case 4:
				seleccionarJugadoresPorNick();
				break;
			case 5:
				seleccionarJugadoresPorContrasenya();
				break;
			case 6:
				seleccionarJugadoresPorEmail();
				break;
			case 7:
				actualizarJugador();
				break;
			case 8:
				actualizarPorNickJugador();
				break;
			case 9:
				actualizarPorContrasenyaJugador();
				break;
			case 10:
				actualizarPorEmailJugador();
				break;
			case 11:
				eliminarJugador();
				break;
			case 12:
				eliminarJugadorPorNick();
				break;
			case 13:
				eliminarJugadorPorContrasenya();
				break;
			case 14:
				eliminarJugadorPorEmail();
				break;
			case 15:
				try {
					MetodosPlayer.eliminarTabla();
				} catch (Exception e) {
					System.err.println("Error al eliminar la tabla.");
				}
				break;
			default:
				System.err.println("Opción no válida.");
				break;
			}
		} while (opcion != 0);

	}

	public static void mostrarMenu() {
		System.out.println(Colores.GREEN + Colores.BOLD + "===== MENÚ DE JUGADORES =====" + Colores.BLUE);
		System.out.println(Colores.WHITE + "1. Nuevo Jugador");
		System.out.println("2. Seleccionar Jugador");
		System.out.println("3. Mostrar Todos los Jugadores");
		System.out.println("4. Buscar Jugador por Nick");
		System.out.println("5. Buscar Jugador por Contraseña");
		System.out.println("6. Buscar Jugador por Email");
		System.out.println("7. Actualizar Jugador");
		System.out.println("8. Actualizar Nick");
		System.out.println("9. Actualizar Contraseña");
		System.out.println("10. Actualizar Email");
		System.out.println("11. Eliminar Jugador");
		System.out.println("12. Eliminar por Nick");
		System.out.println("13. Eliminar por Contraseña");
		System.out.println("14. Eliminar por Email");
		System.out.println("15. Eliminar Tabla");
		System.out.println(Colores.RED + "0. Salir" + Colores.BLUE);
		System.out.println(Colores.GREEN + "=============================" + Colores.BLUE);
	}

	private static void actualizarJugador() {
		EntidadPlayer obj;
		EntidadPlayer objActualizada;
		String nick;
		String email;
		String contrasenya;
		int id;

		System.out.println("\n=== Actualizar Jugador ===");
		System.out.print("Introduce el ID del Jugador a actualizar: ");
		id = Main.pedirInt();

		System.out.print("Ingrese el nuevo nombre del Jugador: ");
		nick = sc.nextLine();

		System.out.print("Ingrese el nuevo email del Jugador: ");
		email = sc.nextLine();

		System.out.print("Ingrese la nueva contraseña del Jugador: ");
		contrasenya = sc.nextLine();

		obj = new EntidadPlayer(nick, contrasenya, email);
		try {
			objActualizada = MetodosPlayer.ActulizarPorId(EntidadPlayer.class, id, obj);
			if (objActualizada != null) {
				System.out.println("\n¡Jugador actualizado con éxito!");
				System.out.println("Detalles del Jugador actualizado:");
				System.out.println(objActualizada);
			} else {
				System.err.println("\nError: No se encontró ningún Jugador con el ID proporcionado.");
			}
		} catch (Exception e) {
			System.err.println("\nError: No se pudo actualizar el Jugador.");
		}
	}

	private static void actualizarPorNickJugador() {
		EntidadPlayer obj;
		EntidadPlayer objActualizada;
		String nombre;
		int id;

		System.out.println("\n=== Actualizar Jugador por Nick ===");
		System.out.print("Introduce el ID del Jugador a actualizar: ");
		id = Main.pedirInt();
		System.out.print("Ingrese el nuevo nick del Jugador: ");
		nombre = sc.nextLine();

		obj = new EntidadPlayer(nombre, "", "");
		try {
			objActualizada = MetodosPlayer.ActulizarPorIdPropiedadNick(EntidadPlayer.class, id, obj);
			if (objActualizada != null) {
				System.out.println("\n¡Jugador actualizado con éxito!");
				System.out.println("Detalles del Jugador actualizado:");
				System.out.println(objActualizada);
			} else {
				System.err.println("\nError: No se encontró ningún Jugador con el ID proporcionado.");
			}
		} catch (Exception e) {
			System.err.println("\nError: No se pudo actualizar el Jugador.");
		}
	}

	private static void actualizarPorContrasenyaJugador() {
		EntidadPlayer obj;
		EntidadPlayer objActualizada;
		String contrasenya;
		int id;

		System.out.println("\n=== Actualizar Jugador por Contraseña ===");
		System.out.print("Introduce el ID del Jugador a actualizar: ");
		id = Main.pedirInt();

		System.out.print("Ingrese la nueva contraseña del Jugador: ");
		contrasenya = sc.nextLine();

		obj = new EntidadPlayer("", contrasenya, "");
		try {
			objActualizada = MetodosPlayer.ActulizarPorIdPropiedadPassword(EntidadPlayer.class, id, obj);
			if (objActualizada != null) {
				System.out.println("\n¡Jugador actualizado con éxito!");
				System.out.println("Detalles del Jugador actualizado:");
				System.out.println(objActualizada);
			} else {
				System.err.println("\nError: No se encontró ningún Jugador con el ID proporcionado.");
			}
		} catch (Exception e) {
			System.err.println("\nError: No se pudo actualizar el Jugador.");
		}
	}

	private static void actualizarPorEmailJugador() {
		EntidadPlayer obj;
		EntidadPlayer objActualizada;
		String email;
		int id;

		System.out.println("\n=== Actualizar Jugador por Email ===");
		System.out.print("Introduce el ID del Jugador a actualizar: ");
		id = Main.pedirInt();

		System.out.print("Ingrese el nuevo email del Jugador: ");
		email = sc.nextLine();

		obj = new EntidadPlayer("", "", email);
		try {
			objActualizada = MetodosPlayer.ActulizarPorIdPropiedadEmail(EntidadPlayer.class, id, obj);
			if (objActualizada != null) {
				System.out.println("\n¡Jugador actualizado con éxito!");
				System.out.println("Detalles del Jugador actualizado:");
				System.out.println(objActualizada);
			} else {
				System.err.println("\nError: No se encontró ningún Jugador con el ID proporcionado.");
			}
		} catch (Exception e) {
			System.err.println("\nError: No se pudo actualizar el Jugador.");
		}
	}

	private static void eliminarJugador() {
		int id;

		System.out.println("\n=== Eliminar Jugador ===");
		System.out.print("Introduce el ID del Jugador a eliminar: ");
		id = Main.pedirInt();
		try {
			MetodosPlayer.EliminarPorId(EntidadPlayer.class, id);
			System.out.println("\n¡Jugador eliminado con éxito!");
		} catch (Exception e) {
			System.err.println("\nError: No se pudo eliminar el Jugador. ");
		}
	}

	private static void eliminarJugadorPorNick() {
		String nick;

		System.out.println("\n=== Eliminar Jugador por Nick ===");
		System.out.print("Introduce el nombre del Jugador a eliminar: ");
		nick = sc.nextLine();

		try {
			MetodosPlayer.eliminarPorNick(nick);
			System.out.println("\n¡Jugador eliminado con éxito!");
		} catch (Exception e) {
			System.err.println("\nError: No se pudo eliminar el Jugador.");
		}
	}

	private static void eliminarJugadorPorContrasenya() {
		String contrasenya;

		System.out.println("\n=== Eliminar Jugador por Contraseña ===");
		System.out.print("Introduce la contraseña del Jugador a eliminar: ");
		contrasenya = sc.nextLine();

		try {
			MetodosPlayer.eliminarPorPassword(contrasenya);
			System.out.println("\n¡Jugador eliminado con éxito!");
		} catch (Exception e) {
			System.err.println("\nError: No se pudo eliminar el Jugador. ");
		}
	}

	private static void eliminarJugadorPorEmail() {
		String email;

		System.out.println("\n=== Eliminar Jugador por Email ===");
		System.out.print("Introduce el email del Jugador a eliminar: ");
		email = sc.nextLine();

		try {
			MetodosPlayer.eliminarPorEmail(email);
			System.out.println("\n¡Jugador eliminado con éxito!");
		} catch (Exception e) {
			System.err.println("\nError: No se pudo eliminar el Jugador. ");
		}
	}

	private static void seleccionarJugador() {
		EntidadPlayer obj;
		int id;

		System.out.println("\n=== Buscar Jugador por ID ===");
		System.out.print("Introduce el ID del Jugador a buscar: ");
		id = Main.pedirInt();

		try {
			obj = MetodosPlayer.obtenerPorId(EntidadPlayer.class, id);
			if (obj != null) {
				System.out.println("\n¡Jugador encontrado!");
				System.out.println("Detalles del Jugador:");
				System.out.println(obj);
			} else {
				System.out.println("\nNo se encontró ningún Jugador con el ID proporcionado.");
			}
		} catch (Exception e) {
			System.err.println("\nError: No se pudo buscar el Jugador. ");
		}
	}

	public static void mostrarTodosLosJugadores() {
		try {
			List<EntidadPlayer> obj = MetodosPlayer.mostrarTodosLosJuegadores();
			if (obj.isEmpty()) {
				System.out.println("\nNo hay Jugadores registrados.");
			} else {
				System.out.println("\n=== Listado de Jugadores ===");
				for (EntidadPlayer c : obj) {
					System.out.println(c);
				}
			}
		} catch (Exception e) {
			System.err.println("\nError: No se pudieron mostrar los Jugadores. ");
		}
	}

	private static void seleccionarJugadoresPorNick() {
		String nick;
		List<EntidadPlayer> obj;

		System.out.println("\n=== Buscar Jugadores por Nick ===");
		System.out.print("Introduce el nombre del Jugador a buscar: ");
		nick = sc.nextLine();

		try {
			obj = MetodosPlayer.obtenerPorNick(nick);
			if (obj.isEmpty()) {
				System.out.println("\nNo se encontraron Jugadores con el nombre proporcionado.");
			} else {
				System.out.println("\n¡Jugadores encontrados!");
				for (EntidadPlayer c : obj) {
					System.out.println(c);
				}
			}
		} catch (Exception e) {
			System.err.println("\nError: No se pudieron buscar los Jugadores. ");
		}
	}

	private static void seleccionarJugadoresPorContrasenya() {
		String contrasenya;
		List<EntidadPlayer> obj;

		System.out.println("\n=== Buscar Jugadores por Contraseña ===");
		System.out.print("Introduce la contraseña del Jugador a buscar: ");
		contrasenya = sc.nextLine();

		try {
			obj = MetodosPlayer.obtenerPorPassword(contrasenya);
			if (obj.isEmpty()) {
				System.out.println("\nNo se encontraron Jugadores con la contraseña proporcionada.");
			} else {
				System.out.println("\n¡Jugadores encontrados!");
				for (EntidadPlayer c : obj) {
					System.out.println(c);
				}
			}
		} catch (Exception e) {
			System.err.println("\nError: No se pudieron buscar los Jugadores. ");
		}
	}

	private static void seleccionarJugadoresPorEmail() {
		String email;
		List<EntidadPlayer> obj;

		System.out.println("\n=== Buscar Jugadores por Email ===");
		System.out.print("Introduce el email del Jugador a buscar: ");
		email = sc.nextLine();

		try {
			obj = MetodosPlayer.obtenerPorEmail(email);
			if (obj.isEmpty()) {
				System.out.println("\nNo se encontraron Jugadores con el email proporcionado.");
			} else {
				System.out.println("\n¡Jugadores encontrados!");
				for (EntidadPlayer c : obj) {
					System.out.println(c);
				}
			}
		} catch (Exception e) {
			System.err.println("\nError: No se pudieron buscar los Jugadores. ");
		}
	}

	private static void nuevoJugador() {
		String nick;
		String email;
		String contrasenya;
		EntidadPlayer nuevoJugador;

		System.out.println("\n=== Nuevo Jugador ===");
		System.out.print("Ingrese el nombre del nuevo Jugador: ");
		nick = sc.nextLine();

		System.out.print("Ingrese el email del nuevo Jugador: ");
		email = sc.nextLine();

		System.out.print("Ingrese la contraseña del nuevo Jugador: ");
		contrasenya = sc.nextLine();

		nuevoJugador = new EntidadPlayer(nick, contrasenya, email);
		try {
			guardar(nuevoJugador);
		} catch (Exception e) {
			System.err.println("\nError: No se pudo guardar el Jugador.  ");
		}
	}

	private static void guardar(Object cosa) {
		try {
			ServiceDB.abrir();
			int id = (int) ServiceDB.guardar(cosa);
			System.out.println("\n¡Jugador guardado con éxito! ID: " + id);
		} catch (Exception e) {
			System.err.println("\nError: No se pudo guardar el Jugador.");
		} finally {
			ServiceDB.cerrar();
		}
	}
}