import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DavikMenuOptionsTest {
    private static final String HOME_PAGE_URL = "https://daviktapes.com/";
    private static WebDriver driver;

    @BeforeAll
    public static void classSetup() {
        driver = DriverSetup.getWebDriver();
        driver.get(HOME_PAGE_URL);
    }

    @AfterEach
    public void testTearDown() {
        driver.get(HOME_PAGE_URL);
    }

    @AfterAll
    /*
    TODO: quit browser once you finish testing
     */
    public static void classTearDown() {
        DriverSetup.quitDriver();
    }

    @Test
    public void homeButtonTest() {

        WebElement homeButton = driver.findElement(By.xpath("//*[@id='menu-item-128']"));
        assertNotNull(homeButton);
        Actions mouse = new Actions(driver);
        mouse.click(homeButton).build().perform();
        String actualResult = driver.getCurrentUrl();
        assertEquals(HOME_PAGE_URL, actualResult);
    }

    @Test
    public void companyButtonTest() {
        WebElement companyButton = driver.findElement(By.xpath("//*[@id='menu-item-2997']"));
        assertNotNull(companyButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions mouse = new Actions(driver);
        mouse.moveToElement(companyButton).build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='menu-item-2997']//following-sibling::*[@id='menu-item-129']")));
        WebElement aboutUs = driver.findElement(By.xpath("//*[@id='menu-item-2997']//following-sibling::*[@id='menu-item-129']"));
        assertNotNull(aboutUs);
    }

    @Test
    public void productsButtonTest() {
        WebElement productsButton = driver.findElement(By.xpath("//*[@id='menu-item-134']"));
        assertNotNull(productsButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions mouse = new Actions(driver);
        mouse.moveToElement(productsButton).build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='menu-item-134']//following-sibling::*[@id='menu-item-2073']")));
        WebElement lowTackTapes = driver.findElement(By.xpath("//*[@id='menu-item-134']//following-sibling::*[@id='menu-item-2073']"));
        assertNotNull(lowTackTapes);
    }
    @Test
    public void industriesButtonTest() {
        WebElement industriesButton = driver.findElement(By.xpath("//*[@id='menu-item-132']"));
        assertNotNull(industriesButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions mouse = new Actions(driver);
        mouse.moveToElement(industriesButton).build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='menu-item-132']//following-sibling::*[@id='menu-item-1428']")));
        WebElement hygiene = driver.findElement(By.xpath("//*[@id='menu-item-132']//following-sibling::*[@id='menu-item-2074']"));
        assertNotNull(hygiene);
    }

    @Test
    public void knowledgeCenterButtonTest() {
        WebElement knowledgeCenterButton = driver.findElement(By.xpath("//*[@id='menu-item-2552']"));
        assertNotNull(knowledgeCenterButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions mouse = new Actions(driver);
        mouse.moveToElement(knowledgeCenterButton).build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='menu-item-2552']//following-sibling::*[@id='menu-item-2082']")));
        WebElement articles = driver.findElement(By.xpath("//*[@id='menu-item-2552']//following-sibling::*[@id='menu-item-2082']"));
        assertNotNull(articles);
    }

    @Test
    public void contactButtonTest() {

        WebElement contactButton = driver.findElement(By.xpath("//*[@id='menu-item-4167']"));
        assertNotNull(contactButton);
        Actions mouse = new Actions(driver);
        mouse.click(contactButton).build().perform();
        String expectedResult = "https://daviktapes.com/contact-us-new/";
        String actualResult = driver.getCurrentUrl();
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void linkedInButtonTest() {
        /*
        TODO: Don't use dynamic locators
         */
        WebElement lnButton = driver.findElement(By.xpath("//*[@class='social-icon']/a[contains(@href, 'linkedin')]/img"));

        assertNotNull(lnButton);
        Actions mouse = new Actions(driver);
        mouse.click(lnButton).build().perform();
        for (String str : driver.getWindowHandles()) {
            driver.switchTo().window(str);
        }
        String expectedUrl = "https://www.linkedin.com/company/davik";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
    }
}
