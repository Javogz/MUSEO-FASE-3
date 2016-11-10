/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author javog
 */
public class Personal extends Usuarios{
    private String nombre;
    private int id;
    private String rut;
    private String direccion;
    private String username;
    private String password;

    public Personal() {
    }

    public Personal(String nombre, int id, String rut, String direccion, String username, String password) {
        this.nombre = nombre;
        this.id = id;
        this.rut = rut;
        this.direccion = direccion;
        this.username = username;
        this.password = password;
    }

    public Personal(String nombre, int id, String rut, String direccion, String username, String password, String nombreUsuario, String passwordUsuario) {
        super(nombreUsuario, passwordUsuario);
        this.nombre = nombre;
        this.id = id;
        this.rut = rut;
        this.direccion = direccion;
        this.username = username;
        this.password = password;
    }

    public Personal(String nombre, int id, String rut, String direccion, String username, String password, String nombreUsuario, String passwordUsuario, String emailUsuario) {
        super(nombreUsuario, passwordUsuario, emailUsuario);
        this.nombre = nombre;
        this.id = id;
        this.rut = rut;
        this.direccion = direccion;
        this.username = username;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
