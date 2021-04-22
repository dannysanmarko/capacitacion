package page;

import Utils.DriverContext;
import Utils.Espera;
import Utils.ReadProperties;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Index {
    @FindBy(xpath = "//*[@id=\"imUname\"]")
    WebElement txtUser;

    @FindBy(xpath = "//*[@id=\"imPwd\"]")
    WebElement txtPws;

    @FindBy(xpath = "//*[@id=\"imLogin\"]/form/div[3]/input")
    WebElement btnIngresar;

    @FindBy(xpath = "//*[@id=\"imLoginPage\"]/div[3]/div")
    WebElement msgError;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_2\"]")
    WebElement txtCampo1;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_3\"]")
    WebElement txtCorreo;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_4\"]")
    WebElement txtCampo2;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_5\"]")
    WebElement txtFecha;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_6\"]")
    WebElement btnLista;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_7_container\"]")
    WebElement btnMultiple;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_7_0\"]")
    WebElement btnMulti1;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_7_1\"]")
    WebElement btnMulti2;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_7_2\"]")
    WebElement btnMulti3;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_8_container\"]")
    WebElement btnRadio;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_8_0\"]")
    WebElement btnRadio1;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_5_icon\"]")
    WebElement btnFecha;

    @FindBy(xpath = "//*[@id=\"imDatePicker\"]")
    WebElement tabFecha;


    public Index() {
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    /**
     * Metodo para que ingrese el usuario correctamente
     *
     * @param usuario parametro de tipo string que contiene el nombre del usuario.
     * @param clave   parametro de tipo string que contiene la contraseña del usuario.
     * @throws InterruptedException extencion que se genera en caso de que tenga que esperar un tiempo y luego seguir ejecutandoce.
     */

    public void login(String usuario, String clave) throws InterruptedException {
        PdfQaNovaReports.addWebReportImage("Inicio de la pagina", "El ingreso a la paginda y correcto despliege de los textbox de usuarios y  contraseña  ", EstadoPrueba.DONE, false);
        txtUser.click();
        txtUser.sendKeys(usuario);
        txtPws.click();
        txtPws.sendKeys(clave);
        PdfQaNovaReports.addWebReportImage("Ingreso de datos", "El ingreso del usuario " + usuario + " y la contraseña " + clave + " a sido todo un exito", EstadoPrueba.DONE, false);
        btnIngresar.click();
        Thread.sleep(1000);
        PdfQaNovaReports.addWebReportImage("Inicio de usuario", "El ingreso a la paginda a sido exitoso  ", EstadoPrueba.DONE, false);
    }

    /**
     * Metodo que extrae el mensaje de error de usuario
     *
     * @param msgAux parametro de tipo string que contiene el mensaje que debe desplegar en caso de que el usuario no este registrado.
     * @throws InterruptedException extencion que se genera en caso de que tenga que esperar un tiempo y luego seguir ejecutandoce.
     */

    public void Ierror(String msgAux) throws InterruptedException {
        PdfQaNovaReports.addWebReportImage("Inicio de la pagina", "El ingreso a la paginda ", EstadoPrueba.DONE, false);
        btnIngresar.click();
        String msg = msgError.getText();
        String color = msgError.getCssValue("color");
        PdfQaNovaReports.addWebReportImage("Ingreso de datos", "El ingreso del usuario  y la contraseña erronia y extraccion de mensaje y color", EstadoPrueba.PASSED, false);
        if (msgAux.equals(msg)) {
            System.out.println("El texto " + msg + " se encontro en la pagina\n" + "El color es " + color);
        } else {
            System.out.println("El texto " + msgAux + "no se encontro en la pagina");
        }
    }

    /**
     * Metodo que ingresa y rellena los campos de la carga de informacion
     *
     * @param usuario     parametro de tipo string que contiene el nombre del usuario.
     * @param clave       parametro de tipo string que contiene la contraseña del usuario.
     * @param campo1      parametro de tipo string que contiene lo que el usuario quiera ingresar en el campo texto.
     * @param campo2      parametro de tipo string que contiene lo que el usuario quiera ingresar en el campo area de texto.
     * @param correo      parametro de tipo string que contiene el correo que el correo ingresado por el usuario.
     * @param fecha       parametro de tipo string que contiene la fecha que quiere ingresar en el texbox.
     * @param campo_lista parametro de tipo int que contiene la opcion segun el orden de la lista.
     * @param Multi2      parametro de tipo boolean que contiene un True haciendo que seleccione un select multiple.
     * @param Multi1      parametro de tipo boolean que contiene un True haciendo que seleccione un select multiple.
     * @param Multi3      parametro de tipo boolean que contiene un True haciendo que seleccione un select multiple.
     * @param campo_radio parametro de tipo int que contiene uno de los button radio.
     */

    public void login_2(String usuario, String clave, String campo1, String campo2, String correo, String fecha, int campo_lista, boolean Multi1, boolean Multi2, boolean Multi3, int campo_radio) {
        PdfQaNovaReports.addWebReportImage("Inicio de la pagina", "El ingreso a la paginda y correcto despliege de los textbox de usuarios y  contraseña  ", EstadoPrueba.DONE, false);
        txtUser.sendKeys(usuario);
        txtPws.sendKeys(clave);
        PdfQaNovaReports.addWebReportImage("Ingreso de datos", "El ingreso del usuario " + usuario + " y la contraseña " + clave + " a sido todo un exito", EstadoPrueba.DONE, false);
        btnIngresar.click();
        Espera.esperar("//*[@id=\"imObjectForm_1_2\"]");
        PdfQaNovaReports.addWebReportImage("Inicio de usuario", "El ingreso a la paginda a sido exitoso  ", EstadoPrueba.DONE, false);
        txtCampo1.sendKeys(campo1);
        txtCampo2.sendKeys(campo2);
        txtCorreo.sendKeys(correo);
        txtFecha.sendKeys(fecha);

        Select Lista = new Select(btnLista);
        Lista.selectByIndex(campo_lista);
        if (Multi1) {
            btnMulti1.click();
        }
        if (Multi2) {
            btnMulti2.click();
        }
        if (Multi3) {
            btnMulti3.click();
        }

        switch (campo_radio) {
            case 1:
                btnRadio1.click();
                break;
            case 2:
                btnRadio1.click();
                break;
            case 3:
                btnRadio1.click();
                break;
        }
        PdfQaNovaReports.addWebReportImage("Ingreso de datos", "Completamiento de los textbox correspondientes para la carga de informacion", EstadoPrueba.PASSED, false);

    }

    /**
     * Metodo que ingresa el usuario
     *
     * @param usuario parametro de tipo string que contiene el nombre del usuario.
     * @param clave   parametro de tipo string que contiene la contraseña del usuario.
     */

    public void extraer(String usuario, String clave) {
        txtUser.sendKeys(usuario);
        txtPws.sendKeys(clave);
        btnIngresar.click();
        Espera.esperar("//*[@id=\"imObjectForm_1_2\"]");
    }

    /**
     * Metodo de seleccion de DatePicker (calendario)
     *
     * @throws InterruptedException extencion que se genera en caso de que tenga que esperar un tiempo y luego seguir ejecutandoce.
     */

    public void fecha() throws InterruptedException {
        Thread.sleep(1000);
        btnFecha.click();
        Thread.sleep(1000);
        List<WebElement> fila = tabFecha.findElements(By.tagName("td"));
        int cantidadFila = fila.size();

        for (int i = 1; i < cantidadFila; i++) {
            String dia = fila.get(i).getText();

            if (dia.equals(ReadProperties.readFromConfig("Properties.properties").getProperty("Dia"))) {
                fila.get(i).click();
                break;

            }
        }
    }
}
