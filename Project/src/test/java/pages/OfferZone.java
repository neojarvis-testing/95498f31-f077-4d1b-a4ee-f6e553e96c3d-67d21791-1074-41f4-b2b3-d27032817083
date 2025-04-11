package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.OfferZoneLoc;
import uistore.TermsConditionsLoc;
import utils.AssertionUtility;
import utils.Base;
import utils.ExcelFileReader;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

/**
 * Represents functionality related to the 'Offer Zone' section.
 * Provides methods for interacting with the Offer Zone, including navigating to it 
 * and verifying its contents.
 * @author Pratik
 * 
 */
public class OfferZone {
    
 
    WebDriverHelper helper=new WebDriverHelper(Base.driver); 
    /**
     * Combines the workflows for clicking on the Offer Zone and verifying its details.
     * 
     * @param test ExtentTest instance for reporting.
     * @author Pratik
     */
    public void offerZone(ExtentTest test){
        clickOfferZone(test);
        verifyOfferZone(test);
        

    }

    /**
     * Scrolls to the footer, hovers, and clicks on the 'Offer Zone' section. 
     * Waits for the element to be visible and switches to the new window.
     * 
     * @param test ExtentTest instance for reporting.
     * 
     * @author Pratik
     * 
     */
    public void clickOfferZone(ExtentTest test){
        
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
        
        helper.scrollByToFooter(test);
    
        helper.hoverAndClick(test, OfferZoneLoc.offerZone, OfferZoneLoc.offerZone); 

    
        helper.waitForElementToBeVisible(OfferZoneLoc.offerZone,5,test);
        helper.switchToWindow(3,test);
    } 

    /**
     * Verifies the Offer Zone by asserting the current URL matches the expected value.
     * Captures a screenshot and attaches it to the report for validation.
     * 
     * @param test ExtentTest instance for reporting.
     * 
     * @author Pratik
     * 
     */
    public void verifyOfferZone(ExtentTest test){
        
        AssertionUtility.useAssertEquals(Base.driver.getCurrentUrl(), ExcelFileReader.readData(Base.prop.getProperty("sheet1"),5, 0, test),test);


        Screenshot.captureScreenshot( Base.driver,test, "logo.png");
        Reporter.attachScreenshotToReport("logo", test, "logo", Base.driver);
    }

}
