package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.BeautyToGoLoc;
import utils.AssertionUtility;
import utils.Base;
import utils.ExcelFileReader;
import utils.WebDriverHelper;

/**
 * Represents functionality related to the 'Beauty To Go' feature.
 * Provides methods to interact with elements like sending beauty information and 
 * verifying terms and conditions.
 * 
 * @author Pratik
 */

public class BeautyToGo {
    
    WebDriverHelper helper=new WebDriverHelper(Base.driver); 
    /**
     * Combines the workflows of sending beauty information and verifying terms 
     * and conditions for the 'Beauty To Go' feature.
     * 
     * @param test ExtentTest instance for reporting.
     * @author Pratik
     */
    public void beautyToGo(ExtentTest test) { 
        sendBeauty(test); 
        termsCon(test);
    }

    /**
     * Sends beauty-related information through the input field and performs assertions 
     * to verify the displayed text matches expected data from Excel.
     * 
     * @param test ExtentTest instance for reporting.
     * @author Pratik
     */
    public void sendBeauty(ExtentTest test){ 
        helper.waitForElementToBeVisible(BeautyToGoLoc.beautyToGo, 10, test);
        AssertionUtility.useAssertTrue(helper.getText(BeautyToGoLoc.beautyToGo, test), ExcelFileReader.readData(Base.prop.getProperty("sheet1"), 0, 0, test),test); 

        helper.clickOnElement(BeautyToGoLoc.inputBar, test);

        helper.sendKeys(BeautyToGoLoc.inputBar, ExcelFileReader.readData(Base.prop.getProperty("sheet1"),1, 0, test), test, "placeholder"); 

    }

    /**
     * Scrolls to the 'Terms and Conditions' section, clicks to verify, switches 
     * to a new window, and performs assertions to ensure text matches the expected data.
     * 
     * @param test ExtentTest instance for reporting.
     * @author Pratik
     */
    public void termsCon(ExtentTest test) { 
        helper.scrollAndClickByPixels(test,BeautyToGoLoc.termsAndCondition); 

        helper.switchToWindow(2,test);

        AssertionUtility.useAssertTrue(ExcelFileReader.readData(Base.prop.getProperty("sheet1"), 2, 0, test), helper.getText(BeautyToGoLoc.verifyTermsAndConditions,test), test);
    }

}
