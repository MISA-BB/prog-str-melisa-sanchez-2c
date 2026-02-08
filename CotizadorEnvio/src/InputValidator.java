import java.util.Scanner;

                public class InputValidator {
                    public double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
                        double valor;
                        while (true) {
                            System.out.println(msg);
                            if (sc.hasNextDouble()) {
                                valor = sc.nextDouble();
                                if (valor >= min && valor <= max) {
                                    return valor;
                                }
                                System.out.println("el valor esta fuera de rango");
                            } else {
                                System.out.println("el valor no es numerico");
                                sc.next();
                            }
                        }
                    }

                    public int leerIntEnRango(Scanner sc, String msg, int min, int max) {
                        int valor;
                        while (true) {
                            System.out.println(msg);
                            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor >= min && valor <= max) {
                    return valor;
                }
                System.out.println("el valor esta fuera de rango");
            } else {
                System.out.println("el valor no es un numero entero");
                sc.next();
            }
        }
    }

    public boolean leerBoolean(Scanner sc, String msg) {
        while (true) {
            System.out.println(msg);
            if (sc.hasNextBoolean()) {
                return sc.nextBoolean();
            } else {
                System.out.println("responda con (true/false)");
                sc.nextLine(); // Limpiar el buffer
                sc.next();     // Consumir el token inválido
            }
        }
    }
}