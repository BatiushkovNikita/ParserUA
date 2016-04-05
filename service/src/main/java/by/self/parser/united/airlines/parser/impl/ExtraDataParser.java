package by.self.parser.united.airlines.parser.impl;


import by.self.parser.united.airlines.ClassType;
import by.self.parser.united.airlines.pojo.ExtraDataVO;
import by.self.parser.united.airlines.pojo.MixedExtraDataVO;
import by.self.parser.united.airlines.utils.Formatter;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

public class ExtraDataParser {

    public List<ExtraDataVO> parse(Element row,  List<ClassType> requiredClasses) {
        Map<ClassType, List<String>> classTypeListMap = prepareExtraData(row, requiredClasses);
        return  extractExtraDataVOs(classTypeListMap);
    }

    private List<ExtraDataVO> extractExtraDataVOs(Map<ClassType, List<String>> classTypeListMap) {
        List<ExtraDataVO> extraDataVOs = new ArrayList<>();
        int i = 0;
        for (Map.Entry<ClassType, List<String>> classTypeSetEntry : classTypeListMap.entrySet()) {
            Set<String> classesSet = new HashSet<>(classTypeSetEntry.getValue());
            if (classesSet.size() <= 1) {
                extraDataVOs.add(createSimpleExtraData(classTypeSetEntry, i));
                break;
            } else {
                extraDataVOs.addAll(createMixedCabinExtraData(classTypeSetEntry, i));
            }
            i++;
        }
        return extraDataVOs;
    }

    private  Map<ClassType, List<String>> prepareExtraData(Element row,  List<ClassType> requiredClasses) {
        Map<ClassType, List<String>> extraData = new HashMap<>();
        for (ClassType classType : requiredClasses) {
            int index = classType.ordinal() + 1;
            Elements columnElements = row.select("td:nth-child(" + index + ")");
            List<String> classesTypeText = new ArrayList<>();
            for (Element columnElement : columnElements) {
                String columnElementText = columnElement.text();
                if (!columnElementText.isEmpty()) {
                    classesTypeText.add(Formatter.receiveClass(columnElementText));
                }
            }
            if (!classesTypeText.isEmpty()) {
                extraData.put(classType, classesTypeText);
            }
        }
        return extraData;
    }

    private List<ExtraDataVO> createMixedCabinExtraData(Map.Entry<ClassType, List<String>> classTypeSetEntry, int index) {
        List<ExtraDataVO> extraDataVOList = new ArrayList<>();
        ExtraDataVO extraDataDescription = createSimpleExtraData(classTypeSetEntry, index);
        extraDataVOList.add(extraDataDescription);
        int i = 0;
        for (String classCode : classTypeSetEntry.getValue()) {
            MixedExtraDataVO mixedExtraDataVO = new MixedExtraDataVO();
            mixedExtraDataVO.setFieldName("mixed_cabins");
            mixedExtraDataVO.setFieldType("string");
            mixedExtraDataVO.setFieldValue(classCode);
            mixedExtraDataVO.setFieldLevel("class_list");
            mixedExtraDataVO.setFieldSubLevel("flight_list_" + i);
            mixedExtraDataVO.setFieldId("class_list_" + index);
            extraDataVOList.add(mixedExtraDataVO);
            i++;
        }
        extraDataVOList.add(createMixedExtraData(classTypeSetEntry, index));
        return extraDataVOList;
    }

    private ExtraDataVO createMixedExtraData(Map.Entry<ClassType, List<String>> classTypeSetEntry, int index) {
        ExtraDataVO extraDataVO = new ExtraDataVO();
        extraDataVO.setFieldName("mixed_description");
        extraDataVO.setFieldType("string");
        extraDataVO.setFieldValue(classTypeSetEntry.getKey().getToString());
        extraDataVO.setFieldLevel("class_list");
        extraDataVO.setFieldId("class_list_" + index);
        return extraDataVO;
    }

    private ExtraDataVO createSimpleExtraData(Map.Entry<ClassType, List<String>> classTypeSetEntry, int index) {
        ExtraDataVO extraDataVO = new ExtraDataVO();
        extraDataVO.setFieldName("class_description");
        extraDataVO.setFieldType("string");
        extraDataVO.setFieldValue(classTypeSetEntry.getKey().getAwardType());
        extraDataVO.setFieldLevel(classTypeSetEntry.getKey().getToString());
        extraDataVO.setFieldId("class_list_" + index);
        return extraDataVO;
    }
}
