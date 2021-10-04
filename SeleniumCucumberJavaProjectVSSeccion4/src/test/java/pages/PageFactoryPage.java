package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PageFactoryPage extends BasePage {
    
    //guarda en cache el elemento en cuestion para que no haga una
    //peticion a selenium cada vez que va a usar el elemento
    //pero este NO debe ser dinamico
    @CacheLookup
    @FindBy(id = "boton")
    WebElement boton;

    public PageFactoryPage(){
        super(driver);
        driver.get("www.gooogle.com");
    }
}
