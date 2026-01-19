import java.util.Scanner;

public class Main {

    public static double VALORMULTI = 1.8;
    public static double PESOBAJO = 18.5;
    public static double PESOMEDIO = 25;
    public static double PESOALTO = 30;
    public static double VALORSUM  = 32;
    public static double PI = 3.14;

    public static void main(String[] args) {
        int Opcion;
        Scanner sc = new Scanner(System.in);

        do {
            Opcion = menuOpciones(sc, "\n Menú \n" +
                    "1.-Calcular IMC \n" +
                    "2.-Calcular área de un rectangulo \n" +
                    "3.-Convertir °C a °F \n" +
                    "4.-Calcular área circúlo \n" +
                    "5.-Salir \n" +
                    "Seleccione una opción del 1-5: ");

            opcionSwitch(sc, Opcion);

        } while (Opcion != 5);

        sc.close();
    }

    public static int menuOpciones(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        return sc.nextInt();
    }

    public static int opcionSwitch(Scanner sc, int Opcion) {
        switch (Opcion) {
            case 1:
                double peso = optenerDouble(sc, "Ingrese su peso en Kg: ");
                double altu = optenerDouble(sc, "Ingrese su altura en Metros: ");
                double IMC = calcuclarIMC(peso, altu);
                String clasificacionIMC = clasificarIMC(IMC);
                System.out.println("IMC: " + IMC + " - Clasificación: " + clasificacionIMC);
                break;
            case 2:
                double altura = optenerDouble(sc, "Ingrese la altura: ");
                double base = optenerDouble(sc, "Ingrese la base: ");
                double AreaRectangulo = CalcularAreaRectangulo(base, altura);
                System.out.println("El area de su rectangulo es: " + AreaRectangulo);
                break;
            case 3:
                double celsius = optenerDouble(sc, "Ingrese sus grados Celsius: ");
                double fahren = transformarAF(celsius);
                System.out.println("Su grados Celsius en Fahrenheit son: " + fahren);
                break;
            case 4:
                double radio = optenerDouble(sc, "Ingrese el radio: ");
                double AreaCirculo = CalcularAreaCirculo(radio);
                System.out.println("El area del circulo es de: " + AreaCirculo);
                break;
            case 5:
                System.out.println("ADIÓS :)");
                break;
            default:
                System.out.println("Porfavor seleccione una opción valida");
        }
        return 0;
    }

    /**
     * FORMÚLA PARA OBTENER EL IMC
     * @param peso --> PESO INGRESADO
     * @param altu --> ALTURA INGRESADA
     * @return
     */
    public static double calcuclarIMC(double peso, double altu) {
        return peso / (altu * altu);
    }

    /**
     * METODO PARA OBTENER UN NÚMERO DOUBLE DESDE LA CONSOLA
     * @param sc -->OBJETO PREVIAMENTE INSTANCIADO
     * @param mensaje --> MENSAJE A MOSTRAR EN CONSOLA
     * @return
     */
    public static double optenerDouble(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    /**
     * COMPRACIÓN DE PESO DEL IMC
     * @param IMC --> EL PESO
     * @return --> PESO MAS ALTO
     */
    public static String clasificarIMC(double IMC) {
        if (IMC < PESOBAJO) {
            return "Peso Bajo";
        } else if (IMC < PESOMEDIO) {
            return "Medio";
        } else if (IMC < PESOALTO) {
            return "Sobre peso";
        } else {
            return "Obesidad";
        }
    }

    /**
     * FOMÚLA PARA SACAR EL ÁREA DEL RECTANGULO
     * @param base --> VALOR INGRESADO DE LA BASE
     * @param altura --> VALOR INGRESADO DE LA ALTURA
     * @return -- > RESULTADO DEL ÁREA
     */
    public static double CalcularAreaRectangulo(double base, double altura) {
        return altura * base;
    }

    /**
     * FORMÚLA PARA PASAR DE CELSIUS A FAHRENHEIT
     * @param celsius -->VALOR INGRESADO DEL CELSIUS
     * @return -->RESULTADO DE LA CONVERCIÓN
     */
    public static double transformarAF(double celsius) {
        return (celsius * VALORMULTI) + VALORSUM;
    }

    /**
     * FORMÚLA PARA SACAR EL ÁREA DEL CIERCULO
     * @param radio -->VALOR INGRESADO DEL RADIO
     * @return -->RESULTADO DEL ÁREA
     */
    public static double CalcularAreaCirculo(double radio) {
        return PI * (radio * radio);
    }
}