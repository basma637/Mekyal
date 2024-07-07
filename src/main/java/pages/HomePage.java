package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By loginLink = By.className("main-title text-[16px] font-bold");
            //linkText("Log in");
    //=By.xpath("//* [contains(@href , '/auth/login')]");
    //"//a [@class='text-gray hover:text-[var(--main-color)]']");

    //private final By registerLink = By.xpath("//a [contains(@href , '/auth/register')]");
    //By loginLink = By.className("text-gray hover:text-[var(--main-color)]");
    //By.xpath("//* [contains(@href , '/auth/register')]");

    public LoginPage clickOnLoginLink() {
        clickFW(loginLink);
        return new LoginPage(driver);
    }

    //private void hoverOverComputers(){hoverOverElement();}
}