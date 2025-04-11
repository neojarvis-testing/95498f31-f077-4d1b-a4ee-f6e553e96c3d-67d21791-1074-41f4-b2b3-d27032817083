package pages;

import org.openqa.selenium.Keys;

import com.aventstack.extentreports.ExtentTest;

import uistore.AddToBagLoc;
import uistore.KajalLoc;
import uistore.NewLaunchesLoc;
import utils.AssertionUtility;
import utils.Base;
import utils.ExcelFileReader;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

/**
 * Represents functionality related to the Kajal product section.
 * Provides methods to search for Kajal products, perform validations, 
 * and interact with formulations.
 * 
 * @author Pratik
 * 
 */
public class KajalAct {
    WebDriverHelper helper=new WebDriverHelper(Base.driver); 


    /**
     * Executes the workflow for selecting Kajal products by calling
     * relevant methods for searching and interacting with formulations.
     * 
     * @param test ExtentTest instance for reporting.
     * @author Pratik
     */
    public void getKajal(ExtentTest test) {  
        sendKajal(test); 
        formuPencil(test);

    }

    /**
     * Searches for Kajal products by interacting with the search bar,
     * verifying categories, and using assertions to ensure the displayed 
     * text matches expected data.
     * 
     * @param test ExtentTest instance for reporting.
     * @author Pratik
     */
    public void sendKajal(ExtentTest test) { 

        AssertionUtility.useAssertEquals(helper.getText(KajalLoc.categories, test),ExcelFileReader.readData(Base.prop.getProperty("sheet4").toLowerCase(), 0, 0, test) , test);

        helper.clickOnElement(KajalLoc.searchBar,test,"placeholder");  

        try { 
            Thread.sleep(2000);
        }
        catch(Exception e){ 
            e.printStackTrace(); 
        }
        
        helper.sendKeys(KajalLoc.searchBar, ExcelFileReader.readData(Base.prop.getProperty("sheet4"), 1, 0, test), test, "placeholder");  

        AssertionUtility.useAssertEquals(helper.getText(KajalLoc.searchBar, test),ExcelFileReader.readData(Base.prop.getProperty("sheet4").toLowerCase(), 1, 0, test) , test);

        Base.driver.findElement(KajalLoc.searchBar).sendKeys(Keys.ENTER);  

        AssertionUtility.useAssertTrue(helper.getText(KajalLoc.kajalVerify,test),ExcelFileReader.readData(Base.prop.getProperty("sheet4"), 1, 0, test),test); 
    } 

    /**
     * Interacts with the Kajal formulations section by hovering and clicking 
     * on formulation and pencil options. Scrolls the page back afterward.
     * 
     * @param test ExtentTest instance for reporting.
     * @author Pratik
     */
    public void formuPencil(ExtentTest test) { 
        helper.hoverAndClick(test, KajalLoc.formulation, KajalLoc.formulation);

        helper.hoverAndClick(test, KajalLoc.pencil, KajalLoc.pencil); 
        helper.scrollBack(test);
    }

    

    
}
