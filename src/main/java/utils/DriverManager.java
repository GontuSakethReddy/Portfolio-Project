package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver init_driver(String browserName)
    {
        System.out.println("Running on browser: " + browserName);
        if (driver == null)
        {
            switch (browserName.toLowerCase())
            {
                case "chrome":
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    driver = new FirefoxDriver();
                    break;

                case "edge":
                    driver = new EdgeDriver();
                    break;

                default:
                    throw new RuntimeException("Browser not supported: " + browserName);
            }
            driver.manage().window().maximize();
        }
        return driver;
    }
    public static WebDriver getDriver()
    {
        return driver;
    }

    public static void quitDriver()
    {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }




}
