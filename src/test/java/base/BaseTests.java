package base;

import data.DataModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import reader.ReadDataFromJson;
import utils.ScreenRecorderUtil;
import utils.UtilsTests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTests {

    protected WebDriver driver;
    protected HomePage homePage;

    ChromeOptions chromeOptions;
    FirefoxOptions firefoxOptions;
    UtilsTests utilsTests;

    @Parameters({"browser"})
    @BeforeClass
    public void setUp(String browser) {
        setUpBrowser(browser);
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome(Method method) throws Exception {
        ScreenRecorderUtil.startRecord(method.getName());
        utilsTests = new UtilsTests(driver);
        utilsTests.createTestCaseInReport(method);
        driver.get(dataModel().URL);
    }

    @AfterMethod
    public void afterMethod(Method method, ITestResult result) throws Exception {
        utilsTests = new UtilsTests(driver);
        utilsTests.takeScreenShot(method);
        ScreenRecorderUtil.stopRecord();
        utilsTests.setStatus(method, result);
    }

    @AfterClass
    public void tearDown() {
       // driver.quit();
    }

    protected DataModel dataModel() throws FileNotFoundException {
        ReadDataFromJson readDataFromJson = new ReadDataFromJson();
        return readDataFromJson.readJsonFile();
    }

    @Parameters("browser")
    public void setUpBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("headlessChrome")) {
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("headlessFireFox")) {
            firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless");
            driver = new FirefoxDriver(firefoxOptions);
        }
        driver.manage().window().maximize();
    }

    @BeforeSuite
    public void beforeSuite() {
        utilsTests = new UtilsTests(driver);
        utilsTests.createReport();
    }

    @AfterSuite
    public void afterSuite() {
        utilsTests = new UtilsTests(driver);
        utilsTests.flushReport();
    }

}
