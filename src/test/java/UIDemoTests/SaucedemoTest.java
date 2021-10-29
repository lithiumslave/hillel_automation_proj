package UIDemoTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SaucedemoTest extends UIBaseTest{
    String url = "https://www.saucedemo.com/";
    String validLoginForStandartUser = "standard_user";
    String validPassword = "secret_sauce";

    @Test
    public void testRightNumberOfProducts() {
        int expectedNumberOfProducts = 6;

        driver.get(url);

        WebElement loginField = driver.findElement(By.cssSelector("input.form_input[type=text]"));
        loginField.sendKeys(validLoginForStandartUser);

        WebElement passwordField = driver.findElement(By.cssSelector("input.form_input[type=password]"));
        passwordField.sendKeys(validPassword);

        WebElement loginBtn = driver.findElement(By.cssSelector("input[type=submit]"));
        loginBtn.click();

        WebElement pageTitle = driver.findElement(By.cssSelector("span.title"));
        String expectedTitle = "PRODUCTS";
        Assert.assertEquals(pageTitle.getText(), expectedTitle);

        List<WebElement> productItemNames = driver.findElements(By.cssSelector(".inventory_item .inventory_item_name"));

        int actualNumberOfProducts = productItemNames.size();

        Assert.assertEquals(actualNumberOfProducts, expectedNumberOfProducts);
    }

}
