package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.NykaaHomeSearch;
import pages.NykaaKurtaLogin;
import pages.NykaaKurtaProduct;
import pages.NykaaKurtaSearch;
import pages.NykaaPillowProduct;
import pages.NykaaPillowSearch;
import utils.Base;
import utils.Reporter;

public class TestRunerTharikaa extends Base{
     
    public ExtentReports report; 
     public ExtentTest test;
    
  
    @BeforeClass
    public void beforeC(){ 
        report=Reporter.generateExtentReport("Nykaa");
    }


    @BeforeMethod
    public void beforeM(){ 
        openBrowser();
    }


/**
 * Description:
 * This test verifies the search and selection process for pillow products on Nykaa.
 *
 * @param test ExtentTest object for logging and reporting.
 * @return void
 * 
 * @enabled true
 * @author Tharikaa Srinithi
 */
    @Test(enabled = true)

    public void testcase1(){ 
      test = report.createTest("NYKAA_Report");
      NykaaHomeSearch action1 = new NykaaHomeSearch();
      NykaaPillowSearch action2 = new NykaaPillowSearch();
      NykaaPillowProduct action3 = new NykaaPillowProduct();
      action1.homeSearchPillow(test);
      action2.pillowSearch(test);
      action3.pillowProduct(test);


    }


  /**
 * Description:
 * This test verifies the search and purchase flow for Kurta products on Nykaa's platform.
 *
 * @param test ExtentTest object for logging and reporting.
 * @return void
 * 
 * @enabled true
 * @author Tharikaa Srinithi
 */
    @Test(enabled = true)
    public void testcase2()
    {
        test = report.createTest("NYKAA_Report");
       
        NykaaHomeSearch action1 = new NykaaHomeSearch();
        NykaaKurtaSearch action2 = new NykaaKurtaSearch();
        NykaaKurtaProduct action3 = new NykaaKurtaProduct();
        NykaaKurtaLogin action4 = new NykaaKurtaLogin();

        action1.homeSearchKurta(test);
        action2.kurtasearch(test);
        action3.kurtaProduct(test);
        action4.kurtaLogin(test);
    }

    @AfterMethod
    public void afterM(){ 
       driver.quit();
    }

    @AfterClass
    public void afterC(){ 
        report.flush();
    }
    
}

