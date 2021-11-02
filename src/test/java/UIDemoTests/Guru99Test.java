package UIDemoTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Guru99Test extends UIBaseTest {
    String url = "https://demo.guru99.com/Agile_Project/Agi_V1/index.php";
    String validLogin = "1303";
    String validPassword = "Guru99";

    @Test
    public void loginWithValidCredentials() {
        driver.get(url);

        WebElement loginField = driver.findElement(By.name("uid"));
        loginField.sendKeys(validLogin);

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(validPassword);

        WebElement loginButton = driver.findElement(By.name("btnLogin"));
        loginButton.click();

        WebElement pageTitle = driver.findElement(By.className("barone"));
        String expectedTitle = "Guru99 Bank";

        Assert.assertEquals(pageTitle.getText(), expectedTitle);

        WebElement logoutButton = driver.findElement(By.cssSelector("[href^=Logout]"));
        logoutButton.click();

        String alertText = "You Have Succesfully Logged Out!!";
        String partialAlertTest = "Logged Out";

        Assert.assertEquals(driver.switchTo().alert().getText(), alertText);
        Assert.assertTrue(driver.switchTo().alert().getText().contains(partialAlertTest));

        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginWithInvalidPassword() {
        String invalidPassword = "123";

        driver.get(url);

        WebElement loginField = driver.findElement(By.name("uid"));
        loginField.sendKeys(validLogin);

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(invalidPassword);

        WebElement loginButton = driver.findElement(By.name("btnLogin"));
        loginButton.click();

        String alertText = "User or Password is not valid";

        Assert.assertEquals(driver.switchTo().alert().getText(), alertText);

        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }


    // HOMEWORK

    @Test
    public void loginWithInvalidLogin() {
        String invalidLogin = "qwerty123";

        driver.get(url);

        WebElement loginField = driver.findElement(By.name("uid"));
        loginField.sendKeys(invalidLogin);

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(validPassword);

        WebElement loginButton = driver.findElement(By.name("btnLogin"));
        loginButton.click();

        String alertText = "User or Password is not valid";

        Assert.assertEquals(driver.switchTo().alert().getText(), alertText);

        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginWithInvalidLoginAndPassword() {
        String invalidLogin = "qwerty123";
        String invalidPassword = "123";

        driver.get(url);

        WebElement loginField = driver.findElement(By.name("uid"));
        loginField.sendKeys(invalidLogin);

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(invalidPassword);

        WebElement loginButton = driver.findElement(By.name("btnLogin"));
        loginButton.click();

        String alertText = "User or Password is not valid";

        Assert.assertEquals(driver.switchTo().alert().getText(), alertText);

        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginWithEmptyLogin() {
        driver.get(url);

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(validPassword);

        WebElement loginButton = driver.findElement(By.name("btnLogin"));
        loginButton.click();

        String alertText = "User or Password is not valid";

        Assert.assertEquals(driver.switchTo().alert().getText(), alertText);

        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginWithEmptyPassword() {
        driver.get(url);

        WebElement loginField = driver.findElement(By.name("uid"));
        loginField.sendKeys(validLogin);

        WebElement loginButton = driver.findElement(By.name("btnLogin"));
        loginButton.click();

        String alertText = "User or Password is not valid";

        Assert.assertEquals(driver.switchTo().alert().getText(), alertText);

        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    // CHECK VALIDATION MESSAGES

    @Test
    public void checkLoginValidationMessage() {
        String loginValidationMessage = "User-ID must not be blank";

        driver.get(url);

        WebElement loginField = driver.findElement(By.name("uid"));
        loginField.click();

        WebElement pageTitle = driver.findElement(By.className("barone"));
        pageTitle.click();

        WebElement validationMessage = driver.findElement(By.id("message23"));
        Assert.assertEquals(validationMessage.getText(), loginValidationMessage);
    }

    @Test
    public void checkPasswordValidationMessage() {
        String passwordValidationMessage = "Password must not be blank";

        driver.get(url);

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.click();

        WebElement pageTitle = driver.findElement(By.className("barone"));
        pageTitle.click();

        WebElement validationMessage = driver.findElement(By.id("message18"));
        Assert.assertEquals(validationMessage.getText(), passwordValidationMessage);
    }
}