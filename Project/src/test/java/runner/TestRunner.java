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

    @Test
    
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

    @Test
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
