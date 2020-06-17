
package ModeoDAO;

import Conexion.Conexion;
import Modelo.User_Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bolaines
 */
public class User_EstudianteSQL extends Conexion {
    
    
     public List mostrar()  {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        ArrayList<User_Estudiante> list = new ArrayList<>();

        String sql = "SELECT* FROM user_Estudiante";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                User_Estudiante usrE = new User_Estudiante();

                usrE.setEstudiante_carnet(rs.getString(1));
                usrE.setUsuario_codUsuario(rs.getString(2));
                
                list.add(usrE);
            }

        } catch (SQLException e) {
            System.err.println(e);

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return list;
    }
    
     
    public boolean agregar(boolean pass, User_Estudiante est) {

        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "INSERT INTO user_estudiante (estudiante_carnet, Usuario_codUsuario) VALUES(?,?,)";

            try {
                int z = 1;
                ps = con.prepareStatement(sql);
                
                ps.setString(z++, est.getEstudiante_carnet()+ generarCod());
                ps.setString(z++, est.getUsuario_codUsuario());
               
             
                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Agregar de la clase User_EstudianteSQL");
                return false;

            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }
        return true;
    } 
     
    
    public void actualizar(boolean pass, User_Estudiante est) {
        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "UPDATE user_estudiante  SET estudiante_carnet, usuario_codUsuario WHERE estudiante_carnet=? ";

            try {
                ps = con.prepareStatement(sql);
                int z=1;
                ps.setString(z++, est.getUsuario_codUsuario());
                ps.setString(z++, est.getEstudiante_carnet());
                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Actualizar de la clase User_EstudianteSQL");

            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }
    }
    
    
     public void eliminar(boolean pass, String estudiante_carnet) {
        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "DELETE FROM user_estudiante WHERE estudiante_carnet=? ";

            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, sql);
                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Eliminar de la clase User_EstudianteSQL");

            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }
    }
    
    
   public String generarCod() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String a = null;

        String sql = "SELECT MAX(estudiante_carnet) as cantidad FROM user_estudiante";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                a = rs.getString(1);
            }

        } catch (SQLException e) {
            System.err.println(e);
            System.out.println("Error en generarCod de la clase User_EstudianteSQL");

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        String string = a;
        string = string.substring(string.length() - 3);

        int i = 0;
        i = Integer.parseInt(string) + 1;

        if (i > 9) {
            if (i > 99) {
                string = "EST" + i;
            } else {
                string = "EST0" + i;
            }
        } else {
            string = "EST00" + i;
        }

        return string;
    }   
    
}//Cierre
