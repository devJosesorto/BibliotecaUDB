
package ModeoDAO;

import Conexion.Conexion;
import Modelo.Categoria;
import Modelo.Departamento;
import Modelo.Docente;
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
public class DepartamentoSQL extends Conexion  {
    
    
    public List mostrar() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        ArrayList<Departamento> list = new ArrayList<>();

        String sql = "SELECT * FROM departamento";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Departamento depto = new Departamento();

                depto.setCodDepartamento(rs.getString(1));
                depto.setNombre(rs.getString(2));
                
                list.add(depto);
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
    
    
    
    public Departamento buscar(String ID) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        Departamento dpto = new Departamento();

        String sql = "SELECT * FROM departamento WHERE codDepartamento="+ID;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                dpto.setCodDepartamento(rs.getString(1));
                dpto.setNombre(rs.getString(2));

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
        return dpto;
    }
    
    
    public void Agregar(boolean pass, Departamento dpto) {

        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "INSERT INTO departamento (codDepartamento, Nombre) VALUES(?,?)";

            try {
                int z = 1;
                ps = con.prepareStatement(sql);
                ps.setString(z++, generarCod());
                ps.setString(z++, dpto.getNombre());

                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Agregar de la clase DepartamentoSQL");
            

            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }
      
    }
    
    
     public void Actualizar(boolean pass, Departamento depa) {
        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "UPDATE departamento SET nombre=? WHERE codDepartamento=? ";

            try {
                ps = con.prepareStatement(sql);
                int z = 1;              
                ps.setString(z++, depa.getNombre());
                ps.setString(z++, depa.getCodDepartamento());
                
                ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Actualizar de la clase DepartamentoSQL");

            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }
    }
     
     
     public void eliminar(boolean pass, String s) {
        if (pass) {
            PreparedStatement ps = null;
            Connection con = getConexion();
            String sql = "DELETE FROM departamento WHERE codDepartamento="+s;

            try {
                
               ps = con.prepareStatement(sql);
               ps.execute();

            } catch (SQLException e) {
                System.err.println(e);
                System.out.println("Error en Eliminar de la clase DepartamentoSQL");

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

        String sql = "SELECT MAX(codDepartamento) as cantidad FROM departamento ";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                a = rs.getString(1);
            }

        } catch (SQLException e) {
            System.err.println(e);
            System.out.println("Error en generarCod de la clase DepartamentoSQL");

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
                string = "DP" + i;
            } else {
                string = "DPC0" + i;
            }
        } else {
            string = "DP00" + i;
        }

        return string;
    }  
 
    
    
}//CIERRE
