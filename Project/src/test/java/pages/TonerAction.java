package pages;

import java.time.Duration;

import com.aventstack.extentreports.ExtentTest;

import uistore.TonerLoc;
import utils.Base;
import utils.LoggerHandler;
import utils.WebDriverHelper;

public class TonerAction {
    static WebDriverHelper driverHelper = new WebDriverHelper(Base.driver);

    /**
     * Description: Verifies if the "Toner" element is displayed on the page.
     *
     * @param test ExtentTest object for logging and reporting.
     * @return void
     * @author Harshit
     */
    public static void tonerDisplayed(ExtentTest test) {
        try {
            driverHelper.isElementDisplayed(TonerLoc.tonerDisplayed, test);

        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    /**
     * Description: Clicks on the "Sort By" element and selects the "New Arrivals"
     * option.
     *
     * @param test ExtentTest object for logging and reporting.
     * @return void
     * @author Harshit
     */
    public static void clickSortAndNewArrivals(ExtentTest test) {
        try {
            driverHelper.clickOnElement(TonerLoc.clickSortBy, test);
            driverHelper.clickOnElement(TonerLoc.clickNewArrivals, test);
        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    /**
     * Description: Clicks on the "Sort By" element and selects the "New Arrivals"
     * option.
     *
     * @param test ExtentTest object for logging and reporting.
     * @return void
     * @author Harshit
     */
    public static void clickOnAvgRating(ExtentTest test) {
        try {
            driverHelper.clickOnElement(TonerLoc.clickAvgRating, test);
            driverHelper.clickOnElement(TonerLoc.clickFirstRatingOption, test);
        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    /**
     * Description: Clicks on the first product in the "New Products" section and
     * switches
     * to the specified window.
     *
     * @param test ExtentTest object for logging and reporting.
     * @return void
     * @author Harshit
     */
    public static void clickOnFirstProduct(ExtentTest test) {
        try {
            driverHelper.clickOnElement(TonerLoc.clickFirstProductNew, test);
            driverHelper.switchToWindow(1, test);

            Base.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            Base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    /**
     * Description: Executes a sequence of actions related to the "Toner" workflow,
     * including
     * verifying the display of the toner element, sorting by "New Arrivals",
     * selecting the
     * average rating option, and clicking on the first product.
     *
     * @param test ExtentTest object for logging and reporting.
     * @return void
     * @author Harshit
     */
    public static void allToner(ExtentTest test) {
        tonerDisplayed(test);
        clickSortAndNewArrivals(test);
        clickOnAvgRating(test);
        clickOnFirstProduct(test);
    }

}
