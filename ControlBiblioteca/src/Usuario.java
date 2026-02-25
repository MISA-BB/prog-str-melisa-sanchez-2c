public class Usuario {
    String usuario;
    boolean tipoDeUsuario;
    int hora;

    public Usuario() {
    }

    public Usuario(String usuario, boolean tipoDeUsuario, int hora) {
        this.usuario = usuario;
        this.tipoDeUsuario = tipoDeUsuario;
        this.hora = hora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public boolean isTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(boolean tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }
}
