package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.NewLaunchesLoc;
import utils.Base;
import utils.LoggerHandler;
import utils.WebDriverHelper;

public class NewLaunchesAction {
    static WebDriverHelper driverHelper = new WebDriverHelper(Base.driver);

    /**
     * Description: Verifies if the "New Launches" element is displayed by waiting
     * for its visibility
     * and checking its presence on the page.
     *
     * @param test ExtentTest object for logging and reporting.
     * @return void
     * @author Harshit
     */
    public static void displayNewLaunches(ExtentTest test) {
        try {
            driverHelper.waitForElementToBeVisible(NewLaunchesLoc.verifyNewLaunches, 5, test);
            driverHelper.isElementDisplayed(NewLaunchesLoc.verifyNewLaunches, test);
        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    /**
     * Description: Waits for the "Natural" element to become visible and performs a
     * hover action over it.
     *
     * @param test ExtentTest object for logging and reporting.
     * @return void
     * @author Harshit
     */
    public static void hoverNatural(ExtentTest test) {
        try {
            driverHelper.waitForElementToBeVisible(NewLaunchesLoc.hoverNatural, 5, test);

            driverHelper.hoverOverElement(NewLaunchesLoc.hoverNatural, test);
        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    /**
     * Description: Waits for the "Face Wash" element to become visible, clicks on
     * it,
     * and switches to the appropriate window.
     *
     * @param test ExtentTest object for logging and reporting.
     * @return void
     * @author Harshit
     */
    public static void clickFaceWash(ExtentTest test) {
        try {
            driverHelper.waitForElementToBeVisible(NewLaunchesLoc.clickFaceWash, 5, test);

            driverHelper.clickOnElement(NewLaunchesLoc.clickFaceWash, test);
            driverHelper.switchInToWindown();

        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    /**
     * Description: Executes a series of actions related to the "New Launches"
     * workflow, including
     * verifying the display of the "New Launches" element, hovering over the
     * "Natural" section,
     * and clicking on the "Face Wash" option.
     *
     * @param test ExtentTest object for logging and reporting.
     * @return void
     * @author Harshit
     */
    public static void allLaunches(ExtentTest test) {
        displayNewLaunches(test);
        hoverNatural(test);
        clickFaceWash(test);
    }

}
