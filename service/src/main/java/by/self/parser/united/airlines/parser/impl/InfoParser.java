package by.self.parser.united.airlines.parser.impl;


import by.self.parser.united.airlines.utils.Formatter;
import org.jsoup.nodes.Element;

public class InfoParser {

    String parse(Element row) {
        return Formatter.receiveTotalDuration(row.select("a.flight-duration.otp-tooltip-trigger").text());
    }

}
