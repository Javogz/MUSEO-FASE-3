package Modelo;

public class Administrador extends Usuarios {

    private int pwAdmin = 123123;
    private String emAdmin = "javo@live.cl";

    public Administrador() {
    }

    public Administrador(String nombreUsuario, String passwordUsuario,
            String emailUsuario) {
        super(nombreUsuario, passwordUsuario, emailUsuario);
    }

    public Administrador(String nombreUsuario, String passwordUsuario,
            String emailUsuario, String emAdmin, int pwAdmin) {
        super(nombreUsuario, passwordUsuario, emailUsuario);
        this.pwAdmin = pwAdmin;
        this.emAdmin = emAdmin;
    }

    public int getPwAdmin() {
        return pwAdmin;
    }

    public void setPwAdmin(int pwAdmin) {
        this.pwAdmin = pwAdmin;
    }

    public String getEmAdmin() {
        return emAdmin;
    }

    public void setEmAdmin(String emAdmin) {
        this.emAdmin = emAdmin;
    }

    Galerias gal = new Galerias();
}
