package Controlador;

import Modelo.Administrador;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CRUD_Administrador {

    ArrayList<Administrador> adm = new ArrayList<>();

    public Administrador verificar_usuario(int clave) {
        leer();
        for (Administrador a : adm) {
            if (a.getPwAdmin()== clave) {
                return a;
            }
        }
        return null;
    }

    public ArrayList<Administrador> read() {
        leer();
        return adm;
    }

    public Administrador search(String buscar) {
        leer();
        for (Administrador se : adm) {
            if (se.getNombreUsuario().equals(buscar) || se.getEmAdmin().equals(buscar)) {
                return se;
            }
        }
        return null;
    }

    public String CheckAdm(String email, String password, String emAdmin, int pwAdmin) {
        leer();
        for (Administrador check : adm) {
            if (check.getEmailUsuario().equals(email)
                    && check.getPasswordUsuario().equals(password)
                    && check.getEmAdmin().equals(email)
                    && check.getPwAdmin() == pwAdmin) {
                return check.getNombreUsuario();
            }
        }
        return "";
    }

    public void NewAdm(String nombre, String password, String email, String emAdmin, int pwAdmin) {
        adm.add(new Administrador(nombre, password, email, emAdmin, pwAdmin));
        grabar();
    }

    public void DeleteAdm(String email, int password) {
        leer();
        for (Administrador del : adm) {
            if (del.getEmAdmin().equals(email) && del.getPwAdmin() == password) {
                adm.remove(adm.indexOf(del));
                grabar();
                break;
            }
        }
    }

    public void ModifyAdm(Administrador m, Administrador m1) {
        leer();
        for (Administrador modi : adm) {
            if ((modi.getEmailUsuario().equals(m.getEmailUsuario())
                    || modi.getNombreUsuario().equals(m.getNombreUsuario()))
                    && modi.getPasswordUsuario().equals(m.getPasswordUsuario())
                    && modi.getEmAdmin().equals(m.getEmAdmin())
                    && modi.getPwAdmin() == m.getPwAdmin()) {
                modi.setNombreUsuario(m1.getNombreUsuario());
                modi.setPasswordUsuario(m1.getPasswordUsuario());
                modi.setEmailUsuario(m1.getEmailUsuario());
                modi.setEmAdmin(m1.getEmAdmin());
                modi.setPwAdmin(m1.getPwAdmin());
                grabar();
                break;
            }
        }
    }

    public String SeeAdm() {
        String mensaje = "";
        leer();
        for (Administrador see : adm) {
            mensaje += "Nombre: " + see.getNombreUsuario()
                    + "  Password: " + see.getPasswordUsuario()
                    + "  Email: " + see.getEmailUsuario()
                    + "  Email Admin: " + see.getEmAdmin()
                    + "  Password Admin: " + see.getPwAdmin() + "\n";
        }
        return mensaje;
    }

    private void leer() {
        //Limpiar ArrayList
        adm.clear();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("src/Administrador.txt");
            br = new BufferedReader(fr);
            String linea = null;
            String[] array = null;
            Administrador admin = null;
            while ((linea = br.readLine()) != null) {
                array = linea.split(",");
                admin = new Administrador();
                admin.setNombreUsuario(array[0].trim());
                admin.setPasswordUsuario(array[1].trim());
                admin.setEmailUsuario(array[2].trim());
                admin.setEmAdmin(array[3].trim());
                admin.setPwAdmin(Integer.parseInt(array[4].trim()));
                adm.add(admin);
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
            fr = new FileWriter("src/Administrador.txt");
            pw = new PrintWriter(fr);
            for (Administrador a : adm) {
                pw.println(a.getNombreUsuario() + "," + a.getPasswordUsuario()
                        + "," + a.getEmailUsuario() + "," + a.getEmAdmin()
                        + "," + a.getPwAdmin());
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
