package com.example.fitness_trAIner.common.exception.exceptions;

public class LoginFailException extends RuntimeException{
    public LoginFailException() {
        super("로그인 실패");
    }
    public LoginFailException(String message) {
        super(message);
    }
}
