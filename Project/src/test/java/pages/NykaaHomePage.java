package pages;

import runner.TestRunnerKumaran;
import uistore.NykaaFooterLoc;
import utils.Base;
import utils.WebDriverHelper;


/**
 * Creator: Kumaran
 * 
 * Description: class contains methods to interact with the Nykaa home page.
 * 
 */
public class NykaaHomePage {
    
    WebDriverHelper helper = new WebDriverHelper(Base.driver);

    
    /**
     * Description: This method scrolls to the footer of the page and clicks on the 'Luxe' link.
     * 
     */
    public void footerLuxeClick()
    {
        helper.scrollByToFooter(TestRunnerKumaran.test);
        helper.scrollByToFooter(TestRunnerKumaran.test);
        helper.hoverAndClick(TestRunnerKumaran.test, NykaaFooterLoc.footerLuxe, NykaaFooterLoc.footerLuxe);
        helper.switchToWindow(1,TestRunnerKumaran.test);
    }

}