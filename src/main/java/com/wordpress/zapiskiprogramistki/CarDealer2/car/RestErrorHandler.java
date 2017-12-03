package com.wordpress.zapiskiprogramistki.CarDealer2.car;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.wordpress.zapiskiprogramistki.CarDealer2.car.exception.CarNotFoundException;

@ControllerAdvice
public class RestErrorHandler {

	
    @ExceptionHandler(CarNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFoundException(CarNotFoundException ex) {

    }
}
