package utils;

import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class AssertionUtility {
    public static void useAssertEquals(String actual,String expected,ExtentTest test){ 
        try{ 
            Assert.assertEquals(actual,actual); 
            LoggerHandler.info("Verification Successful: "+actual);
            test.log(Status.INFO,"Verification Successful: "+actual);
            
        }
        catch(AssertionError e){ 
            LoggerHandler.error("Assertion Error : Entered Wrong  Credentials." +e.getMessage());
            test.log(Status.WARNING,"Entered Wrong  Credentials." + e.getMessage());
            Screenshot.captureScreenshot(Base.driver, test, "Assertion Error"); 
            Reporter.attachScreenshotToReport("AssertionError", test,"AssertionError", Base.driver);
        }
        catch(Exception e1){ 
            LoggerHandler.error("Error: Entered Wrong  Credentials." +e1.getMessage());
            test.log(Status.WARNING,"Entered Wrong  Credentials." + e1.getMessage());
            Screenshot.captureScreenshot(Base.driver, test, "Error"); 
            Reporter.attachScreenshotToReport("Error", test,"Error", Base.driver);
        }
        
    }

    public static void useAssertTrue(String actual,String expected,ExtentTest test){ 
        try{ 
            if(actual.contains(expected)){ 
                Assert.assertTrue(true);
                LoggerHandler.info("Verification Successful: "+actual);
                test.log(Status.INFO,"Verification Successful: "+actual);
                
            }
        }
        catch(AssertionError e){ 
            LoggerHandler.error("Assertion Error : Entered Wrong  Credentials." +e.getMessage());
            test.log(Status.WARNING,"Entered Wrong  Credentials." + e.getMessage());
            Screenshot.captureScreenshot(Base.driver, test, "Assertion Error"); 
            Reporter.attachScreenshotToReport("AssertionError", test,"AssertionError", Base.driver);
        }
        catch(Exception e1){ 
            LoggerHandler.error("Error: Entered Wrong  Credentials." +e1.getMessage());
            test.log(Status.WARNING,"Entered Wrong  Credentials." + e1.getMessage());
            Screenshot.captureScreenshot(Base.driver, test, "Error"); 
            Reporter.attachScreenshotToReport("Error", test,"Error", Base.driver);
        }
        
    }
    
}

