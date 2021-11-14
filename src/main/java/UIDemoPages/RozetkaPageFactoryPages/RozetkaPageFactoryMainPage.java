package UIDemoPages.RozetkaPageFactoryPages;

import UIDemoPages.BasePage;
import org.openqa.selenium.WebDriver;

public class RozetkaPageFactoryMainPage extends BasePage {

    RozetkaMainPageLeftMenuFragment leftMenuFragment;
    TopPanelFragment topPanelFragment;

    public RozetkaPageFactoryMainPage(WebDriver driver) {
        super(driver);
        leftMenuFragment = new RozetkaMainPageLeftMenuFragment(driver);
        topPanelFragment = new TopPanelFragment(driver);
    }

    public void clickOnGamingMenuItem() {
        leftMenuFragment.getGamingGoods().click();
    }

    public void clickLoyaltyItem() {
        leftMenuFragment.getLoyaltyField().click();
    }


    public TopPanelFragment getTopPanelFragment() {
        return topPanelFragment;
    }
}