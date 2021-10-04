package steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.GridPage;

public class GridTestSteps {

    GridPage grid = new GridPage();

    @Given("^I navigate to the static table$")
    public void navigateToGridPage() throws InterruptedException{
        //NO
        //espera que no se debe hacer mala practica, se usa para debug
        //es mejor usar la espera explicita con el "until"
        Thread.sleep(1000);
        grid.navigateToGrid();
    }

    @Then("^I can return the value I wanted$")
    public void returnValue(){
        String value = grid.getValueFromGrid(3, 2);

        //System.out.println(value);
        //comparamos el valor a recibir con el recibido
        Assert.assertEquals("r: 2, c: 1", value);
    }

    @Then("^I can validate the table is displayed$")
    public void theTableIsThere(){
        //Assert.assertFalse("El elemento está siendo mostrado", grid.cellStatus());
        Assert.assertTrue("El elemento está siendo mostrado", grid.cellStatus());
    }
    
}
