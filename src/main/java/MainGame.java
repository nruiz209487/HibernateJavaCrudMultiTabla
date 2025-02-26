import java.util.List;
import java.util.Scanner;

public class MainGame {

	private static Scanner sc = Main.sc;

	public static void mainGame() {
		int opcion;
		do {
			mostrarMenu();
			opcion = Main.pedirInt();
			switch (opcion) {
			case 0:
				System.err.println("Ha salido del programa.");
				break;
			case 1:
				nuevoJuego();
				break;
			case 2:
				seleccionarJuego();
				break;
			case 3:
				mostrarTodosLosJuegos();
				break;
			case 4:
				seleccionarJuegosPorNombre();
				break;
			case 5:
				seleccionarJuegosPorTiempoJugado();
				break;
			case 6:
				actualizarJuego();
				break;
			case 7:
				actualizarNombreJuego();
				break;
			case 8:
				actualizarTiempoJugado();
				break;
			case 9:
				eliminarJuego();
				break;
			case 10:
				eliminarPorNombre();
				break;
			case 11:
				eliminarPorTiempoJugadoRango();
				break;
			case 12:
				try {
					MetodosGames.eliminarTabla();
				} catch (Exception e) {
					System.err.println("Error al impimir la tabla.");
				}

				break;
			default:
				System.err.println("Opción no válida.");
				break;
			}
		} while (opcion != 0);

	}

	public static void mostrarMenu() {
		System.out.println(Colores.GREEN + Colores.BOLD + "===== MENÚ DE JUEGOS =====" + Colores.BLUE);
		System.out.println(Colores.WHITE + "1. Nuevo Juego");
		System.out.println("2. Seleccionar Juego");
		System.out.println("3. Mostrar Todos los Juegos");
		System.out.println("4. Buscar Juegos por Nombre");
		System.out.println("5. Buscar Juegos por Tiempo Jugado");
		System.out.println("6. Actualizar Juego");
		System.out.println("7. Actualizar Nombre");
		System.out.println("8. Actualizar Tiempo Jugado");
		System.out.println("9. Eliminar Juego");
		System.out.println("10. Eliminar por Nombre");
		System.out.println("11. Eliminar por Tiempo Jugado Menor");
		System.out.println("12. Eliminar Tabla");
		System.out.println(Colores.RED + "0. Salir");
		System.out.println(Colores.GREEN + "===========================" + Colores.BLUE);
	}

	private static void actualizarJuego() {
		EntidadGames obj;
		EntidadGames objActualizada;
		String nombre;
		int id;
		System.out.println("\n=== Actualizar Juego ===");
		System.out.println("Introduce el ID del juego que deseas actualizar:");
		id = Main.pedirInt();
		System.out.println("Ingresa el nuevo nombre del juego:");
		nombre = sc.nextLine();
		System.out.println("Ingresa el nuevo tiempo jugado (en horas):");
		int tiempoJugado = sc.nextInt();
		sc.nextLine();
		obj = new EntidadGames(nombre, tiempoJugado);
		try {
			objActualizada = MetodosGames.ActulizarPorId(EntidadGames.class, id, obj);
			if (objActualizada != null) {
				System.out.println("¡Juego actualizado con éxito!");
				System.out.println("Detalles del juego actualizado:");
				System.out.println(objActualizada);
			} else {
				System.err.println("No se encontró ningún juego con el ID proporcionado.");
			}
		} catch (Exception e) {
			System.err.println("Error al intentar actualizar el juego.");
		}
	}

	private static void actualizarNombreJuego() {
		EntidadGames obj;
		EntidadGames objActualizada;
		String nombre;
		System.out.println("\n=== Actualizar Nombre Juego ===");
		int id;
		System.out.println("Introduce el ID del juego cuyo nombre deseas actualizar:");
		id = Main.pedirInt();
		System.out.println("Ingresa el nuevo nombre del juego:");
		nombre = sc.nextLine();
		obj = new EntidadGames(nombre);
		try {
			objActualizada = MetodosGames.ActualizarPorIdPropiedad2(EntidadGames.class, id, obj);
			if (objActualizada != null) {
				System.out.println("¡Nombre del juego actualizado con éxito!");
				System.out.println("Detalles del juego actualizado:");
				System.out.println(objActualizada);
			} else {
				System.err.println("No se encontró ningún juego con el ID proporcionado.");
			}
		} catch (Exception e) {
			System.err.println("Error al intentar actualizar el nombre del juego.");
		}
	}

	private static void actualizarTiempoJugado() {
		EntidadGames obj;
		EntidadGames objActualizada;
		int id;
		int tiempoJugado;
		System.out.println("\n=== Actualizar Tiempo Juego ===");
		System.out.println("Introduce el ID del juego cuyo tiempo jugado deseas actualizar:");
		id = Main.pedirInt();
		System.out.println("Ingresa el nuevo tiempo jugado (en horas):");
		tiempoJugado = Main.pedirInt();
		obj = new EntidadGames(tiempoJugado);
		try {
			objActualizada = MetodosGames.ActualizarPorIdPropiedad1(EntidadGames.class, id, obj);
			if (objActualizada != null) {
				System.out.println("¡Tiempo jugado actualizado con éxito!");
				System.out.println("Detalles del juego actualizado:");
				System.out.println(objActualizada);
			} else {
				System.err.println("No se encontró ningún juego con el ID proporcionado.");
			}
		} catch (Exception e) {
			System.err.println("Error al intentar actualizar el tiempo jugado.");
		}
	}

