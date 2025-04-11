package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.NykaaKurtaLoginLoc;
import utils.Base;
import utils.LoggerHandler;
import utils.Screenshot;
import utils.WebDriverHelper;

public class NykaaKurtaLogin {

  WebDriverHelper help = new WebDriverHelper(Base.driver);

  /**
 * Description:
 * This method handles the login functionality for Kurta purchases on Nykaa.
 *
 * @param test ExtentTest object for logging and reporting.
 * @return void
 * @author Tharikaa
 */
  public void kurtaLogin(ExtentTest test) {
    help.waitForElementToBeVisible(NykaaKurtaLoginLoc.mobile, 3, test);
    try{
        Thread.sleep(4000);
      }
      catch(Exception e){
        e.printStackTrace();
      }
    help.clickOnElement(NykaaKurtaLoginLoc.mobile, test);
    try{
      Thread.sleep(2000);
    }
    catch(Exception e){
      e.printStackTrace();
    }
    
    help.sendKeys(NykaaKurtaLoginLoc.mobile, "9876543210", test, "name");
    try{
        Thread.sleep(4000);
      }
      catch(Exception e){
        e.printStackTrace();
      }
    help.waitForElementToBeVisible(NykaaKurtaLoginLoc.submit, 3, test);

    help.clickOnElement(NykaaKurtaLoginLoc.submit, test);
    Screenshot.captureScreenshot(Base.driver, test, "Login.png");
    LoggerHandler.info("Login Page");
  }

}
