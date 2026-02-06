import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InputValidator validador = new InputValidator();
        ShippingCalculator calculadora = new ShippingCalculator();
        Ticket ticket = new Ticket();

        double peso = leerDoubleEnRango(sc, "Ingresa el peso en kg (0.1 - 50.0):", 0.1, 50.0, validador);
        int distancia = leerIntEnRango(sc, "Ingresa la distancia (1 - 2000):", 1, 2000, validador);
        int servicio = leerIntEnRango(sc, "Tipo servicio (1-Estandar 2-Express):", 1, 2, validador);
        boolean remota = leerBoolean(sc, "¿Zona remota? (true/false)", validador);

        double subtotal = calculadora.calcularSubtotal(peso, distancia, servicio, remota);
        double iva = calculadora.calcularIVA(subtotal);
        calculadora.calcularTotal(subtotal, iva);

        imprimirTicket(servicio, peso, distancia, remota, ticket, calculadora);
    }

    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max, InputValidator valor) {
        return valor.leerDoubleEnRango(sc, msg, min, max);
    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max, InputValidator valor) {
        return valor.leerIntEnRango(sc, msg, min, max);
    }

    public static boolean leerBoolean(Scanner sc, String msg, InputValidator valor) {
        return valor.leerBoolean(sc, msg);
    }

    public static void imprimirTicket(int servicio, double peso, int distancia, boolean remota, Ticket ticket, ShippingCalculator calculadora) {
        ticket.imprimirTicket(servicio, peso, distancia, remota, calculadora);
    }
}