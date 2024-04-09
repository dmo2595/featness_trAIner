package com.example.fitness_trAIner.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);
    User findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByNickname(String nickname);
}
