/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Museos;
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
public class CRUD_Museos {
    ArrayList<Museos> mu= new ArrayList<>();
    
    public ArrayList<Museos> read() {
        leer();
        return mu;
    }    
    public Museos search(String buscar) {
        leer();
        for (Museos m : mu) {
            if (m.getId()==Integer.parseInt(buscar) || m.getNombre().equals(buscar)) {
                return m;
            }
        }
        return null;
    }    
    public void Nuevo(int id,String nombre,String direccion,String contacto,String pais) {
        mu.add(new Museos(id,nombre,direccion,contacto,pais));
        grabar();
    }

    public void Eliminar(int id,String nombre,String direccion,String contacto,String pais) {
        leer();
        for (Museos m : mu) {
            if(m.getId()==id && m.getNombre().equals(nombre) && m.getDireccion().equals(direccion) && m.getContacto().equals(contacto) && m.getPais().equals(pais)){
                mu.remove(mu.indexOf(m));
                grabar();
                break;
            }
        }
    }

    public void Modificar(Museos m, Museos m1) {
        leer();
        for (Museos m3 : mu) {
            if(m.getId()==m3.getId() && m.getNombre().equals(m3.getNombre()) && m.getDireccion().equals(m3.getDireccion()) && m.getContacto().equals(m3.getContacto()) && m.getPais().equals(m3.getPais())){
                m.setId(m1.getId());
                m.setNombre(m1.getNombre());
                m.setDireccion(m1.getDireccion());
                m.setContacto(m1.getContacto());
                m.setPais(m1.getPais());
                grabar();
                break;
            }
        }
    }

    
    private void leer() {
        //Limpiar ArrayList
        mu.clear();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("src/Museos.txt");
            br = new BufferedReader(fr);
            String linea = null;
            String[] array = null;
            Museos m = null;
            while ((linea = br.readLine()) != null) {
                array = linea.split(",");
                m = new Museos();
                m.setId(Integer.parseInt(array[0].trim()));
                m.setNombre(array[1].trim());
                m.setDireccion(array[2].trim());
                m.setContacto(array[3].trim());
                m.setPais(array[3].trim());
                mu.add(m);
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
            for (Museos m : mu) {
                pw.println(m.getId()+ "," + m.getNombre()+ "," +m.getDireccion()+","+m.getContacto()+","+m.getPais());
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
