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
    private String departamento_codDepartamento;

    public Ejemplar(String codEjemplar, String cod_Libro, String ubicacion, String estado, String departamento_codDepartamento) {
        this.codEjemplar = codEjemplar;
        this.cod_Libro = cod_Libro;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.departamento_codDepartamento = departamento_codDepartamento;
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

    public String getdepartamento_codDepartamento() {
        return departamento_codDepartamento;
    }

    public void setdepartamento_codDepartamento(String departamento_codDpto) {
        this.departamento_codDepartamento = departamento_codDepartamento;
    }

}
