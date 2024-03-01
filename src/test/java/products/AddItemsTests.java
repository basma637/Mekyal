package products;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DesktopPage;

import static org.testng.Assert.assertTrue;

public class AddItemsTests extends BaseTests {

    @Test
    public void testAddProductSuccessfully() {
        DesktopPage desktopPage = homePage.selectDesktopProducts();
        desktopPage.clickOnAddToCart();
        assertTrue(desktopPage.barNotificationIsDisplayed());
    }
}
