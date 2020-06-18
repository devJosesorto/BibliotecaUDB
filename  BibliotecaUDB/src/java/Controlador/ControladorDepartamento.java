package Controlador;

import Modelo.Departamento;
import ModeoDAO.DepartamentoSQL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José Sorto
 */
public class ControladorDepartamento extends HttpServlet {
    
     String listar = "vistas/listar/ListarDepartamentos.jsp";
     String nuevodepartamento = "vistas/AgregarDepartamento.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorDepartamento</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorDepartamento at " + request.getContextPath() + "</h1>");
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

            acesso = listar;

        } else if (action.equalsIgnoreCase("nuevodepartamento")) {

            acesso = nuevodepartamento;

        } else if (action.equalsIgnoreCase("agregardepartamento")) {

            Departamento dpto = new Departamento();
            DepartamentoSQL dptosql = new DepartamentoSQL();
            
            dpto.setCodDepartamento("");
            dpto.setNombre(request.getParameter("txtDepartamento"));
            
            dptosql.Agregar(true, dpto);

            acesso = "index.jsp";

        }else if (action.equalsIgnoreCase("test")) {

            acesso = "vistas/testing.jsp";

        }
        
        
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
