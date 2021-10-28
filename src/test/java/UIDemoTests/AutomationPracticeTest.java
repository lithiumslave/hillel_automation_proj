package UIDemoTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AutomationPracticeTest extends UIBaseTest{

    @Test
    public void selectDressByTitle() {
        driver.get("http://automationpractice.com/index.php");
        String whatIWantToBuy = "Printed Chiffon Dress";

        List<WebElement> itemsTitles = driver.findElements(By.cssSelector("#homefeatured a.product-name"));

        for(WebElement item : itemsTitles) {
            System.out.println(item.getText());
            if(item.getText().equals(whatIWantToBuy)) {
                item.click();
                break;
            }
        }

        WebElement selectedProductTitle = driver.findElement(By.cssSelector("[itemprop=name]"));
        Assert.assertEquals(selectedProductTitle.getText(), whatIWantToBuy);
    }
}
