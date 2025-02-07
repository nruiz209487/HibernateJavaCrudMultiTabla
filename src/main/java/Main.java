import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		int opcion;
		do {
			mainMenu();
			opcion = sc.nextInt();
			sc.nextLine();
			switch (opcion) {
			case 0:
				System.err.println("Ha salido del programa.");
				break;
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;
			default:
				System.err.println("Opción no válida.");
				break;
			}
		} while (opcion != 0);
		sc.close();
	}

	private static void mainMenu() {
		System.out.println("Elija una opción:");
		System.out.println("1. Player");
		System.out.println("2. Compras");
		System.out.println("3. Games");
		System.out.println("0. Salir");
	}
}
