package com.example.fitness_trAIner.common.exception.exceptions;

public class SignupFailException extends RuntimeException{
    public SignupFailException() {
        super("회원가입 실패");
    }
    public SignupFailException(String message) {
        super(message);
    }
}
