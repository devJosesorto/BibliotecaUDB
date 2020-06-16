package Modelo;

/**
 *
 * @author Bolaines
 */
public class Categoria {

    private int codCategoria;
    private String nombre;

    public Categoria(int codCategoria, String nombre) {
        this.codCategoria = codCategoria;
        this.nombre = nombre;
    }

    public Categoria() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}// cierre
