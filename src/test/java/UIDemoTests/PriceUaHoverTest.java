package UIDemoTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PriceUaHoverTest extends UIBaseTest {

    @Test
    public void filterProducts() throws InterruptedException {
        driver.get("https://price.ua/ua");

        WebElement audioVideoMenuItem = driver.findElement(By.cssSelector("[data-tracker-cid='11']"));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(audioVideoMenuItem));
        actions.moveToElement(audioVideoMenuItem).perform();

        WebElement musicMenuItem = driver.findElement(By.cssSelector("[data-tracker-cid='5233']"));
        wait.until(ExpectedConditions.elementToBeClickable(musicMenuItem));
        actions.moveToElement(musicMenuItem).perform();

        WebElement keyboardsMenuItem = driver.findElement(By.cssSelector("[data-tracker-cid='5292']"));
        wait.until(ExpectedConditions.elementToBeClickable(keyboardsMenuItem));
        actions.moveToElement(keyboardsMenuItem).perform();

        WebElement pianoMenuItem = driver.findElement(By.cssSelector("[data-tracker-cid='5297']"));
        wait.until(ExpectedConditions.elementToBeClickable(pianoMenuItem));
        pianoMenuItem.click();

        String expectedTitle = "Піаніно, роялі";
        Assert.assertTrue(driver.findElement(By.cssSelector("h1 > span.cat-name")).getText().contains(expectedTitle));

    }
}
