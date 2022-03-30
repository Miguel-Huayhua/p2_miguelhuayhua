<%-- 
    Document   : llenar
    Created on : 29-03-2022, 08:21:34 PM
    Author     : miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="sessionMiguel" method="post">
            <label for="id">ID: </label>
            <input id="id" type="text" name ="id" placeholder="Por favor, coloque el ID">
            <br>
            <label for="tarea">Tarea: </label>
            <input id="tarea" type="text" name ="tarea" placeholder="Coloque la tarea">
            <br>
            <input type="checkbox" checked name="completado" value = "true"></input>
            
            <br>
            <input type="submit" value="GUARDAR TAREA">
        </form>
    </body>
</html>
