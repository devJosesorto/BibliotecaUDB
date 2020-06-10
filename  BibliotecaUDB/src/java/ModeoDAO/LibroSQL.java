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

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
              Libro lib=new Libro();
              lib.setCodLibro(rs.getString("codLibro"));
              lib.setTitulo(rs.getString("Titulo"));
              lib.setCodCategoria(rs.getInt("cod_Categoria"));
              lib.setCodAutor(rs.getInt("cod_Autor"));
              lib.setCodEditorial(rs.getInt("cod_Editorial"));
              lib.setCodISBN(rs.getString("ISBN"));
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
