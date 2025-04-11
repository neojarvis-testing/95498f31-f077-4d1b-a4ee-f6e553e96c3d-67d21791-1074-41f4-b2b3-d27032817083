package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.NykaaHomePageLoc;
import utils.Base;
import utils.ExcelFileReader;
import utils.LoggerHandler;
import utils.WebDriverHelper;

public class NykaaHomeSearch {

    WebDriverHelper help = new WebDriverHelper(Base.driver);

/**
 * Description:
 * This method performs the search functionality for pillow products on the homepage.
 * It waits for the search element to be visible, inputs data from an Excel file,
 * and executes the search action.
 *
 * @param test ExtentTest object for logging and reporting.
 * @return void
 * @author Tharikaa Srinithi
 */
    public void homeSearchPillow(ExtentTest test) {
        try {
            help.waitForElementToBeVisible(NykaaHomePageLoc.search, 3, test);
            help.clickOnElement(NykaaHomePageLoc.search, test);
            String data = ExcelFileReader.readData(Base.prop.getProperty("sheet1"), 9, 0, test);
            help.sendKeys(NykaaHomePageLoc.search, data, test, "placeholder");
            help.enterAction(NykaaHomePageLoc.search, test);
        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }


 /**
 * Description:
 * This method handles the search functionality for Kurta products on Nykaa's homepage.
 *
 * @param test ExtentTest object for logging and reporting.
 * @return void
 * @author Tharikaa
 */
    public void homeSearchKurta(ExtentTest test) {

        try {
            help.waitForElementToBeVisible(NykaaHomePageLoc.search, 3, test);
            help.clickOnElement(NykaaHomePageLoc.search, test);
            String data = ExcelFileReader.readData(Base.prop.getProperty("sheet1"), 10, 0, test);
            help.sendKeys(NykaaHomePageLoc.search, data, test, "placeholder");
            help.enterAction(NykaaHomePageLoc.search, test);
        }

        catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    
}
