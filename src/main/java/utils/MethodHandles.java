package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethodHandles {

    protected WebDriver driver;

    static ExtentReports extent;

    static ExtentTest test;

    WebDriverWait wait;
    Actions actions;

    //private final By loader = By.cssSelector("ajax-loading-block-window");
   // private final By barNotification = By.id("bar-notification");

    public MethodHandles(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement webElement(By locator) {
        return driver.findElement(locator);
    }

    private void explicitWait(By locator, int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(webElement(locator)),
                ExpectedConditions.presenceOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator),
                ExpectedConditions.visibilityOfElementLocated(locator)));
    }

    private void invisibilityOf(By locator, int time) {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.invisibilityOf(webElement(locator)),
                    ExpectedConditions.invisibilityOfElementLocated(locator)));
        } catch (NoSuchElementException s) {

        }

    }

    private void scrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void clickFW(By locator) {
        for (int i = 0;i<5;i++){
            try {
                //invisibilityOf(loader, 20);
                explicitWait(locator, 40);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                webElement(locator).click();
                break;
            }catch (StaleElementReferenceException | ElementClickInterceptedException e){

            }
        }
    }

    protected void sendKeys(By locator, String text) {
        for (int i =0;i<5;i++){
            try {
                explicitWait(locator, 20);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                webElement(locator).sendKeys(text);
                break;
            }catch (StaleElementReferenceException e){

            }
        }
    }

    protected String getText(By locator) {
        String text = null;
        for (int i =0;i<5;i++){
            try {
                explicitWait(locator, 20);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                text= webElement(locator).getText();
                break;
            }catch (StaleElementReferenceException e){

            }
        }
        return text;
    }

    protected void hoverOverElement(By locator) {
        actions = new Actions(driver);
        for (int i = 0;i<5;i++){
            try {
                explicitWait(locator, 10);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                actions.moveToElement(webElement(locator)).build().perform();
                break;
            }catch (StaleElementReferenceException e){

            }
        }
    }

    protected void clickWithActions(By locator) {
        actions = new Actions(driver);
        for (int i=0;i<5;i++){
            try {
                //invisibilityOf(loader, 20);
                explicitWait(locator, 10);

                setSteps();
                addBorderToElement(driver, webElement(locator));
                actions.click(webElement(locator)).build().perform();
                break;
            }catch (StaleElementReferenceException e){

            }
        }
    }

    protected boolean isDisplayed(By locator) {
        boolean flag = false;
        for (int i =0;i<5;i++){
            try {
                explicitWait(locator, 10);
                addBorderToElement(driver, webElement(locator));
                flag =  webElement(locator).isDisplayed();
                break;
            }catch (StaleElementReferenceException e){

            }
        }
        return flag;
    }
    protected void doubleClick(By locator){
        actions = new Actions(driver);
        for (int i=0;i<5;i++){
            try {
                invisibilityOf(locator,10);
                explicitWait(locator,10);
                addBorderToElement(driver,webElement(locator));
                actions.doubleClick().build().perform();
                break;
            }catch (StaleElementReferenceException e){

            }
        }
    }

    //public boolean barNotificationIsDisplayed() {return isDisplayed(barNotification);}

    private static String getMethodName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements.length >= 2) {
            if (stackTraceElements.length >= 4)
                return stackTraceElements[4].getMethodName();
            return stackTraceElements[2].getMethodName();
        } else {
            return "Unknown";
        }
    }

    private void setSteps() {
        test.info(getMethodName());
    }

    private static void addBorderToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border = '5px solid red'", element);
    }
}
