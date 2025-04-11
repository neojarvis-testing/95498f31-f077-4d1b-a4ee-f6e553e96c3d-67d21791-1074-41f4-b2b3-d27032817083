package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.NaturalFaceWahLoc;
import utils.Base;
import utils.LoggerHandler;
import utils.WebDriverHelper;

public class NaturalFaceWashAction {
    static WebDriverHelper driverHelper = new WebDriverHelper(Base.driver);

    /**
     * Description: Verifies if the "Face Wash" element is displayed.
     *
     * @param test ExtentTest object for logging and reporting.
     * @return void
     * @author Harshit
     */
    public static void displayedFaceWash(ExtentTest test) {
        try {
            driverHelper.isElementDisplayed(NaturalFaceWahLoc.verifyFaceWash, test);
        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    /**
     * Description: Clicks on the price dropdown, selects the third price option,
     * and switches to the appropriate window.
     *
     * @param test ExtentTest object for logging and reporting.
     * @return void
     * @author Harshit
     */
    public static void clickPrice(ExtentTest test) {
        try {

            driverHelper.clickOnElement(NaturalFaceWahLoc.clickPriceDropdown, test);
            driverHelper.clickOnElement(NaturalFaceWahLoc.clickPriceThird, test);
            driverHelper.switchInToWindown();
        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    /**
     * Description: Clicks on the first product in the "Face Wash" category and
     * switches to the appropriate window.
     *
     * @param test ExtentTest object for logging and reporting.
     * @return void
     * @author Harshit
     */
    public static void clickFirstProduct(ExtentTest test) {
        try {
            driverHelper.clickOnElement(NaturalFaceWahLoc.clickFirstProductFaceWash, test);
            driverHelper.switchInToWindown();
        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    /**
     * Description: Executes a series of actions related to the "Natural Face"
     * workflow, including
     * verifying the display of the face wash element, selecting a price option, and
     * clicking on the first product.
     *
     * @param test ExtentTest object for logging and reporting.
     * @return void
     * @author Harshit
     */
    public static void allNaturalFace(ExtentTest test) {
        displayedFaceWash(test);
        clickPrice(test);
        clickFirstProduct(test);
    }
}
