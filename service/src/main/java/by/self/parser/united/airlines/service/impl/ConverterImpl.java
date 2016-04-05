package by.self.parser.united.airlines.service.impl;

import by.self.parser.united.airlines.service.interf.Converter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConverterImpl implements Converter {

    @Override
    public Document convertToDOM(WebDriver driver) {
        WebElement html = driver.findElement(By.tagName("html"));
        String innerHTML = "<html>" + html.getAttribute("innerHTML") + "</html>";
        return Jsoup.parse(innerHTML);
    }
}
