package stepdefs;

import com.sun.source.tree.AssertTree;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.ProductPage;
import utils.ConfigReader;
import utils.DriverManager;

import java.util.Properties;

public class ProductSteps {
    ConfigReader cr = new ConfigReader();
    Properties prop = cr.init_prop();

    HomePage hp = new HomePage(DriverManager.getDriver());
    ProductPage pp = new ProductPage(DriverManager.getDriver());

    @When("the user navigates to products page")
    public void the_user_navigates_to_products_page() {
        hp.products();
    }

    @Then("the product list should displayed")
    public void product_list_displayed() {
        Assert.assertTrue(pp.isDisplayed());
    }

    @Then("the page title should be {string}")
    public void the_page_title_should_be(String title) {
        String act = pp.productListTitle();
        Assert.assertEquals(title,act, "Products not showed");
    }

    @When("search for {string} is search box")
    public void search_for_is_search_box(String string) {
        pp.searchForProduct(string);
    }

    @When("Only matching {string} products are visible")
    public void only_matching_products_are_visible(String productName) {
        pp.isMatching(productName);
    }

    @When("click {string} on any product")
    public void click_on_any_product(String string) {
        pp.clickViewProduct();
    }

    @Then("product details are visible.")
    public void product_details_are_visible() {
        Assert.assertTrue(pp.productDetailsVisible(),"Product details not visisble");
    }



}
