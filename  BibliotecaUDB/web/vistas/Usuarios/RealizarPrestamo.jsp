<%-- 
    Document   : RealizarPrestamo
    Created on : 06-20-2020, 04:14:18 PM
    Author     : José Sorto
--%>

<%@page import="ModeoDAO.UsuarioSQL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeoDAO.PrestamoSQL"%>

<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"  %>

<%
    HttpSession sesion = request.getSession();

    if (sesion.getAttribute("nivel") == null) {
        response.sendRedirect("index.jsp");

    } else {
        String nivel = sesion.getAttribute("nivel").toString();

        if (!(nivel.equals("1") || nivel.equals("2"))) {

            response.sendRedirect("../index.jsp");

        }
    }
%>

<!DOCTYPE html>

<html lang="es">
    <head>
        <!CAMBIAR TITULO DE LA PAGINA ##########################################################>
    <title>Prestar libro</title>


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
    <div class="navbar-lateral full-reset">
        <div class="visible-xs font-movile-menu mobile-menu-button"></div>
        <div class="full-reset container-menu-movile nav-lateral-scroll">
            <div class="logo full-reset all-tittles">
                <i class="visible-xs zmdi zmdi-close pull-left mobile-menu-button" style="line-height: 55px; cursor: pointer; padding: 0 10px; margin-left: 7px;"></i> 
                sistema bibliotecario
            </div>
            <div class="nav-lateral-divider full-reset"></div>
            <div class="full-reset" style="padding: 10px 0; color:#fff;">
                <figure>
                    <img src="Bootstrap/assets/img/logo.png" alt="Biblioteca" class="img-responsive center-box" style="width:55%;">
                </figure>
                <p class="text-center" style="padding-top: 15px;">Sistema Bibliotecario</p>
            </div>
            <div class="nav-lateral-divider full-reset"></div>
            <div class="full-reset nav-lateral-list-menu">
                <ul class="list-unstyled">
                    <li><a href="ControladorUsuario?accion=home"><i class="zmdi zmdi-home zmdi-hc-fw"></i>&nbsp;&nbsp; Inicio</a></li>


                    <li>
                        <div class="dropdown-menu-button"><i class="zmdi zmdi-assignment-o zmdi-hc-fw"></i>&nbsp;&nbsp; Libros y catálogo <i class="zmdi zmdi-chevron-down pull-right zmdi-hc-fw icon-sub-menu"></i></div>
                        <ul class="list-unstyled">

                            <li><a href="catalog.html"><i class="zmdi zmdi-bookmark-outline zmdi-hc-fw"></i>&nbsp;&nbsp; Catálogo</a></li>
                        </ul>
                    </li>
                    <li>
                        <div class="dropdown-menu-button"><i class="zmdi zmdi-alarm zmdi-hc-fw"></i>&nbsp;&nbsp; Préstamos y reservaciones <i class="zmdi zmdi-chevron-down pull-right zmdi-hc-fw icon-sub-menu"></i></div>
                        <ul class="list-unstyled">
                            <li><a href="ControladorPrestamo?accion=prestamo"><i class="zmdi zmdi-calendar zmdi-hc-fw"></i>&nbsp;&nbsp; Realizar Prestamo</a></li>
                            <li><a href="loan.html"><i class="zmdi zmdi-calendar zmdi-hc-fw"></i>&nbsp;&nbsp; Todos los préstamos</a></li>
                            <li>
                                <a href="ControladorPrestamo?accion=pendiente"><i class="zmdi zmdi-time-restore zmdi-hc-fw"></i>&nbsp;&nbsp; Devoluciones pendientes <span class="label label-danger pull-right label-mhover">7</span></a>
                            </li>
                            <li>

                            </li>
                        </ul>
                    </li>

                </ul>
            </div>
        </div>
    </div>
    <div class="content-page-container full-reset custom-scroll-containers">
        <nav class="navbar-user-top full-reset">
            <ul class="list-unstyled full-reset">
                <figure>
                    <img src="Bootstrap/assets/img/user01.png" alt="user-picture" class="img-responsive img-circle center-box">
                </figure>
                <li style="color:#fff; cursor:default;">
                    <span class="all-tittles"><%= session.getAttribute("Nombre")%></span>
                </li>
                <li  class="tooltips-general exit-system-button" data-href="index.jsp?cerrar=true" data-placement="bottom" title="Salir del sistema">
                    <i class="zmdi zmdi-power"></i>
                </li>
                <li  class="tooltips-general search-book-button" data-href="searchbook.html" data-placement="bottom" title="Buscar libro">
                    <i class="zmdi zmdi-search"></i>
                </li>
                <li  class="tooltips-general btn-help" data-placement="bottom" title="Ayuda">
                    <i class="zmdi zmdi-help-outline zmdi-hc-fw"></i>
                </li>
                <li class="mobile-menu-button visible-xs" style="float: left !important;">
                    <i class="zmdi zmdi-menu"></i>
                </li>
                <li class="desktop-menu-button hidden-xs" style="float: left !important;">
                    <i class="zmdi zmdi-swap"></i>
                </li>
            </ul>
        </nav>
        <div class="container">
            <div class="page-header">

                <!CAMBIAR NOMBRE #######################################################################################>
                <h1 class="all-tittles">Sistema bibliotecario |<small>Bienvenido</small></h1>
            </div>
        </div>

        <!CUERPO DEL DOCUMENTO #######################################################################################>




        <form class="form-padding">
            <div class="row">

                <div class="col-xs-12">


                    <!Botones y cuadros de texto AQUI ##########################################################>
                    <div class="title-flat-form title-flat-blue">Realizar Prestamo</div>
                    <legend><i class="zmdi zmdi-account-box"></i> &nbsp; Ejemplar a prestar</legend><br>
                    <%
                        Date dNow = new Date();
                        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
                        String currentDate = ft.format(dNow);
                    %>
                    <%
                        PrestamoSQL sql = new PrestamoSQL();
                        UsuarioSQL sql2 = new UsuarioSQL();
                        List<String> obj = new ArrayList<String>();
                        List<String> pers = new ArrayList<String>();

                        int nivel = (Integer) sesion.getAttribute("nivel");
                        String user = (String) sesion.getAttribute("Nombre");

                        obj = sql.seleccionarEjemplar("LIB003");
                        pers = sql2.BuscarporCorreo(user, nivel);

                        if (obj.get(2) == null || obj.size() == 0) {

                            response.sendRedirect("ControladorPrestamo?accion=noejemplares");
                        } else {
                            obj.add(currentDate);
                        }


                    %>

                    <div class="col-xs-12 col-sm-8 col-md-8 text-justify lead">

                        Hola has escogido el libro con el nombre de: <%=obj.get(2)%> <br><br>
                        Numero de ejemplar: <%=obj.get(0)%> <br><br>
                        Fecha del prestamo: <%=currentDate%> <br><br>
                        Prestamo a nombre de: <%=pers.get(3)%> <%=pers.get(4)%><br><br><br><br>

                    </div>



                    <input type="hidden" name="txtFecha" value="<%=currentDate%>" >
                    <input type="hidden" name="txtEjemplar" value="<%=obj.get(0)%>" >
                    <input type="hidden" name="txtID" value="<%=pers.get(0)%>" >



                    <div class="col-xs-12">
                        <p class="text-center">
                            <button type="submit" name="accion" value="realizarprestamo" class="btn btn-primary"><i class="zmdi zmdi-floppy"></i> &nbsp;&nbsp; Guardar</button>
                        </p> 
                    </div>
                    <!Botones y cuadros de texto AQUI ##########################################################>


                </div>
            </div>
        </form>
    </div>







    <!CUERPO DEL DOCUMENTO #######################################################################################>

