import java.lang.invoke.VarHandle;
import java.util.Scanner;
public class Main{
    public static void main (String[] args) {
        GradeService gradeService = new GradeService();
        Scanner sc = new Scanner(System.in);
        InputValitador valitador = new InputValitador();
        Reporte reporte = new Reporte();
        double MAX = 100;
        double MIN = 0;


        String nombre = valitador.leerTextoNoVacio(sc, "Ingrese el nombre: ");
        double[] calificacionParcial = valitador.leerDoubleEnRango (sc ,"Ingrese la calificación " ,MIN, MAX );
        int asistencia = valitador.leerIntEnRango(sc, "Ingrese la asistencia entre 1-100: ");
        boolean entregaProyecto = valitador.leerBoolean(sc, "Entrego proyecto?   true/false");

        double promedio = gradeService.calcularPromedio(calificacionParcial[0],calificacionParcial[1],calificacionParcial[2]);
        double notaFinal = gradeService.calcularFinal(promedio, asistencia);
        String estado = gradeService.determinarEstado(notaFinal, asistencia, entregaProyecto);

        reporte.imprimirReporte(nombre, calificacionParcial, promedio, asistencia,notaFinal, entregaProyecto,estado);

    }

}