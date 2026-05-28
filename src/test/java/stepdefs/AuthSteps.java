package stepdefs;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverManager;

import java.util.Properties;

public class AuthSteps {

    ConfigReader cr = new ConfigReader();
    Properties prop = cr.init_prop();

    HomePage hp = new HomePage(DriverManager.getDriver());
    LoginPage lp = new LoginPage(DriverManager.getDriver());

    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage()
    {
        String url = prop.getProperty("url");
        DriverManager.getDriver().get(url);
    }

    @When("the user navigates to the Signup\\/Login page")
    public void the_user_navigates_to_the_signup_login_page() {

        hp.loginPage();
    }

    @When("enters email {string} and password {string}")
    public void enters_email_and_password(String email, String pass) {
        lp.loginDetails(email,pass);
    }

    @When("clicks the Login button")
    public void clicks_the_login_button() {
        lp.clickLoginBtn();
    }

    @Then("the navbar should show {string}")
    public void the_navbar_should_show(String loggedUsername)
    {
        String act = lp.isLoggedIn();
        Assert.assertEquals(loggedUsername, act, "valid credentials test failed");

    }

    @When("enters invalid email {string} and invalid password {string}")
    public void enters_invalid_email_and_invalid_password(String email, String pass) {
        lp.loginDetails(email,pass);
    }

    @Then("an error {string} should appear")
    public void an_error_should_appear(String Experror) {
        String actErr = lp.errorMsg();
        Assert.assertEquals(Experror, actErr, "Invalid credentials test failed");

    }


}
