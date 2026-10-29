
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testHomePageLoads() {
        driver.get("http://localhost:8081");

        assertEquals(
            "Home page URL should be correct",
            "http://localhost:8081/",
            driver.getCurrentUrl()
        );

        assertTrue(
            "Home page should contain visible content",
            driver.findElement(By.tagName("body"))
                  .getText().length() > 0
        );
    }

    @Test
    public void testApplicationImageLoads() {
        driver.get("http://localhost:8081");

        WebElement image =
            driver.findElement(By.cssSelector("img"));

        assertTrue(
            "Application image should be displayed",
            image.isDisplayed()
        );

        assertTrue(
            "Image should load successfully",
            (Boolean) ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript(
                    "return arguments[0].complete && " +
                    "arguments[0].naturalWidth > 0;",
                    image
                )
        );
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
