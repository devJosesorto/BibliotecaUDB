
package Modelo;

/**
 *
 * @author Bolaines
 */
public class User_Estudiante {
    
    private String estudiante_carnet;
    private String usuario_codUsuario;

    public User_Estudiante(String estudiante_carnet, String usuario_codUsuario) {
        this.estudiante_carnet = estudiante_carnet;
        this.usuario_codUsuario = usuario_codUsuario;
    }
    
    
     public User_Estudiante() {
    
    }
    

    public String getEstudiante_carnet() {
        return estudiante_carnet;
    }

    public void setEstudiante_carnet(String estudiante_carnet) {
        this.estudiante_carnet = estudiante_carnet;
    }

    public String getUsuario_codUsuario() {
        return usuario_codUsuario;
    }

    public void setUsuario_codUsuario(String usuario_codUsuario) {
        this.usuario_codUsuario = usuario_codUsuario;
    }
    
    
    
    
}//Cierre   
