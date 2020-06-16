package Modelo;

/**
 *
 * @author Bolaines
 */
public class Departamento {

    private int codDepartamento;
    private String Nombre;

    public Departamento(int codDepartamento, String Nombre) {
        this.codDepartamento = codDepartamento;
        this.Nombre = Nombre;
    }

    public Departamento() {
    }

    public int getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(int codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

}
