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
public class Devoluciones extends Seguros {

    private String doc;
    private int folio;
    private String fecha;
    private String resolucion;
    private String comentario;

    public Devoluciones() {
    }

    public Devoluciones(String doc, int folio, String fecha, String resolucion, String comentario) {
        this.doc = doc;
        this.folio = folio;
        this.fecha = fecha;
        this.resolucion = resolucion;
        this.comentario = comentario;
    }

    public Devoluciones(String doc, int folio, String fecha, String resolucion, String comentario,
            int Id, String descripcion, String fechaseguro, int monto) {
        super(Id, descripcion, fechaseguro, monto);
        this.doc = doc;
        this.folio = folio;
        this.fecha = fecha;
        this.resolucion = resolucion;
        this.comentario = comentario;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}
