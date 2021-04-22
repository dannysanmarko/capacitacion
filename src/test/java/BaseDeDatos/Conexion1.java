package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion1 {

    static final String BD = "qanova";
    static final String puerto = "jdbc:mysql://localhost:3306/qanova";
    static final String usuario = "root";
    static final String contra = "1104damabe";

    Connection con = null;

    public Conexion1() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(puerto,usuario,contra);
    }

    public Connection getCon() {
        return con;
    }
}
