package Modelo;

public class Autor extends Nacionalidad{
    private int aut_cod;
    private String aut_nom;
    private String aut_f_nac;
    private String aut_f_def;
    
    //Constructores

    public Autor() {
    }

    public Autor(int aut_cod, String aut_nom, String aut_f_nac, String aut_f_def) {
        this.aut_cod = aut_cod;
        this.aut_nom = aut_nom;
        this.aut_f_nac = aut_f_nac;
        this.aut_f_def = aut_f_def;
    }
    
    //Mutadores

    public int getAut_cod() {
        return aut_cod;
    }

    public void setAut_cod(int aut_cod) {
        this.aut_cod = aut_cod;
    }

    public String getAut_nom() {
        return aut_nom;
    }

    public void setAut_nom(String aut_nom) {
        this.aut_nom = aut_nom;
    }

    public String getAut_f_nac() {
        return aut_f_nac;
    }

    public void setAut_f_nac(String aut_f_nac) {
        this.aut_f_nac = aut_f_nac;
    }

    public String getAut_f_def() {
        return aut_f_def;
    }

    public void setAut_f_def(String aut_f_def) {
        this.aut_f_def = aut_f_def;
    }
    
    
}
