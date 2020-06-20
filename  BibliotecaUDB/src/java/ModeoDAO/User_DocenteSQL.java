
package ModeoDAO;

import Conexion.Conexion;
import Modelo.Docente;
import Modelo.User_Docente;
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
public class User_DocenteSQL extends Conexion {
    
    
     public List mostrar()  {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        ArrayList<User_Docente> list = new ArrayList<>();

        String sql = "SELECT* FROM user_docente";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                User_Docente usrD = new User_Docente();

                usrD.setDocente_carnet(rs.getString(1));
                usrD.setUsuario_codUsuario(rs.getString(2));
                
                list.add(usrD);
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
    
     
       public Docente buscar(String ID) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM docente WHERE carnet="+ID;
        Docente doc = new Docente();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                

                doc.setCarnet(rs.getString(1));
                doc.setNombre(rs.getString(2));
                doc.setApellido(rs.getString(3));
                doc.setSexo(rs.getString(4));
                doc.setDepartamento(rs.getString(5));
              
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
        return doc;
    }
     
     
    public boolean agregar(boolean pass, User_Docente doc) {

        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "INSERT INTO user_docente (Docente_carnet, Usuario_codUsuario) VALUES(?,?,)";

            try {
                int z = 1;
                ps = con.prepareStatement(sql);
                //a cada objeto de tipo docente en el cod se debe de asignar "DOC" como valor, el metodo generarCod le proporciona el coorelativo
                ps.setString(z++, doc.getDocente_carnet()+ generarCod());
                ps.setString(z++, doc.getUsuario_codUsuario());
               
               

                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Agregar de la clase User_DocenteSQL");
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
     
    
    public void actualizar(boolean pass, User_Docente doc) {
        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "UPDATE user_docente SET docente_carnet, usuario_codUsuario WHERE docente_carnet=? ";

            try {
                ps = con.prepareStatement(sql);
                int z=1;
                ps.setString(z++, doc.getUsuario_codUsuario());
                ps.setString(z++, doc.getDocente_carnet());
                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Actualizar de la clase User_DocenteSQL");

            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }
    }
    
    
     public void eliminar(boolean pass, String docente_carnet) {
        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "DELETE FROM user_docente WHERE docente_carnet=? ";

            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, sql);
                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Eliminar de la clase User_DocenteSQL");

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

        String sql = "SELECT MAX(docente_carnet) as cantidad FROM user_docente";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                a = rs.getString(1);
            }

        } catch (SQLException e) {
            System.err.println(e);
            System.out.println("Error en generarCod de la clase DocenteSQL");

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
                string = "DOC" + i;
            } else {
                string = "DOC0" + i;
            }
        } else {
            string = "DOC00" + i;
        }

        return string;
    }   
    
}//Cierre
