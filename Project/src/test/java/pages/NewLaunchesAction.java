package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.NewLaunchesLoc;
import utils.Base;
import utils.LoggerHandler;
import utils.WebDriverHelper;

public class NewLaunchesAction {
    static WebDriverHelper driverHelper = new WebDriverHelper(Base.driver);
    public static void displayNewLaunches(ExtentTest test){
        try {
            driverHelper.waitForElementToBeVisible(NewLaunchesLoc.verifyNewLaunches, 5, test);
            driverHelper.isElementDisplayed(NewLaunchesLoc.verifyNewLaunches , test);
        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
         }
       }
   public static void hoverNatural(ExtentTest test){
    try {
        driverHelper.waitForElementToBeVisible(NewLaunchesLoc.hoverNatural, 5, test);

        driverHelper.hoverOverElement(NewLaunchesLoc.hoverNatural, test);
    } catch (Exception e) {
        LoggerHandler.info(e.getMessage());
     }
   }

public static void clickFaceWash(ExtentTest test){
    try {
        driverHelper.waitForElementToBeVisible(NewLaunchesLoc.clickFaceWash, 5, test);

        driverHelper.clickOnElement(NewLaunchesLoc.clickFaceWash, test);
        driverHelper.switchInToWindown();

    } catch (Exception e) {
        LoggerHandler.info(e.getMessage());
     }
   }

   public static void allLaunches(ExtentTest test){
    displayNewLaunches(test);
    hoverNatural(test);
    clickFaceWash(test);
   }

}
