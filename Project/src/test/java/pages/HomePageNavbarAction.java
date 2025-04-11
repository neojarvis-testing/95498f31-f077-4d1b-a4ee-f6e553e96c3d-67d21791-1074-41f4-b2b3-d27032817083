package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.HomePageNavbarLoc;
import utils.Base;
import utils.ExcelFileReader;
import utils.LoggerHandler;
import utils.WebDriverHelper;

public class HomePageNavbarAction {
    static WebDriverHelper driverHelper = new WebDriverHelper(Base.driver);

    /**
     * Description: Clicks on the search bar element.
     *
     * @param test ExtentTest object for logging and reporting.
     * @return void
     * @author Harshit
     */
    public static void clickSearchBar(ExtentTest test) {
        try {
            driverHelper.clickOnElement(HomePageNavbarLoc.searchBar, test);

        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    /**
     * Description: Reads a search value from an Excel file and sends it to the
     * search bar.
     *
     * @param test ExtentTest object for logging and reporting.
     * @return void
     * @author Harshit
     */
    public static void sendKeyToSearchBar(ExtentTest test) {
        try {

            String searchVal = ExcelFileReader.readData(
                    "Sheet1", 8, 0, test);
            driverHelper.sendKeys(HomePageNavbarLoc.searchBar, searchVal, test, "placeholder");

        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    /**
     * Description: Performs an action to simulate pressing "Enter" on the search
     * bar element.
     *
     * @param test ExtentTest object for logging and reporting.
     * @return void
     * @author Harshit
     */
    public static void enterSearchBar(ExtentTest test) {
        try {

            driverHelper.enterAction(HomePageNavbarLoc.searchBar, test);

        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    /**
     * Description: Executes a series of actions related to the navigation bar,
     * including
     * clicking the search bar, entering a search value, and performing the "Enter"
     * action.
     *
     * @param test ExtentTest object for logging and reporting.
     * @return void
     * @author Harshit
     */
    public static void navbarAll(ExtentTest test) {
        clickSearchBar(test);
        sendKeyToSearchBar(test);
        enterSearchBar(test);
    }

}
