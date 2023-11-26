package com.workflex.workation.service.impl;

import com.workflex.workation.exception.EmployeeNotFoundException;
import com.workflex.workation.model.entity.Employee;
import com.workflex.workation.repository.EmployeeRepository;
import com.workflex.workation.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Override
    public Employee retrieveOrInsertEmployee(String name) {
        Optional<Employee> employeeOptional = employeeRepository.findByName(name);
        if (employeeOptional.isPresent()) {
            return employeeOptional.get();
        } else {
            Employee employee = Employee.builder().name(name).build();
            return employeeRepository.save(employee);
        }
    }

    @Override
    public Employee getEmployee(Long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(
                () -> new EmployeeNotFoundException("Employee_not_found",
                        "employee with id " + employeeId + " does not exist"));
    }
}
