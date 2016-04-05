package by.self.parser.united.airlines.service.interf;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface LocatorWrapper {

    WebElement getElementByCssSelector(WebDriver parent, String selector);

    List<WebElement> getElementsByCssSelector(WebDriver parent, String selector);
}
