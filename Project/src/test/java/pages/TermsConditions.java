package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.HomePageLoc;
import uistore.TermsConditionsLoc;
import utils.AssertionUtility;
import utils.Base;
import utils.ExcelFileReader;
import utils.WebDriverHelper;

public class TermsConditions {
    
    WebDriverHelper helper=new WebDriverHelper(Base.driver); 
    public void termsAndCondition(ExtentTest test) throws InterruptedException{ 
        helper.hoverAndClick(test, TermsConditionsLoc.shippingPolicy, TermsConditionsLoc.shippingPolicy); 

        AssertionUtility.useAssertTrue(ExcelFileReader.readData(Base.prop.getProperty("sheet1"), 3, 0, test),helper.getText(TermsConditionsLoc.processWork, test),test); 

        helper.clickOnElement(TermsConditionsLoc.privacyPolicy, test);
        
        AssertionUtility.useAssertTrue(ExcelFileReader.readData(Base.prop.getProperty("sheet1"),4, 0, test),helper.getText(TermsConditionsLoc.processWork, test),test); 
        helper.waitForElementToBeVisible(TermsConditionsLoc.privacyPolicy, 10, test);
    }
}
