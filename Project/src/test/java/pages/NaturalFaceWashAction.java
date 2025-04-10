package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.NaturalFaceWahLoc;
import utils.Base;
import utils.LoggerHandler;
import utils.WebDriverHelper;

public class NaturalFaceWashAction {
    static WebDriverHelper driverHelper = new WebDriverHelper(Base.driver);

    public static void displayedFaceWash(ExtentTest test) {
        try {
            driverHelper.isElementDisplayed(NaturalFaceWahLoc.verifyFaceWash, test);
        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    public static void clickPrice(ExtentTest test) {
        try {

            driverHelper.clickOnElement(NaturalFaceWahLoc.clickPriceDropdown, test);
            driverHelper.clickOnElement(NaturalFaceWahLoc.clickPriceThird, test);
            driverHelper.switchInToWindown();
        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    public static void clickFirstProduct(ExtentTest test) {
        try {
            driverHelper.clickOnElement(NaturalFaceWahLoc.clickFirstProductFaceWash, test);
            driverHelper.switchInToWindown();
        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    public static void allNaturalFace(ExtentTest test){
       displayedFaceWash(test);
       clickPrice(test);
       clickFirstProduct(test);
    }
}
