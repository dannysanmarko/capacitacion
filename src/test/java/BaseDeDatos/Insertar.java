package BaseDeDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Insertar {

    private static Conexion1 conexion1;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        conexion1 = new Conexion1();
        Connection con = conexion1.getCon();
        Statement statement;
        ResultSet resultSet;
        statement = con.createStatement();
        statement.setQueryTimeout(30);
        String query = "insert into elementos(Campo_Texto, Campo_Mail, Campo_Area_de_Texto, Campo_Fecha, Campo_Lista, Campo_Seleccion_Multiple, Campo_Radio_Button) values('wena','hola@qanova.cl','how are you doing?','2021-04-14','valor1','selec1','btn1')";
        statement.executeUpdate(query);
        con.close();
    }
}
