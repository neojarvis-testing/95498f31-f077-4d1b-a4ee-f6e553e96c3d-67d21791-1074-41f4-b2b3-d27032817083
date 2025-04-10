package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import com.google.common.io.Files;

public class Screenshot {
    
    public static TakesScreenshot ts;
    public static void captureScreenshot(WebDriver driver,ExtentTest test1,String filename){ 
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String name = filename + timestamp + ".png";

       // String destPath = "./" + name;

        ts = (TakesScreenshot) driver;
        File file = ts.getScreenshotAs(OutputType.FILE);

        // Create the screenshots directory if it doesn't exist
        File screenshotsDir = new File(System.getProperty("user.dir") + "/screenshots");

        if (!screenshotsDir.exists()) {
            screenshotsDir.mkdirs();
        }

        File target = new File(screenshotsDir, name);
        try {
            Files.copy(file, target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void highlightAndCapture(ExtentTest test,WebDriver driver,String str,By elementToHighlight){ 
        WebDriverHelper helper=new WebDriverHelper(Base.driver);
        helper.highlightElement(test,elementToHighlight);

        captureScreenshot(driver, test, str);
    }
}