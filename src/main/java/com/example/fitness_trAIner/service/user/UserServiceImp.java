package com.example.fitness_trAIner.service.user;

import com.example.fitness_trAIner.common.exception.exceptions.LoginFailException;
import com.example.fitness_trAIner.common.exception.exceptions.SignupFailException;
import com.example.fitness_trAIner.repository.user.User;
import com.example.fitness_trAIner.repository.user.UserRepository;
import com.example.fitness_trAIner.service.user.dto.request.UserServiceLoginRequest;
import com.example.fitness_trAIner.service.user.dto.request.UserServiceSignupRequest;
import com.example.fitness_trAIner.service.user.dto.response.UserServiceLoginResponse;
import com.example.fitness_trAIner.service.user.dto.response.UserServiceSignupResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserServiceSignupResponse signupUser(UserServiceSignupRequest request) {

        Boolean isExistUsername = userRepository.existsByUsername(request.getUsername());
        Boolean isExistNickname = userRepository.existsByNickname(request.getNickname());

        //중복검사
        if (isExistUsername) throw new SignupFailException("아이디 중복");
        if (isExistNickname) throw new SignupFailException("닉네임 중복");

        User user;
        
        try {
            user = userRepository.save(User.builder()
                    .username(request.getUsername())
                    .password(bCryptPasswordEncoder.encode(request.getPassword()))
                    .nickname(request.getNickname())
                    .height(request.getHeight())
                    .weight(request.getWeight())
                    .age(request.getAge())
                    .spicyPreference(request.getSpicyPreference())
                    .meatConsumption(request.getMeatConsumption())
                    .tastePreference(request.getTastePreference())
                    .activityLevel(request.getActivityLevel())
                    .preferenceTypeFood(request.getPreferenceTypeFood())
                    .role("NORMAL")
                    .build());
        } catch (Exception e) {
            throw new SignupFailException();
        }
        return UserServiceSignupResponse.builder()
                .name(user.getUsername())
                .password(user.getPassword())
                .build();


    }

    @Override
    public UserServiceLoginResponse loginUser(UserServiceLoginRequest request) {
        User user;
        try{
            user = userRepository.findByUsername(request.getUsername());
            if (!bCryptPasswordEncoder.matches(request.getPassword(), user.getPassword()))
                throw new LoginFailException("로그인 실패");
            System.out.println(user);
        }catch (RuntimeException e){
            throw new LoginFailException("로그인 실패");
        }
        return UserServiceLoginResponse.builder().token(user.getUsername()).build();
    }


}
