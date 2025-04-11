package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.AddToBagAction;
import pages.AddToCartAction;
import pages.HomePageFooterAction;
import pages.HomePageNavbarAction;
import pages.NaturalFaceWashAction;
import pages.NewLaunchesAction;
import pages.TonerAction;
import utils.Base;
import utils.Reporter;

public class TestRunnerHarsh extends Base {
    ExtentReports reports;
    ExtentTest test;

    @BeforeClass
    public void createReport() {
        reports = Reporter.generateExtentReport("Nyka report");
    }

    @BeforeMethod
    public void launchBrowser() {
        test = reports.createTest("Tc_03");
        openBrowser();
    }

    /**
     * Description: Tests the workflow of Nykaa by executing a sequence of actions,
     * including
     * clicking on "New Launches", navigating through the "Launches" workflow,
     * interacting with
     * the "Natural Face Wash" section, adding a product to the bag, and performing
     * cart operations.
     *
     * This test is executed with priority 1 and is enabled.
     *
     * @priority 1
     * @enabled true
     * @return void
     * @author Harshit
     */
    @Test(priority = 6, enabled = true)
    public void nyka() {
        HomePageFooterAction.clickNewLaunches(test);
        NewLaunchesAction.allLaunches(test);
        NaturalFaceWashAction.allNaturalFace(test);
        AddToBagAction.allAddToBag(test);
        AddToCartAction.allCart(test);

    }

    /**
     * Description: Tests the workflow of Nykaa by executing actions related to the
     * navigation bar,
     * interacting with the "Toner" section, and performing the "Add to Bag"
     * workflow.
     *
     * This test is executed with priority 2 and is enabled.
     *
     * @priority 2
     * @enabled true
     * @return void
     * @author Harshit
     */
    @Test(priority = 7, enabled = true)
    public void nyka4() {
        HomePageNavbarAction.navbarAll(test);
        TonerAction.allToner(test);
        AddToBagAction.allAddToBag1(test);

    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }

    @AfterClass
    public void afterc() {
        reports.flush();
    }
}
