package by.self.parser.united.airlines.utils;

import by.self.parser.united.airlines.ClassType;
import by.self.parser.united.airlines.RequestData;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Helper {

    public List<String> getDatesRange(RequestData requestData) {
        DecimalFormat decimalFormat = new DecimalFormat("00");
        DateTimeFormatter formatter= DateTimeFormat.forPattern("MM/dd/yyyy");
        DateTime startDate= formatter.parseDateTime(requestData.getStartDate());
        DateTime endDate= formatter.parseDateTime(requestData.getEndDate());

        List<String> dates = new ArrayList<>();
        while (!startDate.isAfter(endDate)) {
            dates.add(startDate.getYear() + "-" +
                    decimalFormat.format(startDate.getMonthOfYear()) + "-" +
                    decimalFormat.format(startDate.getDayOfMonth()));
            startDate = startDate.plusDays(1);
        }
        return  dates;
    }

    public List<ClassType> getRequiredClasses(RequestData requestData) {
        List<ClassType> requiredClasses = new ArrayList<>();
        if (requestData.getClasses().contains("E")) {
            requiredClasses.add(ClassType.E);
        }
        if (requestData.getClasses().contains("B")) {
            requiredClasses.add(ClassType.B_SAVER);
            requiredClasses.add(ClassType.B_FULL);
        }
        if (requestData.getClasses().contains("F")) {
            requiredClasses.add(ClassType.F_SAVER);
            requiredClasses.add(ClassType.F_FULL);
        }
        return requiredClasses;
    }

    public String getUrl(RequestData requestData) {
        String classType = "";
        String classData = requestData.getClasses();
        if (classData.contains("B") && classData.contains("F")) {
            classType = "&act=1";
        } else if (classType.contains("F")) {
            classType = "&act=2";
        }
        String url = "https://www.united.com/ual/en/us/flight-search/book-a-flight/results/awd?" +
                "f=" + requestData.getOrigin() + "&t=" + requestData.getDestination() +
                "&d=%s" + "&tt=1&at=1" + classType + "&sc=7&px=" + requestData.getSeats() + "&taxng=1&idx=1";
        return url;
    }
}
