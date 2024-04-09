package com.example.fitness_trAIner.controller.workout;

import com.example.fitness_trAIner.common.response.GlobalExceptionResponse;
import com.example.fitness_trAIner.common.response.GlobalResponse;
import com.example.fitness_trAIner.controller.workout.dto.request.TestRequest;
import com.example.fitness_trAIner.service.workout.WorkOutService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/workouts")
@Tag(name = "WorkOut", description = "유저 개인 운동관련 API")
@RequiredArgsConstructor
@RestController
public class WorkOutController {

    private final WorkOutService workOutService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "동영상 전송", description = "유저 개인운동영상 전송.")
    @ApiResponse(responseCode = "200", description = "성공", useReturnTypeSchema = true)
    @ApiResponse(responseCode = "400", description = "에러 발생", content = @Content(schema = @Schema(implementation = GlobalExceptionResponse.class)))
    public final GlobalResponse<String> uploadMultipart(@RequestPart MultipartFile file, @RequestPart List<TestRequest> request) {
        workOutService.fileUpload(file);
        return GlobalResponse.<String>builder()
                .message("유저 운동영상 전송")
                .result("전송 성공")
                .build();
    }


}
