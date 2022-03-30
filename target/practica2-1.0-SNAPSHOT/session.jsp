<%-- 
    Document   : session
    Created on : 29-03-2022, 06:44:46 PM
    Author     : miguel
--%>

<%@page import="com.miguel.practica2.Tarea"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


        <a href="agregar">Nuevo</a>


        <table>
            <thead>
            <th>Id</th>
            <th>Tarea</th>
            <th>Completado</th>
            <th></th>
        </thead>
        <tbody>
           
 <%
                for (Tarea t : (ArrayList<Tarea>) request.getSession().getAttribute("tarea")) {
            %>
            <tr>
                <td><%=t.getId()%></td>
                <td><%=t.getTarea()%></td>
                <td>  <% if (t.isCompletado()) {
                    %>
                    <input type="checkbox" checked>
                    <%
                    } else { %>
                    <input type="checkbox">

                    <%}%>


                </td>
                <td><a href="sessionMiguel?borrar=si&id=<%=t.getId()%>">Eliminar</a></td>
            </tr>
            <%
                }
            %>


        </tbody>
    </table>



</body>
</html>
