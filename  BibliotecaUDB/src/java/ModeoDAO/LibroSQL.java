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
public class LibroSQL extends Conexion{
    
    public List Mostrar() {
         

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
      
        ArrayList<Libro>list=new ArrayList<>();

        String sql = "SELECT* FROM libro";
        String sql2="SELECT codLibro,Titulo,categoria.Nombre,autor.Nombre,editorial.Nombre,ISBN FROM libro inner join categoria on cod_Categoria=codCategoria inner join autor on cod_Autor=codAutor inner join editorial on cod_Editorial=codEditorial";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
              Libro lib=new Libro();
             
              lib.setCodLibro(rs.getString(1));
              lib.setTitulo(rs.getString(2));
              lib.setCodCategoria(rs.getInt(3));
              lib.setCodAutor(rs.getInt(4));
              lib.setCodEditorial(rs.getInt(5));
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

}
