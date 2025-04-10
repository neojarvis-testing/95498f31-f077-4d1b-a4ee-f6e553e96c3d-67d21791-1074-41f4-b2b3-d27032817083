package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.OfferZoneLoc;
import utils.AssertionUtility;
import utils.Base;
import utils.ExcelFileReader;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class OfferZone {
    
 
    WebDriverHelper helper=new WebDriverHelper(Base.driver); 
    public void offerZone(ExtentTest test){
        clickOfferZone(test);
        verifyOfferZone(test);
        

    }
    public void clickOfferZone(ExtentTest test){
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        helper.scrollByToFooter(test);
       try {
        Thread.sleep(4000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
        helper.hoverAndClick(test, OfferZoneLoc.offerZone, OfferZoneLoc.offerZone); 

    
        helper.waitForElementToBeVisible(OfferZoneLoc.offerZone,5,test);
        helper.switchToWindow(3,test);
    } 

    public void verifyOfferZone(ExtentTest test){
        
        AssertionUtility.useAssertEquals(Base.driver.getCurrentUrl(), ExcelFileReader.readData(Base.prop.getProperty("sheet1"),5, 0, test),test);


        Screenshot.captureScreenshot( Base.driver,test, "logo.png");
        Reporter.attachScreenshotToReport("logo", test, "logo", Base.driver);
    }

}
