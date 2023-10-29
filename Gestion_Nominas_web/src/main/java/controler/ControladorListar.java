package controler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import excepciones.DatosNoCorrectosException;
import model.*;

/**
 * Esta clase es un controlador que administra las peticiones relacionadas con la base de datos
 * de gestión de nóminas. Responde a las solicitudes GET para listar empleados.
 */

@WebServlet(description = "administra peticiones para la base de datos de gestion de nominas", urlPatterns = {"/listar"})
public class ControladorListar extends HttpServlet {

    /**
     * Maneja las solicitudes GET para listar empleados y muestra la lista en una vista.
     *
     * @param request  La solicitud HTTP entrante.
     * @param response La respuesta HTTP que se enviará al cliente.
     * @throws ServletException Si ocurre un error durante la manipulación de la solicitud.
     * @throws IOException      Si ocurre un error de entrada/salida.
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestionDAO gestionDAO = new GestionDAO();

        try {
            List<Empleado> lista = gestionDAO.obtenerEmpleados();

            request.setAttribute("lista", lista);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listar.jsp");
            requestDispatcher.forward(request, response);

        } catch (SQLException e) {
            // Maneja excepciones de SQL
            e.printStackTrace();
        } catch (DatosNoCorrectosException e) {
            // Lanza una excepción de tiempo de ejecución si los datos no son correctos
            throw new RuntimeException(e);
        }
    }
}
