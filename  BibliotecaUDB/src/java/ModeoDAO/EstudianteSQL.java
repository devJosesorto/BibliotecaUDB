
package ModeoDAO;


import java.sql.Connection;
import Conexion.Conexion;
import Modelo.Estudiante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bolaines
 */
public class EstudianteSQL extends Conexion {
    
    
        public List Mostrar()  {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        ArrayList<Estudiante> list = new ArrayList<>();

        String sql = "SELECT* FROM estudiante";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Estudiante estudiante = new Estudiante();

                estudiante.setCarnet(rs.getString(1));
                estudiante.setNombre(rs.getString(2));
                estudiante.setApellido(rs.getString(3));
                estudiante.setSexo(rs.getString(4));
                estudiante.setCarrera(rs.getString(5));
                list.add(estudiante);
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
    
        public boolean Agregar(boolean pass, Estudiante est) {

        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "INSERT INTO estudiante (carnet, nombre, apellido, sexo, carrera) VALUES(?,?,?,?,?)";

            try {
                int z = 1;
                ps = con.prepareStatement(sql);
                //a cada objeto de tipo Estudiante en el cod se debe de asignar "EST" como valor, el metodo generarCod le proporciona el correlativo
                ps.setString(z++, est.getCarnet() + generarCod());
                ps.setString(z++, est.getNombre());
                ps.setString(z++, est.getApellido());
                ps.setString(z++, est.getSexo());
                ps.setString(z++, est.getCarrera());
               

                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Agregar de la clase EstudianteSQL");
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
        
        
         public void Actualizar(boolean pass, Estudiante est) {
        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "UPDATE estudiante SET cartnet=?, nombre=?, apellido=?, sexo=?, carrera=? WHERE carnet=? ";

            try {
                ps = con.prepareStatement(sql);
                int z=1;
                ps.setString(z++, est.getNombre());
                ps.setString(z++, est.getApellido());
                ps.setString(z++, est.getSexo());
                ps.setString(z++, est.getCarrera());
                ps.setString(z++, est.getCarnet());
                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Actualizar de la clase EstudianteSQL");

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
            String sql = "DELETE FROM estudiante WHERE carnet=? ";

            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, sql);
                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Eliminar de la clase EstudianteSQL");

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

        String sql = "SELECT MAX(carnet) as cantidad FROM estudiante";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                a = rs.getString(1);
            }

        } catch (SQLException e) {
            System.err.println(e);
            System.out.println("Error en generarCod de la clase estudianteSQL");

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
           
           
           
    
}// cierre
