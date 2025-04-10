package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.AddtoCartLoc;
import utils.Base;
import utils.LoggerHandler;
import utils.Screenshot;
import utils.WebDriverHelper;

public class AddToCartAction {
    static WebDriverHelper driverHelper = new WebDriverHelper(Base.driver);

    public static void clickCartIcon(ExtentTest test) {
        try {
            driverHelper.clickOnElement(AddtoCartLoc.clickCart, test);
        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

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

    public static void allCart(ExtentTest test) {
        clickCartIcon(test);
        isBagDisplayed(test);
    }

}
