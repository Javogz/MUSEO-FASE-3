package Modelo;
public class Nacionalidades extends Paises{
    private int nac_cod;
    private String nac_des;

    public Nacionalidades() {
    }

    public Nacionalidades(int nac_cod, String nac_des) {
        this.nac_cod = nac_cod;
        this.nac_des = nac_des;
    }
    
    public Nacionalidades(int nac_cod, String nac_des, int pais_cod) {
        super(pais_cod);
        this.nac_cod = nac_cod;
        this.nac_des = nac_des;
    }

    public Nacionalidades(int nac_cod, String nac_des, int pais_cod, String pais_nom) {
        super(pais_cod, pais_nom);
        this.nac_cod = nac_cod;
        this.nac_des = nac_des;
    }

    public int getNac_cod() {
        return nac_cod;
    }

    public void setNac_cod(int nac_cod) {
        this.nac_cod = nac_cod;
    }

    public String getNac_des() {
        return nac_des;
    }

    public void setNac_des(String nac_des) {
        this.nac_des = nac_des;
    }
    
    
}
