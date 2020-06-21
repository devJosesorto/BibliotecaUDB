<%-- 
    Document   : testing
    Created on : 06-20-2020, 01:58:30 PM
    Author     : José Sorto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"  %>

<%
    HttpSession sesion = request.getSession();

    if (sesion.getAttribute("nivel") == null) {
         response.sendRedirect("../index.jsp");

    } else {
        String nivel = sesion.getAttribute("nivel").toString();
    
        if (!nivel.equals("3")) {

            response.sendRedirect("../index.jsp");
        } 
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <body>
        <h1>Inicio Prueba git!</h1>
        <br><br>

        <div>
            <a class="btn btn-primary btn-sm" href="ControladorDepartamento?accion=test" role="button">Test</a>
            <br><br><br>            
            <a class="btn btn-primary btn-sm" href="ControladorLibro?accion=nuevolibro" role="button">Nuevo Libro</a>
            <a class="btn btn-primary btn-sm" href="ControladorLibro?accion=listar" role="button">Listar libros</a>
            <br><br><br>
            <a class="btn btn-primary btn-sm" href="ControladorAutor?accion=nuevoautor" role="button">Nuevo Autor</a>
            <a class="btn btn-primary btn-sm" href="ControladorAutor?accion=listar" role="button">Listar Autor</a>
            <br><br><br>
            
            <a class="btn btn-primary btn-sm" href="ControladorEditorial?accion=nuevaeditorial" role="button">Nuevo Editorial</a>
            <a class="btn btn-primary btn-sm" href="ControladorEditorial?accion=listar" role="button">Listar Editorial</a>
            <br><br><br>
            <a class="btn btn-primary btn-sm" href="ControladorCategoria?accion=nuevacategoria" role="button">Nueva Categoria</a>
            <a class="btn btn-primary btn-sm" href="ControladorCategoria?accion=listar" role="button">Listar Categoria</a>
            <br><br><br>
            <a class="btn btn-primary btn-sm" href="ControladorDepartamento?accion=nuevodepartamento" role="button">Nuevo Departamento</a>
             <a class="btn btn-primary btn-sm" href="ControladorDepartamento?accion=listar" role="button">Listar Departamento</a>
            <br><br><br>
            <a class="btn btn-primary btn-sm" href="ControladorEjemplar?accion=nuevoejemplar" role="button">Nuevo Ejemplar</a>
            <a class="btn btn-primary btn-sm" href="ControladorEjemplar?accion=listar" role="button">Listar Ejemplar</a>
             <br><br><br>
            <a class="btn btn-primary btn-sm" href="ControladorUsuario?accion=agregarusuario" role="button">Nuevo Usuario</a>
            <a class="btn btn-primary btn-sm" href="ControladorDocente?accion=listar" role="button">Listar Usuarios</a>
            
            
            <a href="../index.jsp?cerrar=true"> Cerrar Sesion</a>
            
            <%/*
               editar editorial.JSP - OK 
               departamento, ejemplar y libros, no logre editar ni borrar (no se si el generador de ID, por que en id que
               son numeros si edita y borra
               Avance con el registro, lista y vista de usuario docente
               Hice una vista general para agregar usuarios.
               Controlador de departamento, ejemplar y libros completo
               

             */%>
            
        </div>

    </body>
</html>