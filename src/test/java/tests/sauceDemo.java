package tests;

import framework.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

public class sauceDemo extends BaseTest {
    @BeforeTest
    public void gotoApp() {
        goTo("https://www.saucedemo.com");}
    @Test
    public void doOperation() throws InterruptedException{
// Login with correct Username and Password
        sendKeys(By.xpath("//*[@id='user-name']"), "standard_user");
        sendKeys(By.xpath("//*[@id='password']"), "secret_sauce");
        click(By.xpath("//*[@id='login-button']"));

// Get a list of all product prices
        List<WebElement> allPrices = driver.findElements(By.xpath("//*[@class='inventory_item_price']"));

// Find the highest priced product
        WebElement highestProduct = allPrices.get(0);
        double highPrice = Double.parseDouble(highestProduct.getText().replace("$", ""));
        for (WebElement productPrice : allPrices) {
            double price = Double.parseDouble(productPrice.getText().replace("$", ""));
                if (price > highPrice) {
                    highPrice = price;
                    highestProduct = productPrice;
                }
            }

// Find Add to Cart button associated to Highest price and click
        WebElement addToCartButton = highestProduct.findElement(By.xpath("../button"));
        addToCartButton.click();
        Thread.sleep(5000);
        }

    public void click(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void sendKeys(By by, String value){
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(value);
    }
}
