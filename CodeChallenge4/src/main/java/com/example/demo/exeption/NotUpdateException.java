package com.example.demo.exeption;

public class NotUpdateException extends RuntimeException {
    
    public NotUpdateException(String message){
        super(message);
    }
    
}
