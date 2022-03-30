<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Verificación de cookies</h1>
    </body>
    <%
        if (Boolean.parseBoolean(request.getAttribute("detectar").toString())) {
    %>
    Gracias por visitarnos nuevamente
    <%} else {%>
    Bienvenido nuestro sitio Web


    <%
        }
    %>
    <br>
    <a href="sessionMiguel">Ir a la parte de sesiones</a>

</html>
