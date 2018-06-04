package test.automation.school;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;

import static org.openqa.selenium.Keys.ENTER;
import static org.testng.AssertJUnit.assertTrue;

public class GoogleSearchTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","../drivers/chromedriver-v2.39_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://google.com");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void googleSearchResultTest(){
        WebElement element = driver.findElement(By.cssSelector("[name='q']"));
        element.sendKeys("cheese");
        element.sendKeys(ENTER);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> searchResultElements = element.findElements(By.className("g"));
        assertTrue(searchResultElements.size()>0);
        assertTrue(searchResultElements.contains("cheese"));
    }
}
