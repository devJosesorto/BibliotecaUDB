package Modelo;

/**
 *
 * @author Bolaines
 */
public class Editorial {

    private int codEditorial;
    private String nombre;
    private String pais;

    public Editorial(int codEditorial, String nombre, String pais) {
        this.codEditorial = codEditorial;
        this.nombre = nombre;
        this.pais = pais;
    }

    public Editorial() {
    }

    public int getCodEditorial() {
        return codEditorial;
    }

    public void setCodEditorial(int codEditorial) {
        this.codEditorial = codEditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
