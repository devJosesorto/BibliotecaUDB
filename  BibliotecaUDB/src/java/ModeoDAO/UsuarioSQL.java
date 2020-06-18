
package ModeoDAO;

import Conexion.Conexion;
import Modelo.Usuario;
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
public class UsuarioSQL extends Conexion {
    
    
     public List mostrar() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        ArrayList<Usuario> list = new ArrayList<>();

        String sql = "SELECT* FROM usuario";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Usuario usr = new Usuario();

                usr.setCodUsuario(rs.getInt(1));
                usr.setCorreo(rs.getString(2));
                usr.setPass(rs.getString(3));
                usr.setCod_Rol(rs.getString(4));
                list.add(usr);
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
     
     
     public boolean agregar(boolean pass, Usuario usr ) {

        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "INSERT INTO usuario (codUsuario, correo, pass, cod_Rol) VALUES(?,?,?,?)";

            try {
                int z = 1;
                ps = con.prepareStatement(sql);
                ps.setInt(z++, generarCod());
                ps.setString(z++, usr.getCorreo());
                ps.setString(z++, usr.getPass());
                ps.setString(z++, usr.getCod_Rol());
                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Agregar de la clase RolSQL");
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
    
     
    public void actualizar(boolean pass, Usuario usr) {
        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "UPDATE usuario SET codUsuario=?, correo=?, pass=?, cod_Rol=? WHERE codUsuario=? ";

            try {
                ps = con.prepareStatement(sql);
                int z = 1;
                ps.setString(z++, usr.getCorreo());
                ps.setString(z++, usr.getPass());
                ps.setString(z++, usr.getCod_Rol());
                ps.setInt(z++, usr.getCodUsuario());
                
                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Actualizar de la clase UsuarioSQL");

            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }
    }
    
    
     public void eliminar(boolean pass, String codUsuario) {
        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "DELETE FROM usuario WHERE codUsuario=? ";

            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, sql);
                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Eliminar de la clase UsuarioSQL");

            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }
    }
    
        
     public int generarCod() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT MAX(codUsuario) as cantidad FROM usuario";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                return Integer.parseInt(rs.getString("cantidad")) + 1;
            }
            return 0;
        } catch (SQLException e) {
            System.err.println(e);
            return 0;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    } 
    
}//cierre