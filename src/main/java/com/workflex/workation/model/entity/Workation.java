package com.workflex.workation.model.entity;

import com.workflex.workation.model.enums.Risk;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Workation {
    @Id
    @GeneratedValue
    private Long id;
    private String workationId;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "origin_id")
    private Country origin;
    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Country destination;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long workingDays;
    @Enumerated(EnumType.STRING)
    private Risk risk;
    @CreationTimestamp
    private LocalDateTime createdDateTime;
    @UpdateTimestamp
    private LocalDateTime updatedDateTime;
}
