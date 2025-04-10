package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.HomePageNavbarLoc;
import utils.Base;
import utils.ExcelFileReader;
import utils.LoggerHandler;
import utils.WebDriverHelper;

public class HomePageNavbarAction {
    static WebDriverHelper driverHelper = new WebDriverHelper(Base.driver);

    public static void clickSearchBar(ExtentTest test) {
        try {
            driverHelper.clickOnElement(HomePageNavbarLoc.searchBar, test);

        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    public static void sendKeyToSearchBar(ExtentTest test) {
        try {

            String searchVal = ExcelFileReader.readData(
                    "Sheet1", 1, 0, test);
            driverHelper.sendKeys(HomePageNavbarLoc.searchBar, searchVal, test, "placeholder");

        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    public static void enterSearchBar(ExtentTest test) {
        try {

            driverHelper.enterAction(HomePageNavbarLoc.searchBar, test);

        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    public static void navbarAll(ExtentTest test) {
        clickSearchBar(test);
        sendKeyToSearchBar(test);
        enterSearchBar(test);
    }

}
