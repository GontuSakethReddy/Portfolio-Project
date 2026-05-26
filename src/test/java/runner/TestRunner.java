package runner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestRunner {

    public static String browserName;

    @BeforeClass
    @Parameters("browser")
    public void defineBrowser(String browserName)
    {
        TestRunner.browserName = browserName;
    }
}
