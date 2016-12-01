package Modelo;

public class ObrasArtejavo extends TiposObra {

    private int obra_cod;
    private String obra_titulo;
    private String obra_fcrea;
    private String obra_fllega;

    public ObrasArtejavo() {
    }

    public ObrasArtejavo(int obra_cod, String obra_titulo, String obra_fcrea, String obra_fllega, String tipo_desc) {
        super(tipo_desc);
        this.obra_cod = obra_cod;
        this.obra_titulo = obra_titulo;
        this.obra_fcrea = obra_fcrea;
        this.obra_fllega = obra_fllega;
    }

    public ObrasArtejavo(int obra_cod, String obra_titulo) {
        this.obra_cod = obra_cod;
        this.obra_titulo = obra_titulo;
    }

    public ObrasArtejavo(int obra_cod, String obra_titulo, String obra_fcrea, String obra_fllega) {
        this.obra_cod = obra_cod;
        this.obra_titulo = obra_titulo;
        this.obra_fcrea = obra_fcrea;
        this.obra_fllega = obra_fllega;
    }

    public int getObra_cod() {
        return obra_cod;
    }

    public void setObra_cod(int obra_cod) {
        this.obra_cod = obra_cod;
    }

    public String getObra_titulo() {
        return obra_titulo;
    }

    public void setObra_titulo(String obra_titulo) {
        this.obra_titulo = obra_titulo;
    }

    public String getObra_fcrea() {
        return obra_fcrea;
    }

    public void setObra_fcrea(String obra_fcrea) {
        this.obra_fcrea = obra_fcrea;
    }

    public String getObra_fllega() {
        return obra_fllega;
    }

    public void setObra_fllega(String obra_fllega) {
        this.obra_fllega = obra_fllega;
    }

}
