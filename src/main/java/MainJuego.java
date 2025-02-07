import java.util.List;
import java.util.Scanner;

public class MainJuego {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		int opcion;
		do {
			menuGame();
			opcion = sc.nextInt();
			sc.nextLine();
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
				MetodosGames.eliminarTabla();
				break;
			default:
				System.err.println("Opción no válida.");
				break;
			}
		} while (opcion != 0);
		sc.close();
	}

	private static void menuGame() {
		System.out.println("Elija una opción:");
		System.out.println("1. Nuevo Juego");
		System.out.println("2. Seleccionar Juego");
		System.out.println("3. Mostrar Todos los Juegos");
		System.out.println("4. Buscar Juegos por Nombre");
		System.out.println("5. Buscar Juegos por Tiempo Jugado");
		System.out.println("6. Actualizar Juego");
		System.out.println("7. Actualizar Nombre");
		System.out.println("8. Actualizar Tiempo Jugado");
		System.out.println("9. Eliminar Juego");
		System.out.println("10. Eliminar Por Nombre");
		System.out.println("11. Eliminar Por Tiempo Jugado Menor");
		System.out.println("12. Eliminar Tabla");
		System.out.println("0. Salir");
	}

	private static void actualizarJuego() {
		EntidadGames obj;
		EntidadGames objActualizada;
		String nombre;
		int id;
		System.out.println("Introduce el ID del juego a actualizar:");
		id = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese el nuevo nombre del juego:");
		nombre = sc.nextLine();
		System.out.println("Ingrese el nuevo tiempo jugado:");
		int tiempoJugado = sc.nextInt();
		sc.nextLine();

		obj = new EntidadGames(nombre, tiempoJugado);
		try {
			objActualizada = MetodosGames.ActulizarPorId(EntidadGames.class, id, obj);
			if (objActualizada != null) {
				System.out.println("Juego actualizado con éxito:");
				System.out.println(objActualizada);
			} else {
				System.err.println("No se encontró ningún juego con el ID proporcionado.");
			}
		} catch (Exception e) {
			System.err.println("Error al actualizar el juego.");
		}
	}

	private static void actualizarNombreJuego() {
		EntidadGames obj;
		EntidadGames objActualizada;
		String nombre;
		int id;
		System.out.println("Introduce el ID del juego a actualizar:");
		id = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese el nuevo nombre del juego:");
		nombre = sc.nextLine();
		obj = new EntidadGames(nombre);
		try {
			objActualizada = MetodosGames.ActualizarPorIdPropiedad2(EntidadGames.class, id, obj);
			if (objActualizada != null) {
				System.out.println("Juego actualizado con éxito:");
				System.out.println(objActualizada);
			} else {
				System.err.println("No se encontró ningún juego con el ID proporcionado.");
			}
		} catch (Exception e) {
			System.err.println("Error al actualizar el juego.");
		}
	}

	private static void actualizarTiempoJugado() {
		EntidadGames obj;
		EntidadGames objActualizada;
		int id;
		int tiempoJugado;
		System.out.println("Introduce el ID del juego a actualizar:");
		id = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese el nuevo tiempo jugado:");
		tiempoJugado = sc.nextInt();
		sc.nextLine();

		obj = new EntidadGames(tiempoJugado);
		try {
			objActualizada = MetodosGames.ActualizarPorIdPropiedad1(EntidadGames.class, id, obj);
			if (objActualizada != null) {
				System.out.println("Juego actualizado con éxito:");
				System.out.println(objActualizada);
			} else {
				System.err.println("No se encontró ningún juego con el ID proporcionado.");
			}
		} catch (Exception e) {
			System.err.println("Error al actualizar el juego.");
		}
	}

	private static void eliminarJuego() {
		int id;
		System.out.println("Introduce el ID del juego a eliminar:");
		id = sc.nextInt();
		sc.nextLine();
		try {
			MetodosGames.EliminarPorId(EntidadGames.class, id);
			System.out.println("Juego eliminado con éxito.");
		} catch (Exception e) {
			System.err.println("Error al eliminar el juego.");
		}
	}

	private static void eliminarPorTiempoJugadoRango() {
		int tiempoJugado;
		System.out.println("Introduce el tiempo jugado a partir del cual se eliminan los juegos:");
		tiempoJugado = sc.nextInt();
		int tiempoJugado2;
		System.out.println("Introduce el tiempo jugado del liminte:");
		tiempoJugado2 = sc.nextInt();
		sc.nextLine();
		try {
			MetodosGames.eliminarPorTiempoJugador(tiempoJugado, tiempoJugado2);
			System.out.println("Juegos eliminados con éxito.");
		} catch (Exception e) {
			System.err.println("Error al eliminar los juegos.");
		}
	}

	private static void eliminarPorNombre() {
		String nombre;
		System.out.println("Introduce el nombre del juego a eliminar:");
		nombre = sc.nextLine();
		try {
			MetodosGames.eliminarPorNombre(nombre);
			System.out.println("Juego eliminado con éxito.");
		} catch (Exception e) {
			System.err.println("Error al eliminar el juego.");
		}
	}

	private static void seleccionarJuego() {
		EntidadGames obj;
		int id;
		System.out.println("Introduce el ID del juego a buscar:");
		id = sc.nextInt();
		sc.nextLine();
		try {
			obj = MetodosGames.obtenerPorId(EntidadGames.class, id);
			if (obj != null) {
				System.out.println("Juego encontrado:");
				System.out.println(obj);
			} else {
				System.out.println("No se encontró ningún juego con el ID proporcionado.");
			}
		} catch (Exception e) {
			System.err.println("Error al buscar el juego.");
		}
	}

	private static void mostrarTodosLosJuegos() {
		try {
			List<EntidadGames> obj = MetodosGames.mostrarTodosLosJuegos();
			if (obj.isEmpty()) {
				System.out.println("No hay juegos registrados.");
			} else {
				System.out.println("Listado de juegos:");
				for (EntidadGames c : obj) {
					System.out.println(c);
				}
			}
		} catch (Exception e) {
			System.err.println("Error al mostrar los juegos.");
		}
	}

	private static void seleccionarJuegosPorNombre() {
		String nombre;
		List<EntidadGames> obj;
		System.out.println("Introduce el nombre del juego a buscar:");
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
			System.err.println("Error al buscar juegos por nombre.");
		}
	}

	private static void seleccionarJuegosPorTiempoJugado() {
		int tiempoJugado;
		int tiempoJugado2;
		List<EntidadGames> obj;
		System.out.println("Introduce el tiempo jugado del juego a buscar menor:");
		tiempoJugado = sc.nextInt();
		System.out.println("Introduce el tiempo jugado del juego a buscar mayor:");
		tiempoJugado2 = sc.nextInt();
		sc.nextLine();
		try {
			obj = MetodosGames.obtenerPorTiempoJugado(tiempoJugado, tiempoJugado2);
			if (obj.isEmpty()) {
				System.out.println("No se encontraron juegos con el tiempo jugado proporcionado.");
			} else {
				System.out.println("Juegos encontrados:");
				for (EntidadGames x : obj) {
					System.out.println(x);
				}
			}
		} catch (Exception e) {
			System.err.println("Error al buscar juegos por tiempo jugado.");
		}
	}

	private static void nuevoJuego() {
		String nombre;
		int tiempoJugado;
		EntidadGames nuevoJuego;
		System.out.println("Ingrese el nombre del nuevo juego:");
		nombre = sc.nextLine();
		System.out.println("Ingrese el tiempo jugado:");
		tiempoJugado = sc.nextInt();
		sc.nextLine();
		nuevoJuego = new EntidadGames(nombre, tiempoJugado);
		try {
			guardar(nuevoJuego);
		} catch (Exception e) {
			System.err.println("Error al guardar el juego.");
		}
	}

	private static void guardar(Object cosa) {
		try {
			ServiceDB.abrir();
			int id = (int) ServiceDB.guardar(cosa);
			System.out.println("Juego guardado con ID: " + id);
		} catch (Exception e) {
			System.err.println("Error al guardar el juego: " + e.getMessage());
		} finally {
			ServiceDB.cerrar();
		}
	}
}