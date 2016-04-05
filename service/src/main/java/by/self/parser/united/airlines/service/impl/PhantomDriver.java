package by.self.parser.united.airlines.service.impl;


import by.self.parser.united.airlines.service.interf.Driver;
import net.anthavio.phanbedder.Phanbedder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Scope;

import java.io.File;
import java.util.concurrent.TimeUnit;

@Scope("prototype")
public class PhantomDriver implements Driver {

    @Override
    public WebDriver getDriver(String url) {
        File phantomJs = Phanbedder.unpack();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomJs.getAbsolutePath());
        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] {
                "--ssl-protocol=any"
        });
        //capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_CUSTOMHEADERS_PREFIX + "Accept-Language", "en-US");

        WebDriver driver = new PhantomJSDriver(capabilities);

        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        driver.get(url);
        return driver;
    }

    @Override
    public void closeDriver(WebDriver driver) {
        driver.close();
    }

    @Override
    public void quitDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }
}
