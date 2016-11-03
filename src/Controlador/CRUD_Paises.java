package Controlador;

import Modelo.Paises;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CRUD_Paises {

    //Arreglo de Paises(Vector)ArrayList
    ArrayList<Paises> datos = new ArrayList<>();

    public CRUD_Paises() {
        leer();
    }

    //Create
    public void create(int pais_cod, String pais_nom) {
        datos.add(new Paises(pais_cod, pais_nom));
        grabar();
    }

    //Read
    public String read() {
        leer();
        String mensaje = "Lista de Paises\n";
        for (Paises p : datos) {
            mensaje += "Código: " + p.getPais_cod()
                    + "    Nombre: " + p.getPais_nom() + "\n";
        }
        return mensaje;
    }

    //Update
    public void update(Paises p, int cod) {
        leer();
        for (Paises p1 : datos) {
            if (p1.getPais_cod() == cod) {
                datos.set(datos.indexOf(p1), p);
                grabar();
                break;
            }
        }
    }

    //Delete
    public void delete(Paises p) {
        leer();
        for (Paises p1 : datos) {
            if (p1.getPais_cod() == p.getPais_cod()) {
                datos.remove(datos.indexOf(p1));
                break;
            }
        }
    }

    //Search
    public Paises search(String buscar) {
        for (Paises p : datos) {
            if (p.getPais_nom().equals(buscar)
                    || p.getPais_cod() == Integer.parseInt(buscar)) {
                return p;
            }
        }
        return null;
    }

    private void grabar() {
        FileWriter fr = null;
        PrintWriter pw = null;
        try {
            fr = new FileWriter("src/Paises.txt");
            pw = new PrintWriter(fr);
            for (Paises p : datos) {
                pw.println(p.getPais_cod() + ","
                        + p.getPais_nom());

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

    private void leer() {
        FileReader fr = null;
        BufferedReader br = null;
        datos.clear();
        try {
            fr = new FileReader("src/Paises.txt");
            br = new BufferedReader(fr);
            String linea = null;
            String[] array = null;
            Paises paises = null;
            while ((linea = br.readLine()) != null) {
                array = linea.split(",");
                paises = new Paises();
                paises.setPais_cod(Integer.parseInt(array[0].trim()));
                paises.setPais_nom(array[1].trim());
                datos.add(paises);
               

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
