<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Libro"%>
<%@page import="ModeoDAO.LibroSQL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Listar Libros</h1>
            
            <table border="1">
                <thead>
                    <tr>
                        <th>codLibro</th>
                        <th>Titulo</th>
                        <th>cod_Categoria</th>
                        <th>cod_Autor</th>
                        <th>cod_Editorial</th>
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
                        System.out.println("olv");
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
