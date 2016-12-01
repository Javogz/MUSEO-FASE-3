package Controlador;

import Modelo.ObrasArtejavo;
import Modelo.TiposObra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRUD_ObrasArte {

    Control_Conexion con = new Control_Conexion();
    ArrayList<ObrasArtejavo> datos = new ArrayList();

    public boolean insert(String titulo, String fcrea, String fllega, int aut_cod, int tipo_cod) {
        try {
            con.conectar();
            PreparedStatement sql = con.estado().prepareStatement(""
                    + "INSERT INTO Obras_arte(obra_titulo, obra_fcrea, obra_fllega, aut_cod, tipo_cod)"
                    + " VALUES('" + titulo + "','" + fcrea + "','" + fllega + "','" + aut_cod + "','" + tipo_cod + "')");
            sql.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD_TiposObra.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrar();
        }
        return false;
    }

    public ArrayList Leer(String buscar) {
        try {
            datos.clear();
            con.conectar();
            PreparedStatement sql = con.estado().prepareStatement(""
                    + "SELECT obra_cod, obra_titulo, obra_fcrea, obra_fllega, tipo_desc "
                    + "FROM obras_arte INNER JOIN tiposobra "
                    + "ON obras_arte.tipo_cod = tiposobra.tipo_cod "
                    + "WHERE obra_titulo LIKE '%" + buscar + "%'");
            ResultSet res = sql.executeQuery();
            while (res.next()) {
                datos.add(new ObrasArtejavo(res.getInt("obra_cod"), res.getString("obra_titulo"),
                        res.getString("obra_fcrea"), res.getString("obra_fllega"), res.getString("tipo_desc")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD_TiposObra.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrar();
        }
        return datos;
    }
}
