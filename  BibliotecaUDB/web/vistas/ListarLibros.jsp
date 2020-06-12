<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Libro"%>
<%@page import="ModeoDAO.LibroSQL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Libros</title>
        <link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="Bootstrap/css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div>
            <h1>Listar Libros</h1>
            
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>codLibro</th>
                        <th>Titulo</th>
                        <th>Categoria</th>
                        <th>Autor</th>
                        <th>Editorial</th>
                        <th>ISBN</th>
                    </tr>
                </thead>
                
                <%
                    LibroSQL libsql=new LibroSQL();
                    List<Libro> list=libsql.Mostrar();
                    Iterator<Libro>iter=list.iterator();
                    Libro lib=null;
                    while(iter.hasNext()){
                        lib=iter.next();
                       
                %>
                
                <tbody>
                    <tr>
                        <td><%=lib.getCodLibro()%></td>
                        <td><%=lib.getTitulo()%></td>
                        <td><%=lib.getCodCategoria()%></td>
                        <td><%=lib.getCodAutor()%></td>
                        <td><%=lib.getCodEditorial()%></td>
                        <td><%=lib.getCodISBN()%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

            
        </div>
    </body>
</html>
