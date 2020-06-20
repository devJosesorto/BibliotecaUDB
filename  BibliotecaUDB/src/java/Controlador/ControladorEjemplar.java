/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Ejemplar;
import ModeoDAO.EjemplarSQL;
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
public class ControladorEjemplar extends HttpServlet {
    
    String listar = "vistas/listar/ListarEjemplares.jsp";
    String nuevoejemplar = "vistas/AgregarEjemplar.jsp";
    String editar = "vistas/editar/EditarEjemplar.jsp";
    

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
            
        } else if (action.equalsIgnoreCase("nuevoejemplar")) {

            acesso = nuevoejemplar;
            
        } else if (action.equalsIgnoreCase("agregarejemplar")) {
            int j=0;
            j=Integer.parseInt(request.getParameter("txtCantidad"));
            
            for (int i = 0; i < j; ++i){
                
            Ejemplar ejem = new Ejemplar();
            EjemplarSQL ejemsql = new EjemplarSQL();
            
            ejem.setCodEjemplar("");
            ejem.setCod_Libro(request.getParameter("txtCod_Lib"));
            ejem.setUbicacion(request.getParameter("txtUbicacion")+" "+i+1);
            ejem.setEstado("DISPONIBLE");
            ejem.setCod_Departamento(request.getParameter("txtCod_dpto"));

            ejemsql.Agregar(true, ejem);
            
            }
            
            acesso = listar;

            
            } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("id_", request.getParameter("id"));
            acesso = editar;
            
            } else if (action.equalsIgnoreCase("editarejemplar")) {
                
            //int j=0;
            //j=Integer.parseInt(request.getParameter("txtCantidad"));
                
            Ejemplar ejemplar = new Ejemplar();
            EjemplarSQL ejemplarsql = new EjemplarSQL();

            ejemplar.setCodEjemplar(request.getParameter("txtID"));
            ejemplar.setCod_Libro(request.getParameter("txtCod_Lib"));
            ejemplar.setCod_Departamento(request.getParameter("txtCod_dpto"));
            ejemplar.setEstado(request.getParameter("DISPONIBLE"));
            ejemplar.setUbicacion(request.getParameter("txtUbicacion"));            
            
            
            
            
            ejemplarsql.Actualizar(true, ejemplar);
            
            
            acesso = listar;
            
            } else if (action.equalsIgnoreCase("eliminar")) {

       
            EjemplarSQL ejemplarsql = new EjemplarSQL();
            ejemplarsql.Eliminar(true, request.getParameter("id"));

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
