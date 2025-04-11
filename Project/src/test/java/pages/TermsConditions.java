package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.TermsConditionsLoc;
import utils.AssertionUtility;
import utils.Base;
import utils.ExcelFileReader;
import utils.WebDriverHelper;

/**
 * Represents functionality related to the 'Terms and Conditions' section.
 * Provides methods to interact with elements such as the Shipping Policy and Privacy Policy, 
 * and validates their content using assertions.
 * 
 * @author Pratik
 * 
 */
public class TermsConditions {
    
    WebDriverHelper helper=new WebDriverHelper(Base.driver); 
    /**
     * Executes the workflow for interacting with the 'Terms and Conditions' section.
     * Includes clicking on the Shipping Policy and Privacy Policy, and verifying 
     * the displayed text matches the expected data using assertions.
     * 
     * @param test ExtentTest instance for reporting.
     * 
     * @author Pratik
     * 
     */
    public void termsAndCondition(ExtentTest test) { 
        helper.hoverAndClick(test, TermsConditionsLoc.shippingPolicy, TermsConditionsLoc.shippingPolicy); 

        AssertionUtility.useAssertTrue(ExcelFileReader.readData(Base.prop.getProperty("sheet1"), 3, 0, test),helper.getText(TermsConditionsLoc.processWork, test),test); 

        helper.clickOnElement(TermsConditionsLoc.privacyPolicy, test);
        
        AssertionUtility.useAssertTrue(ExcelFileReader.readData(Base.prop.getProperty("sheet1"),4, 0, test),helper.getText(TermsConditionsLoc.processWork, test),test); 
        helper.waitForElementToBeVisible(TermsConditionsLoc.privacyPolicy, 10, test);
    }
}
