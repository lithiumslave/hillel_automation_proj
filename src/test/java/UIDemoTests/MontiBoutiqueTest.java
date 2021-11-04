package UIDemoTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class MontiBoutiqueTest extends UIBaseTest {

    String url = "https://www.montiboutique.com/en";

    @Test
    public void buyMostExpensiveBag() {

        driver.get(url);

        WebElement womenClothesMenuItem = driver.findElement(By.cssSelector("[data-menu='#women-desktop']"));
        womenClothesMenuItem.click();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".menu [href$=bags]"))));
        WebElement bagsSubMenuItem = driver.findElement(By.cssSelector(".menu [href$=bags]"));
        bagsSubMenuItem.click();

        String expectedTitle = "Women's Bags";
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));

        List<WebElement> prices = driver.findElements(By.cssSelector(".products span[data-gtm-price]"));

        List<Double> convertedPrices = new ArrayList<>();

        for(WebElement price : prices) {
            double convertedPrice = Double.parseDouble(price.getAttribute("data-gtm-price"));
            convertedPrices.add(convertedPrice);
            System.out.println(convertedPrice);
        }

        System.out.println("Size of list:" + convertedPrices.size());

        convertedPrices.sort(Collections.reverseOrder());
        double maxPrice = convertedPrices.get(0);
        System.out.println("Max price is: " + maxPrice);

    }

    @DataProvider
    public Object[][] designerNamesDataProvider() {
        return new Object[][] {
                {"alexander mcqueen "},
                {"alexander wang"},
                {"balenciaga"}
        };
    }


    @Test(dataProvider = "designerNamesDataProvider")
    public void checkFilteringByBrand(String designer) {

        driver.get(url);

        WebElement womenClothesMenuItem = driver.findElement(By.cssSelector("[data-menu='#women-desktop']"));
        womenClothesMenuItem.click();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".menu [href$=bags]"))));
        WebElement bagsSubMenuItem = driver.findElement(By.cssSelector(".menu [href$=bags]"));
        bagsSubMenuItem.click();

        String expectedTitle = "Women's Bags";
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));

        //String designer = "balenciaga";
        //WebElement designerFilterOption = driver.findElement(By.xpath("//div[@class='filters no-mobile']//label[text()='" + designer +"']"));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='filters no-mobile']//label[text()='" + designer +"']")))).click();
        //designerFilterOption.click();



        List<WebElement> designerTitles = driver.findElements(By.cssSelector(".products span.brand"));

        for (WebElement designerTitle : designerTitles) {
            Assert.assertEquals(designerTitle.getText().toLowerCase(), designer);
        }
    }
}