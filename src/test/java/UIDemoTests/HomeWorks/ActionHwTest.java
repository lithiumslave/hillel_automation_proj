package UIDemoTests.HomeWorks;

import UIDemoTests.UIBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class ActionHwTest extends UIBaseTest {

    @Test
    public void dragNDropElements() {
        driver.get("https://demoqa.com/browser-windows");

        String oldTab = driver.getWindowHandle();

        driver.findElement(By.id("tabButton")).click();

        ArrayList<String> twoTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(twoTabs.get(1));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sampleHeading")));
        Assert.assertEquals(driver.findElement(By.id("sampleHeading")).getText(), "This is a sample page");

        driver.switchTo().window(oldTab);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tabButton")));
        driver.findElement(By.id("tabButton")).click();

        ArrayList<String> threeTabs = new ArrayList<>(driver.getWindowHandles());

        Assert.assertEquals(threeTabs.size(), 3);
        driver.switchTo().window(threeTabs.get(2));
        driver.close();

        driver.switchTo().window(threeTabs.get(1));
        driver.close();

        driver.switchTo().window(oldTab);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("main-header")));
        String headerText = driver.findElement(By.className("main-header")).getText();
        Assert.assertEquals(headerText, "Browser Windows");

        ArrayList<String> oneTabs = new ArrayList<>(driver.getWindowHandles());

        Assert.assertEquals(oneTabs.size(), 1);

    }

}
