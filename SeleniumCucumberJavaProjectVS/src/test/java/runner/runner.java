package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "steps",
    plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
    monochrome = true,
    // tags = "@Grid and @Smoke"
    tags = ("@List")
)

public class runner {
    //despues de cada ejecucion cierra el navegador
    @AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser();
    }
}