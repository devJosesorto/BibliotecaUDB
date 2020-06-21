<%-- 
    Document   : index
    Created on : 06-20-2020, 10:38:24 AM
    Author     : José Sorto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Agregar autor</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="Shortcut Icon" type="image/x-icon" href="Bootstrap/assets/icons/book.ico" />
        <script src="Bootstrap/js/sweet-alert.min.js"></script>
        <link rel="stylesheet" href="Bootstrap/css/sweet-alert.css">
        <link rel="stylesheet" href="Bootstrap/css/material-design-iconic-font.min.css">
        <link rel="stylesheet" href="Bootstrap/css/normalize.css">
        <link rel="stylesheet" href="Bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="Bootstrap/css/jquery.mCustomScrollbar.css">
        <link rel="stylesheet" href="Bootstrap/css/style.css">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="Bootstrap/js/jquery-1.11.2.min.js"><\/script>')</script>
        <script src="Bootstrap/js/modernizr.js"></script>
        <script src="Bootstrap/js/bootstrap.min.js"></script>
        <script src="Bootstrap/js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="Bootstrap/js/main.js"></script>
    </head>
    <body>
        <div class="login-container full-cover-background">
            <div class="form-container">
                <p class="text-center" style="margin-top: 17px;">
                    <i class="zmdi zmdi-account-circle zmdi-hc-5x"></i>
                </p>
                <h4 class="text-center all-tittles" style="margin-bottom: 30px;">inicia sesión con tu cuenta</h4>
                <form action="ControladorUsuario" method="POST">
                    <div class="group-material-login">

                        <input type="text" name="txtUser" class="material-login-control" required="" maxlength="70">


                        <span class="highlight-login"></span>
                        <span class="bar-login"></span>
                        <label><i class="zmdi zmdi-account"></i> &nbsp; Nombres</label>
                    </div><br>
                    <div class="group-material-login">

                        <input type="password" name="txtPass" class="material-login-control" required="" maxlength="70">

                        <span class="highlight-login"></span>
                        <span class="bar-login"></span>
                        <label><i class="zmdi zmdi-lock"></i> &nbsp; Contraseña</label>
                    </div>

                    <button class="btn-login" name="btnInicar" type="submit">Ingresar al sistema &nbsp; <i class="zmdi zmdi-arrow-right"></i></button>
                        <%
                            HttpSession sesion = request.getSession();
                            int nivel = 0;

                            if (request.getAttribute("nivel") != null) {
                                nivel = (Integer) request.getAttribute("nivel");

                                if (nivel == 3) {
                                    sesion.setAttribute("Nombre", request.getAttribute("username"));
                                    sesion.setAttribute("nivel", nivel);
                                    response.sendRedirect("testing.jsp");
                                } else if (nivel == 1||nivel == 2) {
                                    sesion.setAttribute("Nombre", request.getAttribute("username"));
                                    sesion.setAttribute("nivel", nivel);
                                    response.sendRedirect("ControladorUsuario?accion=home");
                                }

                            }

                            if (request.getParameter("cerrar")!= null) {
                                session.invalidate();
                                response.sendRedirect("index.jsp");
                            }
                        %>    
                </form>
            </div>   
        </div>
    </body>
</html>