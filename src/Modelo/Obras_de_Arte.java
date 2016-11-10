package Modelo;

import java.util.Date;

public class Obras_de_Arte extends Autores{
    private int obras_cod;
    private String obras_tit;
    private String obras_f_crea;
    private String obras_f_ing;

    public Obras_de_Arte() {
    }

    public Obras_de_Arte(int obras_cod, String obras_tit, String obras_f_crea, String obras_f_ing) {
        this.obras_cod = obras_cod;
        this.obras_tit = obras_tit;
        this.obras_f_crea = obras_f_crea;
        this.obras_f_ing = obras_f_ing;
    }

    public int getObras_cod() {
        return obras_cod;
    }

    public void setObras_cod(int obras_cod) {
        this.obras_cod = obras_cod;
    }

    public String getObras_tit() {
        return obras_tit;
    }

    public void setObras_tit(String obras_tit) {
        this.obras_tit = obras_tit;
    }

    public String getObras_f_crea() {
        return obras_f_crea;
    }

    public void setObras_f_crea(String obras_f_crea) {
        this.obras_f_crea = obras_f_crea;
    }

    public String getObras_f_ing() {
        return obras_f_ing;
    }

    public void setObras_f_ing(String obras_f_ing) {
        this.obras_f_ing = obras_f_ing;
    }
    
    
}


