package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.AddToBag;
import pages.BeautyToGo;
import pages.HomePageAct;
import pages.KajalAct;
import pages.NewLaunches;
import pages.OfferZone;
import pages.TermsConditions;
import pages.TestCase5Actions;
import pages.TestCase6Actions;
import utils.Base;
import utils.Reporter;

public class TestRunner extends Base{
    public ExtentReports reports; 
    public ExtentTest test;
    
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

    @Test(priority = 3, enabled = true)
    public void testcase5(){ 
        TestCase5Actions ta5 = new TestCase5Actions();
        test=reports.createTest("TestCase 5");
        ta5.completeTestCase5(test);
    }
    @Test(priority = 4, enabled = true)
    public void testcase6(){ 
        test=reports.createTest("TestCase 6");
        TestCase6Actions ta6 = new TestCase6Actions();
        ta6.testCase06(test);
    }

    @Test(priority=1,enabled=true)     
    public void beautyAndOffer() throws InterruptedException{ 
        HomePageAct action =new HomePageAct();
        BeautyToGo action1=new BeautyToGo(); 
        TermsConditions action2=new TermsConditions();
        OfferZone action3=new OfferZone();
        test=reports.createTest("Homepage Test");
        action.getApp(test);
        action1.beautyToGo(test);
        action2.termsAndCondition(test); 
        action3.offerZone(test); 
    }

    @Test(priority=2,enabled=true) 
    public void kajalAddToBag() throws InterruptedException{ 
        KajalAct action =new KajalAct(); 
        NewLaunches action1=new NewLaunches();
        AddToBag action2=new AddToBag();
        test=reports.createTest("Kajal Test");
        action.getKajal(test);
        action1.newLaunches(test);
        action2.addToBag(test);
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
