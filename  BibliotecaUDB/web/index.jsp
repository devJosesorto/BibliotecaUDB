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
        </div>

    </body>
</html>