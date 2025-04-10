package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.AddToBagLoc;
import uistore.KajalLoc;
import utils.AssertionUtility;
import utils.Base;
import utils.ExcelFileReader;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class AddToBag {
    
    WebDriverHelper helper=new WebDriverHelper(Base.driver); 

    public void firstProduct(ExtentTest test) throws InterruptedException{ 
        
        helper.clickOnElement(AddToBagLoc.firstProduct,test); 
        
    } 


    public void addTo(ExtentTest test) throws InterruptedException{ 
        helper.switchToWindow(2, test);

        helper.hoverAndClick(test, AddToBagLoc.addToBag, AddToBagLoc.addToBag);
    
        helper.waitForElementToBeVisible(AddToBagLoc.addToBag, 5, test); 
    } 
    
    public void howToUse(ExtentTest test) throws InterruptedException{
        
        helper.hoverAndClick(test,AddToBagLoc.howToUse, AddToBagLoc.howToUse);
        
        helper.waitForElementToBeVisible(AddToBagLoc.howToUse, 5, test);

        AssertionUtility.useAssertEquals(helper.getText(AddToBagLoc.howToUse, test),ExcelFileReader.readData(Base.prop.getProperty("sheet4").toLowerCase(), 3, 0, test) , test);

        Screenshot.captureScreenshot(Base.driver, test, "nykaa");
        Reporter.attachScreenshotToReport("nykaa", test, "nykaa", Base.driver);

    }


    public void addToBag(ExtentTest test) throws InterruptedException{
        firstProduct(test); 
        addTo(test);
        howToUse(test);
        
    }


}
