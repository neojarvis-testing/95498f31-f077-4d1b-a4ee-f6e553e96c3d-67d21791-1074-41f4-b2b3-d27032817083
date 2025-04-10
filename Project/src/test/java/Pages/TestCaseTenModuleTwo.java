package Pages;

import com.aventstack.extentreports.ExtentTest;
import uistore.LocFirstProduct;
import uistore.LocFooter;
import uistore.LocNykaaMan;
import utils.AssertionUtility;
import utils.Base;
import utils.ExcelFileReader;
import utils.WebDriverHelper;

public class TestCaseTenModuleTwo {
    
    WebDriverHelper wb = new WebDriverHelper(Base.driver);
    public void nykaaMan(ExtentTest test) throws InterruptedException{
           
            wb.clickOnElement(LocFooter.clickNykaaMan, test);
            Base.driver.navigate().to(Base.prop.getProperty("url"));
            //wb.waitForElementToBeVisible(LocNykaaMan.clickHealth, 4, test);
            wb.hoverOverElement(LocNykaaMan.clickHealth, test);
            wb.clickOnElement(LocNykaaMan.clickWheyProtein, test);
            wb.switchToWindow(2, test);
            AssertionUtility.useAssertEquals(wb.getText(LocNykaaMan.verifyThree, test), ExcelFileReader.readData( "Sheet1", 0, 0, test), test);

        }

    public void nykaaScroll(ExtentTest test) throws InterruptedException {
       
        wb.scrollByToFooter(test);
        wb.clickOnElement(LocNykaaMan.clickPageTwo,test);
        wb.waitForElementToBeVisible(LocNykaaMan.clickPageTwo,5,test);
    }

    public void nykaaSwitch(ExtentTest test) throws InterruptedException{
        
        wb.hoverOverElement(LocNykaaMan.clickFirstProd, test);
        wb.waitForElementToBeVisible(LocFirstProduct.clickPincode, 3, test);
        wb.clickOnElement(LocNykaaMan.clickFirstProd, test);
        wb.switchToWindow(3, test);
    }


public void nykaaManPage(ExtentTest test) throws InterruptedException{
    nykaaMan(test);
    nykaaScroll(test);
    nykaaSwitch(test);
}

}

