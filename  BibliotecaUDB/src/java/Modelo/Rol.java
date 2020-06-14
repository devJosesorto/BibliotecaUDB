
package Modelo;

/**
 *
 * @author Bolaines
 */
public class Rol {
    
    private int codRol;
    private String nombre;
    private String permisos;

    public Rol(int codRol, String nombre, String permisos) {
        this.codRol = codRol;
        this.nombre = nombre;
        this.permisos = permisos;
    }

    public int getCodRol() {
        return codRol;
    }

    public void setCodRol(int codRol) {
        this.codRol = codRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }
    
     
    
} // cierre
