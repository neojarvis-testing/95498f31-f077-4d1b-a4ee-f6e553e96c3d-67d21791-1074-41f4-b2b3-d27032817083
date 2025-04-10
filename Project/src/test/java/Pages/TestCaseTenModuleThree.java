package Pages;

import com.aventstack.extentreports.ExtentTest;
import uistore.LocFirstProduct;
import utils.AssertionUtility;
import utils.Base;
import utils.Reporter;
import utils.ExcelFileReader;
import utils.Screenshot;
import utils.WebDriverHelper;

public class TestCaseTenModuleThree {

    WebDriverHelper wb = new WebDriverHelper(Base.driver);

    public void firstProduct(ExtentTest test) throws InterruptedException{
        wb.clickOnElement(LocFirstProduct.clickPincode, test);
        wb.sendKeys(LocFirstProduct.clickPincode, "600001", test, "placeholder");
        wb.clickOnElement(LocFirstProduct.clickCheck, test);

       
    } 

    public void verifyPage(ExtentTest test) throws InterruptedException{
        AssertionUtility.useAssertEquals(wb.getText(LocFirstProduct.verifyChennai, test), ExcelFileReader.readData("Sheet1", 6, 0, test), test);

        wb.scrollTillElement(LocFirstProduct.clickReview, test, "class");
        wb.scrollByToFooter(test);
        wb.hoverAndClick(test, LocFirstProduct.clickReview, LocFirstProduct.clickReview);
       

        AssertionUtility.useAssertEquals(wb.getText(LocFirstProduct.verifySignin, test), ExcelFileReader.readData("Sheet1", 7, 0, test), test);


        //wb.waitForElementToBeVisible(LocFirstProduct.sigIn, 5, test);
        Screenshot.captureScreenshot(Base.driver, test, "nykaa");
        Reporter.attachScreenshotToReport("nykaa", test, "ss captured", Base.driver);
    }

    public void firstProductPage(ExtentTest test) throws InterruptedException{
        firstProduct(test);
        verifyPage(test);
    }

    
}
