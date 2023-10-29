package conexion;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Esta clase proporciona métodos para establecer y obtener conexiones a una base de datos MySQL
 * utilizando un pool de conexiones a través de Apache DBCP.
 */
public class ConexionDB {
    private static BasicDataSource dataSource = null;

    /**
     * Obtiene un DataSource para la conexión a la base de datos.
     *
     * @return Un DataSource configurado para la base de datos MySQL.
     */

    private static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUsername("root");
            dataSource.setPassword("123456");
            dataSource.setUrl("jdbc:mysql://localhost:3306/gestion_nominas?useTimezone=true&serverTimezone=UTC");
        }
        return dataSource;
    }

    /**
     * Obtiene una conexión activa a la base de datos a partir del DataSource.
     *
     * @return Una conexión a la base de datos.
     * @throws SQLException Si ocurre un error al establecer la conexión.
     */

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
}
