package Controlador;

import Modelo.Autores;
import Modelo.TiposObra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRUD_Autoresjavo {

    ArrayList<Autores> datos = new ArrayList<>();

    //Instancia de Control_Conexion
    Control_Conexion con = new Control_Conexion();

    //leer
    public ArrayList Leer(String buscar) {
        try {
            datos.clear();
            con.conectar();
            PreparedStatement sql = con.estado().prepareStatement(""
                    + "SELECT * FROM Autores WHERE aut_nombre LIKE '%" + buscar + "%' ORDER BY aut_nombre");
            ResultSet res = sql.executeQuery();
            while (res.next()) {
                datos.add(new Autores(res.getInt("aut_cod"), res.getString("aut_nombre")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD_TiposObra.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrar();
        }
        return datos;
    }

}
