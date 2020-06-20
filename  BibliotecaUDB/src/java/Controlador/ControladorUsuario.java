package Controlador;

import Modelo.Usuario;
import ModeoDAO.UsuarioSQL;
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
public class ControladorUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String username, pass;
            int nivel;
            RequestDispatcher rd = null;

            if (request.getParameter("btnInicar") != null) {
                username = request.getParameter("txtUser");
                pass = request.getParameter("txtPass");

                Usuario user = new Usuario();
                UsuarioSQL usersql = new UsuarioSQL();

                nivel = usersql.Login(username, pass);

                request.setAttribute("nivel", nivel);
                request.setAttribute("username", username);
                request.setAttribute("pass", pass);

                rd = request.getRequestDispatcher("index.jsp");
            }

            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acesso = "";
        String action = request.getParameter("accion");

        if (action.equalsIgnoreCase("home")) {
            acesso = "vistas/Usuarios/home.jsp";

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
