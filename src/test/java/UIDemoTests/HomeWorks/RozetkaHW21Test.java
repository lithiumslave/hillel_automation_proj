package UIDemoTests.HomeWorks;

import UIDemoTests.UIBaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class RozetkaHW21Test extends UIBaseTest {
    @BeforeMethod
    public void openSite() {
        driver.get(url);
    }

    @AfterMethod
    public void refreshSite() {
        driver.navigate().refresh();
    }

    private final String url = "https://rozetka.com.ua/";
    private final String appleTitle = "Apple";
    private final String samsungTitle = "Samsung";
    private final String huaweiTitle = "Huawei";
    private final String searchText = "samsung";
    private final String minPriceValueToSend = "5000";
    private final String maxPriceValueToSend = "15000";
    private final String memoryExpected = "12 ГБ";
    private final String expectedPriceForMonitor = "5000";
    private final String counterFirst = "1";
    private final String counterSecond = "2";

    private final String searchField = "//input[@name='search']";
    private final String mobilePhonesItemInFilter = "//span[contains(text(),\"Мобильные телефоны\")]";
    private final String laptopsAndComputersItemInMainFilter = "//ul[@class='menu-categories menu-categories_type_main']//a[contains(text(),\"Ноутбуки и компьютеры\")]";
    private final String appleItemInFilter = "//label[contains(@for,\"Apple\")]";
    private final String appleItemInFilterChips = "//a[contains(text(),\"Apple\")]";
    private final String huaweiItemInFilter = "//label[contains(@for,\"Huawei\")]";
    private final String huaweiItemInFilterChips = "//a[contains(text(),\"Huawei\")]";
    private final String nextPageOfGoodsButton = "li.pagination__item";
    private final String minPriceField = "//form[@class='slider-filter__form ng-untouched ng-pristine ng-valid']//input[1]";
    private final String maxPriceField = "//form[@class='slider-filter__form ng-untouched ng-pristine ng-valid']//input[2]";
    private final String productFullBlock = ".catalog-grid > li";
    private final String productTitle = "//span[@class='goods-tile__title']";
    private final String productPrice = "//span[@class='goods-tile__price-value']";
    private final String productPriceCss = "span.goods-tile__price-value";
    private final String productDescriptionText = "p.goods-tile__description_type_text";
    private final String memory12RamItemInFilter = "//label[@for='12 ГБ']";
    private final String monitorsInTheListOfAllProducts = "img[alt='Мониторы']";
    private final String compareProductButtonOnTheProductPage = "button.compare-button";
    private final String compareButtonInHeaderOnTheProductPage = "button[aria-label='Списки сравнения']";
    private final String compareAndTrashedIconsInHeaderOfProductPage = "span.counter";
    private final String productTitleOnProductPage = "h1.product__title";
    private final String productPriceOnProductPage = "p.product-prices__big";
    private final String firstItemInComparisonListModal = "a.comparison-modal__link";
    private final String productFullBlocksOnComparisonPage = "li.products-grid__cell";
    private final String productTitleOnComparisonPage = "a.product__heading";
    private final String productPriceOnComparisonPage = "div.product__price";

    @Test
    public void testBrandFilter() {
        waitForJsToLoad();
        sendKeysToSearchField(searchText);
        waitForJsToLoad();
        clickOnMobilePhonesInFilter();
        clickOnAppleItemInFilter();
        clickOnHuaweiItemInFilter();
        waitForJsToLoad();
        Assert.assertTrue(checkIfAllGoodsTitlesContainsExpectedGoodsOnAllPages(appleTitle, samsungTitle, huaweiTitle));
    }

    @Test
    public void testPriceFilter() {
        sendKeysToSearchField(searchText);
        clickOnMobilePhonesInFilter();
        setPriceFilterRange(minPriceValueToSend, maxPriceValueToSend);
        Assert.assertTrue(checkIfAllGoodsAreInExpectedRange(minPriceValueToSend, maxPriceValueToSend));
    }

    @Test
    public void testRamFilter() {
        sendKeysToSearchField(searchText);
        clickOnMobilePhonesInFilter();
        clickOn12GbRamInFilter();
        Assert.assertTrue(checkIfAllGoodsDescriptionContainsExpectedMemory(memoryExpected));
    }

    @Test
    public void verificationOfComparisonOf2Monitors() {
        clickOnLaptopsAndComputersItemInMainFilter();
        clickOnMonitorsItemInListOfAllGoods();

        findAndClickOnTheFirstMonitorWithPriceLessThanExpected(expectedPriceForMonitor);
        String firstMonitorTitle = getProductTitleInProductPage();
        String firstMonitorPrice = getProductPriceInProductPage();
        clickOnCompareButton();
        Assert.assertTrue(checkCorrectNumberInComparedProductsCounter(counterFirst));
        clickBack();

        findAndClickOnTheFirstMonitorWithPriceLessThanExpected(firstMonitorPrice);
        String secondMonitorTitle = getProductTitleInProductPage();
        String secondMonitorPrice = getProductPriceInProductPage();
        clickOnCompareButton();
        Assert.assertTrue(checkCorrectNumberInComparedProductsCounter(counterSecond));

        clickOnCompareButtonInHeader();
        clickOnFirstItemInComparisonList();

        Assert.assertTrue(verificationOfCorrectNumberOfTheProductOnComparisonPage(2));
        Assert.assertTrue(verificationOfTitlesAreEqualsExpected(firstMonitorTitle, secondMonitorTitle));
        Assert.assertTrue(verificationOfPricesAreEqualsExpected(firstMonitorPrice, secondMonitorPrice));
    }

    protected boolean waitForJsToLoad() {

        final String loadJsScript = "return document.readyState";
        final String loadJQueryScript = "return jQuery.active==0";

        ExpectedCondition<Boolean> jsLoad = driver ->
                js.executeScript(loadJsScript).toString().equals("complete");

        /*ExpectedCondition<Boolean> jQueryLoad = driver ->
                (Boolean) (js.executeScript(loadJQueryScript));*/

        return wait.until(jsLoad)/* && wait.until(jQueryLoad)*/;
    }

    private void sendKeysToSearchField(String searchText) {
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

    private void clickOn12GbRamInFilter() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(memory12RamItemInFilter))).click();
    }

    private void clickOnLaptopsAndComputersItemInMainFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(laptopsAndComputersItemInMainFilter))).click();
    }

    private void clickOnMonitorsItemInListOfAllGoods() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(monitorsInTheListOfAllProducts))).click();
    }

    private void clickOnCompareButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(compareProductButtonOnTheProductPage))).click();
    }

    private boolean checkCorrectNumberInComparedProductsCounter(String expectedCounter) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(compareAndTrashedIconsInHeaderOfProductPage)));
        List<WebElement> cartCounter = driver.findElements(By.cssSelector(compareAndTrashedIconsInHeaderOfProductPage));

        Assert.assertFalse(cartCounter.isEmpty());

        return cartCounter.get(0).getText().equals(expectedCounter);
    }

    private void clickOnCompareButtonInHeader() {
        driver.findElement(By.cssSelector(compareButtonInHeaderOnTheProductPage)).click();
    }

    private void clickOnFirstItemInComparisonList() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(firstItemInComparisonListModal))).click();
    }

    private String getProductTitleInProductPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(productPriceOnProductPage)));
        return driver.findElement(By.cssSelector(productTitleOnProductPage)).getText();
    }

    private String getProductPriceInProductPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(productPriceOnProductPage)));

        WebElement price = driver.findElement(By.cssSelector(productPriceOnProductPage));
        return price.getText().replaceAll("[^0-9]", "");
    }

    private void clickBack() {
        driver.navigate().back();
    }

    private boolean checkIfAllGoodsTitlesContainsExpectedGoodsOnAllPages(String expected1, String expected2, String expected3) {
        // Collection of all "next page" buttons
        List<WebElement> nextPagesOfGoodsButtons = driver.findElements(By.cssSelector(nextPageOfGoodsButton));
        boolean result = false;

        for (WebElement nextPageButton : nextPagesOfGoodsButtons) {
            nextPageButton.click();
            waitForJsToLoad();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productTitle)));
            List<WebElement> goodsTitles = driver.findElements(By.xpath(this.productTitle));

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

    private boolean checkIfAllGoodsDescriptionContainsExpectedMemory(String expectedMemory) {
        boolean result = false;
        String memory = "RAM " + expectedMemory;

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productTitle)));
        List<WebElement> goodsBlock = driver.findElements(By.cssSelector(productFullBlock));

        for (WebElement goodBlock : goodsBlock) {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");

            actions.moveToElement(goodBlock).perform();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(productDescriptionText)));

            WebElement descriptionFull = goodBlock.findElement(By.cssSelector(productDescriptionText));

            System.out.println(descriptionFull.getText());
            if (goodBlock.findElement(By.cssSelector(productDescriptionText)).getText().contains(memory)) {
                result = true;
                System.out.println(result);
            } else {
                result = false;
                System.out.println(result);
                break;
            }
        }

        return result;
    }

    private void setPriceFilterRange(String minPriceValue, String maxPriceValue) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(minPriceField)));

        WebElement minPriceFieldToSendKey = driver.findElement(By.xpath(minPriceField));
        WebElement maxPriceFieldToSendKey = driver.findElement(By.xpath(maxPriceField));

        minPriceFieldToSendKey.clear();
        minPriceFieldToSendKey.sendKeys(minPriceValue);

        maxPriceFieldToSendKey.clear();
        maxPriceFieldToSendKey.sendKeys(maxPriceValue, Keys.ENTER);
    }

    private boolean checkIfAllGoodsAreInExpectedRange(String expectedMin, String expectedMax) {
        int expectedMinInt = Integer.parseInt(expectedMin);
        int expectedMaxInt = Integer.parseInt(expectedMax);
        boolean result = false;

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productPrice)));
        List<WebElement> goodsPricesList = driver.findElements(By.xpath(productPrice));

        for (WebElement prices : goodsPricesList) {
            String priceInString = prices.getText();
            int value = Integer.parseInt(priceInString.replaceAll("[^0-9]", ""));

            if (value >= expectedMinInt && value <= expectedMaxInt) {
                result = true;
            } else {
                result = false;
                System.out.println(value + "is not in expected range!");
                break;
            }

        }
        return result;
    }

    private void findAndClickOnTheFirstMonitorWithPriceLessThanExpected(String expectedPrice) {
        int expectedPriceInt = Integer.parseInt(expectedPrice);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(productTitle)));

        List<WebElement> nextPagesOfGoodsButtons = driver.findElements(By.cssSelector(nextPageOfGoodsButton));

        for (WebElement nextPageButton : nextPagesOfGoodsButtons) {
            nextPageButton.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productTitle)));
            boolean result = false;

            List<WebElement> goodsBlock = driver.findElements(By.cssSelector(productFullBlock));

            for (WebElement goodBlock : goodsBlock) {
                int priceValue = Integer.parseInt(goodBlock.findElement(By.cssSelector(productPriceCss)).getText().replaceAll("[^0-9]", ""));

                //System.out.println(priceValue + " < " + expectedPriceInt);
                if (priceValue < expectedPriceInt) {
                    result = true;
                    goodBlock.click();
                    break;
                }
            }
            if (result) {
                break;
            }
        }
    }

    private boolean verificationOfCorrectNumberOfTheProductOnComparisonPage(int expectedNumber) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(productFullBlocksOnComparisonPage)));
        List<WebElement> productBlocks = driver.findElements(By.cssSelector(productFullBlocksOnComparisonPage));
        int sizeOfTheList = productBlocks.size();

        return sizeOfTheList == expectedNumber;
    }

    private boolean verificationOfTitlesAreEqualsExpected(String expectedFirstTitle, String expectedSecondTitle) {
        List<WebElement> productTitles = driver.findElements(By.cssSelector(productTitleOnComparisonPage));
        boolean result = false;

        for (WebElement title : productTitles) {
            if (title.getText().equals(expectedFirstTitle) || title.getText().equals(expectedSecondTitle)) {
                result = true;
            }
        }

        return result;
    }

    private boolean verificationOfPricesAreEqualsExpected(String expectedFirstPrice, String expectedSecondPrice) {
        List<WebElement> productPrices = driver.findElements(By.cssSelector(productPriceOnComparisonPage));
        boolean result = false;

        for (WebElement price : productPrices) {
            String actualPrice = price.getText().replaceAll("[^0-9]", "");
            String actualPriceCutted = actualPrice.substring(4, 8);

            if (actualPriceCutted.equals(expectedFirstPrice) || actualPriceCutted.equals(expectedSecondPrice)) {
                result = true;
            }
        }

        return result;
    }

}
