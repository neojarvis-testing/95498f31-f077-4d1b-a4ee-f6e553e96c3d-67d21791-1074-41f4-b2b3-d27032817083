

package pages;

import com.aventstack.extentreports.ExtentTest;
import uistore.HelpCentreLocators;
import uistore.HomePageLocators;
import uistore.LiquidLipstickLocators;
import utils.AssertionUtility;
import utils.Base;
import utils.ExcelFileReader;
import utils.Screenshot;
import utils.WebDriverHelper;

public class TestCase6Actions {
    WebDriverHelper helper = new WebDriverHelper(Base.driver);
    AssertionUtility assertion = new AssertionUtility(); 
    
     /**
     * Executes the steps for test case 6.
     * 
     * @param test The ExtentTest object used for logging the test steps.
     */

    public void CompleteTestCase06(ExtentTest test){
        searchForLipstick_And_NavigateToLiquidLipsticks(test);
        HoverOnFirstProduct_AndClickOnPreviewShades(test);
        clickViewDetails_ClickOnDownArrow_SelectThirdOption(test);
        scrollDownToFooter_ClickOnContactUs(test);
        clickOnNykaaAccount_ClickOnMyWhishlist(test);
        clickOnHowDoIAddItems_CaptureTheScreenshot(test);
    }
    
     /**
     * Searches for a lipstick product and navigates to the liquid lipsticks section.
     * 
     * @param test The ExtentTest object used for logging the test steps.
     *
     * @author Abhiram   
     */

    public void searchForLipstick_And_NavigateToLiquidLipsticks(ExtentTest test){
        try {
            Thread.sleep(2000);
            String data= ExcelFileReader.readData( Base.prop.getProperty("sheet1"), 6, 0, test);
            helper.clickOnElement(HomePageLocators.homePage_SearchBar, test);
            helper.sendKeys(HomePageLocators.homePage_SearchBar, data, test, data);
            helper.hoverAndClick(test,HomePageLocators.homePage_LiquidLipstickSuggestion , HomePageLocators.homePage_LiquidLipstickSuggestion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
     /**
     * Hovers over the first product and clicks on the preview shades option.
     * 
     * @param test The ExtentTest object used for logging the test steps.
     */

    public void HoverOnFirstProduct_AndClickOnPreviewShades(ExtentTest test){
        helper.hoverOverElement(LiquidLipstickLocators.LiquidLipstick_HoverToUnHideFirstProduct, test);
        helper.waitForElementToBeVisible(LiquidLipstickLocators.LiquidLipstick_PreviewShades1st, 5, test);
        helper.hoverAndClick(test, LiquidLipstickLocators.LiquidLipstick_PreviewShades1st, LiquidLipstickLocators.LiquidLipstick_PreviewShades1st);
    }
    
     /**
     * Clicks on the view details button, clicks on the down arrow, and selects the third option.
     * 
     * @param test The ExtentTest object used for logging the test steps.
     */

    public void clickViewDetails_ClickOnDownArrow_SelectThirdOption(ExtentTest test){
        helper.waitForElementToBeVisible(LiquidLipstickLocators.LiquidLipstick_ViewDetails, 5, test);
        try{ 
            Thread.sleep(2000); 
        }
        catch(Exception e){ 
            e.printStackTrace();

        }
        helper.hoverAndClick(test, LiquidLipstickLocators.LiquidLipstick_ViewDetails, LiquidLipstickLocators.LiquidLipstick_ViewDetails);
        helper.switchToWindow(1, test);
        helper.waitForElementToBeVisible(LiquidLipstickLocators.LiquidLipstick_DownArrow, 5, test);
        helper.clickOnElement(LiquidLipstickLocators.LiquidLipstick_DownArrow, test); 
        helper.waitForElementToBeVisible(LiquidLipstickLocators.LiquidLipstick_ThirdOption, 5, test);
        helper.clickOnElement(LiquidLipstickLocators.LiquidLipstick_ThirdOption, test);
    }
    
     /**
     * Scrolls down to the footer and clicks on the Contact Us option.
     * 
     * @param test The ExtentTest object used for logging the test steps.
     */

    public void scrollDownToFooter_ClickOnContactUs(ExtentTest test){
        helper.scrollByToFooter(test);
        helper.waitForElementToBeVisible(LiquidLipstickLocators.LiquidLipstick_ContactUs,4, test);
        helper.hoverOverElement(LiquidLipstickLocators.LiquidLipstick_ContactUs, test);
        helper.clickOnElement(LiquidLipstickLocators.LiquidLipstick_ContactUs, test);
        helper.switchToWindow(2, test);
    }
    
     /**
     * Clicks on the Nykaa Account option and then clicks on the My Wishlist option.
     * 
     * @param test The ExtentTest object used for logging the test steps.
     */

    public void clickOnNykaaAccount_ClickOnMyWhishlist(ExtentTest test){
        helper.waitForElementToBeVisible(HelpCentreLocators.HelpCentre_NykaaAccount,4, test);
        helper.clickOnElement(HelpCentreLocators.HelpCentre_NykaaAccount, test);
        
        helper.waitForElementToBeVisible(HelpCentreLocators.HelpCentre_MyWishList,4, test);
        helper.clickOnElement(HelpCentreLocators.HelpCentre_MyWishList, test);
    }
    
     /**
     * Clicks on the How Do I Add Items option and captures a screenshot for verification.
     * 
     * @param test The ExtentTest object used for logging the test steps.
     */

    public void clickOnHowDoIAddItems_CaptureTheScreenshot(ExtentTest test){
        helper.waitForElementToBeVisible(HelpCentreLocators.HelpCentre_HowDoIAddItems,4, test);
        helper.clickOnElement(HelpCentreLocators.HelpCentre_HowDoIAddItems, test); 
        Screenshot.captureScreenshot(Base.driver, test, "verified");
    }

}
