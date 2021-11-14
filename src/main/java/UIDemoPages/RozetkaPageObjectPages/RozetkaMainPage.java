package UIDemoPages.RozetkaPageObjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RozetkaMainPage {

    WebDriver driver;

    By searchField = By.xpath("//input[@name='search']");
    By searchButton = By.cssSelector(".button.button_color_green");

    public RozetkaMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public RozetkaProductsPage performSearch(String searchText) {
        enterTextIntoSearchField(searchText);
        clickSearchButton();
        return new RozetkaProductsPage(driver);
    }

    private void enterTextIntoSearchField(String searchText) {
        driver.findElement(searchField).sendKeys(searchText);
    }

    private void clickSearchButton() {
        driver.findElement(searchButton).click();
    }
}
