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
public class Restauradores extends Personal{

    public Restauradores() {
    }

    public Restauradores(String nombre, int id, String rut, String direccion, String username, String password) {
        super(nombre, id, rut, direccion, username, password);
    }

    public Restauradores(String nombre, int id, String rut, String direccion, String username, String password, String nombreUsuario, String passwordUsuario) {
        super(nombre, id, rut, direccion, username, password, nombreUsuario, passwordUsuario);
    }

    public Restauradores(String nombre, int id, String rut, String direccion, String username, String password, String nombreUsuario, String passwordUsuario, String emailUsuario) {
        super(nombre, id, rut, direccion, username, password, nombreUsuario, passwordUsuario, emailUsuario);
    }
    
}
