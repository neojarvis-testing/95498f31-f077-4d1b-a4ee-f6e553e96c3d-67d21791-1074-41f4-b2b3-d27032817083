package pages;

import runner.TestRunner;
import uistore.NykaaManLoc;
import utils.AssertionUtility;
import utils.Base;
import utils.Screenshot;
import utils.WebDriverHelper;

public class NykaaMan {
    
    WebDriverHelper helper = new WebDriverHelper(Base.driver);

    public void groomingAdviceClick()
    {
        helper.hoverAndClick(TestRunner.test, NykaaManLoc.groomingAdvice,NykaaManLoc.groomingAdvice);
        
    }
    public void verifyShavingAndBeard()
    {
        helper.hoverAndClick(TestRunner.test, NykaaManLoc.shavingAndBeardCare,NykaaManLoc.shavingAndBeardCare);
        String actualTitle = Base.driver.findElement(NykaaManLoc.shavingAndBeardCare).getText();
        String expectedTitle = "Shaving & Beard Care";
        AssertionUtility.useAssertEquals(actualTitle, expectedTitle, TestRunner.test);
        Screenshot.captureScreenshot(Base.driver,TestRunner.test,"Shaving & Beard Care");

    }

    public void nykaaMan(){
        groomingAdviceClick();
        verifyShavingAndBeard();
    }
}