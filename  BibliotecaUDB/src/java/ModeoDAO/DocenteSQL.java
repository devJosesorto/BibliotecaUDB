
package ModeoDAO;


import java.sql.Connection;
import Conexion.Conexion;
import Modelo.Docente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bolaines
 */
public class DocenteSQL extends Conexion {
    
    
        public List Mostrar()  {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        ArrayList<Docente> list = new ArrayList<>();

        String sql = "SELECT* FROM docente";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Docente docente = new Docente();

                docente.setCarnet(rs.getString(1));
                docente.setNombre(rs.getString(2));
                docente.setApellido(rs.getString(3));
                docente.setSexo(rs.getString(4));
                docente.setDepartamento(rs.getString(5));
                list.add(docente);
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
    
        public boolean Agregar(boolean pass, Docente doc) {

        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "INSERT INTO docente (carnet, nombre, apellido, sexo, departamento) VALUES(?,?,?,?,?)";

            try {
                int z = 1;
                ps = con.prepareStatement(sql);
                //a cada objeto de tipo docente en el cod se debe de asignar "DOC" como valor, el metodo generarCod le proporciona el coorelativo
                ps.setString(z++, doc.getCarnet() + generarCod());
                ps.setString(z++, doc.getNombre());
                ps.setString(z++, doc.getApellido());
                ps.setString(z++, doc.getSexo());
                ps.setString(z++, doc.getDepartamento());
               

                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Agregar de la clase DocenteSQL");
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
        
        
         public void Actualizar(boolean pass, Docente doc) {
        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "UPDATE docente SET cartnet=?, nombre=?, apellido=?, sexo=?, departamento=? WHERE carnet=? ";

            try {
                ps = con.prepareStatement(sql);
                int z=1;
                ps.setString(z++, doc.getNombre());
                ps.setString(z++, doc.getApellido());
                ps.setString(z++, doc.getSexo());
                ps.setString(z++, doc.getDepartamento());
                ps.setString(z++, doc.getCarnet());
                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Actualizar de la clase DocenteSQL");

            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }
    }
         
         
         public void Eliminar(boolean pass, String carnet) {
        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "DELETE FROM docente WHERE carnet=? ";

            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, sql);
                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Eliminar de la clase DocenteSQL");

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

        String sql = "SELECT MAX(carnet) as cantidad FROM docente";
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
           
           
           
    
}// cierre
