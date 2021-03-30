package page;

import Utils.DriverContext;
import Utils.Espera;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class PaginaDownload {

    private String downloadmFilePath = "C:\\Users\\sanma\\Ejemplo\\";

    public PaginaDownload(){
        PageFactory.initElements(DriverContext.getDriver(), this); }

    @FindBy (xpath = "//*[contains(text(),'some-file.txt')]")
    WebElement btnDescarga;

    public void descargar() throws InterruptedException {
        Espera.esperar("//*[contains(text(),'some-file.txt')]");
        btnDescarga.click();
        Thread.sleep(10000);
    }

    public void eliminarArchivo(){
        File file = new File(downloadmFilePath + "some-file.txt");
        if(file.delete()){
            System.out.println("borrado con exito");
        }
        else {
            System.out.println("no se logro borrar el archivo");
        }
    }
    public void validacionDescarga() {
        File file = new File(downloadmFilePath + "some-file.txt");
        if(file.exists()){
            System.out.println("el archivo ya existe");
        }
        else {
            System.out.println("el archivo no existe");
        }
    }
}

