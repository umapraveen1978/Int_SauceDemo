package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver = null;
    public WebDriverWait wait = null;

    public BasePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

}
