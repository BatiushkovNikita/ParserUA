package by.self.parser.united.airlines.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formatter {

    // Mon, May 30 Wed, Jun 1
    public static String receiveDepartDate(String text) {
        String result = "";
        try {
            text = text.substring(5, 10) + " 2016";
            DateTimeFormatter formatter= DateTimeFormat.forPattern("MMM dd yyyy");
            DateTime date= formatter.parseDateTime(text);
            formatter= DateTimeFormat.forPattern("yyyy-MM-dd");
            result = formatter.print(date);
        } catch (Exception e) {
            result = text;
        }
        return result;
    }

    // 5:35 am - 8:30 am (1h 55m) "div.segment-times"
    public static String receiveDepartTime(String text) {
        String result = "";
        try {
            DateTimeFormatter formatter= DateTimeFormat.forPattern("hh:mm a");
            DateTime time = formatter.parseDateTime(text.substring(0, 8).trim());
            formatter = DateTimeFormat.forPattern("HH:mm");
            result =  formatter.print(time);
        } catch (Exception e) {
            result = text;
        }
        return result;
    }

    // Frankfurt, DE (FRA) to Chicago, IL, US (ORD - O'Hare)
    // Aberdeen, GB (ABZ) to Frankfurt, DE (FRA) "div.segment-orig-dest"
    public static String receiveDepartPlace(String text) {
        String result = "";
        try {
            Pattern pattern = Pattern.compile(".*\\sto\\s");
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                result = matcher.group();
                result = result.substring(0, result.length() - 3);
            }
        } catch (Exception e) {
            result = text;
        }
        return result.trim();
    }

    //Aberdeen, GB (ABZ) to Frankfurt, DE (FRA)
    public static String receiveDepartCode(String text) {
        String result = "";
        try {
            List<String> allMatches = new ArrayList<>();
            Pattern pattern = Pattern.compile("\\(.*\\)");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                allMatches.add(matcher.group());
            }
            result = allMatches.get(0).substring(1, 4);
        } catch (Exception e) {
            result = text;
        }
        return result;
    }

    // 15:35 am - 18:30 am (1h 55m) "div.segment-times"
    // 5:35 am - 8:30 am (1h 55m) "div.segment-times"
    public static String receiveArriveTime(String text) {
        String result = "";
        try {
            Pattern pattern = Pattern.compile("-\\s\\d*:\\d*\\s[a-z]*");
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                result = matcher.group();
            }
            DateTimeFormatter formatter= DateTimeFormat.forPattern("hh:mm a");
            DateTime time = formatter.parseDateTime(result.substring(1).trim());
            formatter = DateTimeFormat.forPattern("HH:mm");
            result = formatter.print(time);
        } catch (Exception e) {
            result = text;
        }
        return result;
    }

    /// calc
    public static String receiveArriveDate(String text) {
        return text;
    }

    //Aberdeen, GB (ABZ) to Frankfurt, DE (FRA) "div.segment-orig-dest"
    public static String receiveArrivePlace(String text) {
        String result = "";
        try {
            List<String> allMatches = new ArrayList<>();
            Pattern pattern = Pattern.compile("\\sto.*");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                allMatches.add(matcher.group());
            }
            result = allMatches.get(0).substring(3);
        } catch (Exception e) {
            result = text;
        }
        return result.trim();
    }
    // Frankfurt, DE (FRA) to San Francisco, CA, US (SFO)
    //Aberdeen, GB (ABZ) to Frankfurt, DE (FRA) "div.segment-orig-dest"
    public static String receiveArriveCode(String text) {
        String result = "";
        try {
            Pattern pattern = Pattern.compile("\\(.*\\)$");
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                result = matcher.group().substring(1, 4);
            }
        } catch (Exception e) {
            result = text;
        }
        return result;
    }

    //5:35 am - 8:30 am (1h 55m) "div.segment-times"
    public static String receiveTravelTime(String text) {
        String result = "";
        try {
            Pattern pattern = Pattern.compile("\\(.*\\)");
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                result = matcher.group();
            }
            return result.substring(1, result.length() - 1);
        } catch (Exception e) {
            result =text;
        }
        return result;
    }

    //LH 975 | Airbus A319 "div.segment-flight-equipment"
    public static String receiveAirlineCompany(String text) {
        String result = "";
        try {
            result = text.substring(0, 2);
        } catch (Exception e) {
            result = text;
        }
        return result;
    }

    //LH 975 | Airbus A319 "div.segment-flight-equipment"
    public static String receiveAircraft(String text) {
        String result = "";
        try {
            Pattern pattern = Pattern.compile("\\|.*");
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                result = matcher.group();
            }
            result = result.substring(2);
        } catch (Exception e) {
            result = text;
        }
        return result;
    }

    //Snack
    public static String receiveMeal(String text) {
        return text;
    }

    // 1h 45m connection
    public static String receiveLayoverTime(String text) {
        String result = "";
        try {
            return text.substring(0, text.length() - 11);
        } catch (Exception e) {
            result = text;
        }
        return result;
    }

    //LH 975 | Airbus A319 "div.segment-flight-equipment"
    public static String receiveFlightNumber(String text) {
        String result = "";
        try {
            Pattern pattern = Pattern.compile(".*\\|");
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                result = matcher.group();
            }
            return result.substring(0, result.length() - 2).replaceAll("\\s", "");
        } catch (Exception e) {
            result = text;
        }
        return result;
    }

    //"Duration33h totalShow on-time performance"
    public static String receiveTotalDuration(String text) {
        try {
            return text.substring(8, text.length() - 30);
        } catch (Exception e) {
            return text;
        }
    }

    // 35k miles
    public static int receiveMileage(String text) {
        int result = 0;
        try {
            String substring = text.substring(0, text.length() - 7) + "000";
            result = Integer.parseInt(substring);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return result;
    }

    // +$175.66
    public static BigDecimal receiveTax(String text) {
        BigDecimal result = null;
        try {
            String substring = text.substring(2);
            result = new BigDecimal(substring);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String receiveClass(String text) {
        String result = "";
        if (text.contains("Economy")) {
            result = "E";
        } else if (text.contains("Business")) {
            result = "B";
        } else if (text.contains("First")) {
            result = "F";
        }
        return result;
    }
}
