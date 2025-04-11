package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.HomePageFooterLoc;
import utils.Base;
import utils.LoggerHandler;
import utils.WebDriverHelper;

public class HomePageFooterAction {
    static WebDriverHelper driverHelper = new WebDriverHelper(Base.driver);

    /**
     * Description: Performs actions to click on the "New Launches" section by
     * scrolling,
     * hovering, and switching to the appropriate window.
     *
     * @param test ExtentTest object for logging and reporting.
     * @return void
     * @author Harshit
     */
    public static void clickNewLaunches(ExtentTest test) {
        try {

            driverHelper.scrollAndClickByPixels(test, HomePageFooterLoc.clickNewLaunches);
            driverHelper.hoverAndClick(test, HomePageFooterLoc.clickNewLaunches, HomePageFooterLoc.clickNewLaunches);
            driverHelper.switchInToWindown();
        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }
}
