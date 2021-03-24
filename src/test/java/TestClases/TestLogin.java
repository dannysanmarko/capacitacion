package TestClases;

import page.Index;
import page.Tabla;

public class TestLogin  {

    Index index;
    Tabla tabla;
    public void inicio(String usuario, String clave) throws InterruptedException{
        index = new Index();
        index.login(usuario, clave);
    }

    public void ErrorAux() {
        String msgAux = "Nombre y/o password incorrecto";
        index = new Index();
        index.Ierror(msgAux);
    }

    public void inicio2(String usuario, String clave, String campo1, String campo2, String correo, String fecha, int campo_lista, boolean Multi1, boolean Multi2, boolean Multi3, int campo_radio) throws InterruptedException{
        index = new Index();
        index.login_2(usuario, clave, campo1, campo2, correo, fecha,campo_lista, Multi1, Multi2, Multi3, campo_radio);
    }

    public void extraer_tabla(String nombre){
        tabla = new Tabla();
        tabla.Filtrar(nombre);
    }


}
