package page;

import Utils.Espera;
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
        Espera.esperar("//*[@id=\"pluginAppObj_4_01_jtable\"]");
        List<WebElement> filas = tablaFiltrada.findElements(By.tagName("tr"));
        int cantFilas = filas.size();
        String id = "",texto = "", email = "", area = "", fecha = "", lista = "", seleccion = "", radio = "";
        for (int x = 1; x < cantFilas; x++){
            List<WebElement> celdas = filas.get(x).findElements(By.tagName("td"));
            id = id + celdas.get(0).getText() + ";";
            texto = texto + celdas.get(1).getText() + ";";
            email = email + celdas.get(2).getText() + ";";
            area = area + celdas.get(3).getText() + ";";
            fecha = fecha + celdas.get(4).getText() + ";";
            lista = lista + celdas.get(5).getText() + ";";
            seleccion = seleccion + celdas.get(6).getText() + ";";
            radio = radio + celdas.get(7).getText() + ";";
        }

        System.out.println("********** RECUPERAR INFROMACION **********");
        System.out.println("ID: "+"\n"+id);
        System.out.println("TEXTO: "+"\n"+texto);
        System.out.println("EMAIL: "+"\n"+email);
        System.out.println("AREA: "+"\n"+area);
        System.out.println("FECHA: "+"\n"+fecha);
        System.out.println("LISTA: "+"\n"+lista);
        System.out.println("SELECCION: "+"\n"+seleccion);
        System.out.println("RADIO: "+"\n"+radio);
        System.out.println("*******************************************");
    }
}


