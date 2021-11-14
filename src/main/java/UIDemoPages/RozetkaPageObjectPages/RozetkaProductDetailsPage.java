package UIDemoPages.RozetkaPageObjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RozetkaProductDetailsPage {

    WebDriver driver;
    By selectedProductTitle = By.cssSelector("h1.product__title");
    By buyButton = By.cssSelector("span.buy-button__label");
    By closeModalWindowButton = By.cssSelector("button.modal__close");
    By cartCounter = By.cssSelector("span.counter");

    public RozetkaProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductTitleText() {
        return driver.findElement(selectedProductTitle).getText();
    }

    public void addProductToCart() {
        clickBuyButton();
        closeModalWindow();
    }

    public boolean isCartEmpty() {
        return driver.findElements(cartCounter).isEmpty();
    }

    public String getCartLabelText() {
        return driver.findElement(cartCounter).getText();
    }

    private void clickBuyButton() {
        driver.findElement(buyButton).click();
    }

    private void closeModalWindow() {
        driver.findElement(closeModalWindowButton).click();
    }

}
