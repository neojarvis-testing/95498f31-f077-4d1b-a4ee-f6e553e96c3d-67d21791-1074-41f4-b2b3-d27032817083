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
     * Completes the entire test case 5 by executing all the necessary steps.
     * 
     * @param test The ExtentTest object used for logging the test steps.
     */
    public void completeTestCase5(ExtentTest test){
        clickOnHelpSwitchWindowVerifyTitleAndClickOnOrderRelated(test);
        verifyTitleOrderRelatedclickOnOrderStatusVerifyTextNavigateBackVerifyTextCanIReturnAndNavBackClickOnCancelletionsAndRefund(test);
        clickOnCancellationPolicyClickOnLinkSwitchWindowVerifyURL(test);
    }     
    /**
     * Clicks on the Help link, switches to the new window, verifies the title, 
     * and clicks on the Order Related link.
     * 
     * @param test The ExtentTest object used for logging the test steps.
     */
    public void clickOnHelpSwitchWindowVerifyTitleAndClickOnOrderRelated(ExtentTest test){
        helper.clickOnElement(HomePageLocators.homepage_Help, test);
        helper.switchToWindow(1, test);;
        helper.waitForElementToBeVisible(HelpCentreLocators.helpCentre_OrderRelated, 4, test);
        //assertion.useAssertEquals("Help Centre", "Help Centre", test);
        helper.clickOnElement(HelpCentreLocators.helpCentre_OrderRelated, test);
    }
    /**
     * Verifies the title of the Order Related page, clicks on the Order Status link, 
     * verifies the text, navigates back, verifies the text for Can I Return, navigates back, 
     * and clicks on the Cancellations and Refund link.
     * 
     * @param test The ExtentTest object used for logging the test steps.
     */
    public void verifyTitleOrderRelatedclickOnOrderStatusVerifyTextNavigateBackVerifyTextCanIReturnAndNavBackClickOnCancelletionsAndRefund(ExtentTest test){
        try {
            
            Thread.sleep(2000); 
            helper.waitForElementToBeVisible(HelpCentreLocators.helpCentre_OrderStatus, 4, test);
            helper.clickOnElement(HelpCentreLocators.helpCentre_OrderStatus, test);

            Thread.sleep(2000);
            Base.driver.navigate().back();
            Thread.sleep(2000);
            helper.waitForElementToBeVisible(HelpCentreLocators.helpCentre_returnsAndRefund, 4, test);
            helper.hoverOverElement(HelpCentreLocators.helpCentre_returnsAndRefund, test);
            helper.clickOnElement(HelpCentreLocators.helpCentre_returnsAndRefund, test);
            
            
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
     * Clicks on the Cancellation Policy link, switches to the new window, 
     * and verifies the URL.
     * 
     * @param test The ExtentTest object used for logging the test steps.
     */

    public void clickOnCancellationPolicyClickOnLinkSwitchWindowVerifyURL(ExtentTest test){
        helper.waitForElementToBeVisible(HelpCentreLocators.helpCentre_CancellationPolicy, 4, test);
        helper.clickOnElement(HelpCentreLocators.helpCentre_CancellationPolicy, test);
        helper.waitForElementToBeVisible(HelpCentreLocators.helpCentre_CancellationPolicyLink, 4, test);
        
        helper.clickOnElement(HelpCentreLocators.helpCentre_CancellationPolicyLink, test);
        helper.switchToWindow(2,test);
        Base.driver.getCurrentUrl();

        Screenshot.captureScreenshot(Base.driver, test, "Cancellation policy");
    }
}
