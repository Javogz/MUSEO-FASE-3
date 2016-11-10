package Controlador;

import Modelo.Nacionalidades;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CRUD_Nacionalidades extends CRUD_Paises {

    ArrayList<Nacionalidades> nat = new ArrayList<>();

    public String CrearNacionalidad(int nac_cod, String nac_des) {
        nat.add(new Nacionalidades(nac_cod, nac_des));
        grabar();
        return "Su creación ha sido exitosa";
    }

    public ArrayList<Nacionalidades> read2() {
        leer();
        return nat;
    }

    public String ReadNationality() {
        leer();
        String mensaje = "Código    Descripción\n";
        for (Nacionalidades dat : nat) {
            mensaje += dat.getNac_cod() + "  " + dat.getNac_des() + "\n";
        }
        return mensaje;
    }
    
    public String ModifyNationality(Nacionalidades n, Nacionalidades n1) {
        leer();
        for (Nacionalidades dat : nat) {
            if (dat.getNac_cod() == n.getNac_cod()) {
                nat.set(nat.indexOf(dat), n1);
                break;
            }
        }
        grabar();
        return n.getNac_des() + " ha sido modificado exitosamente";
    }
    
    public String DeleteNationality(Nacionalidades n) {
        leer();
        for (Nacionalidades dat : nat) {
            if (dat.getNac_cod() == n.getNac_cod()) {
                nat.remove(nat.indexOf(dat));
                break;
            }
        }        
        grabar();
        return n.getNac_des() + " ha sido eliminado exitosamente";
    }
    
    public Nacionalidades search(String buscar) {
        leer();
        for (Nacionalidades n : nat) {
            if (n.getNac_des().equals(buscar) || n.getNac_cod() == Integer.parseInt(buscar)) {
                return n;
            }
        }
        return null;
    }
    
    private void leer() {
        nat.clear();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("src/Nacionalidades.txt");
            br = new BufferedReader(fr);
            String linea = null;
            String[] array = null;
            Nacionalidades nations = null;
            while ((linea = br.readLine()) != null) {
                array = linea.split(",");
                nations = new Nacionalidades();
                nations.setNac_cod(Integer.parseInt(array[0].trim()));
                nations.setNac_des(array[1].trim());
                nat.add(nations);
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
            fr = new FileWriter("src/Nacionalidades.txt");
            pw = new PrintWriter(fr);
            for (Nacionalidades g : nat) {
                pw.println(g.getNac_cod() + "," + g.getNac_des());
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
