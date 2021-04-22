package BaseDeDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Actualizar {

    private static Conexion1 conexion1;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        conexion1 = new Conexion1();
        Connection con = conexion1.getCon();
        Statement statement;
        ResultSet resultSet;
        statement = con.createStatement();
        statement.setQueryTimeout(30);
        String query = "update elementos set Campo_Mail = 'wena@qanova.cl' where id=3";
        statement.executeUpdate(query);
        con.close();
    }
}
