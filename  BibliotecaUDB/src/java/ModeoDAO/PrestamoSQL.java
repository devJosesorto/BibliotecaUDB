
package ModeoDAO;

import Conexion.Conexion;

import Modelo.Prestamo;
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
public class PrestamoSQL extends Conexion {
    
   
     public List mostrar() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        ArrayList<Prestamo> list = new ArrayList<>();

        String sql = "SELECT* FROM prestamo";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Prestamo prestamo = new Prestamo();

                prestamo.setCodPrestamo(rs.getInt(1));
                prestamo.setFecha_entrega(rs.getString(2));
                prestamo.setFecha_devolucion(rs.getString(3));
                prestamo.setEjemplar_codEjemplar(rs.getString(4));
                prestamo.setUsuario(rs.getInt(5));
                prestamo.setMora(rs.getString(6));
                
                
                list.add(prestamo);
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
     
     
      public Prestamo buscar(String ID) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        Prestamo obj = new Prestamo();

        String sql = "SELECT* FROM Prestamo where codPrestamo="+ID;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                obj.setCodPrestamo(rs.getInt(1));
                obj.setFecha_entrega(rs.getString(2));
                obj.setFecha_devolucion(rs.getString(3));
                obj.setEjemplar_codEjemplar(rs.getString(4));
                obj.setUsuario(rs.getInt(5));
                obj.setMora(rs.getString(6));

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
        return obj;
    }
     
    
     public boolean agregar(boolean pass, Prestamo prest ) {

        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "INSERT INTO prestamo (codPrestamo, fecha_entrega, fecha_devolucion, ejemplar_codEjemplar, usuario, mora ) VALUES(?,?,?,?,?,?)";

            try {
                int z = 1;
                ps = con.prepareStatement(sql);
                ps.setInt(z++, generarCod());
                ps.setString(z++, prest.getFecha_entrega());
                ps.setString(z++, prest.getFecha_devolucion());
                ps.setString(z++, prest.getEjemplar_codEjemplar());
                ps.setInt(z++, prest.getUsuario());
                ps.setString(z++, prest.getMora());
                                

                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Agregar de la clase PrestamoSQL");
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
     
    
     public void actualizar(boolean pass, Prestamo prest ) {
        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "UPDATE prestamo SET codPrestamo=?, fecha_entrega=?, fecha_devolucion=?, ejemplar_codEjemplar=?, usuario=?, mora=? WHERE codPrestamo=? ";

            try {
                ps = con.prepareStatement(sql);
                int z = 1;
                ps.setString(z++, prest.getFecha_entrega());
                ps.setString(z++, prest.getFecha_devolucion());
                ps.setString(z++, prest.getEjemplar_codEjemplar());
                ps.setInt(z++, prest.getUsuario());
                ps.setString(z++, prest.getMora());
                ps.setInt(z++, prest.getCodPrestamo());
                
                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Actualizar de la clase PrestamoSQL");

            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }
    }
     
     
     public void eliminar(boolean pass, String id ) {
        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "DELETE FROM prestamo WHERE codPrestamo="+id;

            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, sql);
                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Eliminar de la clase PrestamoSQL");

            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }
    }
     
    
               
     ///Genarador de codigo
     
     public int generarCod() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT MAX(codPrestamo) as cantidad FROM prestamo";
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
    
    
    
}// cierre
