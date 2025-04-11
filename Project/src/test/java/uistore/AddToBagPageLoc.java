package uistore;

import org.openqa.selenium.By;

public class AddToBagPageLoc {
    public static By clickAddToBag = By.cssSelector("div[class='css-vp18r8']");
    public static By clickPincode = By.cssSelector("input[name='pin code']");
    public static By clickPincodeCheck = By.xpath("//button[text()='Check']");
    public static By clickIngredient = By.xpath("//h3[text()='Ingredients']");
    public static By clickReadMore = By.xpath("//span[contains(text() , 'Read ')]");
    public static By descriptionDisplayed = By.cssSelector("h2[class='css-3db1zm']");
    public static By inclusiveDisplayed = By.cssSelector("div[class='css-1c4feqy']");


}
