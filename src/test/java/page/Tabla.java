package page;

import Utils.DriverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Tabla {

    public Tabla(){
        PageFactory.initElements(DriverContext.getDriver(), this); }

    @FindBy (xpath = "//*[@id=\"imMnMnNode4\"]/a/span/span/span[2]")
    WebElement btnMatrizInfo;

    @FindBy (xpath = "//*[@id=\"pluginAppObj_4_01_filter_field\"]")
    WebElement txtFiltrar;

    @FindBy (xpath = "//*[@id=\"pluginAppObj_4_01_filter_button\"]")
    WebElement btnFiltrar;

    @FindBy(xpath = "//*[@id=\"pluginAppObj_4_01_jtable\"]")
    WebElement tablaFiltrada;

    public void Filtrar(String nombre){
        btnMatrizInfo.click();
        txtFiltrar.sendKeys(nombre);
        btnFiltrar.click();
        Utils.Espera.esperar("//*[@id=\"pluginAppObj_4_01_jtable\"]");
        List<WebElement> filas = tablaFiltrada.findElements(By.tagName("tr"));

    }
}


