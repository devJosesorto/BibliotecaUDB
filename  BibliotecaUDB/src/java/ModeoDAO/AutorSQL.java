package ModeoDAO;

import Conexion.Conexion;
import Modelo.Autor;
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
public class AutorSQL extends Conexion {

    public List Mostrar() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        ArrayList<Autor> list = new ArrayList<>();

        String sql = "SELECT* FROM autor";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Autor autor = new Autor();

                autor.setCodAutor(rs.getInt(1));
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
    
    
        public Autor buscar(String ID) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT* FROM autor where codAutor="+ID;
        Autor autor = new Autor();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                

                autor.setCodAutor(rs.getInt(1));
                autor.setNombre(rs.getString(2));
                autor.setPais(rs.getString(3));
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
        return autor;
    }

    public boolean Agregar(boolean pass, Autor autor) {

        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "INSERT INTO autor (codAutor, Nombre, Pais) VALUES(?,?,?)";

            try {
                int z = 1;
                ps = con.prepareStatement(sql);
                ps.setInt(z++, generarCod());
                ps.setString(z++, autor.getNombre());
                ps.setString(z++, autor.getPais());

                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Agregar de la clase AutorSQL");
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

    public void Actualizar(boolean pass, Autor autor) {
        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "UPDATE autor SET Nombre=?, Pais=? WHERE codAutor=? ";

            try {
                ps = con.prepareStatement(sql);
                int z = 1;
                ps.setString(z++, autor.getNombre());
                ps.setString(z++, autor.getPais());
                ps.setInt(z++, autor.getCodAutor());
                
                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Actualizar de la clase AutorSQL");

            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }
    }

    public void Eliminar(boolean pass, String codLibro) {
        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "DELETE FROM autor WHERE codAutor="+codLibro;

            try {
                ps = con.prepareStatement(sql);
                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Eliminar de la clase AutorSQL");

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

        String sql = "SELECT MAX(codAutor) as cantidad FROM autor";
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
