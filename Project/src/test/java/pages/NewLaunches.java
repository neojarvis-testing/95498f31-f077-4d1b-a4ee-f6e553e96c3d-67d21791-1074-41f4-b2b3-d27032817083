package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.KajalLoc;
import uistore.NewLaunchesLoc;
import utils.AssertionUtility;
import utils.Base;
import utils.ExcelFileReader;
import utils.WebDriverHelper;

public class NewLaunches {
    WebDriverHelper helper=new WebDriverHelper(Base.driver); 
   public void newLaunches(ExtentTest test) throws InterruptedException{ 
        
        helper.hoverOverElement(NewLaunchesLoc.fragrance,test); 

        helper.clickOnElement(NewLaunchesLoc.newlaunches, test);
        
        Thread.sleep(2000);
        helper.switchToWindow(1, test);
        helper.waitForElementToBeVisible(NewLaunchesLoc.newLaunchesVerify, 5, test);
        AssertionUtility.useAssertEquals(helper.getText(NewLaunchesLoc.newLaunchesVerify,test),ExcelFileReader.readData(Base.prop.getProperty("sheet4"), 2, 0, test) , test);

    } 

}
