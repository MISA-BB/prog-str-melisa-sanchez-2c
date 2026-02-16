import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AlumnoService alumno = new AlumnoService();

        int opcion;

        do {

            System.out.println("\n⊹₊˚‧︵‿₊୨  MENÚ  ୧₊‿︵‧˚₊⊹");
            System.out.println("1) Alta alumno\n2) Buscar por ID (solo activos)\n3) Actualizar promedio por ID (solo activos)\n4) Baja lógica por ID\n5) Listar activos\n6) Reportes\n0) Salir");
            System.out.print("Seleccione una opción: \n");
            System.out.print("₊˚‧︵‿⊹₊˚‧︵‿₊୨ᰔ୧₊‿︵‧˚₊₊‿︵‧˚₊⊹\n");
          while (!sc.hasNextInt()){
              System.out.println("Opción invalida");
              sc.next();

          }
          opcion = sc.nextInt();
          switch (opcion){
              case 1:
                  alumno.alumnoNuevo(InputValidator.idValido(),InputValidator.nombreValido(),InputValidator.estadoValido(), InputValidator.promedioValido());
                  break;
              case 2:
                  alumno.buscarAlumno(InputValidator.idValido());
                  break;
              case 3:
                  int idAct = InputValidator.idValido();
                  double promAct = InputValidator.promedioValido();
                  alumno.actualizarPromedio(idAct, promAct);
                  break;
              case 4:
                  alumno.bajaLogica(InputValidator.idValido());
                  break;
              case 5:
                  alumno.listarActivas();
                  break;
              case 6:
                  alumno.imprimirReporte();
                  break;
              case 0:
                  System.out.println("Saliendo...");
                  break;
              default:
                  System.out.println("Opción invalidad seleccione (0-6)");

          }
        }while (opcion != 0);


    }
}