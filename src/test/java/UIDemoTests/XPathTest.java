package UIDemoTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XPathTest extends UIBaseTest {

    @Test
    public void testXPath() {

        driver.get("https://theautomationzone.blogspot.com/2020/07/xpath-practice.html");

        WebElement test1 = driver.findElement(By.xpath("//*[@value='value1']"));

        WebElement siblingInput = driver.findElement(By.xpath("//label[@for='father_name']/following-sibling::div/input"));
        WebElement parentDescendantInput = driver.findElement(By.xpath("//label[@for='father_name']/parent::div//input"));

        Select courseSelect = new Select(driver.findElement(By.xpath("//select[@id='course']")));
        courseSelect.selectByVisibleText("Computer Course");
        Assert.assertEquals(courseSelect.getFirstSelectedOption().getText(), "Computer Course");

    }

    public void testXPath2() {

        driver.get("https://theautomationzone.blogspot.com/");

        Select fruitSelect = new Select(driver.findElement(By.id("mySelect")));

        String fruitOfMyChoice = "pineapple";
        fruitSelect.selectByValue(fruitOfMyChoice);
        Assert.assertTrue(driver.findElement(By.id("answer")).getText().contains(fruitOfMyChoice));

    }
}