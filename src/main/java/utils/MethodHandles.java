package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethodHandles {

    protected WebDriver driver;

    WebDriverWait wait;
    Actions actions;

    private final By loader = By.cssSelector("ajax-loading-block-window");
    private final By barNotification = By.id("bar-notification");
    public MethodHandles(WebDriver driver){
        this.driver = driver;
    }
    private WebElement webElement(By locator){
        return driver.findElement(locator);
    }

    private void explicitWait(By locator,int time){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(webElement(locator)),
                ExpectedConditions.presenceOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator),
                ExpectedConditions.visibilityOfElementLocated(locator)));
    }
    private void invisibilityOf(By locator,int time){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.invisibilityOf(webElement(locator)),
                ExpectedConditions.invisibilityOfElementLocated(locator)));
    }
    private void scrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void click(By locator){
//        invisibilityOf(loader,20);
        explicitWait(locator,20);
//        scrollIntoView(driver,webElement(locator));
        webElement(locator).click();
    }
    protected void sendKeys(By locator, String text){
//        invisibilityOf(loader,20);
        explicitWait(locator,20);
//        scrollIntoView(driver,webElement(locator));
        webElement(locator).sendKeys(text);
    }
    protected String getText(By locator){
        explicitWait(locator,20);
//        scrollIntoView(driver,webElement(locator));
        return webElement(locator).getText();
    }
    protected void hoverOverElement(By locator){
        actions = new Actions(driver);
        explicitWait(locator,10);
        actions.moveToElement(webElement(locator)).build().perform();
    }
    protected void clickWithActions(By locator){
        explicitWait(locator,10);
        actions = new Actions(driver);
        actions.click(webElement(locator)).click().build().perform();
    }
    protected boolean isDisplayed(By locator){
        explicitWait(locator,10);
//        scrollIntoView(driver,webElement(locator));
        return webElement(locator).isDisplayed();
    }

    public boolean barNotificationIsDisplayed(){
        return isDisplayed(barNotification);
    }
}
