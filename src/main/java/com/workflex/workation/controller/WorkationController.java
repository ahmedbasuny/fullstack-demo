package com.workflex.workation.controller;

import com.workflex.workation.model.dto.response.WorkationResponseDto;
import com.workflex.workation.service.WorkationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workflex")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class WorkationController {

    private final WorkationService workationService;

    @GetMapping("/workation")
    public ResponseEntity<List<WorkationResponseDto>> getAllWorkations() {
        log.info("getting all workations");
        return ResponseEntity.ok(workationService.getAllWorkations());
    }
}
