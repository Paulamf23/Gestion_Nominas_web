package controler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexion.ConexionDB;
import dao.*;
import excepciones.DatosNoCorrectosException;
import model.*;

/**
 * Esta clase es un controlador que administra las peticiones relacionadas con el cálculo de
 * sueldos de empleados en la base de datos de gestión de nóminas. Responde a las solicitudes GET
 * y POST para consultar y mostrar el sueldo de un empleado.
 */

@WebServlet(description = "administra peticiones para la base de datos de gestion de nominas", urlPatterns = {"/sueldo"})
public class ControllerSueldo extends HttpServlet{

    /**
     * Maneja las solicitudes GET para mostrar un formulario de consulta de sueldo por DNI.
     *
     * @param request  La solicitud HTTP entrante.
     * @param response La respuesta HTTP que se enviará al cliente.
     * @throws ServletException Si ocurre un error durante la manipulación de la solicitud.
     * @throws IOException      Si ocurre un error de entrada/salida.
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("mensaje", "");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/formularioDNI.jsp");
        requestDispatcher.forward(request, response);
    }

    /**
     * Maneja las solicitudes POST para calcular y mostrar el sueldo de un empleado por su DNI.
     *
     * @param request  La solicitud HTTP entrante con el DNI del empleado a consultar.
     * @param response La respuesta HTTP que se enviará al cliente.
     * @throws ServletException Si ocurre un error durante la manipulación de la solicitud.
     * @throws IOException      Si ocurre un error de entrada/salida.
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Empleado empleado = new Empleado();
        empleado.setDni(request.getParameter("dni"));
        if (empleado.getDni().isEmpty() || !obtenerDni(empleado.getDni())) {
            request.setAttribute("mensaje", "Empleado no encontrado");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/formularioDNI.jsp");
            requestDispatcher.forward(request, response);
        } else {
            empleado = obtenerEmpleadoPorDni(empleado.getDni());

            if (empleado != null) {
                Nomina nomina = new Nomina();
                double sueldo = nomina.calculaSueldo(empleado);

                request.setAttribute("nombre", empleado.getNombre());
                request.setAttribute("dni", empleado.getDni());
                request.setAttribute("sueldo", sueldo);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/muestraSalario.jsp");
                requestDispatcher.forward(request, response);
            }
        }
    }

    /**
     * Verifica si un DNI no está vacío.
     *
     * @param dni El DNI a verificar.
     * @return true si el DNI no está vacío, false en caso contrario.
     */

    public boolean obtenerDni(String dni) {
        return !dni.isEmpty();
    }

    /**
     * Obtiene un objeto de empleado a través del DNI proporcionado.
     *
     * @param dni El DNI del empleado a buscar.
     * @return El objeto Empleado correspondiente al DNI, o null si no se encuentra.
     */

    public Empleado obtenerEmpleadoPorDni(String dni) {
        GestionDAO gestionDAO = new GestionDAO();
        try {
            return gestionDAO.obtenerEmpleado(dni);
        } catch (SQLException | DatosNoCorrectosException e) {
            e.printStackTrace();
            return null;
        }
    }
}
