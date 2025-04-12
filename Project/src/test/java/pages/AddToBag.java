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

/**
 * Represents functionality related to adding a product to the shopping bag.
 * Provides methods to interact with elements like selecting a product, 
 * adding it to the bag, and verifying product details.
 * 
 * @author Pratik
 */
public class AddToBag {
    
    WebDriverHelper helper=new WebDriverHelper(Base.driver); 

    /**
     * Selects the first product from the product list on the page.
     * 
     * @param test ExtentTest instance for reporting.
     * @author Pratik
     */
    public void firstProduct(ExtentTest test) { 
        
        helper.clickOnElement(AddToBagLoc.firstProduct,test); 
        
    } 


    /**
     * Switches to the new window and adds the product to the shopping bag.
     * 
     * @param test ExtentTest instance for reporting.
     * @author Pratik
     */
    public void addTo(ExtentTest test) { 
        helper.switchToWindow(2, test);

        helper.hoverAndClick(test, AddToBagLoc.addToBag, AddToBagLoc.addToBag);
    
        helper.waitForElementToBeVisible(AddToBagLoc.addToBag, 5, test); 
    } 
    
    /**
     * Interacts with the 'How to Use' section and verifies its contents using assertions.
     * Captures and attaches a screenshot to the test report.
     * 
     * @param test ExtentTest instance for reporting.
     * @author Pratik
     */
    public void howToUse(ExtentTest test) {
        
        helper.hoverAndClick(test,AddToBagLoc.howToUse, AddToBagLoc.howToUse);
        
        helper.waitForElementToBeVisible(AddToBagLoc.howToUse, 5, test);

        AssertionUtility.useAssertEquals(helper.getText(AddToBagLoc.howToUse, test),ExcelFileReader.readData(Base.prop.getProperty("sheet4").toLowerCase(), 3, 0, test) , test);

        Screenshot.captureScreenshot(Base.driver, test, "nykaa");
        Reporter.attachScreenshotToReport("nykaa", test, "nykaa", Base.driver);

    }

    /**
     * Combines the selection of the product, adding to the shopping bag, 
     * and interacting with the 'How to Use' section into a single workflow.
     * 
     * @param test ExtentTest instance for reporting.
     * @author Pratik
     */

    public void addToBag(ExtentTest test) {
        firstProduct(test); 
        addTo(test);
        //howToUse(test);
        
    }


}
