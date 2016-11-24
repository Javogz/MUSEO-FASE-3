package Controlador;

import Modelo.TiposObra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRUD_TiposObra {

    ArrayList<TiposObra> datos = new ArrayList<>();

    //Instancia de Control_Conexion
    Control_Conexion con = new Control_Conexion();

    //leer
    public ArrayList Leer(String buscar) {
        try {
            datos.clear();
            con.conectar();
            PreparedStatement sql = con.estado().prepareStatement(""
                    + "SELECT * FROM TiposObra WHERE tipo_desc LIKE '%" + buscar + "%'");
            ResultSet res = sql.executeQuery();
            while (res.next()) {
                datos.add(new TiposObra(res.getInt("tipo_cod"), res.getString("tipo_desc")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD_TiposObra.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrar();
        }
        return datos;
    }

    //Insertar
    public boolean insert(String nombre) {
        try {
            con.conectar();
            PreparedStatement sql = con.estado().prepareStatement(""
                    + "INSERT INTO TiposObra(tipo_desc) VALUES('" + nombre + "')");
            sql.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD_TiposObra.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrar();
        }
        return false;
    }

    //Modificar
    public boolean update(int codigo, String nombre) {
        try {
            con.conectar();
            PreparedStatement sql = con.estado().prepareStatement(""
                    + "UPDATE TiposObra SET tipo_desc='" + nombre
                    + "' WHERE tipo_cod='" + codigo + "'");
            sql.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD_TiposObra.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrar();
        }
        return false;
    }

    //Eliminar
    public boolean delete(int codigo) {
        try {
            con.conectar();
            PreparedStatement sql = con.estado().prepareStatement(""
                    + "DELETE FROM TiposObra WHERE tipo_cod='" + codigo + "'");
            sql.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD_TiposObra.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrar();
        }
        return false;
    }
}
