package pages;

public class GooglePage extends BasePage{

    private String searchButton = "//input[@value='Buscar con Google']";
    private String searchTextField = "//body[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]";
    
    public GooglePage(){
        super(driver);
    }

    public void navigateToGoogle(){
        //usamos la funcion de base page
        navigateTo("https://www.google.com");
    }

    public void clickGoogleSearch(){
        clickElement(searchButton);
    }

    public void enterSearchCriteria(String criteria){
        write(searchTextField, criteria);
    }
}
