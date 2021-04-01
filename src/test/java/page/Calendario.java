package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendario {

    //Esta clase aun no esta terminada pero es para seleccionar una fecha cualquiera en el calendario

    public static WebDriver wd;

    public static void main(String[] args) {

        String expectedDate = "11/Abril/2020";
        String dia = expectedDate.split("-")[0];
        String mes = expectedDate.split("-")[1];
        String ano = expectedDate.split("-")[2];

        System.setProperty("webdriver.chrome.driver", "C:\\git\\Tarea_1\\driverNavegador\\chromedriver.exe");

        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.get("");
    }
}