<div class="modal fade" tabindex="-1" role="dialog" id="ModalHelp">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title text-center all-tittles">ayuda del sistema</h4>
            </div>
            <div class="modal-body">
                Cominicarse con el administrador.
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="zmdi zmdi-thumb-up"></i> &nbsp; De acuerdo</button>
            </div>
        </div>
    </div>
</div>
<footer class="footer full-reset">
    <div class="container-fluid">
        <div class="row">
            <div class="col-xs-12 col-sm-6">
                <h4 class="all-tittles">Acerca de</h4>
                <p>
                    Sistema en fase de desarollo.
                </p>
            </div>
            <div class="col-xs-12 col-sm-6">
                <h4 class="all-tittles">Desarrollador</h4>
                <ul class="list-unstyled">
                    <li><i class="zmdi zmdi-check zmdi-hc-fw"></i>&nbsp; Jose Sorto <i class="zmdi zmdi-facebook zmdi-hc-fw footer-social"></i><i class="zmdi zmdi-twitter zmdi-hc-fw footer-social"></i></li>
                    <li><i class="zmdi zmdi-check zmdi-hc-fw"></i>&nbsp; Lilian Recinos <i class="zmdi zmdi-facebook zmdi-hc-fw footer-social"></i><i class="zmdi zmdi-twitter zmdi-hc-fw footer-social"></i></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="footer-copyright full-reset all-tittles">© 2020 Poo UDB Virtual</div>
</footer>
</div>
</body>
</html>
