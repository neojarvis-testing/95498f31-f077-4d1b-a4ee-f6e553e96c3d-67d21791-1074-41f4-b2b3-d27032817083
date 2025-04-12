package uistore;

import org.openqa.selenium.By;

public class NykaaLuxeLoc {
    
    public static By titleLuxe = By.xpath("//div[@id='title']/h1");
    public static By sorter = By.id("filter-sort");
    public static By sortbyCustomerTopRated = By.xpath("//label[@for='radio_customer top rated_undefined']");
    public static By genderFilter = By.xpath("(//div[@class='css-w2222k'])[7]");
    public static By unisex = By.xpath("//label[@for='checkbox_Unisex_10712']");
    public static By filterApplied = By.cssSelector("span[class='filter-value']");
    public static By ocassionFilter = By.xpath("(//div[@class='css-w2222k'])[16]");
    public static By dayWear = By.cssSelector("[for='checkbox_Day Wear_212287']");
    public static By firstProduct = By.xpath("(//div[@class='css-ifdzs8'])[1]");
}
