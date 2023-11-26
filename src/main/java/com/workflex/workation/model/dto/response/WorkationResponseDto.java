package com.workflex.workation.model.dto.response;

import java.time.LocalDate;

public interface WorkationResponseDto {
    Long getId();
    String getWorkationId();
    Long getEmployeeId();
    String getEmployeeName();
    Long getOriginId();
    String getOriginName();
    Long getDestinationId();
    String getDestinationName();
    LocalDate getStart();
    LocalDate getEnd();
    Long getWorkingDays();
    String getRisk();
}
