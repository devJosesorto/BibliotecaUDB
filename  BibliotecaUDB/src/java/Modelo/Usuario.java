
package Modelo;

/**
 *
 * @author Bolaines
 */
public class Usuario {
    
    private int codUsuario;
    private String correo;
    private String pass;
    private String cod_Rol;

    public Usuario(int codUsuario, String correo, String pass, String cod_Rol) {
        this.codUsuario = codUsuario;
        this.correo = correo;
        this.pass = pass;
        this.cod_Rol = cod_Rol;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCod_Rol() {
        return cod_Rol;
    }

    public void setCod_Rol(String cod_Rol) {
        this.cod_Rol = cod_Rol;
    }
    
    
    
    
}
