package Modelo;

public class TiposObra {

    private int tipo_cod;
    private String tipo_desc;

    public TiposObra() {
    }

    public TiposObra(int tipo_cod, String tipo_desc) {
        this.tipo_cod = tipo_cod;
        this.tipo_desc = tipo_desc;
    }

    public int getTipo_cod() {
        return tipo_cod;
    }

    public void setTipo_cod(int tipo_cod) {
        this.tipo_cod = tipo_cod;
    }

    public String getTipo_desc() {
        return tipo_desc;
    }

    public void setTipo_desc(String tipo_desc) {
        this.tipo_desc = tipo_desc;
    }
    
    
}
