package by.self.parser.united.airlines.parser.impl;

import by.self.parser.united.airlines.ClassType;
import by.self.parser.united.airlines.RequestData;
import by.self.parser.united.airlines.exception.ServiceException;
import by.self.parser.united.airlines.parser.interf.Parser;
import by.self.parser.united.airlines.service.interf.*;
import by.self.parser.united.airlines.pojo.*;
import by.self.parser.united.airlines.utils.Helper;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;
import org.springframework.util.StopWatch;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ParserUnited implements Parser {

    private static Logger Log = LogManager.getLogger(ParserUnited.class.getName());

    @Inject
    private Driver driverService;

    @Inject
    private JsonConverter jsonConverter;

    @Inject
    private LocatorWrapper locatorWrapper;

    @Inject
    private Converter converter;

    @Inject
    private ClassParser classParser;

    @Inject
    private FlightParser flightParser;

    @Inject
    private InfoParser infoParser;

    @Inject
    private ExtraDataParser extraDataParser;

    @Inject
    private Helper helper;

    @Override
    public String parseProcess(RequestData requestData) throws ServiceException {
        Elements rows = getAllRows(requestData);
        List<AwardVO> awardVOs = new ArrayList<>();
        for (Element row : rows) {
            AwardVO awardVO = extractAwardVO(row, requestData);
            if (awardVO != null) {
                awardVOs.add(awardVO);
            }
        }
        return jsonConverter.convertToJson(new MainVO(awardVOs));
    }

    private AwardVO extractAwardVO(Element row, RequestData requestData) {
        AwardVO awardVO = new AwardVO();
        List<ClassType> requiredClasses = helper.getRequiredClasses(requestData);
        List<ClassVO> classVOs = classParser.parse(row, requiredClasses);
        if (classVOs.isEmpty()) {
            return null;
        }
        List<FlightVO> flightVOs = flightParser.parse(row, requiredClasses);
        String totalDuration = infoParser.parse(row);
        List<ExtraDataVO> extraDataVOs = extraDataParser.parse(row, requiredClasses);
        awardVO.setClassVOList(classVOs);
        awardVO.setFlightVOList(flightVOs);
        awardVO.setTotalDuration(totalDuration);
        awardVO.setExtraDataVOList(extraDataVOs);
        awardVO.setSplit(false);
        return awardVO;
    }

    private Elements getAllRows(RequestData requestData) throws ServiceException {
        Elements rows = new Elements();
        List<String> dates = helper.getDatesRange(requestData);
        Log.error("Number of dates: " + dates.size());
        WebDriver driver = null;
        for (String date : dates) {
            String url = String.format(helper.getUrl(requestData), date);
            driver = driverService.getDriver(url);
            closePopUp(driver);
            List<WebElement> pagingLinks = locatorWrapper.getElementsByCssSelector(driver, "div.simple-pagination.united-theme ul li");
            int pagesSize = pagingLinks.size() - 3;
            Log.error("Number of pages: " + (pagesSize + 1));
            if (pagesSize > 1) {
                for (int i = 0; i <= pagesSize; i++) {
                    Log.error("Added rows from page " + (i + 1));
                    Elements rowsPerPage = getRowsPerPage(driver);
                    rows.addAll(rowsPerPage);
                    if (i < pagesSize) {
                        locatorWrapper.getElementByCssSelector(driver,
                                "div.simple-pagination.united-theme ul li a.page-link.next").click();
                        sleep(500);
                    }
                }
            } else {
                Elements rowsPerPage = getRowsPerPage(driver);
                rows.addAll(rowsPerPage);
                Log.error("Added rows from page");
            }
            driverService.closeDriver(driver);
        }
        driverService.quitDriver(driver);
        Log.error("Created " + rows.size() + " rows.");
        return rows;
    }

    private Elements getRowsPerPage(WebDriver driver, WebElement pageLink) {
        pageLink.click();
        sleep(500);
        openAllDetails(driver);
        Document document = converter.convertToDOM(driver);
        return document.select("li.flight-block.flight-block-fares.flight-block-expanded");
    }

    private Elements getRowsPerPage(WebDriver driver) {
        sleep(500);
        openAllDetails(driver);
        Document document = converter.convertToDOM(driver);
        return document.select("li.flight-block.flight-block-fares.flight-block-expanded");
    }

    private void closePopUp(WebDriver driver) {
        driver.findElement(By.xpath("/html/body/div[4]/button")).click();
    }

    private void openAllDetails(WebDriver driver) {
        List<WebElement> elements = driver.findElements(By.cssSelector("a.toggle-flight-block-details.ui-tabs-anchor"));
        for (WebElement element : elements) {
            element.click();
        }
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
