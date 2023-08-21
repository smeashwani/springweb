package springweb.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NumberFormatException.class)
    public String numberformatHandler(Model theModel, Exception ex) {       
        theModel.addAttribute("message", "Global_NumberFormatException");
        return "errorPage";
    }
	
    @ExceptionHandler({Exception.class, IllegalArgumentException.class})
    public String ExceptionHandler(Model theModel, Exception ex) {
    	ex.printStackTrace();
        theModel.addAttribute("message", "Global_Exception");
        theModel.addAttribute("exception", ex.getMessage());
        
        return "errorPage";
    }
}
