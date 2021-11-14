package PageObjectTests;

import UIDemoPages.RozetkaPageFactoryPages.RozetkaPageFactoryMainPage;
import UIDemoPages.RozetkaPageFactoryPages.RozetkaPageFactoryProductDetailsPage;
import UIDemoPages.RozetkaPageFactoryPages.RozetkaPageFactoryProductsPage;
import UIDemoTests.UIBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RozetkaPageFactoryTest extends UIBaseTest {

    String searchText = "Xbox Series X 1Tb";
    RozetkaPageFactoryMainPage rozetkaMainPage;
    RozetkaPageFactoryProductsPage productsPage;
    RozetkaPageFactoryProductDetailsPage productDetailsPage;

    @Test
    public void testAddingProductToCart() {
        driver.get("https://rozetka.com.ua/");

        rozetkaMainPage = new RozetkaPageFactoryMainPage(driver);

        //rozetkaMainPage.clickOnGamingMenuItem();
        productsPage = rozetkaMainPage.getTopPanelFragment().performSearch(searchText);

        productDetailsPage = productsPage.clickProductTitle();

        String actualProductTitle = productDetailsPage.getProductTitleText();
        Assert.assertTrue(actualProductTitle.toLowerCase().contains(searchText.toLowerCase()));

        productDetailsPage.addProductToCart();

        Assert.assertFalse(productDetailsPage.getTopPanelFragment().isCartEmpty());
        Assert.assertEquals(productDetailsPage.getTopPanelFragment().getCartLabelText(), "1");
    }
}
