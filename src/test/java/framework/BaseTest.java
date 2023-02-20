package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver = null;
    public WebDriverWait wait = null;

    @BeforeTest
    public void setup() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterTest
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    public void goTo(String url) {
        driver.get(url);
    }
}