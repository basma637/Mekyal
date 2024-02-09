package login;

import base.BaseTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

import static org.testng.Assert.assertTrue;

public class LoginTests1 extends BaseTests {

    @DataProvider
    public Object[][] provideDataToTc() throws FileNotFoundException {
        return dataModel().Login1;
    }

    @Test(dataProvider = "provideDataToTc")
    public void testSuccessfulLogin(String username,String password) throws FileNotFoundException {
        LoginPage loginPage = homePage.clickOnLoginLink();
        loginPage.insertEmail(username);
        loginPage.insertPassword(password);
        loginPage.clickOnLoginButton();
        String expectedResult = dataModel().ValidationMessage;
        String actualResult = loginPage.getValidationMessage();
        assertTrue(actualResult.contains(expectedResult));
    }
}
