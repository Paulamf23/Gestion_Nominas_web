<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Menú de Opciones</title>
    <style>
        body {
            background-color: #f7ecd6; /* Fondo de tono pastel */
            text-align: center;
        }
        .menu-container {
            margin: 100px auto;
            width: 800px; /* Ancho del menú */
            background-color: #ffffff; /* Fondo blanco */
            padding: 20px;
            border-radius: 10px;
        }
        .menu-options {
            list-style-type: none;
            padding: 0;
        }
        .menu-options li {
            margin-bottom: 10px;
            font-size: 25px;
        }
        .menu-options a{
            text-decoration: none;
            color: black;
        }
        h1{
            font-size: 40px;
            color: #F3C734;
            -webkit-text-stroke-width: 1px;
            -webkit-text-stroke-color: black;
        }
    </style>
</head>
<body>
    <div class="menu-container">
        <h1>Menu de Opciones Nóminas</h1>
        <ul class="menu-options">
            <li><a href="listar"> Listar Empleado</a></li>
            <li><a href="sueldo"> Mostrar Salario</a></li>
            <li><a href="modificar"> Modificar un Empleado</a></li>
        </ul>
    </div>
</body>
</html>
