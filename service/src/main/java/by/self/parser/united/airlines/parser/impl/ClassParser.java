package by.self.parser.united.airlines.parser.impl;


import by.self.parser.united.airlines.ClassType;
import by.self.parser.united.airlines.pojo.ClassVO;
import by.self.parser.united.airlines.utils.Formatter;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

public class ClassParser {

    public List<ClassVO> parse(Element row, List<ClassType> requiredClasses) {
        List<ClassVO> classVOs = new ArrayList<>();
        int i = 0;
        Element classRow = row.select("div.flight-block-fares-container.columns_5").get(0);
        for (ClassType classCode: requiredClasses) {
            Element element = classRow.child(classCode.ordinal());
            if (!element.text().contains("Not available")) {
                ClassVO classVO = extractClassVO(element);
                classVO.setName(classCode.getToString());
                classVO.setId(i);
                classVOs.add(classVO);
                i++;
            }
        }
        return classVOs;
    }

    private ClassVO extractClassVO(Element element) {
        ClassVO classVO = new ClassVO();
        classVO.setStatus("AVAILABLE");
        classVO.setMileage(Formatter.receiveMileage(element.select("div.pp-base-price.price-point").text()));
        classVO.setTax(Formatter.receiveTax(element.select("div.pp-additional-fare.price-point").text()));
        return classVO;
    }
}
