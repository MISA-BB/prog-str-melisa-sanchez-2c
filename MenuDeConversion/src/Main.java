import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        int acumulador1 = 0, acumulador2 = 0, acumulador3 = 0, acumulador4 = 0;
        do {
            System.out.println("MENÚ DE CONVERSIONES");
            System.out.println("1) °C a °F");
            System.out.println("2) °F a °C");
            System.out.println("3) Km a Millas");
            System.out.println("4) Millas a Km");
            System.out.println("5) Salir");
            System.out.println("Elija una opción (1-5)");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                if (opcion >= 1 && opcion <= 4) {
                    double valor = valorNumerico(sc);
                    switch (opcion) {
                        case 1:
                            System.out.println(valor + "°C son" + ((valor * 9 / 5) + 32) + "°F");
                            acumulador1++;
                            break;
                        case 2:
                            System.out.println(valor + "°F son " + ((valor - 32) * 5 / 9) + "°C");
                            acumulador2++;
                            break;
                        case 3:
                            System.out.println(valor + " Km son " + (valor * 0.621371) + " Millas");
                            acumulador3++;
                            break;
                        case 4:
                            System.out.println(valor + " Millas son " + (valor / 0.621371) + " Km");
                            acumulador4++;
                            break;

                    }
                } else if (opcion == 5) {
                    System.out.println("Saliendo...");
                } else {
                    System.out.println("ERROR, Opcion fuera del rango (1-5)");
                }
            } else {
                System.out.println("Error: Debe ingresar un número del rango (1-5)");
                sc.next();
            }

        } while (opcion != 5);

        int total = acumulador1 + acumulador2 + acumulador3 + acumulador4;
        System.out.println("Total de conversiones: " + total);
        System.out.println("1) °C a °F: " + acumulador1);
        System.out.println("2) °F a °C: " + acumulador2);
        System.out.println("3) Km a Millas: " + acumulador3);
        System.out.println("4) Millas a Km: " + acumulador4);
    }

    public static double valorNumerico(Scanner sc) {
        while (true) {
            System.out.println("Ingrese el valor a convertir: ");
            if (sc.hasNextDouble()) {
                return sc.nextDouble();
            } else {
                String error = sc.next();
                System.out.println("ERROR " + error + " no es un numero valido");
            }
        }
    }
}