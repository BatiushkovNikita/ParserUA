package by.self.parser.united.airlines.service.interf;

import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;

public interface Converter {

    Document convertToDOM(WebDriver driver);
}
