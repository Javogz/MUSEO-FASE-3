package Controlador;

import Modelo.Autores;
import Modelo.Usuarios;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CRUD_Autores {
    //arraylist
    ArrayList<Autores> datos=new ArrayList<>();
    
    //read
        public ArrayList<Autores> read() {
        leer();
        return datos;
        }    
    //read from file
        private void leer() {
        FileReader fr = null;
        BufferedReader br = null;
        datos.clear();
        try {
            fr = new FileReader("src/Autores.txt");
            br = new BufferedReader(fr);
            String linea = null;
            String[] array = null;
            Autores autor = null;
            while ((linea = br.readLine()) != null) {
                array = linea.split(",");
                autor = new Autores();
                autor.setAut_cod(Integer.parseInt(array[0]));
                autor.setAut_nom(array[1]);
                autor.setAut_f_nac(array[2]);
                autor.setAut_f_def(array[3]);
                datos.add(autor);
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
}
