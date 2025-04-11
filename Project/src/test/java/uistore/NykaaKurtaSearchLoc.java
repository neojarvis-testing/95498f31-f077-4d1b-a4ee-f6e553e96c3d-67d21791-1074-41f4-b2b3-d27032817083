package uistore;

import org.openqa.selenium.By;

public class NykaaKurtaSearchLoc {

     public static By verifyKurtas = By.xpath("//h1[text() = 'Kurtas']");
     public static By SortByPopularity = By.xpath("//button[@class = 'css-drjr1k']");
     public static By BestSeller = By.xpath("//div[@title = 'Bestseller']");
     public static By SecondProduct = By.xpath( "(//div[@class='css-384pms'])[2]");
}
