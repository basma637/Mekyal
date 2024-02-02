package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class LoginPage extends MethodHandles {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By emailFiled= By.id("Email");

    private final By passwordField = By.id("Password");

    private final By loginButton = By.cssSelector(".button-1.login-button");

    public void insertEmail(String username){
        sendKeys(emailFiled,username);
    }
    public void insertPassword(String password){
        sendKeys(passwordField,password);
    }
    public void clickOnLoginButton(){
        click(loginButton);
    }
}
