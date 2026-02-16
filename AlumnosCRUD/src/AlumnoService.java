public class AlumnoService {

    private Alumno[] alumnos = new Alumno[25];
    private int contador = 0;

    public void alumnoNuevo (int id, String nombre, boolean activo, double promedio){
        if (buscarPorId(id) != -1){
            System.out.println("ERROR!: El ID ya existe");
            return;
        }

        if (contador < alumnos.length){
            alumnos[contador++] = new Alumno(id, nombre, activo, promedio);
            System.out.println("Alumno agregado con éxito");
        } else {
            System.out.println("Error: Arreglo lleno (capacidad máxima 25)");
        }
    }

    private int buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (alumnos[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void buscarAlumno(int id) {
        int index = buscarPorId(id);
        if (index != -1 && alumnos[index].isActivo()) {
            System.out.println("Encontrado: " + alumnos[index]);
        } else {
            System.out.println("Alumno no encontrado o inactivo.");
        }
    }

    public void bajaLogica(int id) {
        int posicion = buscarPorId(id);

        if (posicion != -1 && alumnos[posicion].isActivo()) {
            alumnos[posicion].setActivo(false);
            System.out.println("Baja realizada con éxito");
        } else {
            System.out.println("No se encontró al alumno.");
        }
    }

    public void listarActivas() {
        boolean activas = false;
        for (int i = 0; i < contador; i++) {
            if (alumnos[i].isActivo()) {
                System.out.println(alumnos[i]);
                activas = true;
            }
        }
        if (!activas) System.out.println("No hay alumnos activos.");
    }

    public void actualizarPromedio(int id, double nuevoPromedio) {
        int promedio = buscarPorId(id);
        if (promedio != -1 && alumnos[promedio].isActivo()) {
            alumnos[promedio].setPromedio(nuevoPromedio);
            System.out.println("Promedio actualizado.");
        } else {
            System.out.println("No se puede actualizar (inactivo o inexistente).");
        }
    }


    public void imprimirReporte() {
        if (contador == 0) {
            System.out.println("No hay datos para generar reportes.");
            return;
        }

        double sumaPromedios = 0;
        int activos = 0;
        int promediosAltos = 0;
        Alumno mejor = null;
        Alumno peor = null;

        for (int i = 0; i < contador; i++) {
            if (alumnos[i].isActivo()) {
                double p = alumnos[i].getPromedio();
                sumaPromedios += p;
                activos++;

                if (p >= 8.0) promediosAltos++;


                if (mejor == null || p > mejor.getPromedio()) mejor = alumnos[i];
                if (peor == null || p < peor.getPromedio()) peor = alumnos[i];
            }
        }

        if (activos == 0) {
            System.out.println("No hay alumnos activos para el reporte.");
            return;
        }

        System.out.println("\n⊹₊˚‧︵‿₊୨  REPORTE GENERAL (ACTIVOS)  ୧₊‿︵‧˚₊⊹");
        System.out.println("1. Promedio general: " + (sumaPromedios / activos));
        System.out.println("2. Alumno con mayor promedio: " + mejor.getNombre() + " (ID: " + mejor.getId() + ", Prom: " + mejor.getPromedio() + ")");
        System.out.println("3. Alumno con menor promedio: " + peor.getNombre() + " (ID: " + peor.getId() + ", Prom: " + peor.getPromedio() + ")");
        System.out.println("4. Alumnos con promedio >= 8.0: " + promediosAltos);
        System.out.println("₊˚‧︵‿⊹₊˚‧︵‿₊୨ᰔ୧₊‿︵‧˚₊₊‿︵‧˚₊⊹\n");
    }
}