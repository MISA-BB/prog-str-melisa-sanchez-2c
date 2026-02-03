import java.util.Random;
import java.util.Scanner;

public class Main {

    static int fueraDeRango = 0;
    static int noNumerico = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int intentos = 0;
        int limiteIntentos = 7;
        boolean gano = false;
        int secreto = random.nextInt(100) + 1; //sirve para generar un numero entero entre 1... 100

        System.out.println("Adivina el número entre (1-100). Tienes " + limiteIntentos + " intentos.");

        while (intentos < limiteIntentos) {
            System.out.println("Intento: " + (intentos + 1));

            if (sc.hasNextInt()) {
                int numero = sc.nextInt();
                if (numero < 1 || numero > 100) {
                    System.out.println("El número " + numero + " está fuera de rango (1-100).");
                    fueraDeRango++;
                    intentos++;
                }
                else {
                    intentos++;
                    if (numero == secreto) {
                        System.out.println("¡Ganaste! Lo lograste en el intento: " + intentos);
                        gano = true;
                        break;
                    } else if (numero > secreto) {
                        System.out.println("El número secreto es MENOR.");
                    } else {
                        System.out.println("El número secreto es MAYOR.");
                    }
                }
            }
            else {
                String error = sc.next();
                System.out.println("El dato '" + error + "' no es numérico.");
                noNumerico++;
                intentos++;
            }
        }
        if (!gano) { //bandera para saber si gano o perdio
            System.out.println("Perdiste. El número era: " + secreto);
        }

        System.out.println("Numero de intentos: "+ intentos);
        System.out.println("Errores de rango: " + fueraDeRango);
        System.out.println("Datos no numéricos: " + noNumerico);
    }
}