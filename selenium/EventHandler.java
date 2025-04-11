package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;

public class EventHandler implements WebDriverListener {
    public void logger(String logtxt) {
        if(logtxt != null) {
            try {
                File file = new File("/home/coder/project/log.log");
                BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                writer.write(logtxt);             
                writer.write("\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void beforeClick(WebElement element) {
        WebDriverListener.super.beforeClick(element);
    
        String textValue = element.getText();
        String attributeValue = element.getAttribute("value");
        String attributeTitle = element.getAttribute("title");
        String attributeAlt = element.getAttribute("alt");
        String attributePlaceholder = element.getAttribute("placeholder");
        String attributeName = element.getAttribute("name");
        String attributeAriaLabel = element.getAttribute("aria-label");
    
        String clickedDescription = "an element with no discernible identifier";
    
        if (textValue != null && !textValue.isEmpty()) {
            clickedDescription = textValue;
        } else if (attributeValue != null && !attributeValue.isEmpty()) {
            clickedDescription = attributeValue;
        } else if (attributeTitle != null && !attributeTitle.isEmpty()) {
            clickedDescription = attributeTitle;
        } else if (attributeAlt != null && !attributeAlt.isEmpty()) {
            clickedDescription = attributeAlt;
        } else if (attributePlaceholder != null && !attributePlaceholder.isEmpty()) {
            clickedDescription = attributePlaceholder;
        } else if (attributeName != null && !attributeName.isEmpty()) {
            clickedDescription = attributeName;
        } else if (attributeAriaLabel != null && !attributeAriaLabel.isEmpty()) {
            clickedDescription = attributeAriaLabel;
        }
    
        logger("Clicked " + clickedDescription);
    }
    
    
    
    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        WebDriverListener.super.beforeSendKeys(element, keysToSend);
        logger(keysToSend[0].toString()+" value entered");
    }

    @Override
    public void beforePerform(WebDriver driver, Collection<Sequence> actions) {
        WebDriverListener.super.beforePerform(driver, actions);

        String regex = "xpath: (.*?)(?=]})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(actions.iterator().next().toJson().toString());

        if (matcher.find()) {
            String xpath = matcher.group(1);
            logger("Hovered "+ driver.findElement(By.xpath(xpath)).getText());
        } else {
            System.out.println("XPath not found.");
        }
    }
}
