package com.workflex.workation;

import com.workflex.workation.model.dto.request.WorkationRequestDto;
import com.workflex.workation.model.entity.Country;
import com.workflex.workation.model.entity.Employee;
import com.workflex.workation.model.entity.Workation;
import com.workflex.workation.model.enums.Risk;
import com.workflex.workation.repository.CountryRepository;
import com.workflex.workation.repository.EmployeeRepository;
import com.workflex.workation.repository.WorkationRepository;
import com.workflex.workation.service.WorkationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@Slf4j
public class WorkationApplication {

    private static final String CSV_PATH = "/data/workations.csv";

    public static void main(String[] args) {
        SpringApplication.run(WorkationApplication.class, args);
    }

    @Bean
    CommandLineRunner loadCsvData(WorkationService workationService) {
        return args -> {
            log.info("loading csv data ...");
            try (InputStream resource = getClass().getResourceAsStream(CSV_PATH);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(CSV_PATH)));
            ) {
                reader.lines()
                        .skip(1) // Skip header
                        .forEach(line ->
                                workationService.loadData(line.split(","))
                        );
                log.info("loading csv data done.");
            } catch (Exception ex) {
                log.error("error loading csv data, {}", ex.getMessage());
            }
        };
    }
}
