package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By loginLink = By.cssSelector(".ico-login");

    private final By computersLink =
            By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]");

    private final By desktop =
            By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Desktops ')]");

    public LoginPage clickOnLoginLink() {
        click(loginLink);
        return new LoginPage(driver);
    }

    private void hoverOverComputers(){
        hoverOverElement(computersLink);
    }
    private void clickOnDeskTop(){
        clickWithActions(desktop);
    }
    public DesktopPage selectDesktopProducts(){
        hoverOverComputers();
        clickOnDeskTop();
        return new DesktopPage(driver);
    }
}
