package com.example.fitness_trAIner.repository.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(name = "username", unique = true, nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "nickname", nullable = false)
    private String nickname;
    @Column(name = "height")
    private Integer height;
    @Column(name = "weight")
    private Integer weight;
    @Column(name = "age")
    private Integer age;
    @Column(name = "score")
    private Long score;
    @Column(name = "role")
    private String role;
    @Column(name = "spicy_preference")
    private Integer spicyPreference;
    @Column(name = "meat_consumption")
    private Boolean meatConsumption;
    @Column(name = "taste_preference")
    private String tastePreference;
    @Column(name = "activity_level")
    private Integer activityLevel;
    @Column(name = "preference_type_food")
    private String preferenceTypeFood;


    @Builder
    private User(String username, String password, String nickname, Integer height,
                Integer weight, Integer age, Long score, String role, Integer spicyPreference,
                Boolean meatConsumption, String tastePreference, Integer activityLevel, String preferenceTypeFood) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.score = score;
        this.role = role;
        this.spicyPreference = spicyPreference;
        this.meatConsumption = meatConsumption;
        this.tastePreference = tastePreference;
        this.activityLevel = activityLevel;
        this.preferenceTypeFood = preferenceTypeFood;
    }

//    @Builder
//    private User(String username, String role, String password, String nickname) {
//        this.username = username;
//        this.password = password;
//        this.role = role;
//        this.nickname = nickname;
//    }


}
