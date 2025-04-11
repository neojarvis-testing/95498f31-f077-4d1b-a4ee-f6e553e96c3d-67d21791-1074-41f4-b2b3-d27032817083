package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.NykaaKurtaSearchLoc;

import utils.Base;
import utils.WebDriverHelper;

public class NykaaKurtaSearch {

    WebDriverHelper help = new WebDriverHelper(Base.driver);
    
/**
 * Description:
 * This method validates Kurta search results, sorts them by popularity, and selects a product for further actions.
 *
 * @param test ExtentTest object for logging and reporting.
 * @return void
 * @author Tharikaa
 */
    public void kurtasearch(ExtentTest test)
    {
        help.waitForElementToBeVisible(NykaaKurtaSearchLoc.verifyKurtas,4 ,test);
        boolean newtext = Base.driver.findElement(NykaaKurtaSearchLoc.verifyKurtas).isDisplayed();
        System.out.println(newtext);
        help.waitForElementToBeVisible(NykaaKurtaSearchLoc.SortByPopularity,2 ,test);
        help.hoverOverElement(NykaaKurtaSearchLoc.SortByPopularity,test);
        help.clickOnElement(NykaaKurtaSearchLoc.SortByPopularity, test);
        help.hoverAndClick(test, NykaaKurtaSearchLoc.BestSeller, NykaaKurtaSearchLoc.BestSeller);
        help.waitForElementToBeVisible(NykaaKurtaSearchLoc.SecondProduct,4 ,test);
        help.hoverAndClick(test, NykaaKurtaSearchLoc.SecondProduct, NykaaKurtaSearchLoc.SecondProduct);
        help.switchToWindow(1,test);

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
