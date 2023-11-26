package com.workflex.workation.service;

import com.workflex.workation.model.dto.response.WorkationResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkationService {
    public void loadData(String[] loginRequestDto);
    List<WorkationResponseDto> getAllWorkations();
}
