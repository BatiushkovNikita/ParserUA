package by.self.parser.united.airlines.parser.interf;

import by.self.parser.united.airlines.RequestData;
import by.self.parser.united.airlines.exception.ServiceException;

public interface Parser {

    String parseProcess(RequestData requestData) throws ServiceException;
}
