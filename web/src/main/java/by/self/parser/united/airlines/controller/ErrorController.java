package by.self.parser.united.airlines.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController {

    @RequestMapping(value="/error")
    public String handle(HttpServletRequest request, ModelAndView model) {
        Object statusCode = request.getAttribute("javax.servlet.error.status_code");
        request.setAttribute("status", statusCode);
        request.setAttribute("reason", request.getAttribute("javax.servlet.error.message"));
        request.setAttribute("errorUri", request.getAttribute("javax.servlet.error.request_uri"));
        return "/error";
    }
}
