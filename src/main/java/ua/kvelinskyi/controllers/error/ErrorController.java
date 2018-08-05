package ua.kvelinskyi.controllers.error;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorController {
    private Logger logger;
    //TODO Autowired
    @Autowired
    public void setLog(Logger log) {
        this.logger = log;
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView getException(final Throwable throwable) {
        ModelAndView modelAndView = new ModelAndView();
        logger.error("Exception during execution of SpringSecurity application", throwable);
        String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
        modelAndView.addObject("errorMessage", errorMessage);
        modelAndView.addObject("exception", throwable);
        modelAndView.setViewName("error");
//        modelAndView.setStatus(HttpStatus.SERVICE_UNAVAILABLE);
        return modelAndView;
    }
}
