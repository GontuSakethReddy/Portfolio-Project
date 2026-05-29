package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[4]")
    WebElement login;

    @FindBy(xpath = "//a[@href='/logout']")
    WebElement logoutBtn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginPage()
    {
        login.click();
    }

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[10]")
    WebElement afterLogin;

    public void isLoggedin()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try
        {
            WebElement log = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='nav navbar-nav']//li[10]")));
            System.out.println("successfuly logged in");
        }
        catch (Exception e)
        {
            System.out.println("not logged in");
        }
    }
    public void logout()
    {
        logoutBtn.click();
    }



}
