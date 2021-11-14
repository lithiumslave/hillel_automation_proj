package UIDemoPages.RozetkaPageFactoryPages;

import UIDemoPages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TopPanelFragment extends BasePage {

    @FindBy(xpath="//input[@name='search']")
    private WebElement searchField;

    @FindBy(css=".button.button_color_green")
    private WebElement searchButton;

    @FindBy(css="span.counter")
    private WebElement cartCounter;

    @FindBy(css="span.counter")
    private List<WebElement> cartCounterCollection;

    public TopPanelFragment(WebDriver driver) {
        super(driver);
    }

    public RozetkaPageFactoryProductsPage performSearch(String searchText) {
        enterTextIntoSearchField(searchText);
        clickSearchButton();
        return new RozetkaPageFactoryProductsPage(driver);
    }

    public boolean isCartEmpty() {
        return cartCounterCollection.isEmpty();
    }

    public String getCartLabelText() {
        return cartCounter.getText();
    }

    private void enterTextIntoSearchField(String searchText) {
        searchField.sendKeys(searchText);
    }

    private void clickSearchButton() {
        searchButton.click();
    }
}
