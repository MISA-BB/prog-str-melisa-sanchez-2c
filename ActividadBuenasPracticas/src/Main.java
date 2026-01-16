import java.util.Scanner;

public class Main {

    public static int SUMA = 0;

    public static void main(String[] a) {

        Scanner sc = new Scanner(System.in);

        int numero = pedirEntero(sc, "Ingresa un número:");
        int resultado = SumaDeNumero(numero);
        System.out.println("Resultado:" + resultado);

    }

    public static int SumaDeNumero (int numero){
        for (int i=1;i<=numero;i++){
            SUMA += i;
        }
        return SUMA;
    }

    public static int pedirEntero (Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextInt();
    }


}