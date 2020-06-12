package Modelo;

/**
 *
 * @author José Sorto
 */
public class Autor {
    private int codAutor;
    private String Nombre;
    private String Pais;

    public Autor(int codAutor, String Nombre, String Pais) {
        this.codAutor = codAutor;
        this.Nombre = Nombre;
        this.Pais = Pais;
    }

    public Autor() {
    }

    public int getCodAutor() {
        return codAutor;
    }

    public void setCodAutor(int codAutor) {
        this.codAutor = codAutor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }
    
    
    
}
