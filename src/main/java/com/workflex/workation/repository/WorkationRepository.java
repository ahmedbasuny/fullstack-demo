package com.workflex.workation.repository;

import com.workflex.workation.model.dto.response.WorkationResponseDto;
import com.workflex.workation.model.entity.Workation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkationRepository extends JpaRepository<Workation, Long> {

    @Query(value = " SELECT w.id AS id, w.workation_id AS workationId, e.id AS employeeId, " +
                    " e.name AS employeeName, o.id AS originId, " +
                    " o.name AS originName, d.id AS destinationId, " +
                    " d.name AS destinationName, w.start_date AS start, w.end_date AS end, " +
                    " w.working_days AS workingDays, w.risk AS risk " +
                    " FROM workation w " +
                    " JOIN employee e ON w.employee_id = e.id " +
                    " JOIN country o ON w.origin_id = o.id " +
                    " JOIN country d ON w.destination_id = d.id",
            nativeQuery = true)
    List<WorkationResponseDto> getAllWorkationData();
}
