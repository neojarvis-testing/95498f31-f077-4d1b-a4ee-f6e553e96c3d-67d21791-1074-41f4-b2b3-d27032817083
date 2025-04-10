package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.BeautyToGoLoc;
import uistore.HomePageLoc;
import utils.AssertionUtility;
import utils.Base;
import utils.ExcelFileReader;
import utils.WebDriverHelper;

public class BeautyToGo {
    
    WebDriverHelper helper=new WebDriverHelper(Base.driver); 
    public void beautyToGo(ExtentTest test) throws InterruptedException{ 
        sendBeauty(test); 
        termsCon(test);
    }
    public void sendBeauty(ExtentTest test) throws InterruptedException{ 
        helper.waitForElementToBeVisible(BeautyToGoLoc.beautyToGo, 10, test);
        AssertionUtility.useAssertTrue(helper.getText(BeautyToGoLoc.beautyToGo, test), ExcelFileReader.readData(Base.prop.getProperty("sheet1"), 0, 0, test),test); 

        helper.clickOnElement(BeautyToGoLoc.inputBar, test);

        helper.sendKeys(BeautyToGoLoc.inputBar, ExcelFileReader.readData(Base.prop.getProperty("sheet1"),1, 0, test), test, "placeholder"); 

    }
    public void termsCon(ExtentTest test) throws InterruptedException{ 
        helper.scrollAndClickByPixels(test,BeautyToGoLoc.termsAndCondition); 

        helper.switchToWindow(2,test);

        AssertionUtility.useAssertTrue(ExcelFileReader.readData(Base.prop.getProperty("sheet1"), 2, 0, test), helper.getText(BeautyToGoLoc.verifyTermsAndConditions,test), test);
    }

}
