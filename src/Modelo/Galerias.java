package Modelo;

public class Galerias {

    private String ubicacionGaleria;
    private String nombreGaleria;

    public Galerias() {
    }

    public Galerias(String ubicacionGaleria, String nombreGaleria) {
        this.ubicacionGaleria = ubicacionGaleria;
        this.nombreGaleria = nombreGaleria;
    }

    public String getUbicacionGaleria() {
        return ubicacionGaleria;
    }

    public void setUbicacionGaleria(String ubicacionGaleria) {
        this.ubicacionGaleria = ubicacionGaleria;
    }

    public String getNombreGaleria() {
        return nombreGaleria;
    }

    public void setNombreGaleria(String nombreGaleria) {
        this.nombreGaleria = nombreGaleria;
    }

}
