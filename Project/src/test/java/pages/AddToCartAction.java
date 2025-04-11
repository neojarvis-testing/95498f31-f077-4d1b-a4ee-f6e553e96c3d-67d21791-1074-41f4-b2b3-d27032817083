package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.AddtoCartLoc;
import utils.Base;
import utils.LoggerHandler;
import utils.Screenshot;
import utils.WebDriverHelper;

public class AddToCartAction {
    static WebDriverHelper driverHelper = new WebDriverHelper(Base.driver);

    /**
     * Description: Clicks the "Cart" icon.
     *
     * @param test ExtentTest object for logging and reporting.
     * @return void
     * @author Harshit
     */
    public static void clickCartIcon(ExtentTest test) {
        try {
            driverHelper.clickOnElement(AddtoCartLoc.clickCart, test);
        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    /**
     * Description: Verifies if the "Bag" element is displayed on the cart page by
     * waiting for its visibility,
     * switching to the appropriate iframe, and capturing a highlighted screenshot.
     *
     * @param test ExtentTest object for logging and reporting.
     * @return void
     * @author Harshit
     */
    public static void isBagDisplayed(ExtentTest test) {
        try {
            driverHelper.waitForElementToBeVisible(AddtoCartLoc.verifyBag, 5, test);
            Base.driver.switchTo().frame(Base.driver.findElement(AddtoCartLoc.switchToIframe));
            driverHelper.isElementDisplayed(AddtoCartLoc.verifyBag, test);
            driverHelper.waitForElementToBeVisible(AddtoCartLoc.verifyBag, 5, test);
            Screenshot.highlightAndCapture(test, Base.driver, "Cart_Page", AddtoCartLoc.verifyBag);
        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    /**
     * Description: Executes all actions related to the cart workflow, including
     * clicking
     * the cart icon and verifying the bag's display.
     *
     * @param test ExtentTest object for logging and reporting.
     * @return void
     * @author Harshit
     */
    public static void allCart(ExtentTest test) {
        clickCartIcon(test);
        isBagDisplayed(test);
    }

}
