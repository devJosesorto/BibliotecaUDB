
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
    
    
     public List mostrar()  {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        ArrayList<Ejemplar> list = new ArrayList<>();

        String sql = "SELECT* FROM ejemplar";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ejemplar ejemplar = new Ejemplar();

                ejemplar.setCodEjemplar(rs.getString(1));
                ejemplar.setCod_Libro(rs.getString(2));
                ejemplar.setUbicacion(rs.getString(3));
                ejemplar.setEstado(rs.getString(4));
                ejemplar.setdepartamento_codDepartamento(rs.getString(5));
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
    
     
     public boolean agregar(boolean pass, Ejemplar ejem) {

        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "INSERT INTO ejemplar (codEjemplar, cod_Libro, ubicacion, estado, departamento_codDepartamento) VALUES(?,?,?,?,?)";

            try {
                int z = 1;
                ps = con.prepareStatement(sql);
                //a cada objeto de tipo Ejemplar en el cod se debe de asignar "EJE" como valor, el metodo generarCod le proporciona el correlativo
                ps.setString(z++, ejem.getCodEjemplar()+ generarCod());
                ps.setString(z++, ejem.getCod_Libro());
                ps.setString(z++, ejem.getUbicacion());
                ps.setString(z++, ejem.getEstado());
                ps.setString(z++, ejem.getdepartamento_codDepartamento());
               

                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en agregar de la clase EjemplarSQL");
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
     
     
     public void actualizar(boolean pass, Ejemplar ejem) {
        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "UPDATE ejemplar SET codEjemplar=?, cod_Libro=?, ubicacion=?, estado=?, departamento_codDepartamento=? WHERE codEjemplar=? ";

            try {
                ps = con.prepareStatement(sql);
                int z=1;
                ps.setString(z++, ejem.getCod_Libro());
                ps.setString(z++, ejem.getUbicacion());
                ps.setString(z++, ejem.getEstado());
                ps.setString(z++, ejem.getdepartamento_codDepartamento());
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
    
     
     public void eliminar(boolean pass, String carnet) {
        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "DELETE FROM ejemplar WHERE codEjemplar=? ";

            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, sql);
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
