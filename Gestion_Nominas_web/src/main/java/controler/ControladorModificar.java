package controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import model.*;

/**
 * Esta clase es un controlador que administra las peticiones relacionadas con la base de datos
 * de gestión de nóminas. Responde a las solicitudes GET y POST para modificar y buscar empleados.
 */

@WebServlet(description = "administra peticiones para la base de datos de gestion de nominas", urlPatterns = { "/modificar" })
public class ControladorModificar extends HttpServlet {

    /**
     * Maneja las solicitudes GET para mostrar un formulario de modificación de empleados.
     *
     * @param request  La solicitud HTTP entrante.
     * @param response La respuesta HTTP que se enviará al cliente.
     * @throws ServletException Si ocurre un error durante la manipulación de la solicitud.
     * @throws IOException      Si ocurre un error de entrada/salida.
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                request.setAttribute("mensaje", "");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/formularioModificar.jsp");
                requestDispatcher.forward(request, response);

    }

    /**
     * Maneja las solicitudes POST para buscar empleados según un campo y un valor especificados.
     *
     * @param request  La solicitud HTTP entrante con los parámetros de búsqueda.
     * @param response La respuesta HTTP que se enviará al cliente.
     * @throws ServletException Si ocurre un error durante la manipulación de la solicitud.
     * @throws IOException      Si ocurre un error de entrada/salida.
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String campo = request.getParameter("campo");
        String valor = request.getParameter("valor");

        if (campo != null && valor != null) {
                List<Empleado> empleados = new ArrayList<>();
                GestionDAO gestionDAO = new GestionDAO();

                empleados = gestionDAO.buscarEmpleadoPorCampo(campo,valor);

                if (empleados.isEmpty()) {
                    request.setAttribute("mensaje", "No se encontraron empleados para el campo " + campo + " con valor " + valor);
                } else {
                    request.setAttribute("empleados", empleados);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/resultados.jsp");
                    requestDispatcher.forward(request, response);
                }
            }
        }

    }

