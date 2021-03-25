package page;

import Utils.DriverContext;
import Utils.Espera;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Carga_Archivos {

    public Carga_Archivos(){
        PageFactory.initElements(DriverContext.getDriver(), this); }

    @FindBy (xpath = "//*[@id=\"imMnMnNode6\"]/a/span/span/span[2]")
    WebElement btnCargaArchivos;

    @FindBy (xpath = "//*[@id=\"imObjectForm_1_2\"]")
    WebElement btnSeleccionArchivo;

    @FindBy (xpath = "//*[@id=\"imObjectForm_1_submit\"]")
    WebElement btnEnviarArchivo;

    public void archivos(String archivo) throws InterruptedException{
        btnCargaArchivos.click();
        btnSeleccionArchivo.sendKeys(archivo);
        Espera.esperar("//*[@id=\"imObjectForm_1_submit\"]");
        btnEnviarArchivo.click();
    }
}
