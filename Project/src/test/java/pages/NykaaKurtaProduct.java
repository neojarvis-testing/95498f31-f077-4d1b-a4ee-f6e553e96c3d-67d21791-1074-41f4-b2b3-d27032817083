package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.NykaaKurtaProductLoc;
import utils.Base;
import utils.WebDriverHelper;

public class NykaaKurtaProduct {

    WebDriverHelper help = new WebDriverHelper(Base.driver);

/**
 * Description:
 * This method validates and interacts with Kurta product elements, including size guide, reviews, and helpful votes.
 *
 * @param test ExtentTest object for logging and reporting.
 * @return void
 * @author Tharikaa
 */
    public void kurtaProduct(ExtentTest test)
    {
      help.waitForElementToBeVisible(NykaaKurtaProductLoc.SizeGuide,3 ,test);
      help.clickOnElement(NykaaKurtaProductLoc.SizeGuide, test);
      boolean newtext2 = Base.driver.findElement(NykaaKurtaProductLoc.SizeGuide).isDisplayed();
      System.out.println(newtext2);
      help.waitForElementToBeVisible(NykaaKurtaProductLoc.XButton,4 ,test);
      help.clickOnElement(NykaaKurtaProductLoc.XButton, test);
      help.hoverAndClick(test, NykaaKurtaProductLoc.ReadAllViews, NykaaKurtaProductLoc.ReadAllViews);
      boolean newtext3 = Base.driver.findElement(NykaaKurtaProductLoc.ReadAllViews).isDisplayed();
      System.out.println(newtext3);
      help.hoverAndClick(test,NykaaKurtaProductLoc.helpful,NykaaKurtaProductLoc.helpful);
      try{
        Thread.sleep(4000);
      }
      catch(Exception e){
        e.printStackTrace();
      }
  
    }
}
