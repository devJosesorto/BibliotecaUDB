package Modelo;

/**
 *
 * @author Bolaines
 */
public class Departamento {

    private String codDepartamento;
    private String Nombre;

    public Departamento(String codDepartamento, String Nombre) {
        this.codDepartamento = codDepartamento;
        this.Nombre = Nombre;
    }

    public Departamento() {
    }

    public String getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(String codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

}
