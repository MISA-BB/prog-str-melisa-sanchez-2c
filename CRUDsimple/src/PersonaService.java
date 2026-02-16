public class PersonaService {
    private Persona[] personas = new Persona[20];
    private int contador = 0;

    public boolean agregarPersona(int id, String nombre, boolean activa) {
        if (buscarIndicePorId(id) != -1) {
            System.out.println("Error: El ID ya existe.");
            return false;
        }
        if (contador < personas.length) {
            personas[contador++] = new Persona(id, nombre, activa);
            System.out.println("Persona agregada con éxito.");
            return true;
        }
        System.out.println("Arreglo lleno.");
        return false;
    }

    public int buscarIndicePorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (personas[i].getId() == id) return i;
        }
        return -1;
    }


    public void buscarPersona(int id) {
        int index = buscarIndicePorId(id);
        if (index != -1 && personas[index].isActiva()) {
            System.out.println("Encontrada: " + personas[index]);
        } else {
            System.out.println("Persona no encontrada o inactiva.");
        }
    }

    public void bajaLogica(int id) {
        int index = buscarIndicePorId(id);
        if (index != -1 && personas[index].isActiva()) {
            personas[index].setActiva(false);
            System.out.println("Baja realizada con éxito.");
        } else {
            System.out.println("No se pudo dar de baja (no existe o ya es inactiva).");
        }
    }

    public void listarActivas() {
        boolean hayActivas = false;
        for (int i = 0; i < contador; i++) {
            if (personas[i].isActiva()) {
                System.out.println(personas[i]);
                hayActivas = true;
            }
        }
        if (!hayActivas) System.out.println("No hay personas activas.");
    }

    public void actualizarNombre(int id, String nuevoNombre) {
        int index = buscarIndicePorId(id);
        if (index != -1 && personas[index].isActiva()) {
            personas[index].setNombre(nuevoNombre);
            System.out.println("Nombre actualizado.");
        } else {
            System.out.println("No se puede actualizar (inactiva o inexistente).");
        }
    }
}