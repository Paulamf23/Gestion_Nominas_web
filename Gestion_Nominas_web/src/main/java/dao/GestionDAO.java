package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import conexion.ConexionDB;
import excepciones.DatosNoCorrectosException;
import model.Empleado;

/**
 * Esta clase proporciona métodos para acceder y gestionar datos relacionados con empleados en la base de datos.
 */

public class GestionDAO {
    private static Connection connection;
    private static PreparedStatement statement;

    /**
     * Obtiene una lista de empleados desde la base de datos.
     *
     * @return Una lista de objetos Empleado representando a los empleados en la base de datos.
     * @throws SQLException             Si ocurre un error de SQL durante la consulta.
     * @throws DatosNoCorrectosException Si los datos de la base de datos no son correctos.
     */

    // obtener lista de empleados
    public static List<Empleado> obtenerEmpleados() throws SQLException, DatosNoCorrectosException {
        ResultSet rs = null;
        List<Empleado> lista = new ArrayList<>();

        String sql = null;
        connection = obtenerConexion();

        try {
            sql = "SELECT * FROM empleado";  // El nombre de la tabla es "empleado"
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String dni = rs.getString("dni");
                char sexo = rs.getString("sexo").charAt(0);
                int categoria = rs.getInt("categoria");
                double anyosTrabajados = rs.getDouble("anyosTrabajados");

                Empleado empleado = new Empleado(nombre, dni, sexo, categoria, anyosTrabajados);

                lista.add(empleado);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    /**
     * Obtiene un objeto de empleado desde la base de datos basado en su DNI.
     *
     * @param dni El DNI del empleado a buscar.
     * @return Un objeto Empleado representando al empleado encontrado, o null si no se encuentra.
     * @throws SQLException             Si ocurre un error de SQL durante la consulta.
     * @throws DatosNoCorrectosException Si los datos de la base de datos no son correctos.
     */
    public Empleado obtenerEmpleado(String dni) throws SQLException, DatosNoCorrectosException {
        ResultSet resultSet = null;
        Empleado empleado = null;
        connection = obtenerConexion();

        try {
            String sql = "SELECT * FROM empleado WHERE dni =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, dni);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                empleado = new Empleado();

                empleado.setNombre(resultSet.getString(1));
                empleado.setDni(resultSet.getString(2));
                empleado.setSexo(resultSet.getString(3).charAt(0));
                empleado.setCategoria(resultSet.getInt(4));
                empleado.setAnyosTrabajados(resultSet.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empleado;
    }

    /**
     * Busca empleados en la base de datos que coincidan con un campo y valor especificados.
     *
     * @param campo El nombre del campo por el cual se busca.
     * @param valor El valor a buscar en el campo.
     * @return Una lista de objetos Empleado que coinciden con el campo y valor especificados.
     */
    public List<Empleado> buscarEmpleadoPorCampo(String campo, String valor) {
        List<Empleado> empleados = new ArrayList<>();
        String sql = null;

        try (Connection con = ConexionDB.getConnection();
             PreparedStatement statement = con.prepareStatement("SELECT * FROM empleado WHERE " + campo + " like ?")) {
            statement.setString(1, "%" + valor + "%");


            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    String nombreEmpleado = rs.getString(1);
                    String dniEmpleado = rs.getString(2);
                    char sexoEmpleado = rs.getString(3).charAt(0);
                    int categoriaEmpleado = rs.getInt(4);
                    double anyosTrabajadosEmpleado = rs.getDouble(5);

                    Empleado empleado = new Empleado(nombreEmpleado, dniEmpleado, sexoEmpleado, categoriaEmpleado, anyosTrabajadosEmpleado);
                    empleados.add(empleado);
                }
            } catch (DatosNoCorrectosException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }


    /**
     * Obtiene una conexión de la pool de conexiones.
     *
     * @return Una conexión a la base de datos.
     * @throws SQLException Si ocurre un error al obtener la conexión.
     */
    private static Connection obtenerConexion() throws SQLException {
        return ConexionDB.getConnection();
    }


}
