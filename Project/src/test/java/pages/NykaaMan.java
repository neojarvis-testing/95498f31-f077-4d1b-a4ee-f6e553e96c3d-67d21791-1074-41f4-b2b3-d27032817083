package pages;

import runner.TestRunnerKumaran;
import uistore.NykaaManLoc;
import utils.AssertionUtility;
import utils.Base;
import utils.ExcelFileReader;
import utils.Screenshot;
import utils.WebDriverHelper;


/**
 * Creator: Kumaran
 * 
 * Description: class contains methods to interact with the Nykaa Man page.
 */
public class NykaaMan {
    
    WebDriverHelper helper = new WebDriverHelper(Base.driver);

    
    /**
     * Description: This method clicks on the 'Grooming Advice' section.
     */
    public void groomingAdviceClick()
    {
        helper.hoverAndClick(TestRunnerKumaran.test, NykaaManLoc.groomingAdvice,NykaaManLoc.groomingAdvice);
        
    }
    
    /**
     * Description: This method verifies the 'Shaving and Beard Care' section.
     * It compares the actual title with the expected title from an Excel file and captures a screenshot.
     */
    public void verifyShavingAndBeard()
    {
        helper.hoverAndClick(TestRunnerKumaran.test, NykaaManLoc.shavingAndBeardCare,NykaaManLoc.shavingAndBeardCare);
        String actualTitle = Base.driver.findElement(NykaaManLoc.shavingAndBeardCare).getText();
        String expectedTitle = ExcelFileReader.readData("Sheet1", 23, 0, TestRunnerKumaran.test);
        AssertionUtility.useAssertEquals(actualTitle, expectedTitle, TestRunnerKumaran.test);
        Screenshot.captureScreenshot(Base.driver,TestRunnerKumaran.test,expectedTitle);

    }

    
    /**
     * Description: This method performs a series of actions on the Nykaa Man page: clicking on grooming advice and verifying the shaving and beard care section.
     *
     */
    public void nykaaMan(){
        groomingAdviceClick();
        verifyShavingAndBeard();
    }
}