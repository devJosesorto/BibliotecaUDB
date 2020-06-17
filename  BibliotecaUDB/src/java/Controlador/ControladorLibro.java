package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Libro;
import ModeoDAO.LibroSQL;

import Modelo.Autor;
import Modelo.Categoria;
import ModeoDAO.AutorSQL;

import Modelo.Editorial;
import ModeoDAO.CategoriaSQL;
import ModeoDAO.EditorialSQL;
/**
 *
 * @author José Sorto
 */
public class ControladorLibro extends HttpServlet {
    
    String listar="vistas/ListarLibros.jsp";
    String nuevoautor="vistas/AgregarAutor.jsp";
    String nuevolibro="vistas/NuevoLibro.jsp";
    String nuevoeditorial="vistas/AgregarEditorial.jsp";
    String nuevocategoria="vistas/AgregarCatgoria.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorLibro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorLibro at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acesso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
        acesso=listar;
        }else if(action.equalsIgnoreCase("nuevoautor")){
            acesso=nuevoautor;
        }else if(action.equalsIgnoreCase("agregarautor")){
            Autor autor =new Autor();
            AutorSQL autorsql =new AutorSQL();
            
            autor.setNombre(request.getParameter("txtAutor"));
            autor.setPais(request.getParameter("txtPais"));
            autorsql.Agregar(true, autor);
            
            acesso=listar;
        }else if(action.equalsIgnoreCase("nuevolibro")){
            
            acesso=nuevolibro;
        }else if(action.equalsIgnoreCase("agregarlibro")){
            Libro lib =new Libro();
            LibroSQL libsql = new LibroSQL();
            
            lib.setTitulo(request.getParameter("txtTitulo"));
            lib.setCodCategoria(request.getParameter("txtCategoria"));
            lib.setCodAutor(request.getParameter("txtAutor"));
            lib.setCodEditorial(request.getParameter("txtEditorial"));
            lib.setCodISBN(request.getParameter("txtISBN"));
            lib.setDescripcion(request.getParameter("txtDescripcion"));
            libsql.Agregar(true, lib);
            
            acesso=listar;
            
            
        }   // prueba   Categoria
                
            else if(action.equalsIgnoreCase("agregarCategoria")){           
                
            Categoria categoria =new Categoria();
            CategoriaSQL categoriaql =new CategoriaSQL();
            
            categoria.setNombre(request.getParameter("txtCategoria"));
            categoriaql.agregar(true, categoria);
            
            acesso=listar;
        }
        
        
        
       
        
        
        //cierre de prueba
        
        
        
        
        
        
        RequestDispatcher vista=request.getRequestDispatcher(acesso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
