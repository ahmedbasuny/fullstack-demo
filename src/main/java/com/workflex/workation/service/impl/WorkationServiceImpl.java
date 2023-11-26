package com.workflex.workation.service.impl;

import com.workflex.workation.model.dto.response.WorkationResponseDto;
import com.workflex.workation.model.entity.Country;
import com.workflex.workation.model.entity.Employee;
import com.workflex.workation.model.entity.Workation;
import com.workflex.workation.model.enums.Risk;
import com.workflex.workation.repository.WorkationRepository;
import com.workflex.workation.service.CountryService;
import com.workflex.workation.service.EmployeeService;
import com.workflex.workation.service.WorkationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkationServiceImpl implements WorkationService {

    private final EmployeeService employeeService;
    private final CountryService countryService;
    private final WorkationRepository workationRepository;

    @Override
    @Transactional
    public void loadData(String[] line) {
        Employee employee = employeeService.retrieveOrInsertEmployee(line[1]);
        Country origin = countryService.retrieveOrInsertCountry(line[2]);
        Country destination = countryService.retrieveOrInsertCountry(line[3]);
        Workation workation = Workation.builder()
                .workationId(line[0])
                .employee(employee)
                .origin(origin)
                .destination(destination)
                .startDate(LocalDate.parse(line[4]))
                .endDate(LocalDate.parse(line[5]))
                .workingDays(Long.parseLong(line[6]))
                .risk(Risk.valueOf(line[7]))
                .build();
        workationRepository.save(workation);
    }

    @Override
    @Transactional(readOnly = true)
    public List<WorkationResponseDto> getAllWorkations() {
        return workationRepository.getAllWorkationData();
    }
}
