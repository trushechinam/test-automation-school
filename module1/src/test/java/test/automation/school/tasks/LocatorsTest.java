package test.automation.school.tasks;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;


public class LocatorsTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.30-win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void locateElementByIdTest() throws Exception {
        //TODO 1 - locate search input field by ID and assign to a variable named elementById
        WebElement elementById = driver.findElement(By.id("search_query_top"));

        Assert.assertTrue(elementById.isDisplayed());
        //TODO 1
    }


    @Test
    public void locateElementByClassNameTest() throws Exception {
        //TODO 2 - locate *all* (also that are not visible on the screen) products by class name and put them into ArrayList Collection and check that elements list size is 14
        Thread.sleep(1000);
        List<WebElement> searchResultElements = driver.findElements(By.className("ajax_block_product"));
        assertTrue(searchResultElements.size() == 14);
        //TODO 2
    }


    @Test
    public void locateElementByTagNameTest() throws Exception {
        //TODO 3 - locate all images by tag name and put them into ArrayList Collection
        List<WebElement> images = driver.findElements(By.tagName("img"));
        Assert.assertTrue(images.get(1).isDisplayed());
        //TODO 3
    }


    @Test
    public void locateElementByNameTest() throws Exception {
        //TODO 4 - locate newsletter subscription input element by name
        WebElement news = driver.findElement(By.name("email"));
        Assert.assertTrue(news.isDisplayed());

        //TODO 4
    }


    @Test
    public void locateElementByLinkTextTest() throws Exception {
        //TODO 5 - locate "T-Shirts" element by link text
        // NOTE - linkText() is case sensitive and should be selected as it is rendered on the screen, not in HTML
        WebElement tShirts = driver.findElement(By.linkText("T-shirts"));
        Assert.assertTrue(tShirts.isDisplayed());
        //TODO 5
    }


    @Test
    public void locateElementByCssSelctorTest() throws Exception {
        //TODO 6 - locate only *visible* products element by CSS and put them into ArrayList Collection and check that elements list size is 7
        List<WebElement> visibleProduct = driver.findElements(By.cssSelector("#homefeatured.active .ajax_block_product"));
        Assert.assertTrue(visibleProduct.size() == 7);
        //TODO 6

    }

    @Test
    public void locateElementByXpathTest() throws Exception {
        //TODO 7 - locate only *visible* products element by XPATH and put them into ArrayList Collection and check that elements list size is 7
        //NOTE - you have to indicate all class names that are specified on the current element
        // This is contrary to CSS Selector where you can specify just one of the class names
        // TIP - use 'contains()'
        List<WebElement> visibleProduct = driver.findElements(By.xpath("//*[@id='homefeatured'][contains(@class, 'active')]/*[contains(@class, 'ajax_block_product')]"));
        Assert.assertTrue(visibleProduct.size() == 7);
        //TODO 7

    }




}
