/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Seguros;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author javog
 */
public class CRUD_Seguros {

    ArrayList<Seguros> seg = new ArrayList<>();

    public ArrayList<Seguros> read() {
        leer();
        return seg;
    }

    public Seguros searchseg(String buscar) {
        leer();
        for (Seguros s : seg) {
            if (s.getDescripcion().equals(buscar) || s.getId() == Integer.parseInt(buscar)) {
                return s;
            }
        }
        return null;
    }

    public void IngresarSeguro(int Id, String descripcion, String fechaseguro, int monto) {
        seg.add(new Seguros(0, descripcion, fechaseguro, 0));
        grabar();
    }

    public void EliminarSeguro(int Id, String descripcion, String fechaseguro, int monto) {
        leer();
        for (Seguros s : seg) {
            if (s.getId() == Id) {
                seg.remove(seg.indexOf(s));
                grabar();
                break;
            }
        }
    }

    public void ModificarSeguro(Seguros q, Seguros q1) {
        leer();
        for (Seguros s : seg) {
            if (s.getId() == q.getId()) {
                s.setId(q1.getId());
                s.setDescripcion(q1.getDescripcion());
                s.setFechaseguro(q1.getFechaseguro());
                s.setMonto((q1.getMonto()));
                grabar();
                break;
            }
        }
    }

    public String VerSeguro() {
        String mensaje = "";
        leer();
        for (Seguros s : seg) {
            mensaje += "Id: " + s.getId() + "  Descripción: " + s.getDescripcion()
                    + "  Fecha: " + s.getFechaseguro() + "  Monto: " + s.getMonto() + "\n";
        }
        return mensaje;
    }

    private void leer() {
        //Limpiar ArrayList
        seg.clear();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("src/Seguros.txt");
            br = new BufferedReader(fr);
            String linea = null;
            String[] array = null;
            Seguros seguro = null;
            while ((linea = br.readLine()) != null) {
                array = linea.split(",");
                seguro = new Seguros();
                seguro.setId(array[0].charAt(0));
                seguro.setDescripcion(array[1].trim());
                seguro.setFechaseguro(array[2].trim());
                seguro.setMonto(array[3].charAt(0));
                seg.add(seguro);
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
            fr = new FileWriter("src/Seguros.txt");
            pw = new PrintWriter(fr);
            for (Seguros s : seg) {
                pw.println(s.getId() + "," + s.getDescripcion() + "," 
                        + s.getFechaseguro() + "," + s.getMonto());
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
