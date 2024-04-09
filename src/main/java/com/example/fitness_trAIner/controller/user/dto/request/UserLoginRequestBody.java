package com.example.fitness_trAIner.controller.user.dto.request;

import lombok.*;


@Getter
@Setter
public class UserLoginRequestBody {
    private String username;
    private String password;
}
