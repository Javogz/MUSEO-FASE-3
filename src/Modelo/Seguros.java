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
public class Seguros {
    
    private int Id;
    private String descripcion;
    private String fechaseguro;
    private int monto;

    public Seguros() {
    }

    public Seguros(int Id, String descripcion, String fechaseguro, int monto) {
        this.Id = Id;
        this.descripcion = descripcion;
        this.fechaseguro = fechaseguro;
        this.monto = monto;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaseguro() {
        return fechaseguro;
    }

    public void setFechaseguro(String fechaseguro) {
        this.fechaseguro = fechaseguro;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
    
    
}
