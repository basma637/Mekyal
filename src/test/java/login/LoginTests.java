package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.io.FileNotFoundException;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin() throws FileNotFoundException {
        LoginPage loginPage = homePage.clickOnLoginLink();
        loginPage.insertEmail(dataModel().Login.ValidCredentials.Username);
        loginPage.insertPassword(dataModel().Login.ValidCredentials.Password);
        loginPage.clickOnLoginButton();
    }
    @Test
    public void testSuccessfulLogin2() throws FileNotFoundException {
        LoginPage loginPage = homePage.clickOnLoginLink();
        loginPage.insertEmail(dataModel().Login.ValidCredentials.Username);
        loginPage.insertPassword(dataModel().Login.ValidCredentials.Password);
        loginPage.clickOnLoginButton();
    }
}
