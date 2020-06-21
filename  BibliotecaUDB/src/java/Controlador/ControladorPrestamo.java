/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeoDAO.LibroSQL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ModeoDAO.PrestamoSQL;
import Modelo.Prestamo;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José Sorto
 */
public class ControladorPrestamo extends HttpServlet {

    String listar = "vistas/Usuarios/ListarLibrosPrestamo.jsp";
    String listar2 = "searchbook.jsp";

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

        if (action.equalsIgnoreCase("realizarprestamo")) {

            PrestamoSQL sql = new PrestamoSQL();
            Prestamo prest = new Prestamo();

            prest.setFecha_entrega(request.getParameter("txtFecha"));
            prest.setFecha_devolucion("0000-00-00");
            prest.setEjemplar_codEjemplar(request.getParameter("txtEjemplar"));
            prest.setUsuario(Integer.parseInt(request.getParameter("txtID")));
            prest.setMora("0");
            try {
                sql.agregar(true, prest);

            } catch (ParseException ex) {
                Logger.getLogger(ControladorPrestamo.class.getName()).log(Level.SEVERE, null, ex);
            }

            acesso = "vistas/Usuarios/PrestamoRealizado.jsp";
        } else if (action.equalsIgnoreCase("prestamo")) {

            acesso = "vistas/Usuarios/RealizarPrestamo.jsp";
        }else  if (action.equalsIgnoreCase("noejemplares")) {
            
         acesso = "vistas/Usuarios/NoEjemplares.jsp";
        
        }else  if (action.equalsIgnoreCase("pendientes")) {
            
         acesso = "vistas/Usuarios/PrestamosPendientes.jsp";
        
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
