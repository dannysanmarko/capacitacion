package page;

import Utils.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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


    public Index() {
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    public void login(String usuario, String clave) {
        txtUser.click();
        txtUser.sendKeys(usuario);
        txtPws.click();
        txtPws.sendKeys(clave);
        btnIngresar.click();
    }

    public void Ierror(String msgAux) {
        btnIngresar.click();
        String msg = msgError.getText();
        String color = msgError.getCssValue("color");
        if (msgAux.equals(msg)) {
            System.out.println("El texto " + msg + " se encontro en la pagina\n" + "El color es " + color);
        } else {
            System.out.println("El texto " + msgAux + "no se encontro en la pagina");
        }
    }

    public void login_2(String usuario, String clave, String campo1, String campo2, String correo, String fecha, int campo_lista, boolean Multi1, boolean Multi2, boolean Multi3, int campo_radio) {
        txtUser.sendKeys(usuario);
        txtPws.sendKeys(clave);
        btnIngresar.click();
        Utils.Espera.esperar("//*[@id=\"imObjectForm_1_2\"]");
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


    }

    public void extraer(String usuario, String clave){
        txtUser.sendKeys(usuario);
        txtPws.sendKeys(clave);
        btnIngresar.click();
        Utils.Espera.esperar("//*[@id=\"imObjectForm_1_2\"]");

    }

}
