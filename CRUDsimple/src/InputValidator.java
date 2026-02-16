import java.util.Scanner;

public class InputValidator {
    // Scanner estático para ser usado por todos los métodos de la clase
    private static Scanner sc = new Scanner(System.in);

    // Obliga al usuario a ingresar un número entero positivo
    public static int leerIdValido() {
        int id;
        do {
            System.out.print("Ingrese ID: ");
            // Si lo que escribió no es un número...
            while (!sc.hasNextInt()) {
                System.out.println("Error: Debe ser un número.");
                sc.next(); // Limpia la basura escrita para intentar de nuevo
            }
            id = sc.nextInt();
            if (id <= 0) System.out.println("El ID debe ser mayor a cero.");
        } while (id <= 0); // Repite si es negativo o cero
        sc.nextLine(); // Limpia el buffer (el 'Enter' que queda en memoria)
        return id;
    }

    // Obliga al usuario a escribir algo (que no sea un campo vacío)
    public static String leerNombreValido() {
        String nombre;
        do {
            System.out.print("Ingrese nombre: ");
            nombre = sc.nextLine().trim(); // trim() quita espacios al inicio y final
            if (nombre.isEmpty()) System.out.println("El nombre no puede estar vacío.");
        } while (nombre.isEmpty());
        return nombre;
    }

    // Solo permite las palabras exactas "true" o "false"
    public static boolean leerEstadoValido() {
        String entrada;
        while (true) {
            System.out.print("¿Está activa? (true/false): ");
            entrada = sc.next().toLowerCase(); // Convierte a minúsculas
            if (entrada.equals("true")) return true;
            if (entrada.equals("false")) return false;
            System.out.println("Error: Ingrese exactamente 'true' o 'false'.");
        }
    }
}