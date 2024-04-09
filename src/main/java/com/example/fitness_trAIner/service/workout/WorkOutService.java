package com.example.fitness_trAIner.service.workout;

import org.springframework.web.multipart.MultipartFile;

public interface WorkOutService {
    public void fileUpload(MultipartFile file);
}
