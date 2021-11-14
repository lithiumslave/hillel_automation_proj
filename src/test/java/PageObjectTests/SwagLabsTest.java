package PageObjectTests;

import UIDemoPages.Models.LombokUser;
import UIDemoPages.Models.User;
import UIDemoPages.SwagLabsPages.SwagLabsLoginPage;
import UIDemoTests.UIBaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SwagLabsTest extends UIBaseTest {

    @DataProvider(name = "stringCredentialsDataProvider")
    public Object[][] userCreds() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"}
        };
    }

    @DataProvider(name = "builderCredentialsDataProvider")
    public Object[][] users() {
        return new Object[][]{
                {new User.UserBuilder().withUsername("standard_user").withPassword("secret_sauce").build()},
                {new User.UserBuilder().withUsername("problem_user").withPassword("secret_sauce").build()},
                {new User.UserBuilder().withUsername("performance_glitch_user").withPassword("secret_sauce").build()}
        };
    }

    @DataProvider(name = "lombokCredentialsDataProvider")
    public Object[][] users1() {
        return new Object[][]{
                {LombokUser.builder()
                        .userName("standard_user")
                        .userPassword("secret_sauce").build()},
                {LombokUser.builder()
                        .userName("problem_user")
                        .userPassword("secret_sauce").build()},
                {LombokUser.builder()
                        .userName("performance_glitch_user")
                        .userPassword("secret_sauce").build()}
        };
    }

    @Test(dataProvider = "stringCredentialsDataProvider")
    public void loginWithValidUser(String name, String pass) {

        SwagLabsLoginPage loginPage = new SwagLabsLoginPage(driver);
        driver.get("https://www.saucedemo.com/");

        loginPage.loginAs(name,pass);
    }

    @Test(dataProvider = "builderCredentialsDataProvider")
    public void loginWithValidUserBuilder(User validUser) {

        SwagLabsLoginPage loginPage = new SwagLabsLoginPage(driver);
        driver.get("https://www.saucedemo.com/");

        loginPage.loginAs(validUser);
    }
}
