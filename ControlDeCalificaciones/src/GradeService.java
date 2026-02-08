public class GradeService {
    public double calcularPromedio (double calificacion1, double calificacion2, double calificacion3){
        return (calificacion1+calificacion2+calificacion3)/3;
    }

    public double calcularFinal (double promedio, double asistencia){
        return (promedio * 0.7) + (asistencia * 0.3);
    }

    public String determinarEstado (double promedioFinal, int asistencia, boolean entregoProyecto){
        if (asistencia < 80){
            return "Reprobado por asistencia";
        }
        if (!entregoProyecto){
            return "Reprobado por no entregar proyecto";
        }else if (promedioFinal >= 70){
            return "APROBADO";
        }else {
            return "Reprobado por calificación";
        }
    }

}
