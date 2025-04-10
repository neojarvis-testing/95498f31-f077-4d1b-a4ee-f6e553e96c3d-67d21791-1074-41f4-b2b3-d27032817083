package pages;

import org.openqa.selenium.Keys;

import com.aventstack.extentreports.ExtentTest;

import uistore.AddToBagLoc;
import uistore.KajalLoc;
import uistore.NewLaunchesLoc;
import utils.AssertionUtility;
import utils.Base;
import utils.ExcelFileReader;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class KajalAct {
    WebDriverHelper helper=new WebDriverHelper(Base.driver); 

    public void getKajal(ExtentTest test) throws InterruptedException{  
        sendKajal(test); 
        formuPencil(test);

    }
    public void sendKajal(ExtentTest test) throws InterruptedException{ 

        AssertionUtility.useAssertEquals(helper.getText(KajalLoc.categories, test),ExcelFileReader.readData(Base.prop.getProperty("sheet4").toLowerCase(), 0, 0, test) , test);

        helper.clickOnElement(KajalLoc.searchBar,test,"placeholder");  

        Thread.sleep(2000);
        helper.sendKeys(KajalLoc.searchBar, "Kajal", test, "placeholder");  

        AssertionUtility.useAssertEquals(helper.getText(KajalLoc.searchBar, test),ExcelFileReader.readData(Base.prop.getProperty("sheet4").toLowerCase(), 1, 0, test) , test);

        Base.driver.findElement(KajalLoc.searchBar).sendKeys(Keys.ENTER);  

        AssertionUtility.useAssertTrue(helper.getText(KajalLoc.kajalVerify,test),ExcelFileReader.readData(Base.prop.getProperty("sheet4"), 1, 0, test),test); 
    } 
    public void formuPencil(ExtentTest test) throws InterruptedException{ 
        helper.hoverAndClick(test, KajalLoc.formulation, KajalLoc.formulation);

        helper.hoverAndClick(test, KajalLoc.pencil, KajalLoc.pencil); 
        helper.scrollBack(test);
    }

    

    
}
