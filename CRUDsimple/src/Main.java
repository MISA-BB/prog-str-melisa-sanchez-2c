import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PersonaService gestion = new PersonaService();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n⊹₊˚‧︵‿₊୨  MENÚ  ୧₊‿︵‧˚₊⊹");
            System.out.println("1) Alta\n2) Buscar por ID\n3) Baja lógica\n4) Listar activas\n5) Actualizar nombre\n0) Salir");
            System.out.print("Ingrese una opción: \n");
            System.out.print("₊˚‧︵‿⊹₊˚‧︵‿₊୨ᰔ୧₊‿︵‧˚₊₊‿︵‧˚₊⊹\n");

            while (!sc.hasNextInt()) {
                System.out.println("Opción inválida.");
                sc.next();
            }
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    gestion.agregarPersona(InputValidator.leerIdValido(), InputValidator.leerNombreValido(), InputValidator.leerEstadoValido());
                    break;
                case 2:
                    gestion.buscarPersona(InputValidator.leerIdValido());
                    break;
                case 3:
                    gestion.bajaLogica(InputValidator.leerIdValido());
                    break;
                case 4:
                    gestion.listarActivas();
                    break;
                case 5:
                    int idAct = InputValidator.leerIdValido();
                    String nomAct = InputValidator.leerNombreValido();
                    gestion.actualizarNombre(idAct, nomAct);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 0);
    }
}