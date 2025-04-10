package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.NykaaPillowProductLoc;
import utils.Base;
import utils.Screenshot;
import utils.WebDriverHelper;

public class NykaaPillowProduct {

    WebDriverHelper help = new WebDriverHelper(Base.driver);

    /**
 * Description:
 * This method handles adding a product to the shopping bag after ensuring the button is visible.
 *
 * @param test ExtentTest object for logging and reporting.
 * @return void
 * @author Tharikaa
 */
    public void addToBag(ExtentTest test) {

        help.waitForElementToBeVisible(NykaaPillowProductLoc.AddToBag, 4, test);
        help.clickOnElement(NykaaPillowProductLoc.AddToBag, test);

    }

    /**
 * Description:
 * This method handles clicking the cart icon after ensuring it is visible.
 *
 * @param test ExtentTest object for logging and reporting.
 * @return void
 * @author Tharikaa
 */
    public void cartIcon(ExtentTest test)
    {
        help.waitForElementToBeVisible(NykaaPillowProductLoc.CartIcon, 4, test);
        help.clickOnElement(NykaaPillowProductLoc.CartIcon, test);
    }


    /**
 * Description:
 * This method verifies the visibility of the cart icon and captures a screenshot for validation.
 *
 * @param test ExtentTest object for logging and reporting.
 * @return void
 * @author Tharikaa
 */
    public void cartVerify(ExtentTest test)
    {
        boolean newtext2 = Base.driver.findElement(NykaaPillowProductLoc.CartIcon).isDisplayed();
        System.out.println(newtext2);
        Screenshot.captureScreenshot(Base.driver, test, "Bag.png");

    }

/**
 * Description:
 * This method manages the full product flow for pillow purchases, including adding to the bag, accessing the cart, and verifying it.
 *
 * @param test ExtentTest object for logging and reporting.
 * @return void
 * @author Tharikaa
 */
    public void pillowProduct(ExtentTest test)
    {
        addToBag(test);
        cartIcon(test);
        cartVerify(test);
        
    }
}
