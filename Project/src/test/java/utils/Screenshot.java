package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Screenshot {
    

    public static void captureScreenshot(WebDriver driver,ExtentTest test1,String str){ 
        TakesScreenshot ts = (TakesScreenshot) driver;

        File ss = ts.getScreenshotAs(OutputType.FILE);

        String screenshot = str;

        File target = new File(System.getProperty("user.dir") + "/screenshots/");

        String target1 = System.getProperty("user.dir") + "/screenshots/";
        if (!target.exists()) {
            target.mkdirs();
        }

        try {
            FileHandler.copy(ss, new File(target1 + screenshot));
            test1.log(Status.INFO, "Screenshot Captured");
        } catch (IOException e) {
            e.printStackTrace();
            test1.log(Status.FAIL, "Screenshot not Captured");

        }
    }

    public static void highlightAndCapture(ExtentTest test,WebDriver driver,String str,By elementToHighlight){ 
        WebDriverHelper helper=new WebDriverHelper(Base.driver);
        helper.highlightElement(test,elementToHighlight);

        captureScreenshot(driver, test, str);
    }
}
