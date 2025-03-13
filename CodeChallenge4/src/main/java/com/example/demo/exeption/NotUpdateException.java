package com.example.demo.exeption;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotUpdateException extends RuntimeException {
    
    public NotUpdateException(String message){
        super(message);
    }
    
}
