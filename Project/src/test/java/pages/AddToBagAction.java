package pages;

import org.openqa.selenium.JavascriptExecutor;
import com.aventstack.extentreports.ExtentTest;
import uistore.AddToBagPageLoc;
import utils.Base;
import utils.ExcelFileReader;
import utils.LoggerHandler;
import utils.Screenshot;
import utils.WebDriverHelper;

public class AddToBagAction {
    static WebDriverHelper driverHelper = new WebDriverHelper(Base.driver);
    static JavascriptExecutor js = (JavascriptExecutor) Base.driver;
    
    /**
 * Description:
 * This method clicks the "Add to Bag" button after ensuring it is visible.
 *
 * @param test ExtentTest object for logging and reporting.
 * @return void
 * @author Harshit
 */
    public static void clickAddToBag(ExtentTest test) {
        try {
            driverHelper.waitForElementToBeVisible(AddToBagPageLoc.clickAddToBag, 10, test);
            driverHelper.clickOnElement(AddToBagPageLoc.clickAddToBag, test);
        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }
    
    /**
 * Description: Checks if the description element is displayed on the page.
 *
 * @param test ExtentTest object for logging and reporting.
 * @return void
 * @author Harshit
 */
    public static void descriptionDisplayed(ExtentTest test) {
        try {
            driverHelper.isElementDisplayed(AddToBagPageLoc.descriptionDisplayed, test);
        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }
    /**
 * Description: Clicks the "Ingredient" element after ensuring it is visible and scrolls to it if needed.
 *
 * @param test ExtentTest object for logging and reporting.
 * @return void
 * @author Harshit
 */
    public static void clickIngredient(ExtentTest test) {
        try {
            driverHelper.waitForElementToBeVisible(AddToBagPageLoc.clickIngredient, 5, test);
            driverHelper.scrollAndClickByPixels(test, AddToBagPageLoc.clickIngredient);
            driverHelper.clickOnElement(AddToBagPageLoc.clickIngredient, test);

        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    /**
 * Description: Clicks the "Read More" element, scrolls down the page, and captures a screenshot.
 *
 * @param test ExtentTest object for logging and reporting.
 * @return void
 * @author Harshit
 */
    public static void clickReadMore(ExtentTest test) {
        try {
            driverHelper.waitForElementToBeVisible(AddToBagPageLoc.clickReadMore, 5, test);

            driverHelper.clickOnElement(AddToBagPageLoc.clickReadMore, test);
            js.executeScript("window.scrollBy(0,400)", "");
            Screenshot.highlightAndCapture(test, Base.driver, "Description.png", AddToBagPageLoc.clickIngredient);

        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    /**
 * Description: Clicks the "Pincode Search" element.
 *
 * @param test ExtentTest object for logging and reporting.
 * @return void
 * @author Harshit
 */
    public static void clickPincodeSearch(ExtentTest test) {
        try {
            driverHelper.clickOnElement(AddToBagPageLoc.clickPincode, test);
        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    /**
 * Description: Reads a pincode from the Excel file and sends it to the relevant input field.
 *
 * @param test ExtentTest object for logging and reporting.
 * @return void
 * @author Harshit
 */
    public static void sendPincode(ExtentTest test) {
        try {
            String pinCodeNumber = ExcelFileReader.readData(
                    "Sheet1", 0, 0, test);
            driverHelper.sendKeys(AddToBagPageLoc.clickPincode, pinCodeNumber, test, "placeholder");
        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    /**
 * Description: Clicks the "Pincode Check" button.
 *
 * @param test ExtentTest object for logging and reporting.
 * @return void
 * @author Harshit
 */
    public static void clickPincodeCheck(ExtentTest test) {
        try {
            driverHelper.clickOnElement(AddToBagPageLoc.clickPincodeCheck, test);
        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    /**
 * Description: Executes a series of actions related to the "Add to Bag" process, including
 * clicking "Add to Bag", performing pincode search, sending pincode, and clicking the pincode check button.
 *
 * @param test ExtentTest object for logging and reporting.
 * @return void
 * @author Harshit
 */
    public static void allAddToBag(ExtentTest test) {
        clickAddToBag(test);
        clickPincodeSearch(test);
        sendPincode(test);
        clickPincodeCheck(test);
    }
    /**
 * Description: Performs a sequence of actions for the "Add to Bag" workflow, including clicking 
 * "Add to Bag", checking if the description is displayed, interacting with the "Ingredient" element, 
 * and clicking "Read More".
 *
 * @param test ExtentTest object for logging and reporting.
 * @return void
 * @author Harshit
 */
    public static void allAddToBag1(ExtentTest test) {    
        clickAddToBag(test);
        descriptionDisplayed(test);
        clickIngredient(test);
        clickReadMore(test);
        
    }

}
