package pages;

public class TestSandBox extends BasePage {
    
    private String categoryDropdown = "//body/div[2]/main[1]/div[3]/div[1]/select[1]";

    public TestSandBox(){
        super(driver);
    }

    public void navigateToSandbox(){
        navigateTo("https://getbootstrap.com/docs/5.0/forms/select/");
    }

    public void selectCategory(String category){
        selectFromDropdownByValue(categoryDropdown, category);
    }
}
