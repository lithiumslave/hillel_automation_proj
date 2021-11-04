package UIDemoTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AutomationZoneTest extends UIBaseTest {

    @Test
    public void selectValueInTable() {
        driver.get("https://theautomationzone.blogspot.com/");

        List<WebElement> tableRows = driver.findElements(By.xpath("//div[@class='divTableCell']/parent::div"));
        int minimumAge = 25;

        for(WebElement row : tableRows) {
            WebElement age = row.findElement(By.cssSelector("div.divTableCell:nth-of-type(4)"));
            int actualAge = Integer.parseInt(age.getText());

            if(actualAge >= minimumAge) {
                row.findElement(By.cssSelector("div.divTableCell input")).click();
                Assert.assertTrue(row.findElement(By.cssSelector("div.divTableCell input")).isSelected());
            } else {
                Assert.assertFalse(row.findElement(By.cssSelector("div.divTableCell input")).isSelected());
            }
        }
    }
}