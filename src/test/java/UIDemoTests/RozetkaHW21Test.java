package UIDemoTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/*Verification of 3 filters (manufacturer, price, your own choice)
1. Navigate to https://rozetka.com.ua/
2. Search by "samsung"
3. Click "Мобильные телефоны" in the product filters panel
4. Add to filters "Apple" and "Huawei"
5. Verify all filtered products are products made by Samsung, Apple or Huawei*/

public class RozetkaHW21Test extends UIBaseTest {
    @BeforeClass
    public void openSite() {
        driver.get(url);
    }

    private final String url = "https://rozetka.com.ua/";
    private final String appleTitle = "Apple";
    private final String samsungTitle = "Samsung";
    private final String huaweiTitle = "Huawei";
    private final String searchText = "samsung";

    private final String searchField = "//input[@name='search']";
    private final String mobilePhonesItemInFilter = "//span[contains(text(),\"Мобильные телефоны\")]";
    private final String appleItemInFilter = "//label[contains(@for,\"Apple\")]";
    private final String appleItemInFilterChips = "//a[contains(text(),\"Apple\")]";
    private final String huaweiItemInFilter = "//label[contains(@for,\"Huawei\")]";
    private final String huaweiItemInFilterChips = "//a[contains(text(),\"Huawei\")]";
    private final String goodsTitle = "//span[@class='goods-tile__title']";
    //private final String nextPageOfGoodsButton = "a[class='pagination__link ng-star-inserted']";
    private final String nextPageOfGoodsButton = "li.pagination__item";

    @Test
    public void samsungAppleHuawei() throws InterruptedException {
        sendKeysToSearchField();
        clickOnMobilePhonesInFilter();
        clickOnAppleItemInFilter();
        clickOnHuaweiItemInFilter();
        Assert.assertTrue(checkIfAllGoodsTitlesContainsExpectedGoodsOnAllPages(appleTitle, samsungTitle, huaweiTitle));
        //Thread.sleep(3000);
    }

    private void sendKeysToSearchField() {
        driver.findElement(By.xpath(searchField)).sendKeys(searchText, Keys.ENTER);
    }

    private void clickOnMobilePhonesInFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(mobilePhonesItemInFilter))).click();
    }

    private void clickOnAppleItemInFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(appleItemInFilter))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(appleItemInFilterChips)));
    }

    private void clickOnHuaweiItemInFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(huaweiItemInFilter))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(huaweiItemInFilterChips)));
    }

    private boolean checkIfAllGoodsTitlesContainsExpectedGoodsOnAllPages(String expected1, String expected2, String expected3) throws InterruptedException {
        // Collection of all "next page" buttons
        List<WebElement> nextPagesOfGoodsButtons = driver.findElements(By.cssSelector(nextPageOfGoodsButton));
        boolean result = false;

        for (WebElement nextPageButton : nextPagesOfGoodsButtons) {
            nextPageButton.click();
            Thread.sleep(3000);
            //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.catalog-grid__cell:first-of-type")));
            //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("a[class*='pagination__link_state_active']")));

            List<WebElement> goodsTitles = driver.findElements(By.xpath(goodsTitle));

            for (WebElement good : goodsTitles) {
                String goodTitle = good.getText().toLowerCase();

                if (goodTitle.contains(expected1.toLowerCase()) || goodTitle.contains(expected2.toLowerCase()) || goodTitle.contains(expected3.toLowerCase())) {
                    result = true;
                } else {
                    result = false;
                    System.out.println(goodTitle + " is not contains any of titles");
                    break;
                }
            }
        }

        return result;
    }

    /*private boolean checkIfAllGoodsTitlesContainsExpectedGoods(String expected1, String expected2, String expected3) {
        List<WebElement> goodsTitles = driver.findElements(By.xpath(goodsTitle));
        boolean result = false;

        for (WebElement good : goodsTitles) {
            String goodTitle = good.getText().toLowerCase();

            if (goodTitle.contains(expected1.toLowerCase()) || goodTitle.contains(expected2.toLowerCase()) || goodTitle.contains(expected3.toLowerCase())) {
                result = true;
            } else {
                result = false;
                System.out.println(goodTitle + " is not contains any of titles");
                break;
            }
        }

        return result;
    }*/
}
