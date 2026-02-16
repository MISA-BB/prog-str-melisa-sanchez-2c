import java.util.Scanner;
public class InputValidator {
    private static Scanner sc= new Scanner(System.in);

    public static int idValido(){
        int id;
        do{
            System.out.println("Ingrese ID:");
            while (!sc.hasNextInt()){
                System.out.println("ERROR!: Debe ser númerico");
                sc.next();
            }
            id = sc.nextInt();
            if (id <= 0){
                System.out.println("El ID debe ser mayor a cero ");
            }
        } while (id <= 0);
        sc.nextLine();
        return id;
    }

    public static String nombreValido() {
        String nombre;
        do {
            System.out.print("Ingrese nombre: ");
            nombre = sc.nextLine();
            if (nombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
            }
        } while (nombre.isEmpty());
        return nombre;
    }

    public static double promedioValido(){
        double promedio;
        do {
            System.out.println("Ingrese el promedio: ");
            promedio = sc.nextDouble();
            if (promedio < 0 || promedio > 10){
                System.out.println("El promedio debe ser entre (0-10)");
            }
        }while (promedio < 0 || promedio > 10);
        sc.nextLine();
        return promedio;
    }

    public static boolean estadoValido() {
        String entrada;
        while (true) {
            System.out.print("¿Está activa? (true/false): ");
            entrada = sc.next().toLowerCase();
            if (entrada.equals("true")) return true;
            if (entrada.equals("false")) return false;
            System.out.println("Error: Ingrese exactamente 'true' o 'false'.");
        }
    }

}
