package pages;

import runner.TestRunner;
import uistore.NykaaFooterLoc;
import utils.Base;
import utils.WebDriverHelper;

public class NykaaHomePage {
    
    WebDriverHelper helper = new WebDriverHelper(Base.driver);

    public void footerLuxeClick()
    {
        helper.scrollByToFooter(TestRunner.test);
        helper.scrollByToFooter(TestRunner.test);
        helper.hoverAndClick(TestRunner.test, NykaaFooterLoc.footerLuxe, NykaaFooterLoc.footerLuxe);
        helper.switchToWindow(1,TestRunner.test);
    }

}