package uistore;

import org.openqa.selenium.By;

public class HelpCentreLocators {
    public static By helpCentre_OrderRelated = By.xpath("//span[text()='Order Related']");
    public static By helpCentre_OrderStatus = By.xpath("//div[text()='Order Status']");
    public static By helpCentre_returnsAndRefund = By.xpath("//div[text()='Returns and Refunds']");
    public static By helpCentre_CancellationsAndRefund = By.xpath("//div[text()='Cancellations and Refund']");
    public static By helpCentre_CancellationPolicy = By.xpath("//p[text()='Cancellation Policy']");
    public static By helpCentre_CancellationPolicyLink = By.linkText("https://www.nykaa.com/cancellation-policy/lp");
    public static By HelpCentre_NykaaAccount = By.xpath("//span[text()='Nykaa Account']");
    public static By HelpCentre_MyWishList = By.xpath("//div[text()='My Wishlist']");
    public static By HelpCentre_HowDoIAddItems = By.xpath("//p[text()='How do I add items to my wishlist?']");
}
