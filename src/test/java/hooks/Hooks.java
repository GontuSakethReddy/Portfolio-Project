package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import runner.TestRunner;
import utils.ConfigReader;
import utils.DriverManager;

import java.util.Properties;

public class Hooks
{
    @Before
    public void setup()
    {
        String browserName = TestRunner.browserName;
        DriverManager.init_driver(browserName);
    }

    @After
    public void close()
    {

    }




}
