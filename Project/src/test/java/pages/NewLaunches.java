package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.NewLaunchesLoc;
import utils.AssertionUtility;
import utils.Base;
import utils.ExcelFileReader;
import utils.WebDriverHelper;

/**
 * Represents functionality related to the 'New Launches' section.
 * Provides methods to interact with elements such as hovering over fragrance,
 * clicking on new launches, and verifying the displayed information.
 * 
 * @author Pratik
 * 
 */
public class NewLaunches {
    WebDriverHelper helper=new WebDriverHelper(Base.driver); 
   public void newLaunches(ExtentTest test) { 
        
        helper.hoverOverElement(NewLaunchesLoc.fragrance,test); 

        helper.clickOnElement(NewLaunchesLoc.newlaunches, test);
        
        try{ 
            Thread.sleep(2000);
        }
        catch(Exception e){ 
            e.printStackTrace();
        }
        
        helper.switchToWindow(1, test);
        helper.waitForElementToBeVisible(NewLaunchesLoc.newLaunchesVerify, 5, test);
        AssertionUtility.useAssertEquals(helper.getText(NewLaunchesLoc.newLaunchesVerify,test),ExcelFileReader.readData(Base.prop.getProperty("sheet4"), 2, 0, test) , test);

    } 

}
