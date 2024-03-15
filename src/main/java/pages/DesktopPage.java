package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class DesktopPage extends MethodHandles {

    public DesktopPage(WebDriver driver) {
        super(driver);
    }

    private final By addToCart = By.xpath("(//button[contains(text(),'Add to cart')])[2]");

    public void clickOnAddToCart(){
        clickWithActions(addToCart);
    }

}
