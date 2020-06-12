package Modelo;

/**
 *
 * @author José Sorto
 */
public class Libro {
    
    private String codLibro;
    private String titulo;
    private String codCategoria;
    private String codAutor;
    private String codEditorial;
    private String codISBN;

    public Libro(String codLibro, String titulo, String codCategoria, String codAutor, String codEditorial, String codISBN) {
        this.codLibro = codLibro;
        this.titulo = titulo;
        this.codCategoria = codCategoria;
        this.codAutor = codAutor;
        this.codEditorial = codEditorial;
        this.codISBN = codISBN;
    }

    public Libro() {
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

    public String getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(String codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getCodAutor() {
        return codAutor;
    }

    public void setCodAutor(String codAutor) {
        this.codAutor = codAutor;
    }

    public String getCodEditorial() {
        return codEditorial;
    }

    public void setCodEditorial(String codEditorial) {
        this.codEditorial = codEditorial;
    }

    public String getCodISBN() {
        return codISBN;
    }

    public void setCodISBN(String codISBN) {
        this.codISBN = codISBN;
    }
    
    
    
}
