
package ModeoDAO;

import Conexion.Conexion;
import Modelo.Ejemplar;
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
public class EjemplarSQL extends Conexion {
    
    
     public List Mostrar()  {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        ArrayList<Ejemplar> list = new ArrayList<>();

        String sql = "SELECT * FROM ejemplar";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ejemplar ejemplar = new Ejemplar();

                ejemplar.setCodEjemplar(rs.getString(1));
                ejemplar.setCod_Libro(rs.getString(2));
                ejemplar.setUbicacion(rs.getString(3));
                ejemplar.setEstado(rs.getString(4));
                ejemplar.setCod_Departamento(rs.getString(5));
                list.add(ejemplar);
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
     
     public Ejemplar buscar(String ID) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        Ejemplar ejemplar = new Ejemplar();
        
        String sql = "SELECT * FROM ejemplar WHERE codEjemplar='"+ID+"'";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
               
                ejemplar.setCodEjemplar(rs.getString(1));
                ejemplar.setCod_Libro(rs.getString(2));
                ejemplar.setUbicacion(rs.getString(3));
                ejemplar.setEstado(rs.getString(4));
                ejemplar.setCod_Departamento(rs.getString(5));
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
        return ejemplar;
    }
    
     
     public void Agregar(boolean pass, Ejemplar ejem) {

        if (pass){
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "INSERT INTO ejemplar (codEjemplar, cod_Libro, Ubicacion, Estado, departamento_codDepartamento) VALUES(?,?,?,?,?)";

            try {
                int z = 1;
                ps = con.prepareStatement(sql);
                //a cada objeto de tipo Ejemplar en el cod se debe de asignar "EJE" como valor, el metodo generarCod le proporciona el correlativo
                ps.setString(z++, generarCod());
                ps.setString(z++, ejem.getCod_Libro());
                ps.setString(z++, ejem.getUbicacion());
                ps.setString(z++, ejem.getEstado());
                ps.setString(z++, ejem.getCod_Departamento());
               

                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en agregar de la clase EjemplarSQL");
             

            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }
  
    }
     
     
     public void Actualizar(boolean pass, Ejemplar ejem) {
        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "UPDATE ejemplar SET cod_Libro=?, ubicacion=?, estado=?, departamento_codDepartamento=? WHERE codEjemplar=? ";

            try {
                ps = con.prepareStatement(sql);
                int z=1;
                ps.setString(z++, ejem.getCod_Libro());
                ps.setString(z++, ejem.getUbicacion());
                ps.setString(z++, ejem.getEstado());
                ps.setString(z++, ejem.getCod_Departamento());
                ps.setString(z++, ejem.getCodEjemplar());
                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Actualizar de la clase EjemplarSQL");

            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }
    }
    
     
     public void Eliminar(boolean pass, String id) {
        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "DELETE FROM ejemplar WHERE codEjemplar='"+id+"'";
                              
            try {
                ps = con.prepareStatement(sql);
               //ps.setString(1, sql);
                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Eliminar de la clase EjemplarSQL");

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

        String sql = "SELECT MAX(codEjemplar) as cantidad FROM ejemplar";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                a = rs.getString(1);
            }

        } catch (SQLException e) {
            System.err.println(e);
            System.out.println("Error en generarCod de la clase EjemplarSQL");

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
                string = "EJE" + i;
            } else {
                string = "EJE0" + i;
            }
        } else {
            string = "EJE00" + i;
        }

        return string;
    }   
    
    
    
}// cierre
