<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="Bootstrap/css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Inicio Prueba git!</h1>
        <br><br>

        <div>
            <a class="btn btn-primary btn-sm" href="ControladorLibro?accion=listar" role="button">Listar libros</a>
            <a class="btn btn-primary btn-sm" href="ControladorLibro?accion=nuevoautor" role="button">Nuevo Autor</a>
            <a class="btn btn-primary btn-sm" href="ControladorLibro?accion=nuevolibro" role="button">Nuevo Libro</a>
            <a class="btn btn-primary btn-sm" href="ControladorLibro?accion=nuevoeditorial" role="button">Nuevo Editorial</a>
        </div>

    </body>
</html>