package utils;

import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class AssertionUtility {
    public static void useAssert(String text,String text1,ExtentTest test){ 
        try{ 
            Assert.assertEquals(text,text1); 
            LoggerHandler.info("Verification Successful: "+text1);
            test.log(Status.INFO,"Verification Successful: "+text1);
        }
        catch(AssertionError e){ 
            LoggerHandler.error("Assertion Error : Entered Wrong  Credentials." +e.getMessage());
            test.log(Status.WARNING,"Entered Wrong  Credentials." + e.getMessage());
            Screenshot.captureScreenshot(Base.driver, test, "Assertion Error"); 
            Reporter.attachScreenshotToReport("AssertionError", test,"AssertionError", Base.driver);
        }
        catch(Exception e1){ 
            LoggerHandler.error("Assertion Error : Entered Wrong  Credentials." +e1.getMessage());
            test.log(Status.WARNING,"Entered Wrong  Credentials." + e1.getMessage());
            Screenshot.captureScreenshot(Base.driver, test, "Assertion Error"); 
            Reporter.attachScreenshotToReport("Error", test,"AssertionError", Base.driver);
        }
        
        
    }
}