import java.util.Scanner;

public class Main {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int opcion;
		do {
			mostrarMenu();
			opcion = pedirInt();
			switch (opcion) {
			case 0:
				System.err.println("Ha salido del programa.");
				break;
			case 1:
				MainCompras.mainCompras();
				break;
			case 2:
				MainGame.mainGame();
				break;
			case 3:
				MainPlayer.mainPlayer();
				break;
			case 4:
				MainCompras.mostrarTodasLasCompra();
				MainGame.mostrarTodosLosJuegos();
				MainPlayer.mostrarTodosLosJugadores();
				break;
			case 5:
				try {
					MetodosCompras.eliminarTablaCompras();
					MetodosGames.eliminarTabla();
					MetodosPlayer.eliminarTabla();
				} catch (Exception e) {
					System.err.println("Error al eliminar la tabla");
				}
				break;
			default:
				System.err.println("Opción no válida.");
				break;
			}
		} while (opcion != 0);
		sc.close();
	}

	public static void mostrarMenu() {
		System.out.println(Colores.GREEN + Colores.BOLD + "===== MENÚ PRINCIPAL =====" + Colores.BLUE);
		System.out.println(Colores.WHITE + "1. Compras");
		System.out.println("2. Game");
		System.out.println("3. Player");
		System.out.println("4. Consultar todas las tablas");
		System.out.println("5. Eliminar todas las tablas");
		System.out.println(Colores.RED + "0. Salir");
		System.out.println(Colores.GREEN + "==========================" + Colores.BLUE);
	}

	public static int pedirInt() {
		int numero = 0;
		boolean entradaValida = false;

		while (!entradaValida) {
			System.out.println("Ingrese un número entero válido:");
			if (sc.hasNextInt()) {
				numero = sc.nextInt();
				sc.nextLine();
				entradaValida = true;
			} else {
				System.out.println("Entrada inválida. Por favor, ingrese un número entero válido.");
				sc.next();
			}
		}
		return numero;
	}

	public static double pedirDouble() {
		double numero = 0;
		boolean entradaValida = false;

		while (!entradaValida) {
			System.out.println("Ingrese un número válido:");
			if (sc.hasNextDouble()) {
				numero = sc.nextDouble();
				sc.nextLine();
				entradaValida = true;
			} else {
				System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
				sc.next();
			}
		}
		return numero;
	}

}
