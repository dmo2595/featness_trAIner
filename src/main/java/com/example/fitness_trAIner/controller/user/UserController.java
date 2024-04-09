package com.example.fitness_trAIner.controller.user;

import com.example.fitness_trAIner.common.response.GlobalExceptionResponse;
import com.example.fitness_trAIner.common.response.GlobalResponse;
import com.example.fitness_trAIner.controller.user.dto.request.UserLoginRequestBody;
import com.example.fitness_trAIner.controller.user.dto.request.UserSignupRequestBody;
import com.example.fitness_trAIner.service.user.UserService;
import com.example.fitness_trAIner.service.user.dto.request.UserServiceLoginRequest;
import com.example.fitness_trAIner.service.user.dto.request.UserServiceSignupRequest;
import com.example.fitness_trAIner.service.user.dto.response.UserServiceLoginResponse;
import com.example.fitness_trAIner.service.user.dto.response.UserServiceSignupResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@Tag(name = "User", description = "유저 관련 API")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    @Operation(summary = "회원가입", description = "유저 회원가입 API")
    @ApiResponse(responseCode = "200", description = "성공", useReturnTypeSchema = true)
    @ApiResponse(responseCode = "400", description = "에러 발생", content = @Content(schema = @Schema(implementation = GlobalExceptionResponse.class)))
    public final GlobalResponse<UserServiceSignupResponse> saveUser(@RequestBody @Valid UserSignupRequestBody requestBody) {


        return GlobalResponse.<UserServiceSignupResponse>builder()
                .message("유저 회원가입")
                .result(userService.signupUser(UserServiceSignupRequest.builder()
                        .username(requestBody.getUsername())
                        .password(requestBody.getPassword())
                        .nickname(requestBody.getNickname())
                        .height(requestBody.getHeight())
                        .weight(requestBody.getWeight())
                        .age(requestBody.getAge())
                        .spicyPreference(requestBody.getSpicyPreference())
                        .meatConsumption(requestBody.getMeatConsumption())
                        .tastePreference(requestBody.getTastePreference())
                        .activityLevel(requestBody.getActivityLevel())
                        .preferenceTypeFood(requestBody.getPreferenceTypeFood())
                        .build()))
                .build();
    }
    @PostMapping("/login")
    @Operation(summary = "로그인", description = "유저 로그인 API")
    public final GlobalResponse<UserServiceLoginResponse> loginUser(@RequestBody UserLoginRequestBody requestBody) {

        return GlobalResponse.<UserServiceLoginResponse>builder()
                .message("유저 로그인")
                .result(userService.loginUser(UserServiceLoginRequest.builder()
                                .username(requestBody.getUsername())
                                .password(requestBody.getPassword())
                        .build()))
                .build();
    }

//    @GetMapping()
//    @Operation(summary = "유저 조회", description = "유저 조회")
//    @ApiResponse(responseCode = "200", description = "성공", useReturnTypeSchema = true)
//    @ApiResponse(responseCode = "400", description = "에러 발생", content = @Content(schema = @Schema(implementation = GlobalExceptionResponse.class)))
//    public final GlobalResponse<UserServiceDetailInfoResponse> findById(@RequestBody UserRequestBody request) {
//        return GlobalResponse.<UserServiceDetailInfoResponse>builder()
//                .message("유저 상세 조회")
//                .result(UserServiceDetailInfoResponse.builder()
//                        .name(request.getName())
//                        .build())
//                .build();
//
//    }

}
