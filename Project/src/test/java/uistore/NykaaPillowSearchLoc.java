package uistore;

import org.openqa.selenium.By;

public class NykaaPillowSearchLoc {

   public static By verifypillow = By.xpath("//h1[@class = 'page-title-search']");
   public static By price = By.xpath("(//div[@class = 'filter-open css-1gdff5r'])[2]");
   public static By priceDropdown = By.xpath("//input[@id = 'checkbox_Rs. 1000 - Rs. 1999_1000-1999']");
   public static By Discount = By.xpath("(//div[@class = 'filter-open css-1gdff5r'])[4]");
   public static By DiscountThirdOption = By.xpath("//input[@id = 'radio_50% and above_50-*']");
   public static By AvgCustomerRating = By.xpath("(//div[@class = 'filter-open css-1gdff5r'])[5]");
   public static By AvgCustomerRatingFirstOption = By.xpath("//input[@id = 'radio_4 stars & above_4']");
   public static By firstproduct = By.xpath("(//div[@class = 'css-43m2vm'])[1]");
   
}
