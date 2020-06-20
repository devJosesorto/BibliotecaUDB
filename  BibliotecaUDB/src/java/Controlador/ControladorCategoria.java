/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import ModeoDAO.CategoriaSQL;
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
public class ControladorCategoria extends HttpServlet {

    String listar = "vistas/listar/ListarCategorias.jsp";
    String nuevacategoria = "vistas/AgregarCategoria.jsp";
    String editar = "vistas/editar/EditarCategoria.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorEjemplar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorEjemplar at " + request.getContextPath() + "</h1>");
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

        } else if (action.equalsIgnoreCase("nuevacategoria")) {
            acesso = nuevacategoria;

        } else if (action.equalsIgnoreCase("agregarCategoria")) {

            Categoria categoria = new Categoria();
            CategoriaSQL categoriasql = new CategoriaSQL();
            categoria.setNombre(request.getParameter("txtCategoria"));
            categoriasql.agregar(true, categoria);
            acesso = listar;
            
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("id_", request.getParameter("id"));
            acesso = editar;
            
        }else if (action.equalsIgnoreCase("EditarCategoria")) {
            Categoria categoria = new Categoria();
            CategoriaSQL categoriasql = new CategoriaSQL();
            
            categoria.setCodCategoria(Integer.parseInt(request.getParameter("txtID")));
            categoria.setNombre(request.getParameter("txtCategoria"));
            
            categoriasql.actualizar(true, categoria);
            acesso = listar;
            
            
        }else if (action.equalsIgnoreCase("eliminar")) {
           
            CategoriaSQL categoriasql = new CategoriaSQL();            
            categoriasql.eliminar(true, request.getParameter("id"));
            
            acesso = listar;
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
