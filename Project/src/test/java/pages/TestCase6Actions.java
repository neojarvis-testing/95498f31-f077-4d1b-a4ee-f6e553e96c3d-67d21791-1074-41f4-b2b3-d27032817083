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
     * Executes the steps for test case 6, which includes searching for a product, 
     * verifying product details, navigating through various help center options, 
     * and capturing a screenshot for verification.
     * 
     * @param test The ExtentTest object used for logging the test steps.
     */
    public void testCase06(ExtentTest test){
        try {
            String data= ExcelFileReader.readData( Base.prop.getProperty("sheet1"), 6, 0, test);
            helper.clickOnElement(HomePageLocators.homePage_SearchBar, test);
            helper.sendKeys(HomePageLocators.homePage_SearchBar, data, test, data);
            helper.hoverAndClick(test,HomePageLocators.homePage_LiquidLipstickSuggestion , HomePageLocators.homePage_LiquidLipstickSuggestion);
            //verify Liquid Lipstick
            helper.hoverOverElement(LiquidLipstickLocators.LiquidLipstick_HoverToUnHideFirstProduct, test);
            helper.hoverAndClick(test, LiquidLipstickLocators.LiquidLipstick_PreviewShades1st, LiquidLipstickLocators.LiquidLipstick_PreviewShades1st);
            helper.hoverAndClick(test, LiquidLipstickLocators.LiquidLipstick_ViewDetails, LiquidLipstickLocators.LiquidLipstick_ViewDetails);
            helper.switchToWindow(1, test);
            helper.clickOnElement(LiquidLipstickLocators.LiquidLipstick_DownArrow, test); 
            // Select select=new Select(Base.driver.findElement(By.xpath("//select[@class='css-2t5nwu']"))); 
            // select.selectByVisibleText("Vacation Nude"); 
            helper.clickOnElement(LiquidLipstickLocators.LiquidLipstick_ThirdOption, test);

            
            helper.scrollByToFooter(test);
            helper.waitForElementToBeVisible(LiquidLipstickLocators.LiquidLipstick_ContactUs,4, test);
            helper.hoverOverElement(LiquidLipstickLocators.LiquidLipstick_ContactUs, test);
            helper.clickOnElement(LiquidLipstickLocators.LiquidLipstick_ContactUs, test);
            helper.switchToWindow(2, test);
            
            helper.waitForElementToBeVisible(HelpCentreLocators.HelpCentre_NykaaAccount,4, test);
            helper.clickOnElement(HelpCentreLocators.HelpCentre_NykaaAccount, test);
            
            helper.waitForElementToBeVisible(HelpCentreLocators.HelpCentre_MyWishList,4, test);
            helper.clickOnElement(HelpCentreLocators.HelpCentre_MyWishList, test);
            
            helper.waitForElementToBeVisible(HelpCentreLocators.HelpCentre_HowDoIAddItems,4, test);
            
            helper.clickOnElement(HelpCentreLocators.HelpCentre_HowDoIAddItems, test); 
            Screenshot.captureScreenshot(Base.driver, test, "verified");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

}
