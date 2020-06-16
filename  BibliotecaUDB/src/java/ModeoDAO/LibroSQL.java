package ModeoDAO;

import Conexion.Conexion;
import Modelo.Libro;
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
public class LibroSQL extends Conexion {

    public List Mostrar() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        ArrayList<Libro> list = new ArrayList<>();

        String sql = "SELECT* FROM libro";
        String sql2 = "SELECT codLibro,Titulo,categoria.Nombre,autor.Nombre,editorial.Nombre,ISBN "
                + "FROM libro "
                + "inner join categoria on cod_Categoria=codCategoria "
                + "inner join autor on cod_Autor=codAutor "
                + "inner join editorial on cod_Editorial=codEditorial";
        try {
            ps = con.prepareStatement(sql2);
            rs = ps.executeQuery();
            while (rs.next()) {
                Libro lib = new Libro();

                lib.setCodLibro(rs.getString(1));
                lib.setTitulo(rs.getString(2));
                lib.setCodCategoria(rs.getString(3));
                lib.setCodAutor(rs.getString(4));
                lib.setCodEditorial(rs.getString(5));
                lib.setCodISBN(rs.getString(6));
                list.add(lib);
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

    public boolean Agregar(boolean pass, Libro lib) {

        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "INSERT INTO libro (codLibro, Titulo, cod_Categoria, cod_Autor, cod_Editorial, ISBN, descripcion) VALUES(?,?,?,?,?,?,?)";

            try {
                int z = 1;
                ps = con.prepareStatement(sql);
                //a cada onjeto de tipo libro en el cod se debe de asignar "LIB" como valor, el metodo generarCod le proporciona el coorelativo
                ps.setString(z++, lib.getCodLibro() + generarCod());
                ps.setString(z++, lib.getTitulo());
                ps.setInt(z++, Integer.parseInt(lib.getCodCategoria()));
                ps.setInt(z++, Integer.parseInt(lib.getCodAutor()));
                ps.setInt(z++, Integer.parseInt(lib.getCodEditorial()));
                ps.setString(z++, lib.getCodISBN());
                ps.setString(z++, lib.getDescripcion());

                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Agregar de la clase LibroSQL");
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
    
        public void Actualizar(boolean pass, Libro lib) {
        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "UPDATE libro SET Titulo=?, cod_Categoria=?, cod_Autor=?, cod_Editorial=?, ISBN=?, descripcion=? WHERE codLibro=? ";

            try {
                ps = con.prepareStatement(sql);
                int z=1;
                ps.setString(z++, lib.getTitulo());
                ps.setString(z++, lib.getCodCategoria());
                ps.setString(z++, lib.getCodAutor());
                ps.setString(z++, lib.getCodEditorial());
                ps.setString(z++, lib.getCodISBN());
                ps.setString(z++, lib.getDescripcion());
                ps.setString(z++, lib.getCodLibro());
                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Actualizar de la clase LibroSQL");

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
            String sql = "DELETE FROM desktop WHERE codigo_desktop=? ";

            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, sql);
                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Eliminar de la clase LibroSQL");

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

        String sql = "SELECT MAX(codAutor) as cantidad FROM libro";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                a = rs.getString(1);
            }

        } catch (SQLException e) {
            System.err.println(e);
            System.out.println("Error en generarCod de la clase LibroSQL");

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
                string = "LIB" + i;
            } else {
                string = "LIB0" + i;
            }
        } else {
            string = "LIB00" + i;
        }

        return string;
    }

}
