package lesson18HWTestingURL;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestingURLNegativeAndPositive {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void checkTitleOfPagePositive() {
        driver.get("https://phptravels.com/demo/");
        Assert.assertEquals(driver.getTitle(), "Demo Script Test drive - PHPTRAVELS", "Actual title not equals expected");
    }

    @Test
    public void checkInvalidUrlTitleNegative() {
        driver.get("https://phptravels.com/demo/");
        Assert.assertNotEquals(driver.getTitle(), "Some negative title", "Failed, URLs are the same");
    }

    @Test
    public void compareUrlOneWithEmptyTabUrl() {
        driver.get("https://phptravels.com/demo/");
        String currentTabURL = driver.getCurrentUrl();

        driver.switchTo().newWindow(WindowType.TAB);
        String newTabURL = driver.getCurrentUrl();

        Assert.assertNotEquals(newTabURL, currentTabURL, "Failed, URLs are the same");
    }

    @Test
    public void checkSecondUrl() {
        driver.get("https://phptravels.com/demo/");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("http://the-internet.herokuapp.com/");

        Assert.assertEquals(driver.getCurrentUrl(), "http://the-internet.herokuapp.com/");
    }

    @AfterTest
    public void teamDown() {
        driver.quit();
    }
}
