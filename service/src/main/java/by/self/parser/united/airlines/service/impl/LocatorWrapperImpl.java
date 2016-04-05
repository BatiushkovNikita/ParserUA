package by.self.parser.united.airlines.service.impl;

import by.self.parser.united.airlines.service.interf.LocatorWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class LocatorWrapperImpl implements LocatorWrapper {

    private static Logger Log = LogManager.getLogger(LocatorWrapperImpl.class.getName());

    @Override
    public WebElement getElementByCssSelector(WebDriver parent, String selector) {
        try {
            return parent.findElement(By.cssSelector(selector));
        } catch (NoSuchElementException e) {
            Log.error("Cannot find elements: " + e.getMessage());
            return null;
        } catch (WebDriverException e) {
            Log.error("Cannot find elements: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<WebElement> getElementsByCssSelector(WebDriver parent, String selector) {
        try {
            return parent.findElements(By.cssSelector(selector));
        } catch (NoSuchElementException e) {
            Log.error("Cannot find elements: " + e.getMessage());
            return null;
        } catch (WebDriverException e) {
            Log.error("Cannot find elements: " + e.getMessage());
            return null;
        }
    }
}
