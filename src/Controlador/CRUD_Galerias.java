package Controlador;

import Modelo.Autor;
import Modelo.Galerias;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CRUD_Galerias {
    //arraylist
    ArrayList<Galerias> datos=new ArrayList<>();
    
    //read
        public ArrayList<Galerias> read() {
        leer();
        return datos;
        }    
    //read from file
        private void leer() {
        FileReader fr = null;
        BufferedReader br = null;
        datos.clear();
        try {
            fr = new FileReader("src/Galerias.txt");
            br = new BufferedReader(fr);
            String linea = null;
            String[] array = null;
            Galerias galeria = null;
            while ((linea = br.readLine()) != null) {
                array = linea.split(",");
                galeria = new Galerias();
                galeria.setNombreGaleria(array[0]);
                galeria.setUbicacionGaleria(array[1]);
                datos.add(galeria);
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
