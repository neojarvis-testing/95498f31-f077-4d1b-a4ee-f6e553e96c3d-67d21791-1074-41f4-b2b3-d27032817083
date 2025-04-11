package uistore;

import org.openqa.selenium.By;

public class TonerLoc {
 public static By clickSortBy = By.cssSelector("button[class=' css-1aucgde']");
    public static By clickNewArrivals = By.xpath("//span[text()='new arrivals']");
    public static By clickAvgRating = By.xpath("(//div[@class='filter-open css-1gdff5r'])[8]");
    public static By clickFirstRatingOption = By.xpath("//span[contains(text(), '4 stars')]");
    public static By clickFirstProductNew = By.xpath("(//a[@class='css-qlopj4'])[1]");
    public static By tonerDisplayed = By.xpath("//h1[text()='Buy Skin Toners & Mist Online']");

}
