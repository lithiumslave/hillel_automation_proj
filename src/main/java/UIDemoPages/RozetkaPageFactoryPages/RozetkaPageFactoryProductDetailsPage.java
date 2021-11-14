package UIDemoPages.RozetkaPageFactoryPages;

import UIDemoPages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RozetkaPageFactoryProductDetailsPage extends BasePage {

    WebDriver driver;
    private TopPanelFragment topPanelFragment;

    @FindBy(css="h1.product__title")
    private WebElement selectedProductTitle;

    @FindBy(css="span.buy-button__label")
    private WebElement buyButton;

    @FindBy(css="button.modal__close")
    private WebElement closeModalWindowButton;

    public RozetkaPageFactoryProductDetailsPage(WebDriver driver) {
        super(driver);
        topPanelFragment = new TopPanelFragment(driver);
    }

    public String getProductTitleText() {
        return selectedProductTitle.getText();
    }

    public void addProductToCart() {
        clickBuyButton();
        closeModalWindow();
    }

    private void clickBuyButton() {
        buyButton.click();
    }

    private void closeModalWindow() {
        closeModalWindowButton.click();
    }

    public TopPanelFragment getTopPanelFragment() {
        return topPanelFragment;
    }
}