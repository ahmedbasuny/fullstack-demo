package com.workflex.workation.model.dto.request;

import java.time.LocalDate;

public record WorkationRequestDto(
        String workationId,
        String employee,
        String origin,
        String destination,
        LocalDate start,
        LocalDate end,
        Long workingDays,
        String risk
) {
}
