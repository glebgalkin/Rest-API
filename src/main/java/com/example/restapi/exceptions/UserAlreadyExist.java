package com.example.restapi.exceptions;

public class UserAlreadyExist extends Exception{
    public UserAlreadyExist(String message){
        super(message);
    }
}
