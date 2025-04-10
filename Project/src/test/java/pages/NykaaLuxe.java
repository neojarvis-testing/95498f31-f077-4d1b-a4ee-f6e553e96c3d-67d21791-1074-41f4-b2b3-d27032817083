package pages;

import runner.TestRunner;
import uistore.NykaaLuxeLoc;
import utils.AssertionUtility;
import utils.Base;
import utils.WebDriverHelper;

public class NykaaLuxe {
    
    WebDriverHelper helper = new WebDriverHelper(Base.driver);

    public void luxeVerify()
    {
        String actual = Base.driver.findElement(NykaaLuxeLoc.titleLuxe).getText();
        String expected = "Luxe";
        AssertionUtility.useAssertTrue(actual, expected, TestRunner.test);
    
    }

    public void luxeSortAndFilter()
    {
        helper.hoverAndClick(TestRunner.test, NykaaLuxeLoc.sorter,NykaaLuxeLoc.sorter);
        helper.hoverAndClick(TestRunner.test, NykaaLuxeLoc.sortbyCustomerTopRated,NykaaLuxeLoc.sortbyCustomerTopRated);
        helper.hoverAndClick(TestRunner.test, NykaaLuxeLoc.genderFilter,NykaaLuxeLoc.genderFilter);
        helper.hoverAndClick(TestRunner.test, NykaaLuxeLoc.unisex,NykaaLuxeLoc.unisex);
        String actualFilter = Base.driver.findElement(NykaaLuxeLoc.filterApplied).getText();
        String expectedFilter = "Unisex";
        AssertionUtility.useAssertEquals(actualFilter, expectedFilter, TestRunner.test); 
        helper.hoverAndClick(TestRunner.test, NykaaLuxeLoc.ocassionFilter,NykaaLuxeLoc.ocassionFilter);
        helper.hoverAndClick(TestRunner.test, NykaaLuxeLoc.dayWear,NykaaLuxeLoc.dayWear);
    }

    public void firstProductClick()
    {
        helper.hoverAndClick(TestRunner.test, NykaaLuxeLoc.firstProduct,NykaaLuxeLoc.firstProduct);
        helper.switchToWindow(2,TestRunner.test);
    }

    public void luxe(){ 
        luxeVerify();
        luxeSortAndFilter(); 
        firstProductClick();
    }
    
}