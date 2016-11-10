/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author javog
 */
public class Prestamos extends Seguros{

    private int foliopre;
    private String fechapre;
    private String resolucionpre;
    private String comentariopre;

    public Prestamos() {
    }

    public Prestamos(int foliopre, String fechapre, String resolucionpre, String comentariopre) {
        this.foliopre = foliopre;
        this.fechapre = fechapre;
        this.resolucionpre = resolucionpre;
        this.comentariopre = comentariopre;
    }

    public Prestamos(int foliopre, String fechapre, String resolucionpre, String comentariopre, int Id, String descripcion, String fechaseguro, int monto) {
        super(Id, descripcion, fechaseguro, monto);
        this.foliopre = foliopre;
        this.fechapre = fechapre;
        this.resolucionpre = resolucionpre;
        this.comentariopre = comentariopre;
    }

    public int getFoliopre() {
        return foliopre;
    }

    public void setFoliopre(int foliopre) {
        this.foliopre = foliopre;
    }

    public String getFechapre() {
        return fechapre;
    }

    public void setFechapre(String fechapre) {
        this.fechapre = fechapre;
    }

    public String getResolucionpre() {
        return resolucionpre;
    }

    public void setResolucionpre(String resolucionpre) {
        this.resolucionpre = resolucionpre;
    }

    public String getComentariopre() {
        return comentariopre;
    }

    public void setComentariopre(String comentariopre) {
        this.comentariopre = comentariopre;
    }
    
    
}
