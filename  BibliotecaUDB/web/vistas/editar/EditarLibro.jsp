<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>

<%@page import="Modelo.Libro"%>
<%@page import="ModeoDAO.LibroSQL"%>

<%@page import="Modelo.Autor"%>
<%@page import="ModeoDAO.AutorSQL"%>

<%@page import="Modelo.Categoria"%>
<%@page import="ModeoDAO.CategoriaSQL"%>

<%@page import="Modelo.Editorial"%>
<%@page import="ModeoDAO.EditorialSQL"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Buscar libro</title>
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
                        <li><a href="index.jsp"><i class="zmdi zmdi-home zmdi-hc-fw"></i>&nbsp;&nbsp; Inicio</a></li>
                        <li>
                            <div class="dropdown-menu-button"><i class="zmdi zmdi-case zmdi-hc-fw"></i>&nbsp;&nbsp; Administración <i class="zmdi zmdi-chevron-down pull-right zmdi-hc-fw icon-sub-menu"></i></div>
                            <ul class="list-unstyled">
                                <li><a href="institution.html"><i class="zmdi zmdi-balance zmdi-hc-fw"></i>&nbsp;&nbsp; Datos institución</a></li>
                                <li><a href="provider.html"><i class="zmdi zmdi-truck zmdi-hc-fw"></i>&nbsp;&nbsp; Nuevo proveedor</a></li>
                                <li><a href="category.html"><i class="zmdi zmdi-bookmark-outline zmdi-hc-fw"></i>&nbsp;&nbsp; Nueva categoría</a></li>
                                <li><a href="section.html"><i class="zmdi zmdi-assignment-account zmdi-hc-fw"></i>&nbsp;&nbsp; Nueva sección</a></li>
                            </ul>
                        </li>
                        <li>
                            <div class="dropdown-menu-button"><i class="zmdi zmdi-account-add zmdi-hc-fw"></i>&nbsp;&nbsp; Registro de usuarios <i class="zmdi zmdi-chevron-down pull-right zmdi-hc-fw icon-sub-menu"></i></div>
                            <ul class="list-unstyled">
                                <li><a href="admin.html"><i class="zmdi zmdi-face zmdi-hc-fw"></i>&nbsp;&nbsp; Nuevo administrador</a></li>
                                <li><a href="teacher.html"><i class="zmdi zmdi-male-alt zmdi-hc-fw"></i>&nbsp;&nbsp; Nuevo docente</a></li>
                                <li><a href="student.html"><i class="zmdi zmdi-accounts zmdi-hc-fw"></i>&nbsp;&nbsp; Nuevo estudiante</a></li>
                                <li><a href="personal.html"><i class="zmdi zmdi-male-female zmdi-hc-fw"></i>&nbsp;&nbsp; Nuevo personal administrativo</a></li>
                            </ul>
                        </li>
                        <li>
                            <div class="dropdown-menu-button"><i class="zmdi zmdi-assignment-o zmdi-hc-fw"></i>&nbsp;&nbsp; Libros y catálogo <i class="zmdi zmdi-chevron-down pull-right zmdi-hc-fw icon-sub-menu"></i></div>
                            <ul class="list-unstyled">
                                <li><a href="book.html"><i class="zmdi zmdi-book zmdi-hc-fw"></i>&nbsp;&nbsp; Nuevo libro</a></li>
                                <li><a href="catalog.html"><i class="zmdi zmdi-bookmark-outline zmdi-hc-fw"></i>&nbsp;&nbsp; Catálogo</a></li>
                            </ul>
                        </li>
                        <li>
                            <div class="dropdown-menu-button"><i class="zmdi zmdi-alarm zmdi-hc-fw"></i>&nbsp;&nbsp; Préstamos y reservaciones <i class="zmdi zmdi-chevron-down pull-right zmdi-hc-fw icon-sub-menu"></i></div>
                            <ul class="list-unstyled">
                                <li><a href="loan.html"><i class="zmdi zmdi-calendar zmdi-hc-fw"></i>&nbsp;&nbsp; Todos los préstamos</a></li>
                                <li>
                                    <a href="loanpending.html"><i class="zmdi zmdi-time-restore zmdi-hc-fw"></i>&nbsp;&nbsp; Devoluciones pendientes <span class="label label-danger pull-right label-mhover">7</span></a>
                                </li>
                                <li>
                                    <a href="loanreservation.html"><i class="zmdi zmdi-timer zmdi-hc-fw"></i>&nbsp;&nbsp; Reservaciones <span class="label label-danger pull-right label-mhover">7</span></a>
                                </li>
                            </ul>
                        </li>
                        <li><a href="report.html"><i class="zmdi zmdi-trending-up zmdi-hc-fw"></i>&nbsp;&nbsp; Reportes y estadísticas</a></li>
                        <li><a href="advancesettings.html"><i class="zmdi zmdi-wrench zmdi-hc-fw"></i>&nbsp;&nbsp; Configuraciones avanzadas</a></li>
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
                        <span class="all-tittles">Admin Name</span>
                    </li>
                    <li  class="tooltips-general exit-system-button" data-href="index.jsp" data-placement="bottom" title="Salir del sistema">
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

            <br><br><br>
            <h3 class="text-center all-tittles">Editar libro</h3>

            <!CUERPO DEL DOCUMENTO #######################################################################################>
            <form class="form-padding">
                
                 <form class="form-padding">
                <%
                    Libro libro = new Libro();
                    LibroSQL librosql = new LibroSQL();
                    String id =(String)request.getAttribute("id_");
                    libro=librosql.buscar(id);

                %>

                <input type="hidden" name="txtID" value="<%=libro.getCodLibro()%>" >
                
                <div class="row">

                    <div class="col-xs-12">
                        <div class="title-flat-form title-flat-blue">Editar libro</div>
                        <legend><i class="zmdi zmdi-account-box"></i> &nbsp; Datos del libro</legend><br>
                    </div>

                    <div class="col-xs-12 col-sm-6">
                        <div class="group-material">
                            <input type="text" name="txtTitulo" class="material-control tooltips-general" placeholder="Nombre del titulo" required="" maxlength="50" data-toggle="tooltip" data-placement="top" title="Escribe el nombre del titulo">
                            <span class="highlight"></span>
                            <span class="bar"></span>
                            <label> Titulo </label>
                        </div>
                    </div>

                    <div class="col-xs-12">
                        <div class="group-material">
                            <span>Autor</span>
                            <select name="txtAutor" class="tooltips-general material-control" data-toggle="tooltip" data-placement="top" title="Elige un autor" required>
                                <option value="" disabled="" selected="">Selecciona un autor</option>

                                <%
                                    AutorSQL autorsql = new AutorSQL();
                                    List<Autor> list = autorsql.Mostrar();
                                    Iterator<Autor> iter = list.iterator();
                                    Autor autor = null;
                                    while (iter.hasNext()) {
                                        autor = iter.next();
                                %>
                                <option value="<%=autor.getCodAutor()%>"><%=autor.getNombre()%></option>                              
                                <%}%>

                            </select>
                        </div>
                        <p class="text-center pull-right">
                            <a href="ControladorAutor?accion=nuevoautor" class="btn btn-info btn-xs" style="margin-right: 10px;"><i class="zmdi zmdi-info-outline"></i> &nbsp;&nbsp; Agregar autor</a>
                        </p>
                    </div>

                    <div class="col-xs-12">
                        <div class="group-material">
                            <span>Categoria</span>
                            <select name="txtCategoria" class="tooltips-general material-control" data-toggle="tooltip" data-placement="top" title="Elige la categoria del libro" required>
                                <option value="" disabled="" selected="">Selecciona una categoria</option>
                                <%
                                    CategoriaSQL categoriasql = new CategoriaSQL();
                                    List<Categoria> listcat = categoriasql.mostrar();
                                    Iterator<Categoria> itercat = listcat.iterator();
                                    Categoria categoria = null;
                                    while (itercat.hasNext()) {
                                        categoria = itercat.next();
                                %>
                                <option value="<%=categoria.getCodCategoria()%>"><%=categoria.getNombre()%></option>                              
                                <%}%>
                            </select>
                        </div>
                        <p class="text-center pull-right">
                            <a href="ControladorCategoria?accion=editarlibro" class="btn btn-info btn-xs" style="margin-right: 10px;"><i class="zmdi zmdi-info-outline"></i> &nbsp;&nbsp; Editar Libro</a>
                        </p>
                    </div>



                    <div class="col-xs-12">
                        <div class="group-material">
                            <span>Editorial</span>
                            <select name="txtEditorial" class="tooltips-general material-control" data-toggle="tooltip" data-placement="top" title="Elige una editorial" required>
                                <option value="" disabled="" selected="">Selecciona una Editorial</option>
                                <%
                                    EditorialSQL editorialsql = new EditorialSQL();
                                    List<Editorial> listedit = editorialsql.mostrar();
                                    Iterator<Editorial> iteredit = listedit.iterator();
                                    Editorial editorial = null;
                                    while (iteredit.hasNext()) {
                                        editorial = iteredit.next();
                                %>
                                <option value="<%=editorial.getCodEditorial()%>"><%=editorial.getNombre()%></option>                              
                                <%}%>
                            </select>
                        </div>
                        <p class="text-center pull-right">
                            <a href="ControladorEditorial?accion=nuevaeditorial" class="btn btn-info btn-xs" style="margin-right: 10px;"><i class="zmdi zmdi-info-outline"></i> &nbsp;&nbsp; Agregar Editorial</a>
                        </p>
                    </div>

                    <div class="col-xs-12 col-sm-6">
                        <div class="group-material">
                            <input type="text" name="txtDescripcion" class="material-control tooltips-general" placeholder="Escribe una breve descripcion" required="" maxlength="150" data-toggle="tooltip" data-placement="top" title="Escribe una breve descripcion">
                            <span class="highlight"></span>
                            <span class="bar"></span>
                            <label>Descripcion del libro</label>
                        </div>
                    </div>


                    <div class="col-xs-12 col-sm-6">
                        <div class="group-material">
                            <input type="text" name="txtISBN" class="material-control tooltips-general" placeholder="Escribe el ISBN" required="" maxlength="150" data-toggle="tooltip" data-placement="top" title="Escribe el ISBN">
                            <span class="highlight"></span>
                            <span class="bar"></span>
                            <label>ISBN</label>
                        </div>
                    </div>


                    <div class="col-xs-12">
                        <p class="text-center">
                            <button type="reset" class="btn btn-info" style="margin-right: 20px;"><i class="zmdi zmdi-roller"></i> &nbsp;&nbsp; Limpiar</button>
                            <button type="submit" name="accion" value="editarlibro" class="btn btn-primary"><i class="zmdi zmdi-floppy"></i> &nbsp;&nbsp; Guardar</button>
                        </p> 
                    </div>
                </div>
            </form>
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
