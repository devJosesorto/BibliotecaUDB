package Modelo;

/**
 *
 * @author Bolaines
 */
public class Ejemplar {

    private String codEjemplar;
    private String cod_Libro;
    private String ubicacion;
    private String estado;
    private String cod_Departamento;

    public Ejemplar(String codEjemplar, String cod_Libro, String ubicacion, String estado, String cod_Departamento) {
        this.codEjemplar = codEjemplar;
        this.cod_Libro = cod_Libro;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.cod_Departamento = cod_Departamento;
    }

    public Ejemplar() {
    }

    public String getCodEjemplar() {
        return codEjemplar;
    }

    public void setCodEjemplar(String codEjemplar) {
        this.codEjemplar = codEjemplar;
    }

    public String getCod_Libro() {
        return cod_Libro;
    }

    public void setCod_Libro(String cod_Libro) {
        this.cod_Libro = cod_Libro;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCod_Departamento() {
        return cod_Departamento;
    }

    public void setCod_Departamento(String cod_Departamento) {
        this.cod_Departamento = cod_Departamento;
    }

    
}
