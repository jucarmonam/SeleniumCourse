package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;

public class ListPage extends BasePage {
    
    private String searchField = "//body/form[1]/input[1]";
    private String searchResults = "name";

    public ListPage(){
        super(driver);
    }

    public void navigateToListPage(){
        navigateTo("https://andreidbr.github.io/JS30/06AjaxTypeAhead/index.html");
    }

    public void enterSearchCriteria() throws InterruptedException{
        try {
            //este es un caso particular de uso del sleep porque la pagina no busca
            //si se escribe muy rapido, pero nunca se deberia usar
            Thread.sleep(600);
            write(searchField, "Washington");
        } catch (NoSuchElementException e) {
            System.out.println("The WebElement Search Field Couldn't be Found");
            e.printStackTrace();
        }
    }

    public List<String> getAllSearchResults(){
        List<WebElement> list = bringMeAllElements(searchResults);
        List<String> stringsFromList = new ArrayList<String>();

        for(WebElement e: list){
            stringsFromList.add(e.getText());
        }
        return stringsFromList;
    }
}
