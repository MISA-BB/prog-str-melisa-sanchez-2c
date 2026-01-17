import java.util.Scanner;
public class Main {
    public static int SUMA = 0;
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int numero = pedirEntero(sc, "Ingresa un número:");
        int resultado = SumaDeNumero(numero);
        System.out.println("Resultado:" + resultado);
    }
    /**
     * sentencia repetitiva
     * @param numero -->numero ingresado
     * @return --> suma
     */
    public static int SumaDeNumero (int numero){
        for (int i=1;i<=numero;i++){
            SUMA += i;
        }
        return SUMA;
    }
    /**
     *
     * @param sc -->objeto previamente instanciado
     * @param mensaje --> Mensaje a mostrar en consola
     * @return
     */
    public static int pedirEntero (Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextInt();
    }
}
/**
 * 1. Declaracion de variables descriptivas
 * 2. No estan en mayúsculas
 * 3. Llaves mal puestas
 * 4. Orden de lectura
 * 5. Sintaxis
 * 6. Formato de espaciado
 * 7. Declaraciones en una sola línea
 * 8. Nunca cierra Scanner
 */