
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class MainCompras {

	private static Scanner sc = new Scanner(System.in);
	private static SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) throws Exception {
		int opcion;
		do {
			menuCompras();
			opcion = sc.nextInt();
			sc.nextLine();
			switch (opcion) {
			case 0:
				System.err.println("Ha salido del programa.");
				break;
			case 1:
				nuevaCompra();
				break;
			case 2:
				sleccionarCompra();
				break;
			case 3:
				mostrarTodasLasCompra();
				break;
			case 4:
				seleccionarComprasPorCosa();
				break;
			case 5:
				seleccionarComprasPorFecha();
				break;
			case 6:
				seleccionarComprasPorPrecio();
				break;
			case 7:
				actualizarCompra();
				break;
			case 8:
				actualizarPorCosa();
				break;
			case 9:
				actualizarPorFecha();
				break;
			case 10:
				actualizarPorPrecio();
				break;
			case 11:

				break;
			case 13:

				break;
			case 14:
				eliminarCompra();
				break;
			case 15:
				eliminarCompraPorCosa();
				break;
			case 16:
				eliminarCompraPorFecha();
				break;
			case 17:
				eliminarCompraPorPrecio();
				break;
			case 18:
				eliminarCompraPorIdGame();
				break;
			case 19:
				eliminarCompraPorIdPlayer();
				break;
			case 20:
				MetodosCompras.eliminarTablaCompras();
				break;
			default:
				System.err.println("Opción no válida.");
				break;
			}
		} while (opcion != 0);
		sc.close();
	}

	private static void menuCompras() {
		System.out.println("Elija una opción:");
		System.out.println("1. Nueva Compra");
		System.out.println("2. Seleccionar Compra");
		System.out.println("3. Mostrar Todas las Compras");
		System.out.println("4. Buscar Compras por Cosa");
		System.out.println("5. Buscar Compras por Fecha");
		System.out.println("6. Buscar Compras por Precio");
		System.out.println("7. Actualizar Compra");
		System.out.println("8. Actualizar por Cosa");
		System.out.println("9. Actualizar por Fecha");
		System.out.println("10. Actualizar por Precio");
		System.out.println("11. Actualizar por ID de Juego");
		System.out.println("13. Actualizar por ID de Jugador");
		System.out.println("14. Eliminar Compra");
		System.out.println("15. Eliminar Compra por Cosa");
		System.out.println("16. Eliminar Compra por Fecha");
		System.out.println("17. Eliminar Compra por Precio");
		System.out.println("18. Eliminar Compra por ID de Juego");
		System.out.println("19. Eliminar Compra por ID de Jugador");
		System.out.println("20. Eliminar Tabla de Compras");
		System.out.println("0. Salir");
	}

	private static void actualizarCompra() {
		EntidadCompras obj;
		EntidadCompras objActualizada;
		String cosa;
		Date fecha = null;
		double precio;
		int id;
		System.out.println("Introduce el ID de la compra a actualizar:");
		id = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese el nuevo nombre del objeto de la compra:");
		cosa = sc.nextLine();
		System.out.println("Ingrese la nueva fecha de la compra (YYYY-MM-DD):");
		String fechaInput = sc.nextLine();

		try {
			fecha = (Date) formatoFecha.parse(fechaInput);
		} catch (ParseException e) {
			System.err.println("Error: Formato de fecha incorrecto. Use YYYY-MM-DD.");
		}
		if (fecha != null) {
			System.out.println("Ingrese el nuevo precio de la compra:");
			precio = sc.nextDouble();
			sc.nextLine();
			obj = new EntidadCompras(cosa, precio, fecha);
			try {
				objActualizada = MetodosCompras.ActulizarPorId(EntidadCompras.class, id, obj);
				if (objActualizada != null) {
					System.out.println("Compra actualizada con éxito:");
					System.out.println(objActualizada);
				} else {
					System.err.println("No se encontró ninguna compra con el ID proporcionado.");
				}
			} catch (Exception e) {
				System.err.println("Error al actualizar la compra.");
			}
		}
	}

	private static void actualizarPorCosa() {
		EntidadCompras obj;
		EntidadCompras objActualizada;
		String cosa;
		int id;
		System.out.println("Introduce el ID de la compra a actualizar:");
		id = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese la nueva cosa de la compra:");
		cosa = sc.nextLine();
		obj = new EntidadCompras(cosa, 0.0);
		try {
			objActualizada = MetodosCompras.ActualizarPorIdPropiedadCosa(EntidadCompras.class, id, obj);
			if (objActualizada != null) {
				System.out.println("compra actualizado con éxito:");
				System.out.println(objActualizada);
			} else {
				System.err.println("No se encontró ningúna compra con el ID proporcionado.");
			}
		} catch (Exception e) {
			System.err.println("Error al actualizar la compra.");
		}
	}

	private static void actualizarPorFecha() {
		EntidadCompras obj;
		EntidadCompras objActualizada;
		Date fecha = null;
		int id;
		boolean fechaCorrecta = true;
		System.out.println("Introduce el ID de la compra a actualizar:");
		id = sc.nextInt();
		sc.nextLine();

		System.out.println("Ingrese la fecha límite del nuevo compra (YYYY-MM-DD):");
		String fechaInput = sc.nextLine();

		try {
			java.util.Date fechaUtil = formatoFecha.parse(fechaInput);
			fecha = new java.sql.Date(fechaUtil.getTime());
		} catch (ParseException e) {
			System.err.println("Error: Formato de fecha incorrecto. Use YYYY-MM-DD.");
			fechaCorrecta = false;
		}
		if (fechaCorrecta) {
			obj = new EntidadCompras("", 0.0, fecha);

			try {
				objActualizada = MetodosCompras.ActualizarPorIdPropiedadFecha(EntidadCompras.class, id, obj);
				if (objActualizada != null) {
					System.out.println("Compra actualizada con éxito:");
					System.out.println(objActualizada);
				} else {
					System.err.println("No se encontró ninguna compra con el ID proporcionado.");
				}
			} catch (Exception e) {
				System.err.println("Error al actualizar la compra.");
			}
		}
	}

	private static void actualizarPorPrecio() {
		EntidadCompras obj;
		EntidadCompras objActualizada;
		double precio;
		int id;
		System.out.println("Introduce el ID de la compra a actualizar:");
		id = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese el nuevo precio del compra:");
		precio = sc.nextDouble();
		sc.nextLine();
		obj = new EntidadCompras("", precio);
		try {
			objActualizada = MetodosCompras.ActualizarPorIdPropiedadPrecio(EntidadCompras.class, id, obj);
			if (objActualizada != null) {
				System.out.println("compra actualizado con éxito:");
				System.out.println(objActualizada);
			} else {
				System.err.println("No se encontró ningún compra con el ID proporcionado.");
			}
		} catch (Exception e) {
			System.err.println("Error al actualizar el compra.");
		}
	}

	private static void eliminarCompra() {
		int id;
		System.out.println("Introduce el ID del compra a eliminar:");
		id = sc.nextInt();
		sc.nextLine();
		try {
			MetodosCompras.EliminarPorId(EntidadCompras.class, id);
			System.out.println("compra eliminado con éxito.");
		} catch (Exception e) {
			System.err.println("Error al eliminar el compra.");
		}
	}

	private static void eliminarCompraPorCosa() {
		String cosa;
		System.out.println("Introduce el cosa del compra a eliminar:");
		cosa = sc.nextLine();
		try {
			MetodosCompras.eliminarPorCosa(cosa);
			System.out.println("compra eliminado con éxito.");
		} catch (Exception e) {
			System.err.println("Error al eliminar el compra.");
		}
	}

	private static void eliminarCompraPorFecha() {
		Date fecha = null;
		Date fechaLimite = null;
		String fechaInput;
		System.out.println("Ingrese la fecha límite del nuevo compra (YYYY-MM-DD):");
		fechaInput = sc.nextLine();
		try {
			java.util.Date fechaUtil = formatoFecha.parse(fechaInput);
			fecha = new java.sql.Date(fechaUtil.getTime());
		} catch (ParseException e) {
			System.err.println("Error: Formato de fecha incorrecto. Use YYYY-MM-DD.");
		}

		System.out.println("Ingrese la fecha límite del nuevo compra (YYYY-MM-DD):");
		fechaInput = sc.nextLine();
		try {
			java.util.Date fechaUtil = formatoFecha.parse(fechaInput);
			fechaLimite = new java.sql.Date(fechaUtil.getTime());

		} catch (ParseException e) {
			System.err.println("Error: Formato de fecha incorrecto. Use YYYY-MM-DD.");
		}
		if (fecha != null && fechaLimite != null) {
			try {
				MetodosCompras.eliminarPorFecha(fecha, fechaLimite);
				System.out.println("compra eliminado con éxito.");
			} catch (Exception e) {
				System.err.println("compra al eliminar el Player.");
			}
		}
	}

	private static void eliminarCompraPorPrecio() {
		double precio;
		double precioMaximo;
		System.out.println("Introduce el precio del compra a eliminar:");
		precio = sc.nextDouble();
		sc.nextLine();
		System.out.println("Introduce el precioMaximo del compra a eliminar:");
		precioMaximo = sc.nextDouble();
		sc.nextLine();
		try {
			MetodosCompras.eliminarPorPrecio(precio, precioMaximo);
			System.out.println("Player eliminado con éxito.");
		} catch (Exception e) {
			System.err.println("Error al eliminar el juego.");
		}
	}

	private static void eliminarCompraPorIdPlayer() {
		int idPlayer;
		System.out.println("Introduce el email del compra a eliminar:");
		idPlayer = sc.nextInt();
		sc.nextLine();
		try {
			MetodosCompras.eliminarPorIdPlayer(idPlayer);
			System.out.println("compra eliminado con éxito.");
		} catch (Exception e) {
			System.err.println("Error al eliminar el compra.");
		}

	}

	private static void eliminarCompraPorIdGame() {
		int idGame;
		System.out.println("Introduce el idGame del compra a eliminar:");
		idGame = sc.nextInt();
		sc.nextLine();
		try {
			MetodosCompras.eliminarPorIdGame(idGame);
			System.out.println("compra eliminado con éxito.");
		} catch (Exception e) {
			System.err.println("Error al eliminar el compra.");
		}

	}

	private static void sleccionarCompra() {
		EntidadCompras obj;
		int id;
		System.out.println("Introduce el ID del compra a buscar:");
		id = sc.nextInt();
		sc.nextLine();
		try {
			obj = MetodosCompras.obtenerPorId(EntidadCompras.class, id);
			if (obj != null) {
				System.out.println("compra encontrado:");
				System.out.println(obj);
			} else {
				System.out.println("No se encontró ningún compra con el ID proporcionado.");
			}
		} catch (Exception e) {
			System.err.println("Error al buscar el compra.");
		}
	}

	private static void mostrarTodasLasCompra() {
		try {
			List<EntidadCompras> obj = MetodosCompras.mostrarTodosLasCompras();
			if (obj.isEmpty()) {
				System.out.println("No hay compra registrados.");
			} else {
				System.out.println("Listado de compra:");
				for (EntidadCompras c : obj) {
					System.out.println(c);
				}
			}
		} catch (Exception e) {
			System.err.println("Error al mostrar los compra.");
		}
	}

	private static void seleccionarComprasPorCosa() {
		String cosa;
		List<EntidadCompras> obj;
		System.out.println("Introduce el cosa del compra a buscar:");
		cosa = sc.nextLine();
		try {
			obj = MetodosCompras.obtenerPorCosa(cosa);
			if (obj.isEmpty()) {
				System.out.println("No se encontraron compra con el nombre proporcionado.");
			} else {
				System.out.println("compra encontrados:");
				for (EntidadCompras c : obj) {
					System.out.println(c);
				}
			}
		} catch (Exception e) {
			System.err.println("Error al buscar compra por nombre.");
		}
	}

	private static void seleccionarComprasPorFecha() {
		String fehca;
		String fehcaLimite;
		List<EntidadCompras> obj;
		System.out.println("Introduce la fehca del compra a buscar:");
		fehca = sc.nextLine();
		System.out.println("Introduce la fehcaLimite del compra a buscar:");
		fehcaLimite = sc.nextLine();
		try {
			obj = MetodosCompras.obtenerPorFecha(fehca, fehcaLimite);
			if (obj.isEmpty()) {
				System.out.println("No se encontraron compra con el contasenya proporcionado.");
			} else {
				System.out.println("compra encontrados:");
				for (EntidadCompras c : obj) {
					System.out.println(c);
				}
			}
		} catch (Exception e) {
			System.err.println("Error al buscar compra por nombre.");
		}
	}

	private static void seleccionarComprasPorPrecio() {
		double precio;
		double precioLimite;
		List<EntidadCompras> obj;
		System.out.println("Introduce el precio del compra a buscar:");
		precio = sc.nextDouble();
		sc.nextLine();
		System.out.println("Introduce el precioLimite del compra a buscar:");
		precioLimite = sc.nextDouble();
		sc.nextLine();
		try {
			obj = MetodosCompras.obtenerPorPrecio(precio, precioLimite);
			if (obj.isEmpty()) {
				System.out.println("No se encontraron Player con el nombre proporcionado.");
			} else {
				System.out.println("compra encontrados:");
				for (EntidadCompras c : obj) {
					System.out.println(c);
				}
			}
		} catch (Exception e) {
			System.err.println("Error al buscar compra por email.");
		}
	}

	private static void nuevaCompra() {
		int idGame;
		int idPlayer;
		String cosa;
		Date fecha = null;
		double precio;
		EntidadCompras nuevaCompra;
		System.out.println("Ingrese el idGame del nuevo compra:");
		idGame = sc.nextInt();
		sc.nextLine();
		EntidadGames objGame = null;
		try {
			objGame = MetodosGames.obtenerPorId(EntidadGames.class, idGame);
		} catch (Exception e) {
			System.err.println("El Game no existe.");
		}

		System.out.println("Ingrese el idPlayer del nuevo compra:");
		idPlayer = sc.nextInt();
		sc.nextLine();
		EntidadPlayer objPlayer = null;
		try {
			objPlayer = MetodosPlayer.obtenerPorId(EntidadPlayer.class, idPlayer);
		} catch (Exception e) {
			System.err.println("El Player no existe.");
		}

		System.out.println("Ingrese el cosa del nuevo compra:");
		cosa = sc.nextLine();

		System.out.println("Ingrese el precio del nuevo compra:");
		precio = sc.nextDouble();
		sc.nextLine();

		System.out.println("Ingrese la fecha límite del nuevo compra (YYYY-MM-DD):");
		String fechaInput = sc.nextLine();
		try {
			java.util.Date fechaUtil = formatoFecha.parse(fechaInput);
			fecha = new java.sql.Date(fechaUtil.getTime());
		} catch (ParseException e) {
			System.err.println("Error: Formato de fecha incorrecto. Use YYYY-MM-DD.");
		}

		if (objGame != null && objPlayer != null && fecha != null) {
			nuevaCompra = new EntidadCompras(objPlayer, objGame, cosa, precio, fecha);
			try {
				guardar(nuevaCompra);
				System.out.println("Compra guardada con éxito.");
			} catch (Exception e) {
				System.err.println("Error al guardar la compra.");
			}
		} else {
			System.err.println("Error: Player o Game no encontrados.");
		}
	}

	private static void guardar(Object cosa) {
		try {
			ServiceDB.abrir();
			int id = (int) ServiceDB.guardar(cosa);
			System.out.println("Player guardado con ID: " + id);
		} catch (Exception e) {
			System.err.println("Error al guardar el compra: " + e.getMessage());
		} finally {
			ServiceDB.cerrar();
		}
	}
}