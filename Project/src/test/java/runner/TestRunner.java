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

public class TestRunner extends Base{
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
    
    @Test(enabled=true)
    public void nyka(){
        HomePageFooterAction.clickNewLaunches(test);
        NewLaunchesAction.allLaunches(test);
        NaturalFaceWashAction.allNaturalFace(test);
        AddToBagAction.allAddToBag(test);
        AddToCartAction.allCart(test);
        
    }
    @Test(enabled=true)
    public void nyka4(){
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
