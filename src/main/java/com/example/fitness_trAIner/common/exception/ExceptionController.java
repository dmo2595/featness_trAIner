package com.example.fitness_trAIner.common.exception;

import com.example.fitness_trAIner.common.exception.exceptions.LoginFailException;
import com.example.fitness_trAIner.common.exception.exceptions.SignupFailException;
import com.example.fitness_trAIner.common.response.GlobalExceptionResponse;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

//Exception 전역 관리
@RestControllerAdvice
@Hidden
@Slf4j
public class ExceptionController {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final GlobalExceptionResponse handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        log.error("잘못된 RequestBody", e);
        return makeResponse(e.getBindingResult()
                .getFieldErrors()
                .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList()));
    }

    @ExceptionHandler({SignupFailException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final GlobalExceptionResponse handleSignupFailException(final SignupFailException e) {
        log.error("회원가입 오류", e);
        return makeResponse(e.getMessage(), 301);
    }

    @ExceptionHandler({LoginFailException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final GlobalExceptionResponse loginFailException(final LoginFailException e) {
        log.error("로그인 오류", e);
        return makeResponse(e.getMessage(), 301);
    }

//    @ExceptionHandler({SQLIntegrityConstraintViolationException.class})
//    public final ResponseEntity<GlobalExceptionResponse> test(final SQLIntegrityConstraintViolationException e) {
//        log.error("잘못된 SQL작성", e);
//        ErrorCode errorCode = ErrorCode.A_ERROR;
//        final GlobalExceptionResponse response = new GlobalExceptionResponse(errorCode.getMessage(), errorCode.getStatus());
//        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getStatus()));
//    }


    private GlobalExceptionResponse<String> makeResponse(String message, int status) {
        return GlobalExceptionResponse.<String>builder()
                .message(message)
                .status(status)
                .build();
    }

    private GlobalExceptionResponse<List<String>> makeResponse(List<String> messages) {
        return GlobalExceptionResponse.<List<String>>builder()
                .message(messages)
                .build();
    }


}
