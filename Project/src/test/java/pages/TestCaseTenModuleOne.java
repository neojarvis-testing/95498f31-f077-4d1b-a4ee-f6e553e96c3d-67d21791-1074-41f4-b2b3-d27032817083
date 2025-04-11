package pages;

import com.aventstack.extentreports.ExtentTest;
import uistore.LocFooter;
import utils.Base;
import utils.WebDriverHelper;



public class TestCaseTenModuleOne {

    WebDriverHelper wb = new WebDriverHelper(Base.driver);


    public void footerPage(ExtentTest test) throws InterruptedException {
      
            wb.scrollByToFooter(test);
            wb.waitForElementToBeVisible(LocFooter.clickNykaaMan, 2, test);
            wb.scrollByToFooter(test);
            wb.waitForElementToBeVisible(LocFooter.clickNykaaMan, 2, test);
            wb.scrollByToFooter(test);

        }
           


        
}
