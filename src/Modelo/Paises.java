package Modelo;
public class Paises {
    private int pais_cod;
    private String pais_nom;
    
    //Constructores
    
    public Paises() {
    }

    public Paises(int pais_cod) {
        this.pais_cod = pais_cod;
    }

    public Paises(int pais_cod, String pais_nom) {
        this.pais_cod = pais_cod;
        this.pais_nom = pais_nom;
    }

    //Mutadores
    public int getPais_cod() {
        return pais_cod;
    }

    public String getPais_nom() {
        return pais_nom;
    }

    //Setter
    public void setPais_cod(int pais_cod) {
        this.pais_cod = pais_cod;
    }

    public void setPais_nom(String pais_nom) {
        this.pais_nom = pais_nom;
    }
    
}
