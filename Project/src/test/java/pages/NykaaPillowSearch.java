package pages;

import com.aventstack.extentreports.ExtentTest;

import uistore.NykaaPillowSearchLoc;
import utils.Base;
import utils.WebDriverHelper;

public class NykaaPillowSearch {

    WebDriverHelper help = new WebDriverHelper(Base.driver);

    public void PillowSearch(ExtentTest test) {
        help.waitForElementToBeVisible(NykaaPillowSearchLoc.verifypillow, 4, test);

        boolean newtext = Base.driver.findElement(NykaaPillowSearchLoc.verifypillow).isDisplayed();
        System.out.println(newtext);
    }

    public void filterPillowSearch(ExtentTest test)
    {

        help.clickOnElement(NykaaPillowSearchLoc.price, test);

        help.waitForElementToBeVisible(NykaaPillowSearchLoc.priceDropdown, 4, test);

        help.clickOnElement(NykaaPillowSearchLoc.priceDropdown, test);

        help.waitForElementToBeVisible(NykaaPillowSearchLoc.Discount, 4, test);
        help.clickOnElement(NykaaPillowSearchLoc.Discount, test);

        help.waitForElementToBeVisible(NykaaPillowSearchLoc.DiscountThirdOption, 4, test);
        help.clickOnElement(NykaaPillowSearchLoc.DiscountThirdOption, test);

        help.waitForElementToBeVisible(NykaaPillowSearchLoc.AvgCustomerRating, 4, test);
        help.clickOnElement(NykaaPillowSearchLoc.AvgCustomerRating, test);

        help.waitForElementToBeVisible(NykaaPillowSearchLoc.AvgCustomerRatingFirstOption, 4, test);
        help.clickOnElement(NykaaPillowSearchLoc.AvgCustomerRatingFirstOption, test);

    }

    public void clickfirstProductPillow(ExtentTest test)
    {

        help.waitForElementToBeVisible(NykaaPillowSearchLoc.firstproduct, 4, test);
        help.clickOnElement(NykaaPillowSearchLoc.firstproduct, test);

        help.switchToWindow(1,test);
    }


    public void pillowSearch(ExtentTest test)
    {
        PillowSearch(test);
        filterPillowSearch(test);
        clickfirstProductPillow(test);
    }
}
