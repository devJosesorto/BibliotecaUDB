package Modelo;

/**
 *
 * @author Bolaines
 */
public class Prestamo {

    private int codPrestamo;
    private String fecha_entrega;
    private String fecha_devolucion;
    private String ejemplar_codEjemplar;
    private int usuario;
    private String mora;

    public Prestamo(int codPrestamo, String fecha_entrega, String fecha_devolucion, String ejemplar_codEjemplar, int usuario, String mora) {
        this.codPrestamo = codPrestamo;
        this.fecha_entrega = fecha_entrega;
        this.fecha_devolucion = fecha_devolucion;
        this.ejemplar_codEjemplar = ejemplar_codEjemplar;
        this.usuario = usuario;
        this.mora = mora;

    }

    public Prestamo() {
    }

    public int getCodPrestamo() {
        return codPrestamo;
    }

    public void setCodPrestamo(int codPrestamo) {
        this.codPrestamo = codPrestamo;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(String fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public String getEjemplar_codEjemplar() {
        return ejemplar_codEjemplar;
    }

    public void setEjemplar_codEjemplar(String ejemplar_codEjemplar) {
        this.ejemplar_codEjemplar = ejemplar_codEjemplar;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getMora() {
        return mora;
    }

    public void setMora(String mora) {
        this.mora = mora;
    }

}
