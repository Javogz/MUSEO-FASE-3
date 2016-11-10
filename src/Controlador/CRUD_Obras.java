package Controlador;

import Modelo.Obras_de_Arte;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CRUD_Obras {

    ArrayList<Obras_de_Arte> obras = new ArrayList<>();

    public String Create(int obras_cod, String obras_tit,
            String obras_f_crea, String obras_f_ing) {
        obras.add(new Obras_de_Arte(obras_cod, obras_tit,
                obras_f_crea, obras_f_ing));
        grabar();
        return "Creación exitosa";
    }

    public ArrayList<Obras_de_Arte> read() {
        leer();
        return obras;
    }

    public String Reads() {
        leer();
        String mensaje = "Código   Título   FechaCreaciín   FechaIngreso\n";
        for (Obras_de_Arte dato : obras) {
            mensaje += dato.getObras_cod() + "  "
                    + dato.getObras_tit() + "  "
                    + dato.getObras_f_crea() + "  "
                    + dato.getObras_f_ing() + "\n";
        }
        return mensaje;
    }

    public String Modify(Obras_de_Arte o, Obras_de_Arte o1) {
        leer();
        for (Obras_de_Arte dato : obras) {
            if (dato.getObras_cod() == o.getObras_cod()) {
                obras.set(obras.indexOf(dato), o1);
                break;
            }
        }
        grabar();
        return o.getObras_tit() + " ha sido modificado existosamente";
    }

    public String Delete(Obras_de_Arte o) {
        leer();
        for (Obras_de_Arte dato : obras) {
            if (dato.getObras_cod() == o.getObras_cod()) {
                obras.remove(obras.indexOf(dato));
                break;
            }
        }
        grabar();
        return o.getObras_tit() + " ha sido eliminado exitosamente";
    }

    public Obras_de_Arte search(String buscar) {
        leer();
        for (Obras_de_Arte dato : obras) {
            if (dato.getObras_tit().equals(buscar) || dato.getObras_cod()
                    == Integer.parseInt(buscar)) {
                return dato;
            }
        }
        return null;
    }

    //Metodos internos
    private void leer() {
        obras.clear();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("src/Obras_Arte.txt");
            br = new BufferedReader(fr);
            String linea = null;
            String[] array = null;
            Obras_de_Arte obrasdearte = null;
            while ((linea = br.readLine()) != null) {
                array = linea.split(",");
                //galeria = new Galeria(array[0].trim(), array[1].trim());
                obrasdearte = new Obras_de_Arte();
                obrasdearte.setObras_cod(Integer.parseInt(array[0].trim()));
                obrasdearte.setObras_tit(array[1].trim());
                obrasdearte.setObras_f_crea(array[2].trim());
                obrasdearte.setObras_f_ing(array[3].trim());
                obras.add(obrasdearte);
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

    private void grabar() {
        FileWriter fr = null;
        PrintWriter pw = null;
        try {
            fr = new FileWriter("src/ObrasDeArte.txt");
            pw = new PrintWriter(fr);
            for (Obras_de_Arte a : obras) {
                pw.println(a.getObras_cod() + "," + a.getObras_tit() + ","
                        + a.getObras_f_crea() + "," + a.getObras_f_ing());
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
