package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.NykaaHomePage;
import pages.NykaaLuxe;
import pages.NykaaLuxeProduct;
import pages.NykaaMan;
import utils.Base;
import utils.Reporter;


/**
 * TestRunnerKumaran class is the test runner for executing test cases.
 * It uses TestNG annotations for setting up and tearing down the test environment.
 */
public class TestRunnerKumaran extends Base{

    public static ExtentReports report;
    public static ExtentTest test;

    @BeforeClass
    public void configReport()
    {
        report = Reporter.generateExtentReport("Nykaa");
    }
    @BeforeMethod
    public void configBrowser()
    {
        openBrowser();
        test = report.createTest("TestCase9");
    }

    @Test(enabled=true)
    public void testCase1()
    {
         NykaaHomePage action1 = new NykaaHomePage();
         NykaaLuxe action2 = new NykaaLuxe();
         NykaaLuxeProduct action3 = new NykaaLuxeProduct();
         NykaaMan action4 = new NykaaMan();
         action1.footerLuxeClick();
         action2.luxe();
         action3.footerNykaaManClick();
         action4.nykaaMan();
    }
    
    @AfterMethod
    public void closeBrowser()
    {
        if(driver!=null)
        {
            driver.quit();
        }
    }
    @AfterClass
    public void closeReport()
    {
        report.flush();
    }

}