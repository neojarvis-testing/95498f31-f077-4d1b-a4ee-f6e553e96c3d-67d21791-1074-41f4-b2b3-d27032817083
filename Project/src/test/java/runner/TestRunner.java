package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Pages.TestCaseTenModuleOne;
import Pages.TestCaseTenModuleThree;
import Pages.TestCaseTenModuleTwo;
import utils.Base;
import utils.Reporter;

public class TestRunner extends Base{
    public ExtentReports reports;
    public ExtentTest tests; 
    
    /*
     *Description: Generate Extent Report for Nykaa Website
     */
    @BeforeClass
    public void beforeC(){ 
        reports=Reporter.generateExtentReport("Nykaa");
    }

    /*
     * Description: Open the Nykaa Homepage Browser
     */
    @BeforeMethod
    public void beforeM(){ 
        openBrowser();
    }

    @Test
    public void testcase1() throws InterruptedException{ 
      TestCaseTenModuleOne action1 = new TestCaseTenModuleOne();
      TestCaseTenModuleTwo action2 = new TestCaseTenModuleTwo();
      TestCaseTenModuleThree action3 = new TestCaseTenModuleThree();
        tests = reports.createTest("TestCase 10");

        action1.footerPage(tests);
        action2.nykaaManPage(tests);
        action3.firstProductPage(tests);
      
    }

    /*
     * Description: All the browser is closing and the driver is quitting
     */
    @AfterMethod
    public void afterM(){ 
        driver.quit();
    }

    /*
     * Description: Add all the report logs to the report
     */
    @AfterClass
    public void afterC(){ 
        reports.flush();
    }
    
}
