package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    //esta instancia del driver como es estatica va tener siempre el mismo
    //valor en todos los lugares donde los creamos
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

        //metodo para que funcione el pageFactory, porque esto
        //lo que hara sera incializar los webelements que creamos
        //en la otra pagina
        PageFactory.initElements(driver, this);

        wait = new WebDriverWait(driver, 10);

        //esto es una espera implicita porque es para todo el framework y le
        //decimos que entre toda acction espere 10 segundos, sin embargo esta alenta
        //la ejecucion
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //funcion para navegar
    public static void navigateTo(String url){
        driver.get(url);
    }
    
    //funcion para encontrar el webElement
    private WebElement Find(String locator){
        //espera explicita porque esta esperando hasta los 10 segundos que le pusimos
        //y ademas espera a la visibilidad del elemento
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator){
        Find(locator).click();
    }

    public void write(String locator, String textToWrite){
        //clear limpia el campo de texto
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));

        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select(Find(locator));

        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownByText(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));

        dropdown.selectByVisibleText(valueToSelect);
    }

    public void hoverOverElement(String locator){
        //esta funcion pasa el mouse sobre un elemento
        action.moveToElement(Find(locator));
    }

    public void doubleClick(String locator){
        action.doubleClick(Find(locator));
    }

    public void rightClick(String locator){
        action.contextClick(Find(locator));
    }

    public String getValueFromTable(String locator, int row, int column){
        String cellINeed = locator+"/table/tbody/tr["+row+"]/td["+column+"]";

        return Find(cellINeed).getText();
    }

    public void setValueOnTable(String locator, int row, int column, String stringToSend){

        String cellToFill = locator+"/table/tbody/tr["+row+"]/td["+column+"]";

        Find(cellToFill).sendKeys(stringToSend);
    }

    public void switchToiFrame(int iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
}
