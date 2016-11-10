/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Museos;
import Modelo.Personal;
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
public class CRUD_Personal {

    ArrayList<Personal> per = new ArrayList<>();

    public ArrayList<Personal> read() {
        leer();
        return per;
    }

    public Personal search(String buscar) {
        leer();
        for (Personal p : per) {
            if (p.getId() == Integer.parseInt(buscar) || p.getNombre().equals(buscar)) {
                return p;
            }
        }
        return null;
    }

    public void Nuevo(String nombre, int id, String rut, String direccion, String username, String password) {
        per.add(new Personal(nombre, 0, rut, direccion, username, password));
        grabar();
    }

    public void Eliminar(String nombre, int id, String rut, String direccion, String username, String password) {
        leer();
        for (Personal p : per) {
            if (p.getId() == id && p.getNombre().equals(nombre) &&p.getDireccion().equals(direccion) && p.getRut().equals(rut) && p.getUsername().equals(username)&& p.getPassword().equals(password)) {
                per.remove(per.indexOf(p));
                grabar();
                break;
            }
        }
    }

    public void Modificar(Personal p, Personal p1) {
        leer();
        for (Personal p2 : per) {
            if (p.getId() == p2.getId() && p.getNombre().equals(p2.getNombre()) && p.getDireccion().equals(p2.getDireccion()) && p.getRut().equals(p2.getRut()) && p.getUsername().equals(p2.getUsername()) && p.getPassword().equals(p2.getPassword())) {
                p.setId(p1.getId());
                p.setNombre(p1.getNombre());
                p.setDireccion(p1.getDireccion());
                p.setRut(p1.getRut());
                p.setUsername(p1.getUsername());
                p.setPassword(p1.getPassword());
                grabar();
                break;
            }
        }
    }

    private void leer() {
        //Limpiar ArrayList
        per.clear();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("src/Museos.txt");
            br = new BufferedReader(fr);
            String linea = null;
            String[] array = null;
            Personal p = null;
            while ((linea = br.readLine()) != null) {
                array = linea.split(",");
                p = new Personal();
                p.setId(Integer.parseInt(array[0].trim()));
                p.setNombre(array[1].trim());
                p.setRut(array[2].trim());
                p.setDireccion(array[3].trim());
                p.setUsername(array[4].trim());
                p.setPassword(array[5].trim());
                per.add(p);
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
            fr = new FileWriter("src/Museos.txt");
            pw = new PrintWriter(fr);
            for (Personal p : per) {
                pw.println(p.getId() + "," + p.getNombre() + "," + p.getRut() + "," + p.getDireccion() + "," + p.getUsername()+","+p.getPassword());
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
