import java.util.Scanner;
public class InputValitador {
    public String leerTextoNoVacio(Scanner sc, String msg){
        String valor = "";
        while (true){
            System.out.println(msg);
            valor = sc.nextLine();

            if(valor.isBlank()){ // isBlank revisa que mi variable no tenga espacios y tampoco este vacío
                System.out.println("ERROR!, el campo no puede quedar vacio, ingrese un valor.");
                continue;
            }
            if (valor.matches(".*\\d.*")){  //que sea igual a lo declarado (solo texto)
                System.out.println("ERROR!, el nombre no puede contener números");
                continue;
            }
            break;
        }
        return valor;
    }

        public double[] leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
            double[] calificacion = new double[3];
            int contador = 0;
            while (contador < 3) {
                System.out.println(msg + "" + (contador + 1) + ":");

                if (sc.hasNextDouble()) {
                    double entrada = sc.nextDouble();
                    if (entrada <= max && entrada >= min) {
                        calificacion[contador] = entrada;
                        contador++;
                    } else {
                        System.out.printf("ERROR! La calificación debe de estar entre %.1f y %.1f \n", min, max);
                    }
                } else {
                    System.out.println("ERROR!, el valor debe de ser númerico.");
                    sc.next();
                }

            }
            return calificacion;
        }

        public int leerIntEnRango(Scanner sc, String msg) {
            int valor;
            while (true) {
                System.out.println(msg);
                if (sc.hasNextInt()) {
                    valor = sc.nextInt();
                    if (valor >= 0 && valor <= 100) {
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
