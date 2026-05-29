package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    WebDriver driver;

    @FindBy (xpath = "//input[@data-qa='login-email']")
    WebElement emailField;

    @FindBy (xpath = "//input[@data-qa='login-password']")
    WebElement passField;

    @FindBy (xpath = "//button[@data-qa='login-button']")
    WebElement loginBtn;

    @FindBy (xpath = "//ul[@class='nav navbar-nav']//li[10]")
    WebElement loggedIn;

    @FindBy (xpath = "//p[@style='color: red;']")
    WebElement error;

    @FindBy (xpath = "//div[@class='col-sm-4 col-sm-offset-1']")
    WebElement loginPage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void loginDetails(String email, String pass)
    {
        emailField.sendKeys(email);
        passField.sendKeys(pass);
    }

    public void clickLoginBtn()
    {
        loginBtn.click();
    }

    public String isLoggedIn()
    {
        String actual = loggedIn.getText();
        return actual;
    }

    public String errorMsg()
    {
        String errorMsg = error.getText();
        return errorMsg;
    }


    public boolean isLoginPageDisplayed() {
        return loginPage.isDisplayed();
    }
}
