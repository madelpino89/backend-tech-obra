package com.obramat.app.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class AppExceptions extends RuntimeException {

    private String message;
    private HttpStatus httpStatus;

    public AppExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
