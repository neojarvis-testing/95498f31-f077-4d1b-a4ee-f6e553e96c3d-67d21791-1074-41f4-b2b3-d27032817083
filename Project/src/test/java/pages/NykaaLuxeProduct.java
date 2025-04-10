package pages;

import runner.TestRunner;
import uistore.NykaaFooterLoc;
import utils.Base;
import utils.WebDriverHelper;

public class NykaaLuxeProduct {
    
    WebDriverHelper helper = new WebDriverHelper(Base.driver);

    public void footerNykaaManClick()
    {
        helper.scrollByToFooter(TestRunner.test);
        helper.scrollByToFooter(TestRunner.test);
        helper.hoverAndClick(TestRunner.test, NykaaFooterLoc.footerNykaaMan,NykaaFooterLoc.footerNykaaMan);
        helper.switchToWindow(3,TestRunner.test);
    }
}