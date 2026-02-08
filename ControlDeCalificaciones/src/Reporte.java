public class Reporte {
    public static void imprimirReporte(String nombre, double[] calificacion,double promedio, int asistencia, double calificacionFinal, boolean proyecto, String estado ){
        System.out.println("------------------------------");
        System.out.println("REPORTE DEL ALUMNO " + nombre.toUpperCase());
        System.out.printf("Parciales: [%.1f, %.1f, %.1f]\n", calificacion[0], calificacion[1], calificacion[2]);
        System.out.println("Promedio Parciales: "+ promedio);
        System.out.println("Asistencia: "+ asistencia);
        System.out.println("Proyecto entregado: "+(proyecto ? "si" : "no"));
        System.out.println("Calificación final: "+ calificacionFinal);
        System.out.println("Estado Final: "+estado);
        System.out.println("------------------------------");
    }
}
