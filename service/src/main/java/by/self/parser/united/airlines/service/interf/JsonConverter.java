package by.self.parser.united.airlines.service.interf;

import by.self.parser.united.airlines.exception.ServiceException;
import by.self.parser.united.airlines.pojo.MainVO;

public interface JsonConverter {

    String convertToJson(MainVO mainVO) throws ServiceException;
}
