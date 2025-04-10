package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.NykaaPillowProductLoc;
import utils.Base;
import utils.Screenshot;
import utils.WebDriverHelper;

public class NykaaPillowProduct {

    WebDriverHelper help = new WebDriverHelper(Base.driver);

    public void addToBag(ExtentTest test) {

        help.waitForElementToBeVisible(NykaaPillowProductLoc.AddToBag, 4, test);
        help.clickOnElement(NykaaPillowProductLoc.AddToBag, test);

    }
    public void cartIcon(ExtentTest test)
    {
        help.waitForElementToBeVisible(NykaaPillowProductLoc.CartIcon, 4, test);
        help.clickOnElement(NykaaPillowProductLoc.CartIcon, test);
    }
    public void cartVerify(ExtentTest test)
    {
        boolean newtext2 = Base.driver.findElement(NykaaPillowProductLoc.CartIcon).isDisplayed();
        System.out.println(newtext2);
        Screenshot.captureScreenshot(Base.driver, test, "Bag.png");

    }
    public void pillowProduct(ExtentTest test)
    {
        addToBag(test);
        cartIcon(test);
        cartVerify(test);
        
    }
}
