package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.HomePageFooterLoc;
import utils.Base;
import utils.LoggerHandler;
import utils.WebDriverHelper;

public class HomePageFooterAction {
    static WebDriverHelper driverHelper = new WebDriverHelper(Base.driver);
    
    public static void clickNewLaunches(ExtentTest test){
        try {

            driverHelper.scrollAndClickByPixels(test, HomePageFooterLoc.clickNewLaunches); 
            driverHelper.hoverAndClick(test, HomePageFooterLoc.clickNewLaunches, HomePageFooterLoc.clickNewLaunches);
            driverHelper.switchInToWindown();
        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }
}
