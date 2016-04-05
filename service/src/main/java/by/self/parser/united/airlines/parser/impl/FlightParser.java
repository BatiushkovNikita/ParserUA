package by.self.parser.united.airlines.parser.impl;

import by.self.parser.united.airlines.ClassType;
import by.self.parser.united.airlines.pojo.FlightVO;
import by.self.parser.united.airlines.utils.Formatter;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class FlightParser {

    public List<FlightVO> parse(Element row, List<ClassType> requiredClasses) {
        ArrayList<FlightVO> flightVOs = new ArrayList<>();
        Elements segments = row.select("div.segment");
        Elements separators = row.select("div.connection-separator");
        int segmentsSize = segments.size();
        int separatorsSize = separators.size();
        for (int i = 0; i < segmentsSize; i++) {
            Element separator;
            if (separatorsSize > i) {
                separator = separators.get(i);
            } else {
                separator = null;
            }
            FlightVO flightVO = extractFlightVO(segments.get(i), separator, row);
            flightVO.setId(i);
            flightVOs.add(flightVO);
        }
        return flightVOs;
    }

    private FlightVO extractFlightVO(Element segment, Element separator, Element row) {
        FlightVO flightVO = new FlightVO();
        flightVO.setDepartTime(Formatter.receiveDepartTime(segment.select("div.segment-times").text()));
        flightVO.setDepartDate(Formatter.receiveDepartDate(row.select("div.date-duration").text()));
        flightVO.setDepartPlace(Formatter.receiveDepartPlace(segment.select("div.segment-orig-dest").text()));
        flightVO.setDepartCode(Formatter.receiveDepartCode(segment.select("div.segment-orig-dest").text()));
        flightVO.setArriveTime(Formatter.receiveArriveTime(segment.select("div.segment-times").text()));
        flightVO.setArriveDate(Formatter.receiveArriveDate(""));
        flightVO.setArrivePlace(Formatter.receiveArrivePlace(segment.select("div.segment-orig-dest").text()));
        flightVO.setArriveCode(Formatter.receiveArriveCode(segment.select("div.segment-orig-dest").text()));
        flightVO.setTravelTime(Formatter.receiveTravelTime(segment.select("div.segment-times").text()));
        flightVO.setFlightNumber(Formatter.receiveFlightNumber(segment.select("div.segment-flight-equipment").text()));
        flightVO.setAirlineCompany(Formatter.receiveAirlineCompany(segment.select("div.segment-flight-equipment").text()));
        flightVO.setAircraft(Formatter.receiveAircraft(segment.select("div.segment-flight-equipment").text()));
        flightVO.setMeal(Formatter.receiveMeal(segment.select("div.meal:nth-child(1)").text()));
        if (separator != null) {
            flightVO.setLayoverTime(Formatter.receiveLayoverTime(separator.select("div.width-restrictor").text()));
        } else {
            flightVO.setLayoverTime("");
        }
        return flightVO;
    }
}
