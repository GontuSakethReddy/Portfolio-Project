package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefs","hooks"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    public static String browserName;

    @BeforeClass
    @Parameters("browser")
    public void defineBrowser(String browser) {

        browserName = browser;
    }
}