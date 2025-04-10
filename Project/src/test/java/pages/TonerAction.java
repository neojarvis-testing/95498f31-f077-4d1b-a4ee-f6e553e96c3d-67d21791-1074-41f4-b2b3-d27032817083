package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.TonerLoc;
import utils.Base;
import utils.LoggerHandler;
import utils.WebDriverHelper;

public class TonerAction {
    static WebDriverHelper driverHelper = new WebDriverHelper(Base.driver);

    public static void tonerDisplayed(ExtentTest test){
        try {
            driverHelper.isElementDisplayed(TonerLoc.tonerDisplayed , test);

        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }
    public static void clickSortAndNewArrivals(ExtentTest test){
        try {
            driverHelper.clickOnElement(TonerLoc.clickSortBy, test);
            driverHelper.clickOnElement(TonerLoc.clickNewArrivals, test);
        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }
    public static void clickOnAvgRating(ExtentTest test){
        try {
            driverHelper.clickOnElement(TonerLoc.clickAvgRating, test);
            driverHelper.clickOnElement(TonerLoc.clickFirstRatingOption, test);
        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }
    public static void clickOnFirstProduct(ExtentTest test){
        try {
            driverHelper.clickOnElement(TonerLoc.clickFirstProductNew, test);
            driverHelper.switchToWindow(1, test);
        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    public static void allToner(ExtentTest test){
        tonerDisplayed(test);
        clickSortAndNewArrivals(test);
        clickOnAvgRating(test);
        clickOnFirstProduct(test);
    }





}
