import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroUno = pedirEntero(scanner, "Ingrese un número");
        int numeroDos = pedirEntero(scanner, "Ingrese un número");
        int numeroTres = pedirEntero(scanner, "Ingrese un número");

        int suma = sumaFinal(numeroUno, numeroDos, numeroTres);
        System.out.println("suma=" + suma);
        System.out.println("prom=" + promedioFinal(suma));
    }
    public static int pedirEntero(Scanner scanner,String mensaje){
        System.out.println(mensaje);
        return scanner.nextInt();
    }
    public static int sumaFinal(int numeroUno, int numeroDos, int numeroTres ){
        return numeroUno + numeroDos + numeroTres;
    }
    public static double promedioFinal(int suma ){
        return suma / 3;
    }
}