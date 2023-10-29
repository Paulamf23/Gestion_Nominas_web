<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Formulario Modifica Empleado</title>
    <style>
        body {
            background-color: #f7ecd6;
            text-align: center;
        }
        .menu-container {
            margin: 100px auto;
            width: 800px; /* Ancho del menú */
            background-color: #ffffff; /* Fondo blanco */
            padding: 20px;
            border-radius: 10px;
        }

        .menu-container a, .menu-container a:visited{
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

        table {
            width: 80%;
            border: 2px solid #F3C734;
            margin: 20px auto;
        }

        tr {
            background-color: #f2f2f2;
            text-align: center;
        }

        td {
            padding: 12px;
            border: 1px solid #333;
            text-align: center;
        }

        input {
            padding: 10px;
            border: 2px solid #F3C734;
            border-radius: 5px;
            width: 40%;
            margin: 10px 0;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="menu-container">
<h1>Modificar</h1>
<p><%=request.getAttribute("mensaje")%></p>
    <form action="modificar" method="post">
        <table border="1">
            <tr>
                <td>Seleccionar campo:</td>
                <td>
                    <select name="campo">
                        <option value="nombre">Nombre</option>
                        <option value="dni">DNI</option>
                        <option value="sexo">Sexo</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Valor:</td>
                <td><input type="text" name="valor" size="50"></td>
            </tr>
        </table>
        <input type="submit" name="accion" value="Buscar">
    </form>

    <div class="inicio">
        <a href="index.jsp">Volver</a>
    </div>
</div>
</body>
</html>