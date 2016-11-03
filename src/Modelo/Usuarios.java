package Modelo;
public class Usuarios {
    private String nombreUsuario;
    private String passwordUsuario;
    private String emailUsuario;
    
    //Constructores
    public Usuarios() {
    }
    public Usuarios(String nombreUsuario, String passwordUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.passwordUsuario = passwordUsuario;
    }
    public Usuarios(String nombreUsuario, String passwordUsuario, String emailUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.passwordUsuario = passwordUsuario;
        this.emailUsuario = emailUsuario;
    }

    //Mutadores
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }
    
}
