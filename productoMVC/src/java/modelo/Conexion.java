package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    static private Connection connection = null;

    private Conexion() {
    }

    public static Connection getInstance() {
        if (connection == null) {
            connection = Conexion.conexion("com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost/ejemplo",
                    "root", "");
        }
        return connection;
    }

    public static Connection conexion(String driver,
            String url,
            String user,
            String pass) {
        Connection cn = null;
        try {
            Class.forName(driver);
            Connection conexion = DriverManager.getConnection(url,
                    user, pass);
            cn = conexion;
        } catch (ClassNotFoundException e) {
            System.out.println("Error en clase: "
                    + e.getStackTrace());
            e.printStackTrace();
        } catch (SQLException esql) {
            System.out.println("Error de sql: "
                    + esql.getSQLState());
            esql.printStackTrace();
        }
        return cn;
    }
}
