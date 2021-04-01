package page;

import Utils.DriverContext;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgregarUsuario {

    public AgregarUsuario() {
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"dynObj_02\"]/p/a")
    WebElement btnCrearUsuario;

    @FindBy(xpath = "//*[@id=\"imRegUname\"]")
    WebElement txtUsuario;

    @FindBy(xpath = "//*[@id=\"imRegPwd\"]")
    WebElement txtContraseña;

    @FindBy(xpath = "//*[@id=\"imRepeatPwd\"]")
    WebElement txtRepContra;

    @FindBy(xpath = "//*[@id=\"imRealname\"]")
    WebElement txtNombreCompleto;

    @FindBy(xpath = "//*[@id=\"imEmail\"]")
    WebElement txtEmail;

    @FindBy(xpath = "//*[@id=\"imRegister_submit\"]")
    WebElement btnRegistrarse;

    @FindBy(xpath = "//*[@id=\"imLoginPage\"]/div[4]/div")
    WebElement msgRegistrado;

    /**
     * Metodo para agregar un nuevo usuario
     *
     * @param nuevoUsuario parametro de tipo string que contiene el nombre del nuevo usuario.
     * @param contra parametro de tipo string que contiene la contraseña del usuario.
     * @param nombreCompleto parametro de tipo string que contiene los nombres y apellidos del usuario.
     * @param correo parametro de tipo string que contiene el correo que el correo ingresado por el usuario.
     * @param msgAuxi parametro de tipo string que contiene el mensaje que deberia retornar en caso de que el ususario se haya registrado con exito.
     * @param msgFallado parametro de tipo string que contiene el mensaje que deberia retornar en caso de que el ususario ya estaba registrado.
     * @throws InterruptedException extencion que se genera en caso de que tenga que esperar un tiempo y luego seguir ejecutandoce.
     */
    public void agregar(String nuevoUsuario, String contra, String nombreCompleto, String correo, String msgAuxi, String msgFallado) throws InterruptedException {
        PdfQaNovaReports.addWebReportImage("Inicio de la pagina", "El ingreso a la paginda y correcto ingreso del boton crear usuario ", EstadoPrueba.DONE, false);
        btnCrearUsuario.click();
        Thread.sleep(1000);
        PdfQaNovaReports.addWebReportImage("Ingreso a la pagina de registrar una nueva cuenta", "Carga nueva pagina donde se encontraran los textbox correspondientes para un usuario ya registrado como para registrar una nueva cuenta", EstadoPrueba.PASSED, false);
        txtUsuario.sendKeys(nuevoUsuario);
        txtContraseña.sendKeys(contra);
        txtRepContra.sendKeys(contra);
        txtNombreCompleto.sendKeys(nombreCompleto);
        txtEmail.sendKeys(correo);
        PdfQaNovaReports.addWebReportImage("Ingreso de datos", "Completamiento de los textbox correspondientes para registrar un nuevo ususario al sistema", EstadoPrueba.PASSED, false);
        btnRegistrarse.click();
        String msg = msgRegistrado.getText();
        String color = msgRegistrado.getCssValue("color");
        if (msgAuxi.equals(msg)) {
            System.out.println("El texto " + msg + " se encontro en la pagina\n" + "El color es " + color);
            PdfQaNovaReports.addWebReportImage("Usuario registrado", "se despliega mensaje " + msg + " correctamente", EstadoPrueba.PASSED, false);
        } else {
            System.out.println("El texto " + msgAuxi + " no se encontro en la pagina, se econtro el texto " + msgFallado);

        }

    }
}
