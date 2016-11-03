package Controlador;

import Modelo.Paises;
import Modelo.Usuarios;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CRUD_Usuarios {
    //ArrayList
    ArrayList<Usuarios> datos = new ArrayList<>();
    //Constructores
    public CRUD_Usuarios() {
        leer();
    }
    //Create
    public void create(String nombre, String password,
            String email) {
        datos.add(new Usuarios(nombre, password, email));
        grabar();
    }
    //Read
    public ArrayList<Usuarios> read() {
        leer();
        return datos;
    }
    //Update
     public void update(Usuarios u, String email) {
         leer();
        for (Usuarios u1 : datos) {
            if (u1.getEmailUsuario().equals(email)) {
                datos.set(datos.indexOf(u1), u);
                grabar();
                break;
            }
        }
    }
    //Delete
      public void delete(Usuarios u) {
          leer();
        for (Usuarios u1 : datos) {
            if (u1.getEmailUsuario().equals(u.getEmailUsuario())) {
                datos.remove(datos.indexOf(u1));
                grabar();
                break;
            }
        }
        
    }
    //Search
       public Usuarios search(String buscar) {
           leer();
        for (Usuarios u : datos) {
            if (u.getNombreUsuario().equals(buscar)) {
                return u;
            }
        }
        return null;
    }
    //Verificar Usuario
        public boolean verificar(Usuarios u){
            
            for (Usuarios u1:datos) {
              if(u1.getNombreUsuario().equals(u.getNombreUsuario())
                 && u1.getPasswordUsuario().equals(u.getPasswordUsuario())){
                    return true;
              }
            }
            return false;
        }
    /**
     * ****Archivos de Texto****
     */
    //Leer
    private void leer() {
        FileReader fr = null;
        BufferedReader br = null;
        datos.clear();
        try {
            fr = new FileReader("src/Usuarios.txt");
            br = new BufferedReader(fr);
            String linea = null;
            String[] array = null;
            Usuarios usuario = null;
            while ((linea = br.readLine()) != null) {
                array = linea.split(",");
                usuario = new Usuarios();
                usuario.setNombreUsuario(array[0]);
                usuario.setPasswordUsuario(array[1]);
                usuario.setEmailUsuario(array[2]);
                datos.add(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
                fr.close();
                br.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

    }
    //Grabar
    private void grabar() {
        FileWriter fr = null;
        PrintWriter pw = null;
        try {
            fr = new FileWriter("src/Usuarios.txt");
            pw = new PrintWriter(fr);
            for (Usuarios u : datos) {
                pw.println(u.getNombreUsuario() + ","
                        + u.getPasswordUsuario()+","
                        + u.getEmailUsuario());
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
                fr.close();
                pw.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

    }
}
