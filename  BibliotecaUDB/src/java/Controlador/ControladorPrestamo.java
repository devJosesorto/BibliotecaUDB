/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ModeoDAO.PrestamoSQL;
import Modelo.Prestamo;

/**
 *
 * @author José Sorto
 */
public class ControladorPrestamo extends HttpServlet {

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

        if (action.equalsIgnoreCase("prestamo")) {
            acesso = "vistas/Usuarios/RealizarPrestamo.jsp";

        } else if (action.equalsIgnoreCase("realizarprestamo")) {

            PrestamoSQL sql = new PrestamoSQL();
            Prestamo prest = new Prestamo();

            prest.setFecha_entrega(request.getParameter("txtFecha"));
            prest.setFecha_devolucion("");
            prest.setEjemplar_codEjemplar(request.getParameter("txtEjemplar"));
            prest.setUsuario(Integer.parseInt(request.getParameter("txtID")));
            prest.setMora("0");
            
            sql.agregar(true, prest);
            
             acesso = "vistas/Usuarios/RealizarPrestamo.jsp";

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
