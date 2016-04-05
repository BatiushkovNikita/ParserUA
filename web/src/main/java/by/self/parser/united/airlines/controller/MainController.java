package by.self.parser.united.airlines.controller;

import by.self.parser.united.airlines.RequestData;
import by.self.parser.united.airlines.exception.MvcException;
import by.self.parser.united.airlines.exception.ServiceException;
import by.self.parser.united.airlines.parser.interf.Parser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.Map;

@Controller
public class MainController {

    @Inject
    private Parser parserUnited;

    @RequestMapping(value = "/ParserService/UA", method = RequestMethod.GET,
            params = {"startDate", "endDate", "origin", "destination", "seats", "class", "request_id", "user_id", "type"})
    public ModelAndView process(@RequestParam Map<String, String> params) throws MvcException {
        RequestData requestData = getRequestData(params);
        String json = null;
        try {
            json = parserUnited.parseProcess(requestData);
        } catch (ServiceException e) {
           throw new MvcException(e.getMessage());
        }
        return new ModelAndView("test", "jsonData", json);
    }

    private RequestData getRequestData(Map<String, String> params) {
        RequestData requestData = new RequestData();
        requestData.setStartDate(params.get("startDate"));
        requestData.setEndDate(params.get("endDate"));
        requestData.setOrigin(params.get("origin"));
        requestData.setDestination(params.get("destination"));
        requestData.setSeats(Integer.valueOf(params.get("seats")));
        requestData.setClasses(params.get("class"));
        requestData.setRequestId(Long.valueOf(params.get("request_id")));
        requestData.setUserId(Long.valueOf(params.get("user_id")));
        requestData.setType(params.get("type"));
        return requestData;
    }
}
