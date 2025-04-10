package pages;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentTest;

import uistore.BeautyToGoLoc;
import uistore.HomePageLoc;
import uistore.OfferZoneLoc;
import uistore.TermsConditionsLoc;
import utils.AssertionUtility;
import utils.Base;
import utils.ExcelFileReader;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class HomePageAct {
    WebDriverHelper helper=new WebDriverHelper(Base.driver); 
    
    public void getApp(ExtentTest test) throws InterruptedException{ 
        helper.hoverAndClick(test, HomePageLoc.getApp, HomePageLoc.getApp); 

        helper.switchToWindow(1,test); 
    }
    
}
