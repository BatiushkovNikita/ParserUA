package by.self.parser.united.airlines.service.impl;

import by.self.parser.united.airlines.exception.ServiceException;
import by.self.parser.united.airlines.service.interf.JsonConverter;
import by.self.parser.united.airlines.pojo.MainVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverterImpl implements JsonConverter {

    @Override
    public String convertToJson(MainVO mainVO) throws ServiceException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(mainVO);
        } catch (JsonProcessingException e) {
            throw new ServiceException();
        }
    }
}
