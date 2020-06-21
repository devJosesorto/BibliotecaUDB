package Controlador;

import Modelo.Usuario;
import ModeoDAO.UsuarioSQL;

import Modelo.Estudiante;
import Modelo.Docente;
import Modelo.User_Docente;
import Modelo.User_Estudiante;

import ModeoDAO.EstudianteSQL;
import ModeoDAO.DocenteSQL;
import ModeoDAO.User_DocenteSQL;
import ModeoDAO.User_EstudianteSQL;

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
        } else if (action.equalsIgnoreCase("prestamo")) {
            acesso = "vistas/Usuarios/RealizarPrestamo.jsp";
        } else if (action.equalsIgnoreCase("agregarusuario")) {
            acesso = "vistas/AgregarUsuario.jsp";
        } else if (action.equalsIgnoreCase("user")) {

            Usuario user = new Usuario();
            Estudiante est = new Estudiante();
            Docente doc = new Docente();
            
            UsuarioSQL usersql= new UsuarioSQL();            
            EstudianteSQL essql=new EstudianteSQL();
            DocenteSQL docsql =new DocenteSQL();
            
            User_EstudianteSQL UE = new User_EstudianteSQL();
            User_DocenteSQL UD = new User_DocenteSQL();
            
            User_Docente U = new User_Docente();

            if (request.getParameter("txtRol").equals("1")) {
                
                est.setNombre(request.getParameter("txtNombre"));
                est.setApellido(request.getParameter("txtApellido"));
                est.setSexo(request.getParameter("txtGenero"));
                est.setCarrera(request.getParameter("txtCarrera"));

                essql.agregar(true, est);
                
                user.setCod_Rol(request.getParameter("txtRol"));
                user.setCorreo(request.getParameter("txtCorreo"));
                user.setPass(request.getParameter("txtPass"));
                
                usersql.agregar(true, user);
                
            } else if (request.getParameter("txtRol").equals("2")) {
                
                doc.setNombre(request.getParameter("txtNombre"));
                doc.setApellido(request.getParameter("txtApellido"));
                doc.setSexo(request.getParameter("txtGenero"));
                doc.setDepartamento(request.getParameter("txtCod_dpto"));
                
                docsql.agregar(true, doc);

                user.setCod_Rol(request.getParameter("txtRol"));
                user.setCorreo(request.getParameter("txtCorreo"));
                user.setPass(request.getParameter("txtPass"));
                
                usersql.agregar(true, user);
                
                U.setDocente_carnet(docsql.ObtenerCod());
                U.setUsuario_codUsuario(usersql.ObtenerCod()+"");
                
                UD.agregar(true, U);

            } else if (request.getParameter("txtRol").equals("3")) {
                user.setCod_Rol(request.getParameter("txtRol"));
                user.setCorreo(request.getParameter("txtCorreo"));
                user.setPass(request.getParameter("txtPass"));
                
                usersql.agregar(true, user);

            }

            acesso = "vistas/AgregarUsuario.jsp";
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
