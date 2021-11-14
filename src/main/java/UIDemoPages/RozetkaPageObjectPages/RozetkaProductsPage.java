package UIDemoPages.RozetkaPageObjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RozetkaProductsPage {

    WebDriver driver;

    By productTitle = By.cssSelector(".content_type_catalog .goods-tile__heading");

    public RozetkaProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public RozetkaProductDetailsPage clickProductTitle() {
        driver.findElement(productTitle).click();
        return new RozetkaProductDetailsPage(driver);
    }
}
