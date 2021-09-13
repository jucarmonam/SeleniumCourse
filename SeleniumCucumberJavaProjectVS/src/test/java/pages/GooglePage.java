package pages;

public class GooglePage extends BasePage{
    
    public GooglePage(){
        super(driver);
    }

    public void navigateToGoogle(){
        //usamos la funcion de base page
        navigateTo("https://www.google.com");
    }
}
