package TestSuite;

import TestClases.TestLogin;
import Utils.DriverContext;
import Utils.Navegador;
import Utils.ReadProperties;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.Index;

public class RecuperarInformacion {
    String url = "http://www.qanovagroup.com/piloto";

    @BeforeTest
    public void setUp(){
        DriverContext.setUp(Navegador.Chrome,url);
    }

    @AfterTest
    public void end(){
        DriverContext.closeDriver();
    }

    @Test
    public void Inicio() throws InterruptedException {
        TestLogin iniciar = new TestLogin();
        iniciar.inicio("nvivas", "qanova");
    }

    @Test
    public void Ierror() throws InterruptedException {
        TestLogin iniciar = new TestLogin();
        iniciar.ErrorAux();
    }

    @Test
    public void inicio_2() throws InterruptedException {
        TestLogin iniciar2 = new TestLogin();
        String usuario = ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
        String clave = ReadProperties.readFromConfig("propiedades.properties").getProperty("clave");
        String campo1 = ReadProperties.readFromConfig("propiedades.properties").getProperty("campo1");
        String campo2 = ReadProperties.readFromConfig("propiedades.properties").getProperty("campo2");
        String correo = ReadProperties.readFromConfig("propiedades.properties").getProperty("correo");
        String fecha = ReadProperties.readFromConfig("propiedades.properties").getProperty("fecha");
        int campo_lista =Integer.parseInt( ReadProperties.readFromConfig("propiedades.properties").getProperty("valor_lista"));
        int campo_radio =Integer.parseInt( ReadProperties.readFromConfig("propiedades.properties").getProperty("radio_button1"));
        boolean Multi1 = (ReadProperties.readFromConfig("propiedades.properties").getProperty("Multi1").equals("true"));
        boolean Multi2 = (ReadProperties.readFromConfig("propiedades.properties").getProperty("Multi2").equals("true"));
        boolean Multi3 = (ReadProperties.readFromConfig("propiedades.properties").getProperty("Multi3").equals("true"));
        iniciar2.inicio2(usuario, clave, campo1, campo2, correo, fecha, campo_lista, Multi1, Multi2, Multi3, campo_radio);
    }

    @Test
    public void extraer_tabla() throws InterruptedException {
        Index extraer = new Index();
        String usuario = ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
        String clave = ReadProperties.readFromConfig("propiedades.properties").getProperty("clave");
        extraer.extraer(usuario,clave);
        TestLogin extraer_tabla = new TestLogin();
        String nombre = ReadProperties.readFromConfig("propiedades.properties").getProperty("nombre");
        extraer_tabla.extraer_tabla(nombre);
    }

    @Test
    public void subir_archivo() throws InterruptedException {
        Index extraer = new Index();
        String usuario = ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
        String clave = ReadProperties.readFromConfig("propiedades.properties").getProperty("clave");
        extraer.extraer(usuario,clave);
        TestLogin subir_archivos = new TestLogin();
        String archivo = ReadProperties.readFromConfig("propiedades.properties").getProperty("archivo");
        subir_archivos.subir_archivos(archivo);
    }
}
