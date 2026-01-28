import java.util.Scanner;

public class ActividadIfElseTarifa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int edad;
        boolean esEstudiante;

        System.out.println("Ingrese su edad: ");
        edad = sc.nextInt();
        System.out.println("Eres estudiante? (TRUE/FALSE)");
        esEstudiante = sc.hasNextBoolean();

        if (edad >= 0 && edad <= 120) {
            if (edad < 12) {
                System.out.println("tarifa = 50");
                System.out.println("Es estudiante: " + (esEstudiante ? "Si" : "No"));
                System.out.println("su edad es: " + edad);
            } else {
                if (edad >= 12 && edad <= 17) {
                    if (esEstudiante == true) {
                        System.out.println("tarifa = 60");
                        System.out.println("Es estudiante: " + (esEstudiante ? "Si" : "No"));
                        System.out.println("su edad es: " + edad);
                    } else {
                        System.out.println("tarifa = 80");
                        System.out.println("Es estudiante: " + (esEstudiante ? "Si" : "No"));
                        System.out.println("su edad es: " + edad);
                    }
                }


            }
            if (edad >= 18) {
                if (esEstudiante == true) {
                    System.out.println("tarifa = 90");
                    System.out.println("Es estudiante: " + (esEstudiante ? "Si" : "No"));
                    System.out.println("su edad es: " + edad);
                } else {
                    System.out.println("tarifa = 120");
                    System.out.println("Es estudiante: " + (esEstudiante ? "Si" : "No"));
                    System.out.println("su edad es: " + edad);
                }
            }
        } else {
            System.out.println("Edad invalida");
        }

    }
}