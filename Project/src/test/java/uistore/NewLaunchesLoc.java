package uistore;

import org.openqa.selenium.By;

public class NewLaunchesLoc {
    public static By fragrance=By.xpath("(//a[text()='fragrance'])");
    
    public static By newlaunches=By.xpath("//a[@href='/fragrance/new-launches/c/187?ptype=lst&id=187&root=nav_3&dir=desc&order=popularity']");
    

    public static By newLaunchesVerify=By.xpath("(//h1[@class='css-c0pzm0'])"); 
    public static By hoverNatural = By.xpath("//a[text()='Natural']");
    public static By clickFaceWash = By.xpath("//a[text()=' Face Wash']");
    public static By verifyNewLaunches = By.cssSelector("h1[class='css-c0pzm0']");

    

}


