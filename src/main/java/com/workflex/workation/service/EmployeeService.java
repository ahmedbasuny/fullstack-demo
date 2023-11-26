package com.workflex.workation.service;

import com.workflex.workation.model.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    Employee retrieveOrInsertEmployee(String name);
    Employee getEmployee(Long employeeId);
}