	private static void eliminarJuego() {
		int id;
		System.out.println("\n=== Eliminar Juego ===");
		System.out.println("Introduce el ID del juego que deseas eliminar:");
		id = Main.pedirInt();
		try {
			MetodosGames.EliminarPorId(EntidadGames.class, id);
			System.out.println("¡Juego eliminado con éxito!");
		} catch (Exception e) {
			System.err.println("Error al intentar eliminar el juego.");
		}
	}

	private static void eliminarPorTiempoJugadoRango() {
		int tiempoJugado;
		System.out.println("\n=== Eliminar Juego por tiempo de juego ===");
		System.out.println("Introduce el tiempo jugado mínimo para eliminar juegos:");
		tiempoJugado = Main.pedirInt();
		int tiempoJugadoLimite;
		System.out.println("Introduce el tiempo jugado máximo para eliminar juegos:");
		tiempoJugadoLimite = Main.pedirInt();
		sc.nextLine();
		try {
			MetodosGames.eliminarPorTiempoJugador(tiempoJugado, tiempoJugadoLimite);
			System.out.println("¡Juegos eliminados con éxito!");
		} catch (Exception e) {
			System.err.println("Error al intentar eliminar los juegos.");
		}
	}

	private static void eliminarPorNombre() {
		String nombre;
		System.out.println("\n=== Eliminar Juego por nombre ===");
		System.out.println("Introduce el nombre del juego que deseas eliminar:");
		nombre = sc.nextLine();
		try {
			MetodosGames.eliminarPorNombre(nombre);
			System.out.println("¡Juego eliminado con éxito!");
		} catch (Exception e) {
			System.err.println("Error al intentar eliminar el juego.");
		}
	}

	private static void seleccionarJuego() {
		EntidadGames obj;
		int id;
		System.out.println("\n=== Seleccionar Juego ===");
		System.out.println("Introduce el ID del juego que deseas buscar:");
		id = Main.pedirInt();
		try {
			obj = MetodosGames.obtenerPorId(EntidadGames.class, id);
			if (obj != null) {
				System.out.println("Juego encontrado:");
				System.out.println(obj);
			} else {
				System.out.println("No se encontró ningún juego con el ID proporcionado.");
			}
		} catch (Exception e) {
			System.err.println("Error al intentar buscar el juego.");
		}
	}

	public static void mostrarTodosLosJuegos() {

		try {
			List<EntidadGames> obj = MetodosGames.mostrarTodosLosJuegos();
			System.out.println("\n=== Mostar Juegos ===");
			if (obj.isEmpty()) {
				System.out.println("No hay juegos registrados en la base de datos.");
			} else {
				System.out.println("Listado de todos los juegos:");
				for (EntidadGames c : obj) {
					System.out.println(c);
				}
			}
		} catch (Exception e) {
			System.err.println("Error al intentar mostrar los juegos.");
		}
	}

	private static void seleccionarJuegosPorNombre() {
		String nombre;
		List<EntidadGames> obj;
		System.out.println("\n=== Mostar Juegos por nombre ===");
		System.out.println("Introduce el nombre del juego que deseas buscar:");
		nombre = sc.nextLine();
		try {
			obj = MetodosGames.obtenerPorNombre(nombre);
			if (obj.isEmpty()) {
				System.out.println("No se encontraron juegos con el nombre proporcionado.");
			} else {
				System.out.println("Juegos encontrados:");
				for (EntidadGames c : obj) {
					System.out.println(c);
				}
			}
		} catch (Exception e) {
			System.err.println("Error al intentar buscar juegos por nombre.");
		}
	}

	private static void seleccionarJuegosPorTiempoJugado() {
		int tiempoJugado;
		int tiempoJugado2;
		List<EntidadGames> obj;
		System.out.println("\n=== Mostar Juegos por Tiempo de Juego ===");
		System.out.println("Introduce el tiempo jugado mínimo para buscar juegos:");
		tiempoJugado = Main.pedirInt();
		System.out.println("Introduce el tiempo jugado máximo para buscar juegos:");
		tiempoJugado2 = Main.pedirInt();
		try {
			obj = MetodosGames.obtenerPorTiempoJugado(tiempoJugado, tiempoJugado2);
			if (obj.isEmpty()) {
				System.out.println("No se encontraron juegos dentro del rango de tiempo proporcionado.");
			} else {
				System.out.println("Juegos encontrados:");
				for (EntidadGames x : obj) {
					System.out.println(x);
				}
			}
		} catch (Exception e) {
			System.err.println("Error al intentar buscar juegos por tiempo jugado.");
		}
	}

	private static void nuevoJuego() {
		String nombre;
		int tiempoJugado;
		EntidadGames nuevoJuego;
		System.out.println("\n=== Nuevo Juego ===");
		System.out.println("Ingresa el nombre del nuevo juego:");
		nombre = sc.nextLine();
		System.out.println("Ingresa el tiempo jugado (en horas):");
		tiempoJugado = Main.pedirInt();
		nuevoJuego = new EntidadGames(nombre, tiempoJugado);
		try {
			guardar(nuevoJuego);
		} catch (Exception e) {
			System.err.println("Error al intentar guardar el nuevo juego.");
		}
	}

	private static void guardar(Object cosa) {
		try {
			ServiceDB.abrir();
			int id = (int) ServiceDB.guardar(cosa);
			System.out.println("¡Juego guardado con éxito! ID asignado: " + id);
		} catch (Exception e) {
			System.err.println("Error al intentar guardar el juego.");
		} finally {
			ServiceDB.cerrar();
		}
	}
}