package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\carju\\Desktop\\CursoSelenium\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        //un solo driver que podremos usar en las demas paginas
        driver = new ChromeDriver(chromeOptions);
        //le pasamos el driver y le indicamos el tiempo que va a esperar
        //en la pagina buscando el locator que le proveemos
        wait = new WebDriverWait(driver, 10);
    }

    //constructor
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    //funcion para navegar
    public static void navigateTo(String url){
        driver.get(url);
    }
}
