package BaseDeDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultaPrueba {

    private static Conexion1 conexion1;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        conexion1 = new Conexion1();
        Connection con = conexion1.getCon();
        Statement statement;
        ResultSet resultSet;
        statement = con.createStatement();
        statement.setQueryTimeout(30);
        resultSet = statement.executeQuery("select * from export");
        System.out.println(resultSet);
        while (resultSet.next()){
            System.out.println("Id :" + resultSet.getString("id"));
            System.out.println("Campo texto: " + resultSet.getString("Campo_Texto"));
            System.out.println("Campo mail: " + resultSet.getString("Campo_Mail"));
            System.out.println("Campo area: " + resultSet.getString("Campo_Area_de_Texto"));
            System.out.println("Campo Fecha: " + resultSet.getString("Campo_Fecha"));
            System.out.println("Campo lista: " + resultSet.getString("Campo_Lista"));
            System.out.println("Campo seleccion: " + resultSet.getString("Campo_Seleccion_Multiple"));
            System.out.println("Combo radio: " + resultSet.getString("Combo_Radio_Button"));
            System.out.println("-----------------------------");
            //FINALIZANDO EL PROCESO
        }
        con.close();
    }


}
