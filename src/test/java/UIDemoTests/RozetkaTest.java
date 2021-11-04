package UIDemoTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RozetkaTest extends UIBaseTest {

    @Test
    public void testAddingProductToCart() throws InterruptedException {
        driver.get("https://rozetka.com.ua/");
        String searchText = "Xbox Series X 1Tb";

        WebElement searchField = driver.findElement(By.xpath("//input[@name='search']"));
        searchField.sendKeys(searchText);
        //searchField.sendKeys(searchText, Keys.ENTER);

        WebElement searchButton = driver.findElement(By.cssSelector(".button.button_color_green"));
        searchButton.click();

        WebElement productTitle = driver.findElement(By.cssSelector(".content_type_catalog .goods-tile__heading"));
        productTitle.click();

        WebElement selectedProductTitle = driver.findElement(By.cssSelector("h1.product__title"));
        System.out.println("Product text: " + selectedProductTitle.getText());
        Assert.assertTrue(selectedProductTitle.getText().toLowerCase().contains(searchText.toLowerCase()));

        WebElement buyButton = driver.findElement(By.cssSelector("span.buy-button__label"));
        buyButton.click();

        WebElement closeModalWindowButton = driver.findElement(By.cssSelector("button.modal__close"));
        closeModalWindowButton.click();

        List<WebElement> cartCounter = driver.findElements(By.cssSelector("span.counter"));
        Assert.assertFalse(cartCounter.isEmpty());
        Assert.assertEquals(cartCounter.get(0).getText(), "1");
    }
}