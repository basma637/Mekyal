package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class LoginPage extends MethodHandles {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By emailFiled= By.id("emailOrIdNum");

    private final By passwordField = By.id("password");

    private final By loginButton =  By.cssSelector("button[class='my-3 py-4  main-button w-full h-full text-[#D2DDE9] py-[15px] px-[50px] rounded-[40px] flex items-center justify-center border-2 border-transparent bg-[var(--main-color)] hover:bg-transparent hover:text-[var(--main-color)] transition-all hover:border-[var(--main-color)] duration-300']");
    //By.xpath("//a [contains(@type , 'submit')]");
    //private final By validationMessage = By.cssSelector(".message-error.validation-summary-errors");

    public void insertEmail(String username){
        sendKeys(emailFiled,username);
    }
    public void insertPassword(String password){
        sendKeys(passwordField,password);
    }
    public void clickOnLoginButton(){
        clickFW(loginButton);
    }
    //public String getValidationMessage(){return getText(validationMessage);}
}
