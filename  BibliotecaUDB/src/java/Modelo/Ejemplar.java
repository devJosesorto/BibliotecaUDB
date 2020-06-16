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
    private String departamento_codDpto;

    public Ejemplar(String codEjemplar, String cod_Libro, String ubicacion, String estado, String departamento_codDpto) {
        this.codEjemplar = codEjemplar;
        this.cod_Libro = cod_Libro;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.departamento_codDpto = departamento_codDpto;
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

    public String getDepartamento_codDpto() {
        return departamento_codDpto;
    }

    public void setDepartamento_codDpto(String departamento_codDpto) {
        this.departamento_codDpto = departamento_codDpto;
    }

}
