public class Alumno {
    private int id;
    private String nombre;
    private double promedio;
    private boolean activo;

    public Alumno() {
    }

    public Alumno(int id, String nombre, boolean activo, double promedio) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
        this.promedio = promedio;
    }

    public Alumno(int id, String nombre, boolean activo) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Alumno" +
                "Id=" + id +
                ", | Nombre='" + nombre + '\'' +
                ", | Promedio=" + promedio +
                ", | Estado=" + (activo ? "Activa" : "Inactiva");
    }
}
