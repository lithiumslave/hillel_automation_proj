package UIDemoTests.HomeWorks;

import UIDemoTests.UIBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PriceUATest extends UIBaseTest {
    String url = "https://price.ua/ua";

    @Test
    public void checkAvailabilityOfSpecificProduct() throws InterruptedException {
        String searchQuery = "oculus";
        String specificProductName = "Oculus Quest 2 256 Gb";

        driver.get(url);

        WebElement searchField = driver.findElement(By.id("SearchForm_searchPhrase"));
        searchField.sendKeys(searchQuery);

        Thread.sleep(3000);

        WebElement searchBtn = driver.findElement(By.id("search-block-submit"));
        searchBtn.click();

        WebElement setFilterDescending = driver.findElement(By.cssSelector("a.hight-to-low"));
        setFilterDescending.click();

        List<WebElement> productItems = driver.findElements(By.cssSelector("#fluid-grid .white-wrap .model-name"));


        Assert.assertTrue(checkAvailabilityOfProductInCollectionByName(productItems, specificProductName));
    }

    private boolean checkAvailabilityOfProductInCollectionByName(List<WebElement> productItem, String expectedName) {
        boolean result = false;

        for (WebElement item : productItem) {
            if (item.getText().equals(expectedName)) {
                result = true;
                break;
            }
        }

        return result;
    }
}
