package pages;

import runner.TestRunnerKumaran;
import uistore.NykaaLuxeLoc;
import utils.AssertionUtility;
import utils.Base;
import utils.ExcelFileReader;
import utils.WebDriverHelper;

/**
 * Creator: Kumaran
 * 
 * Description: class contains methods to interact with the Nykaa Luxe page.
 * 
 */
public class NykaaLuxe {

    WebDriverHelper helper = new WebDriverHelper(Base.driver);

    /**
     *
     *Description: This method verifies the title of the Luxe page.
     *     
     */
    public void luxeVerify() {
        String actual = Base.driver.findElement(NykaaLuxeLoc.titleLuxe).getText();
        String expected = ExcelFileReader.readData("Sheet1", 21, 0, TestRunnerKumaran.test);
        AssertionUtility.useAssertTrue(actual, expected, TestRunnerKumaran.test);

    }

    /**
     * Description: This method sorts and filters products on the Luxe page.
     *     
     */
    public void luxeSortAndFilter() {
        helper.hoverAndClick(TestRunnerKumaran.test, NykaaLuxeLoc.sorter, NykaaLuxeLoc.sorter);
        helper.hoverAndClick(TestRunnerKumaran.test, NykaaLuxeLoc.sortbyCustomerTopRated,
                NykaaLuxeLoc.sortbyCustomerTopRated);
        helper.hoverAndClick(TestRunnerKumaran.test, NykaaLuxeLoc.genderFilter, NykaaLuxeLoc.genderFilter);
        helper.hoverAndClick(TestRunnerKumaran.test, NykaaLuxeLoc.unisex, NykaaLuxeLoc.unisex);
        String actualFilter = Base.driver.findElement(NykaaLuxeLoc.filterApplied).getText();
        String expectedFilter = ExcelFileReader.readData("Sheet1", 22, 0, TestRunnerKumaran.test);
        AssertionUtility.useAssertEquals(actualFilter, expectedFilter, TestRunnerKumaran.test);
        helper.hoverAndClick(TestRunnerKumaran.test, NykaaLuxeLoc.ocassionFilter, NykaaLuxeLoc.ocassionFilter);
        helper.hoverAndClick(TestRunnerKumaran.test, NykaaLuxeLoc.dayWear, NykaaLuxeLoc.dayWear);
    }

    /**
     * Description: This method clicks on the first product in the list and switches to the new window.
     *     
     */
    public void firstProductClick() {
        helper.hoverAndClick(TestRunnerKumaran.test, NykaaLuxeLoc.firstProduct, NykaaLuxeLoc.firstProduct);
        helper.switchToWindow(2, TestRunnerKumaran.test);
    }

    /**
     * Description: This method performs a series of actions on the Luxe page: verifying the title,sorting and filtering products, and clicking on the first product.
     *     
     */
    public void luxe() {
        luxeVerify();
        luxeSortAndFilter();
        firstProductClick();
    }

}