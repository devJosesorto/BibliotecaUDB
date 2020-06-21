
package Controlador;


import Modelo.Docente;
import ModeoDAO.DocenteSQL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bolaines
 */
public class ControladorDocente extends HttpServlet {

    String listar = "vistas/listar/ListarDocentes.jsp";
    String nuevousuario = "vistas/AgregarUsuario.jsp";
    String editar = "vistas/editar/EditarUsuario.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorDocente</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorDocente at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acesso = "";
        String action = request.getParameter("accion");

        if (action.equalsIgnoreCase("listar")) {

            acesso = "vistas/listar/ListarDocentes.jsp";
            
        } else if (action.equalsIgnoreCase("nuevousuario")) {
            acesso = nuevousuario;

        } else if (action.equalsIgnoreCase("agregarusuario")) {
           
            Docente doc = new Docente();
            DocenteSQL docesql = new DocenteSQL();
            
            doc.setCarnet("");
            doc.setNombre(request.getParameter("txtNombre"));
            doc.setApellido(request.getParameter("txtApellido"));
            doc.setSexo("txtGenero");
            doc.setDepartamento(request.getParameter("txtCod_dpto"));

            docesql.agregar(true, doc);
            
            }
            
            acesso = listar;

            
             
            
       

        RequestDispatcher vista = request.getRequestDispatcher(acesso);
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