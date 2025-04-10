package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class WebDriverHelper {
    private WebDriver driver;

    public WebDriverHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeVisibleWithAttribute(By locator, int timeoutInSeconds,String attribute,ExtentTest test) {
        String webElementText=getTextByAttribute(test, locator, attribute);
        try {
            LoggerHandler.info("Wait for "+webElementText+" to be visible"); 
            test.log(Status.INFO, "Wait for "+webElementText+" to be visible"); 
            new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
            LoggerHandler.info("Waited for "+webElementText+" to be visible"); 
            test.log(Status.INFO, "Waited for "+webElementText+" to be visible"); 
        } catch (Exception e) {
            LoggerHandler.info(webElementText+" :"+e.getMessage());
            test.log(Status.FAIL, webElementText+" :"+e.getMessage()); 
            
        }
    }

    public void waitForElementToBeVisible(By locator, int timeoutInSeconds,ExtentTest test) {
        
        try {
            LoggerHandler.info("Wait for to be visible"); 
            test.log(Status.INFO, "Wait for to be visible"); 
            new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
            LoggerHandler.info("Waited for to be visible"); 
            test.log(Status.INFO, "Waited for to be visible"); 
        } catch (Exception e) {
            LoggerHandler.info("Element not visible :"+e.getMessage());
            test.log(Status.FAIL, "Element not visible :"+e.getMessage()); 
            
        }
    }

    public void clickOnElement(By locator,ExtentTest test,String attribute) {
        String webElementText=getTextByAttribute(test, locator, attribute);
        try {
            WebElement webElement = driver.findElement(locator);
            LoggerHandler.info("Click "+webElementText); 
            test.log(Status.INFO, "Click "+webElementText); 
            webElement.click();
            LoggerHandler.info("Clicked on "+webElementText); 
            test.log(Status.INFO, "Clicked on "+webElementText); 
        } catch (Exception e) {
            LoggerHandler.info(webElementText+" "+attribute+" :"+e.getMessage());
            test.log(Status.FAIL, webElementText+" "+attribute+" :"+e.getMessage()); 
        }
    }

    public void clickOnElement(By locator,ExtentTest test) {
        
        try {
            WebElement webElement = driver.findElement(locator);
            LoggerHandler.info("Click"); 
            test.log(Status.INFO, "Click"); 
            webElement.click();
            LoggerHandler.info("Clicked"); 
            test.log(Status.INFO, "Clicked"); 
        } catch (Exception e) {
            LoggerHandler.info("Element not clicked :"+e.getMessage());
            test.log(Status.FAIL, "Element not clicked :"+e.getMessage()); 
            
        }
    }

    public void scrollTillElement(By locator,ExtentTest test,String attribute){ 
        JavascriptExecutor js=(JavascriptExecutor) driver; 
        String webElementText=getTextByAttribute(test, locator, attribute);
        try{ 
            LoggerHandler.info("The screen is scrolled to "+webElementText); 
            test.log(Status.INFO, "The screen is scrolled to "+webElementText);
            js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(locator)); 
        }
        catch(Exception e){ 
            LoggerHandler.info("The screen is not scrolled to that Element "+e.getMessage());
            test.log(Status.FAIL, "The screen is not scrolled to that Element "+e.getMessage());   
        }
           
    }

    public void jsExecuteClick(By locator,ExtentTest test,String attribute){ 
        JavascriptExecutor js=(JavascriptExecutor) driver; 
        String webElementText=getTextByAttribute(test, locator, attribute);
        try{ 
            LoggerHandler.info("The element is clicked"+webElementText); 
            test.log(Status.INFO, "The element is clicked"+webElementText);
            js.executeScript("arguments[0].click()", driver.findElement(locator)); 
        }
        catch(Exception e){ 
            LoggerHandler.info("The element is not clicked"+e.getMessage());
            test.log(Status.FAIL, "The element is not clicked"+e.getMessage()); 
            
        }
    }

    public void switchToWindow(int windowNumber,ExtentTest test){ 
        Set<String> set=Base.driver.getWindowHandles(); 

        List<String> list=new ArrayList<>(set);  

        Base.driver.switchTo().window(list.get(windowNumber));
        test.log(Status.INFO,"switch to new window"); 
        LoggerHandler.info("switch to new window");

        
    }

   

    public void scrollByToFooter(ExtentTest test){ 

        JavascriptExecutor js=(JavascriptExecutor) driver; 
        
        try{ 
            LoggerHandler.info("scroll down to footer"); 
            test.log(Status.INFO, "scroll down to footer");
            js.executeScript("window.scrollBy(0,80000)", ""); 
        }
        catch(Exception e){ 
            LoggerHandler.info("scroll down to footer"+e.getMessage());
            test.log(Status.FAIL, "scroll down to footer"+e.getMessage()); 
            
        }
        
    }

    public void scrollBack(ExtentTest test){ 

        JavascriptExecutor js=(JavascriptExecutor) driver; 
        
        try{ 
            LoggerHandler.info("scroll down to footer"); 
            test.log(Status.INFO, "scroll down to footer");
            js.executeScript("window.scrollBy(0,-10000)", ""); 
        }
        catch(Exception e){ 
            LoggerHandler.info("scroll down to footer"+e.getMessage());
            test.log(Status.FAIL, "scroll down to footer"+e.getMessage()); 
            
        }
        
    }

    public void highlightElement(ExtentTest test,By locator){ 
        JavascriptExecutor js=(JavascriptExecutor) driver;  
        try{ 
            js.executeScript("arguments[0].style.border='5px solid red'", driver.findElement(locator)); 
            LoggerHandler.info("The element has changed its color"); 
            test.log(Status.INFO, "The element has changed its color");
        }
        catch(Exception e){ 
            LoggerHandler.info("The text is not highlighted"+e.getMessage());
            test.log(Status.FAIL, "The text is not highlighted"+e.getMessage()); 
            
        }
    }

    public void sendKeys(By locator, String data,ExtentTest test,String attribute) {
        String webElementText=getTextByAttribute(test, locator, attribute);
        try {
            WebElement webElement = driver.findElement(locator);
            LoggerHandler.info("send Keys :"+data); 
            test.log(Status.INFO, "send Keys :"+data); 
            webElement.sendKeys(data);
            LoggerHandler.info("sent Keys "+data+" to "+webElementText); 
            test.log(Status.INFO, "sent Keys "+data+" to "+webElementText); 

        } catch (Exception e) {
             LoggerHandler.info(data+" is not sent to "+ webElementText+" :"+e.getMessage());
            test.log(Status.FAIL, data+" is not sent to "+ webElementText+" :"+e.getMessage()); 
            
        }
    }

    public String getTextByAttribute(ExtentTest test,By webElementBy,String attribute){ 
        
        try{ 
            WebElement webElement=driver.findElement(webElementBy); 
            test.log(Status.INFO, "");
            String webElementText=webElement.getAttribute(attribute); 
            LoggerHandler.info(attribute);
            test.log(Status.INFO, attribute+" Attribute value is fetched ");
            return webElementText;
             
        }

        catch(Exception e){ 
            LoggerHandler.info(attribute+" Attribute value is not fetched "+" :"+e.getMessage());
            test.log(Status.FAIL, attribute+" Attribute value is not fetched "+" :"+e.getMessage()); 
            
            return ""; 
        }
        
    }

    public void isElementDisplayed(By locator , ExtentTest test) {
        try {
            WebElement element = driver.findElement(locator);
            boolean elemtext = element.isDisplayed();
            LoggerHandler.info(element.getText() +": " +elemtext);
            test.log(Status.INFO, element.getText() +": " +elemtext);

        } catch (Exception e) {
            LoggerHandler.info(e.getMessage());
        }
    }

    


    public void switchInToWindown(){ 
        Set<String> windowIds = Base.driver.getWindowHandles();
             String parentWindowId = Base.driver.getWindowHandle();
             for (String string : windowIds) {
                 if (!string.equals(parentWindowId)) {
                     Base.driver.switchTo().window(string);
                 }
             }
         }

    public String getText(By locator,ExtentTest test) {
        try {
            WebElement webElement = driver.findElement(locator);
            LoggerHandler.info("Get Text "); 
            test.log(Status.INFO, "Get Text "); 
            return webElement.getText();
        } catch (Exception e) {
            LoggerHandler.info("The text is not fetched "+e.getMessage());
            test.log(Status.FAIL, "The text is not fetched "+e.getMessage()); 
            
            return " ";
        }
    }

    public void hoverAndClickWithAttribute(ExtentTest test,By hoverLocator,By clickLocator,String attribute){ 
        hoverOverElement(clickLocator, test); 
        highlightElement(test, clickLocator);
        clickOnElement(clickLocator, test, attribute);
    }

    public void hoverAndClick(ExtentTest test,By hoverLocator,By clickLocator){ 
        hoverOverElement(clickLocator, test); 
        waitForElementToBeVisible(clickLocator, 5, test);
        clickOnElement(clickLocator, test);
    }

    public void scrollAndClickByElement(ExtentTest test,By scrollElement,By clickLocator,String attribute){ 
        scrollTillElement(scrollElement,test,attribute); 
        waitForElementToBeVisible(clickLocator,10,test);
        clickOnElement(clickLocator, test); 
    }

    public void scrollAndClickByPixels(ExtentTest test,By clickLocator){ 
        scrollByToFooter(test);
        waitForElementToBeVisible(clickLocator, 5,test); 
        clickOnElement(clickLocator, test); 
    }

    public void scrollToFooterAndClickWithAttribute(ExtentTest test,By clickLocator,String attribute){ 
        scrollByToFooter(test);
        waitForElementToBeVisibleWithAttribute(clickLocator, 5,attribute,test); 
        clickOnElement(clickLocator, test); 
    }

    
    public void enterAction(By locator,ExtentTest test) {
        try {
            WebElement webElement = driver.findElement(locator);
            LoggerHandler.info("Enter on Keyboard"); 
            test.log(Status.INFO, "Enter on Keyboard"); 
            webElement.sendKeys(Keys.ENTER);
            LoggerHandler.info("Enter on Keyboard performed"); 
            test.log(Status.INFO, "Enter on Keyboard performed"); 
        } catch (Exception e) {
            LoggerHandler.info("Enter on Keyboard not performed"+e.getMessage());
            test.log(Status.FAIL, "Enter on Keyboard not performed"+e.getMessage()); 
        }
    }

    public void hoverOverElement(By locator,ExtentTest test) {
        try {
            WebElement webElement = driver.findElement(locator);
            Actions actions = new Actions(driver);
            LoggerHandler.info("Hover to the Element");
            test.log(Status.INFO, "Hover to the Element"); 
            actions.moveToElement(webElement).perform();
        } catch (Exception e) {
            LoggerHandler.info("Failed to Hover to the Element"+e.getMessage());
            test.log(Status.FAIL, "Failed to Hover to the Element"+e.getMessage()); 
        }
    }
    public List<WebElement> getElementsByXPath(String XPath){
        return driver.findElements(By.xpath(XPath));
    }

}