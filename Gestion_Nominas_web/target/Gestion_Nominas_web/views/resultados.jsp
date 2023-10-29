<%@ page import="model.Empleado" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Listar Empleados</title>
    <style>
        body {
            background-color: #f7ecd6; /* Fondo de tono pastel */
            text-align: center;
        }
        table{
            width: 100%;
        }
        .menu-container {
            margin: 100px auto;
            width: 800px; /* Ancho del menú */
            background-color: #ffffff; /* Fondo blanco */
            padding: 20px;
            border-radius: 10px;
        }
        .menu-container a, .inicio, .menu-container a:visited{
            text-decoration: none;
            color: #F3C734;
            font-weight: bold;
            -webkit-text-stroke-width: 0.2px;
            -webkit-text-stroke-color: black;
        }

        h1{
            font-size: 40px;
            color: #F3C734;
            -webkit-text-stroke-width: 1px;
            -webkit-text-stroke-color: black;
        }
        .principal{
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="menu-container">
    <h1>Listar Empleados Por Campo</h1>
    <table border="1">
        <%
        List<Empleado> empleados = (List<Empleado>) request.getAttribute("empleados");
        if (empleados != null){
        for (Empleado empleado : empleados) {
    %>
        <tr>
            <td class="principal">Nombre</td>
            <td><%= empleado.getNombre() %></td>
            <td>
                <a href="#">MODIFICAR</a>
            </td>
        </tr>
        <tr>
            <td class="principal">DNI</td>
            <td><%= empleado.getDni() %></td>
            <td>
                <a href="#">MODIFICAR</a>
            </td>
        </tr>
        <tr>
            <td class="principal">Sexo</td>
            <td><%= empleado.getSexo() %></td>
            <td>
                <a href="#">MODIFICAR</a>
            </td>
        </tr>
        <tr>
            <td class="principal">Categoria</td>
            <td><%= empleado.getCategoria() %></td>
            <td>
                <a href="#">MODIFICAR</a>
            </td>
        </tr>
        <tr>
            <td class="principal">Años Trabajados</td>
            <td><%= empleado.getAnyosTrabajados() %></td>
            <td>
                <a href="#">MODIFICAR</a>
            </td>
        </tr>
        <% }
           } %>
    </table>
    <br>
    <div class="inicio">
        <a href="index.jsp">Volver</a>
    </div>

</div>
</body>
</html>
