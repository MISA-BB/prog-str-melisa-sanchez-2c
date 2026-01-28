import java.util.Scanner;

public class ActividadSwitchCalculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion;
        double numero1;
        double numero2;
        double TOTAL= 0;

        System.out.println("Menú Calculadora \n");
        System.out.println(" 1) Sumar\n" +
                " 2) Restar\n" +
                " 3) Multiplicar\n" +
                " 4) Dividir \n");
        System.out.println("Elija una opción \n");
        opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Ingrese los numero a sumar: ");
                    numero1 = sc.nextDouble();
                    numero2 = sc.nextDouble();
                    TOTAL = numero1 + numero2;
                    System.out.println("El resultado: "+ TOTAL) ;
                    break;
                case 2:
                    System.out.println("Ingrese los numero a restar: ");
                    numero1 = sc.nextDouble();
                    numero2 = sc.nextDouble();
                    TOTAL = numero1 - numero2;
                    System.out.println("El resultado: "+ TOTAL) ;
                    break;
                case 3:
                    System.out.println("Ingrese los numero a multiplicar: ");
                    numero1 = sc.nextDouble();
                    numero2 = sc.nextDouble();
                    TOTAL = numero1 * numero2;
                    System.out.println("El resultado: "+ TOTAL) ;
                    break;
                case 4:
                    System.out.println("Ingrese los numero a dividir: ");
                    numero1 = sc.nextDouble();
                    numero2 = sc.nextDouble();
                    if (numero2 == 0){
                        System.out.println("No se puede dividir entre cero");
                    }else {
                        TOTAL = numero1 / numero2;
                        System.out.println("El resultado: "+ TOTAL) ;
                    }
                    break;
                default:
                    System.out.println("opcion invalida ");
        }
    }
}