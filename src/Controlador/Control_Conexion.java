package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Control_Conexion {

    private String usuario;
    private String password;
    private String url;
    
    //objeto tipo conexion
    Connection con=null;

    public Control_Conexion() {
        this.usuario="root";
        this.password="";
        this.url="jdbc:mysql://127.0.0.1/museojavo101";
    } 
    
    //conectar
    
    public void conectar(){
        try {
            //llamar al driver
            Class.forName("com.mysql.jdbc.Driver");
            //cadena de conexion
            con=DriverManager.getConnection(url, usuario, password);
        } catch (SQLException ex) {
            Logger.getLogger(Control_Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Control_Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //desconectar
    
    public void cerrar(){
        con=null;
    }
    
    //estado conexion
    
    public Connection estado(){
        return con;
    }
}
