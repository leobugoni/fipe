package io.github.leobugoni.fipe.Controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @ResponseBody
    @RequestMapping("/error")
    public String handleError(final HttpServletRequest request) {
        final Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        final Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        return String.format("Error: %s - Exception Message: %s", statusCode, exception == null ? "N/A" : exception.getMessage());
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}