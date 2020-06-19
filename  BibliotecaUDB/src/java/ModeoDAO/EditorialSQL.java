package ModeoDAO;

import Conexion.Conexion;
import Modelo.Editorial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author José Sorto
 */
public class EditorialSQL extends Conexion {

    public List mostrar() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        ArrayList<Editorial> list = new ArrayList<>();

        String sql = "SELECT* FROM editorial";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Editorial autor = new Editorial();

                autor.setCodEditorial(rs.getInt(1));
                autor.setNombre(rs.getString(2));
                autor.setPais(rs.getString(3));
                list.add(autor);
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
    
    
     public Editorial buscar(String ID) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM editorial where codEditorial="+ID;
        Editorial editorial = new Editorial();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                

                editorial.setCodEditorial(rs.getInt(1));
                editorial.setNombre(rs.getString(2));
                editorial.setPais(rs.getString(3));
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
        return editorial;
    }

    public boolean agregar(boolean pass, Editorial editorial) {

        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "INSERT INTO editorial (codEditorial, Nombre, Pais) VALUES(?,?,?)";

            try {
                int z = 1;
                ps = con.prepareStatement(sql);
                ps.setInt(z++, generarCod());
                ps.setString(z++, editorial.getNombre());
                ps.setString(z++, editorial.getPais());

                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Agregar de la clase EditorialSQL");
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

    public void actualizar(boolean pass, Editorial editorial) {
        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "UPDATE editorial SET Nombre=?, Pais=? WHERE codEditorial=? ";

            try {
                ps = con.prepareStatement(sql);
                int z = 1;
                ps.setString(z++, editorial.getNombre());
                ps.setString(z++, editorial.getPais());
                ps.setInt(z++, editorial.getCodEditorial());
                
                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Actualizar de la clase EditorialSQL");

            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }
    }

    public void eliminar(boolean pass, String codEditorial) {
        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "DELETE FROM editorial WHERE codEditorial="+codEditorial;

            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, sql);
                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Eliminar de la clase EditorialSQL");

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

        String sql = "SELECT MAX(codEditorial) as cantidad FROM editorial";
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

}

