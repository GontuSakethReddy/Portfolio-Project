package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v141.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ProductPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='features_items']")
    List<WebElement> products;

    @FindBy(xpath = "//h2[@class='title text-center']")
    WebElement title;

    @FindBy(xpath = "//input[@name = 'search']")
    WebElement searchBox;

    @FindBy(xpath = "//button[@id='submit_search']")
    WebElement searchBtn;

    @FindBy(xpath = "//div[@class='features_items']//div[@class='col-sm-4']//div[@class='productinfo text-center']//p")
    List<WebElement> searchedProducts;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isDisplayed()
    {
        return products.size() > 0;
    }

    public String productListTitle()
    {
        return title.getText();
    }

    public void searchForProduct(String productName)
    {
        searchBox.sendKeys(productName);
        searchBtn.click();
    }

    public void isMatching(String productName)
    {
        int totalProducts = searchedProducts.size();
        int releavent = 0;
        for(WebElement x : searchedProducts)
        {
            //System.out.println(x.getText());
            String actName = x.getText();
            if(actName.contains(productName))
            {
                releavent++;
            }
        }
//        System.out.println(releavent);
        double percentage = (double) (releavent * 100) /totalProducts;
//        if(percentage > 80.00)
//        {
//            System.out.println("passed all products are relevant");
//        }
//        System.out.println(percentage);

        Assert.assertTrue(percentage > 80.00, "Fetched products are not relevant to searched product");
    }



}
