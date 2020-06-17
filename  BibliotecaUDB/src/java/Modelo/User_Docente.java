
package Modelo;

/**
 *
 * @author Bolaines
 */
public class User_Docente {
    
    private String docente_carnet;
    private String usuario_codUsuario;
    

    public User_Docente(String docente_carnet, String usuario_codUsuario) {
        this.docente_carnet = docente_carnet;
        this.usuario_codUsuario = usuario_codUsuario;
    }
    
    
    public User_Docente() {
    }
    
    
    public String getDocente_carnet() {
        return docente_carnet;
    }

    public void setDocente_carnet(String docente_carnet) {
        this.docente_carnet = docente_carnet;
    }

    public String getUsuario_codUsuario() {
        return usuario_codUsuario;
    }

    public void setUsuario_codUsuario(String usuario_codUsuario) {
        this.usuario_codUsuario = usuario_codUsuario;
    }
    
    
    
    
}
