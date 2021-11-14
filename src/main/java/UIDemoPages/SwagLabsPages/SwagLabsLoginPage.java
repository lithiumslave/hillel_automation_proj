package UIDemoPages.SwagLabsPages;

import UIDemoPages.BasePage;
import UIDemoPages.Models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwagLabsLoginPage extends BasePage {

    @FindBy(id="user-name")
    private WebElement userName;

    @FindBy(id="password")
    private WebElement passwordField;

    @FindBy(id="login-button")
    private WebElement loginButton;

    public SwagLabsLoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void loginAs(String login, String password) {
        userName.sendKeys(login);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void loginAs(User user) {
        userName.sendKeys(user.getUserName());
        passwordField.sendKeys(user.getUserPassword());
        loginButton.click();
    }
}
