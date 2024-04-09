package com.example.fitness_trAIner.service.user.dto.response;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserServiceDetailInfoResponse {
    private Long id;
    private String name;
}
