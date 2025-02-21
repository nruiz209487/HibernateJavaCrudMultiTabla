
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class MainCompras {

	private static Scanner sc = Main.sc;
	private static SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

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
				nuevaCompra();
				break;
			case 2:
				seleccionarCompra();
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
				eliminarCompra();
				break;
			case 12:
				eliminarCompraPorCosa();
				break;
			case 13:
				eliminarCompraPorFecha();
				break;
			case 14:
				eliminarCompraPorPrecio();
				break;
			case 15:
				try {
					MetodosCompras.eliminarTablaCompras();
				} catch (Exception e) {
					System.err.println("Error al eliminar la tabla");
				}
				break;
			default:
				System.err.println("Opción no válida.");
				break;
			}
		} while (opcion != 0);

	}

	public static void mostrarMenu() {
		System.out.println(Colores.GREEN + Colores.BOLD + "===== MENÚ DE COMPRAS =====" + Colores.BLUE);
		System.out.println(Colores.WHITE + "1. Nueva Compra");
		System.out.println("2. Seleccionar Compra");
		System.out.println("3. Mostrar Todas las Compras");
		System.out.println("4. Buscar Compras por Cosa");
		System.out.println("5. Buscar Compras por Fecha");
		System.out.println("6. Buscar Compras por Precio");
		System.out.println("7. Actualizar Compra");
		System.out.println("8. Actualizar por Cosa");
		System.out.println("9. Actualizar por Fecha");
		System.out.println("10. Actualizar por Precio");
		System.out.println("11. Eliminar Compra");
		System.out.println("12. Eliminar Compra por Cosa");
		System.out.println("13. Eliminar Compra por Fecha");
		System.out.println("14. Eliminar Compra por Precio");
		System.out.println("15. Eliminar Tabla de Compras");
		System.out.println(Colores.RED + "0. Salir" + Colores.BLUE);
		System.out.println(Colores.GREEN + "===========================" + Colores.BLUE);
	}

	private static void actualizarCompra() {
		EntidadCompras obj;
		EntidadCompras objActualizada;
		String cosa;
		Date fecha = null;
		double precio;
		int id;

		System.out.println("\n=== ACTUALIZAR COMPRA ===");
		System.out.println("---------------------------------");
		System.out.println("Introduce el ID de la compra a actualizar:");
		id = Main.pedirInt();
		System.out.println("Ingrese el nuevo nombre del objeto de la compra:");
		cosa = sc.nextLine();

		System.out.println("Ingrese la nueva fecha de la compra (YYYY-MM-DD):");
		String fechaInput = sc.nextLine();

		try {
			java.util.Date fechaUtil = formatoFecha.parse(fechaInput);
			fecha = new java.sql.Date(fechaUtil.getTime());
		} catch (ParseException e) {
			System.err.println("Error: Formato de fecha incorrecto. Use YYYY-MM-DD.");
		}

		if (fecha != null) {
			System.out.println("Ingrese el nuevo precio de la compra:");
			precio = Main.pedirDouble();

			obj = new EntidadCompras(cosa, precio, fecha);
			try {
				objActualizada = MetodosCompras.ActulizarPorId(EntidadCompras.class, id, obj);
				if (objActualizada != null) {
					System.out.println("\n--- Compra actualizada con éxito ---");
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

		System.out.println("\n=== ACTUALIZAR COMPRA POR COSA ===");
		System.out.println("---------------------------------");
		System.out.println("Introduce el ID de la compra a actualizar:");
		id = Main.pedirInt();

		System.out.println("Ingrese la nueva cosa de la compra:");
		cosa = sc.nextLine();

		obj = new EntidadCompras(cosa, 0.0);
		try {
			objActualizada = MetodosCompras.ActualizarPorIdPropiedadCosa(EntidadCompras.class, id, obj);
			if (objActualizada != null) {
				System.out.println("\n--- Compra actualizada con éxito ---");
				System.out.println(objActualizada);
			} else {
				System.err.println("No se encontró ninguna compra con el ID proporcionado.");
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

		System.out.println("\n=== ACTUALIZAR COMPRA POR FECHA ===");
		System.out.println("---------------------------------");
		System.out.println("Introduce el ID de la compra a actualizar:");
		id = Main.pedirInt();

		System.out.println("Ingrese la nueva fecha de la compra (YYYY-MM-DD):");
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
					System.out.println("\n--- Compra actualizada con éxito ---");
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

		System.out.println("\n=== ACTUALIZAR COMPRA POR PRECIO ===");
		System.out.println("---------------------------------");
		System.out.println("Introduce el ID de la compra a actualizar:");
		id = Main.pedirInt();
		System.out.println("Ingrese el nuevo precio de la compra:");
		precio = sc.nextDouble();
		sc.nextLine();

		obj = new EntidadCompras("", precio);
		try {
			objActualizada = MetodosCompras.ActualizarPorIdPropiedadPrecio(EntidadCompras.class, id, obj);
			if (objActualizada != null) {
				System.out.println("\n--- Compra actualizada con éxito ---");
				System.out.println(objActualizada);
			} else {
				System.err.println("No se encontró ninguna compra con el ID proporcionado.");
			}
		} catch (Exception e) {
			System.err.println("Error al actualizar la compra.");
		}
	}

	private static void eliminarCompra() {
		int id;

		System.out.println("\n=== ELIMINAR COMPRA ===");
		System.out.println("---------------------------------");
		System.out.println("Introduce el ID de la compra a eliminar:");
		id = Main.pedirInt();

		try {
			MetodosCompras.EliminarPorId(EntidadCompras.class, id);
			System.out.println("\n--- Compra eliminada con éxito ---");
		} catch (Exception e) {
			System.err.println("Error al eliminar la compra.");
		}
	}

	private static void eliminarCompraPorCosa() {
		String cosa;

		System.out.println("\n=== ELIMINAR COMPRA POR COSA ===");
		System.out.println("---------------------------------");
		System.out.println("Introduce el nombre de la cosa de la compra a eliminar:");
		cosa = sc.nextLine();

		try {
			MetodosCompras.eliminarPorCosa(cosa);
			System.out.println("\n--- Compra eliminada con éxito ---");
		} catch (Exception e) {
			System.err.println("Error al eliminar la compra.");
		}
	}

	private static void eliminarCompraPorFecha() {
		Date fecha = null;
		Date fechaLimite = null;
		String fechaInput;

		System.out.println("\n=== ELIMINAR COMPRA POR FECHA ===");
		System.out.println("---------------------------------");
		System.out.println("Ingrese la fecha inicial de la compra a eliminar (YYYY-MM-DD):");
		fechaInput = sc.nextLine();

		try {
			java.util.Date fechaUtil = formatoFecha.parse(fechaInput);
			fecha = new java.sql.Date(fechaUtil.getTime());
		} catch (ParseException e) {
			System.err.println("Error: Formato de fecha incorrecto. Use YYYY-MM-DD.");
		}

		System.out.println("Ingrese la fecha límite de la compra a eliminar (YYYY-MM-DD):");
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
				System.out.println("\n--- Compra eliminada con éxito ---");
			} catch (Exception e) {
				System.err.println("Error al eliminar la compra.");
			}
		}
	}

	private static void eliminarCompraPorPrecio() {
		double precio;
		double precioMaximo;

		System.out.println("\n=== ELIMINAR COMPRA POR PRECIO ===");
		System.out.println("---------------------------------");
		System.out.println("Introduce el precio mínimo de la compra a eliminar:");
		precio = Main.pedirDouble();

		System.out.println("Introduce el precio máximo de la compra a eliminar:");
		precioMaximo = Main.pedirDouble();

		try {
			MetodosCompras.eliminarPorPrecio(precio, precioMaximo);
			System.out.println("\n--- Compra eliminada con éxito ---");
		} catch (Exception e) {
			System.err.println("Error al eliminar la compra.");
		}
	}

	private static void seleccionarCompra() {
		EntidadCompras obj;
		int id;

		System.out.println("\n=== SELECCIONAR COMPRA ===");
		System.out.println("---------------------------------");
		System.out.println("Introduce el ID de la compra a buscar:");
		id = Main.pedirInt();

		try {
			obj = MetodosCompras.obtenerPorId(EntidadCompras.class, id);
			if (obj != null) {
				System.out.println("\n--- Compra encontrada ---");
				System.out.println(obj);
			} else {
				System.out.println("No se encontró ninguna compra con el ID proporcionado.");
			}
		} catch (Exception e) {
			System.err.println("Error al buscar la compra.");
		}
	}

	public static void mostrarTodasLasCompra() {
		System.out.println("\n=== MOSTRAR TODAS LAS COMPRAS ===");
		System.out.println("---------------------------------");
		try {
			List<EntidadCompras> obj = MetodosCompras.mostrarTodosLasCompras();
			if (obj.isEmpty()) {
				System.out.println("No hay compras registradas.");
			} else {
				System.out.println("Listado de compras:");
				for (EntidadCompras c : obj) {
					System.out.println(c);
				}
			}
		} catch (Exception e) {
			System.err.println("Error al mostrar las compras.");
		}
	}

	private static void seleccionarComprasPorCosa() {
		String cosa;
		List<EntidadCompras> obj;

		System.out.println("\n=== SELECCIONAR COMPRAS POR COSA ===");
		System.out.println("---------------------------------");
		System.out.println("Introduce el nombre de la cosa de la compra a buscar:");
		cosa = sc.nextLine();

		try {
			obj = MetodosCompras.obtenerPorCosa(cosa);
			if (obj.isEmpty()) {
				System.out.println("No se encontraron compras con el nombre proporcionado.");
			} else {
				System.out.println("\n--- Compras encontradas ---");
				for (EntidadCompras c : obj) {
					System.out.println(c);
				}
			}
		} catch (Exception e) {
			System.err.println("Error al buscar compras por nombre.");
		}
	}

	private static void seleccionarComprasPorFecha() {
		String fechaInput;
		String fechaLimiteInput;
		List<EntidadCompras> obj;

		System.out.println("\n=== SELECCIONAR COMPRAS POR FECHA ===");
		System.out.println("---------------------------------");
		System.out.println("Introduce la fecha inicial de la compra a buscar (YYYY-MM-DD):");
		fechaInput = sc.nextLine();

		System.out.println("Introduce la fecha límite de la compra a buscar (YYYY-MM-DD):");
		fechaLimiteInput = sc.nextLine();

		Date fechaInicial = null;
		Date fechaLimite = null;

		try {
			java.util.Date fechaUtil = formatoFecha.parse(fechaInput);
			java.util.Date fechaUtilLimite = formatoFecha.parse(fechaLimiteInput);

			fechaInicial = new java.sql.Date(fechaUtil.getTime());
			fechaLimite = new java.sql.Date(fechaUtilLimite.getTime());
		} catch (ParseException e) {
			System.err.println("Error: Formato de fecha incorrecto. Use YYYY-MM-DD.");
			return;
		}

		try {
			obj = MetodosCompras.obtenerPorFecha(fechaInicial, fechaLimite);
			if (obj.isEmpty()) {
				System.out.println("No se encontraron compras dentro del rango de fechas proporcionado.");
			} else {
				System.out.println("\n--- Compras encontradas ---");
				for (EntidadCompras c : obj) {
					System.out.println(c);
				}
			}
		} catch (Exception e) {
			System.err.println("Error al buscar compras por fecha.");
		}
	}

	private static void seleccionarComprasPorPrecio() {
		double precio;
		double precioLimite;
		List<EntidadCompras> obj;

		System.out.println("\n=== SELECCIONAR COMPRAS POR PRECIO ===");
		System.out.println("---------------------------------");
		System.out.println("Introduce el precio mínimo de la compra a buscar:");
		precio = Main.pedirDouble();

		System.out.println("Introduce el precio máximo de la compra a buscar:");
		precioLimite = Main.pedirDouble();

		try {
			obj = MetodosCompras.obtenerPorPrecio(precio, precioLimite);
			if (obj.isEmpty()) {
				System.out.println("No se encontraron compras dentro del rango de precios proporcionado.");
			} else {
				System.out.println("\n--- Compras encontradas ---");
				for (EntidadCompras c : obj) {
					System.out.println(c);
				}
			}
		} catch (Exception e) {
			System.err.println("Error al buscar compras por precio.");
		}
	}

	private static void nuevaCompra() {
		int idGame;
		int idPlayer;
		String cosa;
		Date fecha = null;
		double precio;
		EntidadCompras nuevaCompra;

		System.out.println("\n=== NUEVA COMPRA ===");
		System.out.println("---------------------------------");
		System.out.println("Ingrese el ID del juego:");
		idGame = Main.pedirInt();

		EntidadGames objGame = null;
		try {
			objGame = MetodosGames.obtenerPorId(EntidadGames.class, idGame);
		} catch (Exception e) {
			System.err.println("El juego no existe.");
		}

		System.out.println("Ingrese el ID del jugador:");
		idPlayer = Main.pedirInt();

		EntidadPlayer objPlayer = null;
		try {
			objPlayer = MetodosPlayer.obtenerPorId(EntidadPlayer.class, idPlayer);
		} catch (Exception e) {
			System.err.println("El jugador no existe.");
		}

		System.out.println("Ingrese el nombre de la cosa comprada:");
		cosa = sc.nextLine();

		System.out.println("Ingrese el precio de la compra:");
		precio = Main.pedirDouble();

		System.out.println("Ingrese la fecha de la compra (YYYY-MM-DD):");
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
				System.out.println("\n--- Compra guardada con éxito ---");
			} catch (Exception e) {
				System.err.println("Error al guardar la compra.");
			}
		} else {
			System.err.println("Error: Jugador o juego no encontrados.");
		}
	}

	private static void guardar(Object cosa) {
		try {
			ServiceDB.abrir();
			int id = (int) ServiceDB.guardar(cosa);
			System.out.println("Compra guardada con ID: " + id);
		} catch (Exception e) {
			System.err.println("Error al guardar la compra: ");
		} finally {
			ServiceDB.cerrar();
		}
	}
}