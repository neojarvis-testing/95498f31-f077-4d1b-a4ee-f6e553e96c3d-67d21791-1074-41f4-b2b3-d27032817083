package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.HelpCentreLocators;
import uistore.HomePageLocators;
import utils.AssertionUtility;
import utils.Base;
import utils.Screenshot;
import utils.WebDriverHelper;

public class TestCase5Actions {
    WebDriverHelper helper = new WebDriverHelper(Base.driver);
    AssertionUtility assertion = new AssertionUtility(); 
    
     /**
     * Executes the steps for test case 5.
     * 
     * @param test The ExtentTest object used for logging the test steps.
     *
     * @author Abhiram
     */

    public void completeTestCase5(ExtentTest test){
        clickOnHelp_ClickOnOrderRelated(test);
        NavigateAnd_ClickOnCancelletionsAndRefund(test);
        clickOnCancellationPolicy_ClickOnLinkSwitchWindow(test);
    }     
    
     /**
     * Clicks on the Help button and then clicks on the Order Related option.
     * 
     * @param test The ExtentTest object used for logging the test steps.
     */

    public void clickOnHelp_ClickOnOrderRelated(ExtentTest test){
        helper.clickOnElement(HomePageLocators.homepage_Help, test);
        helper.switchToWindow(1, test);;
        helper.waitForElementToBeVisible(HelpCentreLocators.helpCentre_OrderRelated, 4, test);
        helper.clickOnElement(HelpCentreLocators.helpCentre_OrderRelated, test);
    }
    
     /**
     * Navigates through the help center and clicks on the Cancellations and Refund option.
     * 
     * @param test The ExtentTest object used for logging the test steps.
     */

    public void NavigateAnd_ClickOnCancelletionsAndRefund(ExtentTest test){
        try {
            
            Thread.sleep(2000);
            helper.waitForElementToBeVisible(HelpCentreLocators.helpCentre_OrderStatus, 7, test);
            helper.clickOnElement(HelpCentreLocators.helpCentre_OrderStatus, test);

            Thread.sleep(2000);
            Base.driver.navigate().back();
            Thread.sleep(2000);

            helper.waitForElementToBeVisible(HelpCentreLocators.helpCentre_returnsAndRefund, 4, test);
            helper.hoverOverElement(HelpCentreLocators.helpCentre_returnsAndRefund, test);
            helper.clickOnElement(HelpCentreLocators.helpCentre_returnsAndRefund, test);
            
            Thread.sleep(2000);
            Base.driver.navigate().back();
            Thread.sleep(2000);

            helper.waitForElementToBeVisible(HelpCentreLocators.helpCentre_CancellationsAndRefund, 10, test);
            helper.hoverOverElement(HelpCentreLocators.helpCentre_CancellationsAndRefund, test);
            helper.clickOnElement(HelpCentreLocators.helpCentre_CancellationsAndRefund, test);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    
     /**
     * Clicks on the Cancellation Policy link and switches to the new window.
     * 
     * @param test The ExtentTest object used for logging the test steps.
     */

    public void clickOnCancellationPolicy_ClickOnLinkSwitchWindow(ExtentTest test){
        helper.waitForElementToBeVisible(HelpCentreLocators.helpCentre_CancellationPolicy, 4, test);
        helper.clickOnElement(HelpCentreLocators.helpCentre_CancellationPolicy, test);
        helper.waitForElementToBeVisible(HelpCentreLocators.helpCentre_CancellationPolicyLink, 4, test);
        
        helper.clickOnElement(HelpCentreLocators.helpCentre_CancellationPolicyLink, test);
        helper.switchToWindow(2,test);
        Base.driver.getCurrentUrl();
        
        Screenshot.captureScreenshot(Base.driver, test, "Cancellation policy");
    }
}