package by.self.parser.united.airlines.service.interf;

import org.openqa.selenium.WebDriver;

public interface Driver {

    WebDriver getDriver(String url);

    void closeDriver(WebDriver driver);

    void quitDriver(WebDriver driver);
}
