package Modelo;

/**
 *
 * @author José Sorto
 */
public class Libro {
    
    private String codLibro;
    private String titulo;
    private int codCategoria;
    private int codAutor;
    private int codEditorial;
    private String codISBN;

    public Libro() {
    }

    public Libro(String codLibro, String titulo, int codCategoria, int codAutor, int codEditorial, String codISBN) {
        this.codLibro = codLibro;
        this.titulo = titulo;
        this.codCategoria = codCategoria;
        this.codAutor = codAutor;
        this.codEditorial = codEditorial;
        this.codISBN = codISBN;
    }

    public String getCodLibro() {
        return codLibro;
    }

    public void setCodLibro(String codLibro) {
        this.codLibro = codLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public int getCodAutor() {
        return codAutor;
    }

    public void setCodAutor(int codAutor) {
        this.codAutor = codAutor;
    }

    public int getCodEditorial() {
        return codEditorial;
    }

    public void setCodEditorial(int codEditorial) {
        this.codEditorial = codEditorial;
    }

    public String getCodISBN() {
        return codISBN;
    }

    public void setCodISBN(String codISBN) {
        this.codISBN = codISBN;
    }

    
}
